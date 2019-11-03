
#### 基于数据库存储令牌的访问授权:

 1. 创建数据库db_oauth2, 执行schema.sql建表语句 
    注意数据库的编码方式:
    Default characterset: utf8mb4
    Default collation: utf8mb4_bin
 
 2. 因为client_secret插入数据库的是加密的,所以运行测试类EncodedTest生成自定义的"secret"字符密文:
 
    $2a$10$RcCCUjMkLVfVwLnvfQpEfO3xCXf2nDshl0tlL29MvKTrdeiolCmfi

 3. 手动插入一条认证客户详情数据:
 
 ```
INSERT INTO `db_oauth2`.`oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('client', null, '$2a$10$RcCCUjMkLVfVwLnvfQpEfO3xCXf2nDshl0tlL29MvKTrdeiolCmfi', 'app', 'authorization_code', 'https://www.baidu.com', null, null, null, null, null);
 ```

4. 后面的步骤类似:
 1. 启动主类后.
 
 2. 访问http://localhost:8081/oauth/authorize?client_id=client&response_type=code.
 
 3. 输入pjqdyd 密码123456登录后.
 
 4. 选择 Approve 表示同意授权,就跳转到百度了(相当于回调服务器的地址),  Deny不同意
 
 5. 跳转到百度(回调服务器)地址栏是https://www.baidu.com/?code=IEIWTh,表示已经拿到了授权code
 
 6. 使用postman等工具, 根据授权code再次请求服务器获取令牌access_token:
 
 ```
    curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=IEIWTh' 'http://client:secret@localhost:8081/oauth/token'
 ```
    
    
返回结果样式:
{
    "access_token": "fffksdod-HGAJFKAJ-DFFKJ83SFHJA",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "app"
}

