package org.cloud.common.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.cloud.common.security.ShiroDbRealm;
import org.cloud.common.security.ShiroSpringCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ShiroConfig {

    // 注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
    @Bean(name = "shiroDbRealm")
    public ShiroDbRealm shiroDbRealm(ShiroSpringCacheManager shiroSpringCacheManager) {
        DefaultHashService defaultHashService = new DefaultHashService();
        defaultHashService.setHashAlgorithmName("SHA-512");
        defaultHashService.setHashIterations(500000);
        defaultHashService.setGeneratePublicSalt(true);

        DefaultPasswordService defaultPasswordService = new DefaultPasswordService();
        defaultPasswordService.setHashService(defaultHashService);

        PasswordMatcher credentialsMatcher = new PasswordMatcher();
        credentialsMatcher.setPasswordService(defaultPasswordService);

        ShiroDbRealm shiroDbRealm = new ShiroDbRealm(shiroSpringCacheManager, credentialsMatcher);

        // 启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        shiroDbRealm.setAuthenticationCachingEnabled(true);

        // 缓存AuthenticationInfo信息的缓存名称
        shiroDbRealm.setAuthenticationCacheName("authenticationCache");

        // 缓存AuthorizationInfo信息的缓存名称
        shiroDbRealm.setAuthorizationCacheName("authorizationCache");
        return shiroDbRealm;
    }

    /**
     * shiroFilter
     * 
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");

        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/");

        // 未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        Map<String, String> filterMap = new HashMap<String, String>();
        filterMap.put("/static/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/**", "authc");// 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 权限管理，配置主要是Realm的管理认证
     * 
     * @param realm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(ShiroDbRealm shiroDbRealm, SessionManager sessionManager,
            ShiroSpringCacheManager shiroSpringCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 设置realm.
        securityManager.setRealm(shiroDbRealm);

        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(shiroSpringCacheManager);

        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager sessionManager(ShiroSpringCacheManager shiroSpringCacheManager) {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        SimpleCookie simpleCookie = new SimpleCookie("shiro.sesssion");
        simpleCookie.setPath("/");

        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
        enterpriseCacheSessionDAO.setActiveSessionsCacheName("activeSessionCache");
        enterpriseCacheSessionDAO.setCacheManager(shiroSpringCacheManager);

        defaultWebSessionManager.setGlobalSessionTimeout(30 * 60 * 1000);
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        defaultWebSessionManager.setSessionIdCookie(simpleCookie);
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        defaultWebSessionManager.setSessionDAO(enterpriseCacheSessionDAO);
        return defaultWebSessionManager;
    }

    @Bean(name = "shiroSpringCacheManager")
    public ShiroSpringCacheManager shiroSpringCacheManager(EhCacheCacheManager cacheManager) {
        ShiroSpringCacheManager shiroSpringCacheManager = new ShiroSpringCacheManager();
        shiroSpringCacheManager.setCacheManager(cacheManager);
        return shiroSpringCacheManager;
    }

    @Bean(name = "cacheManager")
    public EhCacheCacheManager cacheManager() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManagerFactoryBean.getObject());
        return ehCacheCacheManager;
    }

}
