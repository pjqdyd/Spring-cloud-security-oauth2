package com.pjqdyd.mapper;

import com.pjqdyd.entity.TbPermission;
import com.pjqdyd.tk.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {

    List<TbPermission> selectPermissionByUserId(@Param("id") Long id);

}