package org.cloud.system.mapper;

import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.SysLog;

public interface SysLogMapper extends BaseMapper<SysLog> {

    void clearLogs();

}
