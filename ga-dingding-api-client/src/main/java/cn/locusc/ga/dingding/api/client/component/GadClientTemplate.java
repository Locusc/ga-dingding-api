package cn.locusc.ga.dingding.api.client.component;

import com.alibaba.xxpt.gateway.shared.client.http.*;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Jay Chan
 * @Description 封装政务钉钉官方SDK
 * @Date 16:42 2020/6/24
 **/
@Component
public class GadClientTemplate {

    @Resource
    private ExecutableClient executableClient;

    /**
     * @Description execute方法
     * @Param [httpRequest]
     * @return java.lang.String
     **/
    public String executeGad(AbstractRequest httpRequest) throws GwException {
        return executableClient.execute(httpRequest);
    }

    /**
     * @Description 初始化方法
     **/
    public void initGad() {
        executableClient.init();
    }

    /**
     * @Description Get请求
     * @Param [api]
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api) {
        return executableClient.newGetClient(api);
    }

    /**
     * @Description Get请求
     * @Param [api, timeout] 请求地址, 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api, int timeout) {
        return executableClient.newGetClient(api, timeout);
    }

    /**
     * @Description Get请求
     * @Param [api, version] 请求地址, 版本号
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api, String version) {
        return executableClient.newGetClient(api, version);
    }

    /**
     * @Description Get请求
     * @Param [api, version, timeout] 请求地址, 版本号, 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api, String version, int timeout) {
        return executableClient.newGetClient(api, version, timeout);
    }

    /**
     * @Description Post请求
     * @Param [api] 请求地址
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api) {
        return executableClient.newPostClient(api);
    }

    /**
     * @Description Post请求
     * @Param [api, timeout] 请求地址, 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api, int timeout) {
        return executableClient.newPostClient(api, timeout);
    }

    /**
     * @Description Post请求
     * @Param [api, version] 请求地址, 版本号
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api, String version) {
        return executableClient.newPostClient(api, version);
    }

    /**
     * @Description Post请求
     * @Param [api, version, timeout] 请求地址, 版本号, 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api, String version, int timeout) {
        return executableClient.newPostClient(api, version, timeout);
    }

    /**
     * @Description 获取Uri
     * @return java.lang.String
     **/
    public String getGadUri() {
        return executableClient.getUri();
    }

    /**
     * @Description 获取RoutePlanner
     * @return org.apache.http.conn.routing.HttpRoutePlanner
     **/
    public HttpRoutePlanner getGadRoutePlanner() {
        return executableClient.getRoutePlanner();
    }

    /**
     * @Description 获取Idletime
     * @return long
     **/
    public long getGadIdletime() {
        return executableClient.getIdletime();
    }

    /**
     * @Description 获取HttpClient
     * @return org.apache.http.impl.client.CloseableHttpClient
     **/
    public CloseableHttpClient getGadHttpClient() {
        return executableClient.getHttpClient();
    }

    /**
     * @Description 设置routePlanner
     * @Param [routePlanner]
     **/
    private void setGadRoutePlanner(HttpRoutePlanner routePlanner) {
        executableClient.setRoutePlanner(routePlanner);
    }

    /**
     * @Description 设置协议
     * @Param [protocol]
     **/
    private void setGadProtocol(String protocol) {
        executableClient.setProtocal(protocol);
    }

    /**
     * @Description 设置idletime
     * @Param [idletime]
     **/
    private void setGadIdletime(long idletime) {
        executableClient.setIdletime(idletime);
    }

    /**
     * @Description 设置网关域名
     * https://openplatform-portal.dg-work.cn/portal/#/helpdoc?docKey=kfzn&slug=zbyq0h
     * @Param [domainName]
     **/
    private void setGadDomainName(String domainName) {
        executableClient.setDomainName(domainName);
    }

    /**
     * @Description 设置appSecret
     * @Param [secretKey]
     **/
    private void setGadSecretKey(String secretKey) {
        executableClient.setSecretKey(secretKey);
    }

    /**
     * @Description 设置appKey
     * @Param [accessKey]
     **/
    private void setGadAccessKey(String accessKey) {
        executableClient.setAccessKey(accessKey);
    }

    /**
     * @Description 销毁方法
     **/
    public void destroyGad() {
        executableClient.destroy();
    }

}
