package org.cloud.common.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {

        @Autowired
        private M mapper;

        @Override
        public Long getCount(T entity) {
            return mapper.selectCount(entity);
        }

        @Override
        public Optional<T> getById(Long id) {
            return  Optional.ofNullable(mapper.selectByPrimaryKey(id));
        }

        @Override
        public List<T> getAll() {
            return mapper.selectAll();
        }

        @Override
        public List<T> getAll(int pageNum, int pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            return mapper.selectAll();
        }

        @Override
        public long save(T entity) {
            if (null != entity) {
                Class<?> cls = entity.getClass();
                try {
                    Method method = cls.getMethod("getId");
                    Object idVal = method.invoke(entity);
                    if(null!=idVal) {
                        return mapper.updateByPrimaryKey(entity);
                    } else {
                        return mapper.insert(entity);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }

        @Override
        public long deleteById(Long id) {
            return mapper.deleteByPrimaryKey(id);
        }
}
