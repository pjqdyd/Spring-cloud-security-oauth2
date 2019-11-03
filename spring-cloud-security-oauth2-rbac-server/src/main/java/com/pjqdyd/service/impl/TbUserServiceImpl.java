package com.pjqdyd.service.impl;

import com.pjqdyd.entity.TbUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.pjqdyd.mapper.TbUserMapper;
import com.pjqdyd.service.TbUserService;
import tk.mybatis.mapper.entity.Example;

@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getUserByName(String userName) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", userName);
        return tbUserMapper.selectOneByExample(example);
    }
}
