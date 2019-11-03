package com.pjqdyd;

import com.pjqdyd.tk.MyMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tk.mybatis.spring.annotation.MapperScan;

/**   
 * @Description:  [spring cloud 基于RBAC的授权启动类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyMapper.class)})
@MapperScan(basePackages = "com.pjqdyd.mapper")
public class SpringCloudSecurityOauth2RbacServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSecurityOauth2RbacServerApplication.class, args);
    }

}
