package org.cloud.system.service.impl;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.SysLogMapper;
import org.cloud.system.model.SysLog;
import org.cloud.system.service.ISysLogService;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
