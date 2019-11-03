package com.pjqdyd.service;

import com.pjqdyd.entity.TbPermission;

import java.util.List;

public interface TbPermissionService{

    List<TbPermission> selectPermissionByUserId(Long id);

}
