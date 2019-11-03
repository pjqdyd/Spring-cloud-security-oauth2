package com.pjqdyd.service.impl;

import com.pjqdyd.entity.TbPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.pjqdyd.mapper.TbPermissionMapper;
import com.pjqdyd.service.TbPermissionService;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectPermissionByUserId(Long id) {
        return tbPermissionMapper.selectPermissionByUserId(id);
    }
}
