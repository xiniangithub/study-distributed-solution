# 分布式解决方案

## 分布式ID

### 美团Leaf

案例代码

- distributed-id-leaf

测试：

- 数据库号段模式：http://localhost:8888/distributed-id-leaf/id/segment
- 雪花算法：http://localhost:8888/distributed-id-leaf/id/snowflake

## 分布式Session
### Spring Session

案例代码

- distributed-session-spring

测试：

- 设置Session：http://127.0.0.1:8888/distributed-session-spring/login?username=admin&password=admin
- 集群服务A获取Session：http://127.0.0.1:8888/distributed-session-spring/info
- 集群服务B获取Session：http://127.0.0.1:9999/distributed-session-spring/info
- 查看Redis中是否有生成的Session key

### Token + Redis

案例代码

- distributed-session-token

测试：

- 设置Token：http://localhost:8888/distributed-session-token/login?username=admin&password=admin
- 在header中设置token发送请求：http://localhost:8888/distributed-session-token/info

### JWT

案例代码

- distributed-session-jwt

测试：

- 设置Token：http://localhost:8888/distributed-session-jwt/user/login?username=admin&password=admin
- 在header中设置token发送请求：http://localhost:8888/distributed-session-jwt/user/info

统一拦截器处理测试：

- 设置Token：http://localhost:8888/distributed-session-jwt/user2/login?username=admin&password=admin
- 在header中设置token发送请求：http://localhost:8888/distributed-session-jwt/user2/info