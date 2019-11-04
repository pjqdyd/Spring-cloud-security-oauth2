
#### 资源服务器

1. 启动spring-cloud-security-oauth2-rbac-server, 按步骤获取access_token

2. 再启动本资源服务, 访问http://localhost:9090/view?access_token=[access_token]

3. 即可请求到view查询接口的资源