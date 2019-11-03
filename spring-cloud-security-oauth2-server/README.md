
#### 基于内存存储令牌的授权访问模式:

 1. 启动主类后.
 
 2. 访问http://localhost:8080/oauth/authorize?client_id=client&response_type=code.
 
 3. 输入pjqdyd 密码123456登录后.
 
 4. 选择 Approve 表示同意授权,就跳转到百度了(相当于回调服务器的地址),  Deny不同意
 
 5. 跳转到百度(回调服务器)地址栏是https://www.baidu.com/?code=IEIWTh,表示已经拿到了授权code
 
 6. 使用postman等工具, 根据授权code再次请求服务器获取令牌access_token:
    curl -X POST -h "Content-Type: application/x-www-form-urlencoded" -d 
    'grant_type=authorization_code&code=IEIWTh'
    'http://client:secret@localhost:8080/oauth/token'
    
    返回结果:
    {
        "access_token": "fffksdod-HGAJFKAJ-DFFKJ83SFHJA",
        "token_type": "bearer",
        "expires_in": 43199,
        "scope": "app"
    }