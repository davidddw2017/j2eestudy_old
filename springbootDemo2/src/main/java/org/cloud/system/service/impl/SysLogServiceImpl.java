package org.cloud.system.service.impl;

import javax.annotation.Resource;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.SysLogMapper;
import org.cloud.system.model.SysLog;
import org.cloud.system.service.ISysLogService;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void clearLogs() {
        sysLogMapper.clearLogs();
    }

}
