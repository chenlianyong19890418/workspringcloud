package com.dlsmartercity.annualaccount.service;

import com.dlsmartercity.annualaccount.datasource.DataSource;
import com.dlsmartercity.annualaccount.datasource.DynamicDataSourceGlobal;
import com.dlsmartercity.annualaccount.dto.single.SysError;

/**
 * 
 * @ClassName: ISysErrorService
 * @Description: TODO(系统异常处理)
 * @author ujhan
 * @date 2017年12月7日 下午3:00:39
 *
 */
public interface ISysErrorService {

	@DataSource(DynamicDataSourceGlobal.WRITE)
	void insertSysError(SysError t);

}
