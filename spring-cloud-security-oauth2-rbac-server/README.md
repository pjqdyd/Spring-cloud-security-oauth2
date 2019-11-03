
#### 基于RBAC角色访问授权控制

前提: 已运行了spring-cloud-security-oauth2-db-server模块
      已经创建好了db_oauth2数据库

1. 执行初始数据init_table.sql

2. 操作类似

 1. 启动主类后.
 
 2. 访问http://localhost:8082/oauth/authorize?client_id=client&response_type=code.
 
 3. 输入admin 密码123456登录后.
 
 4. 选择 Approve 表示同意授权,就跳转到百度了(相当于回调服务器的地址),  Deny不同意
 
 5. 跳转到百度(回调服务器)地址栏是https://www.baidu.com/?code=IEIWTh,表示已经拿到了授权code
 
 6. 使用postman等工具, 根据授权code再次请求服务器获取令牌access_token:
    curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 
    'grant_type=authorization_code&code=IEIWTh'
    'http://client:secret@localhost:8082/oauth/token'
    
    返回结果:
    {
        "access_token": "fffksdod-HGAJFKAJ-DFFKJ83SFHJA",
        "token_type": "bearer",
        "expires_in": 43199,
        "scope": "app"
    }