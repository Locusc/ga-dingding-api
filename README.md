<p align="center">
	<strong>第三方应用请求政务钉钉服务端API工具</strong>
</p>

## maven 引用：
```xml
    <dependency>
        <groupId>cn.locusc</groupId>
        <artifactId>ga-dingding-api-client</artifactId>
        <version>1.1.0</version>
    </dependency>
```
## application.yml 配置：
```yaml
gad:
  api:
    client:
      access-key: appKey
      secret-key: appSercet
      domain-name: 网关域名
      protocol: 协议类型
```
## 使用：
[方法文档](http://www.locusc.cn)
```java
    @Resource
    public GadApiTemplate gadApiTemplate;
```
## 说明：
1. 包含官方请求SDK的功能。
2. 包含官方现有服务端API除日程外的的实现方法。
3. 官方提醒：所有对接口数据的增删改查都会影响到政务钉钉线上数据，请谨慎操作。
4. authCode只能在政务钉钉APP内部使用前端接口获取，PC端无法获取。
## 已完成：
* [x] 官方请求SDK的功能 
* [x] DING
* [x] 轨迹服务
* [x] 消息
* [x] 业务事件回调
* [x] JSAPI鉴权
* [x] 文件存储
* [x] 待办
* [x] 工作通知消息
* [x] 获取通讯录部门信息
* [x] 获取通讯录用户信息
* [x] 企业内应用免登
## 未完成：
* [ ] 日程
* [ ] 一些其他的接口 比如: 获取所有的部门code以及部门详情，获取部门下所有用户code以及用户详情
* [ ] Python版本
## 欢迎提交issue
如果对您有帮助，希望能给项目一个Star
## 联系作者：
QQ：2227628925
