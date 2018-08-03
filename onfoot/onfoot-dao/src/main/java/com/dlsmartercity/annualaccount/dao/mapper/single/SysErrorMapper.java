package com.dlsmartercity.annualaccount.dao.mapper.single;

import com.dlsmartercity.annualaccount.dto.single.SysError;

public interface SysErrorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysError record);

    int insertSelective(SysError record);

    SysError selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysError record);

    int updateByPrimaryKey(SysError record);
}