package com.pjqdyd.tk;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**   
 * @Description:  [tk.mybatis提供的通用Mapper接口, 注意，该接口不能被扫描到，否则会出错]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
