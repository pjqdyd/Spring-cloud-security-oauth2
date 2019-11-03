package com.pjqdyd.service.impl;

import com.pjqdyd.entity.TbPermission;
import com.pjqdyd.entity.TbUser;
import com.pjqdyd.service.TbPermissionService;
import com.pjqdyd.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**   
 * @Description:  [用户详情服务实现, 提供用户数据给Spring security, 方便认证授权]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getUserByName(s); //查询用户
        List<GrantedAuthority> grantedAuthoritiesList = Lists.newArrayList(); //创建认证权限集合(方便提供给Security认证)
        if(tbUser != null){
            //查询用户的权限列表
            List<TbPermission> tbPermissionList = tbPermissionService.selectPermissionByUserId(tbUser.getId());
            tbPermissionList.forEach(tbPermission -> {
                //根据用户的权限名getEnname, 创建grantedAuthority认证权限对象
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                //添加到认证权限集合中
                grantedAuthoritiesList.add(grantedAuthority);
            });

            //返回一个用户对象, 交由security验证
            return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthoritiesList);
        }

        return null;
    }

}
