package cn.locusc.ga.dingding.api.client.component;

import com.alibaba.xxpt.gateway.shared.client.http.*;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Jay Chan
 * 封装政务钉钉官方SDK
 * 16:42 2020/6/24
 **/
@Component
public class GadClientTemplate {

    @Resource
    private ExecutableClient executableClient;

    /**
     * execute方法
     * @param httpRequest httpRequest
     * @return java.lang.String
     * @throws GwException GwException
     **/
    public String executeGad(AbstractRequest httpRequest) throws GwException {
        return executableClient.execute(httpRequest);
    }

    /**
     * 初始化方法
     **/
    public void initGad() {
        executableClient.init();
    }

    /**
     * Get请求
     * @param api 请求地址
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api) {
        return executableClient.newGetClient(api);
    }

    /**
     * Get请求
     * @param api 请求地址
     * @param timeout 超时事件
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api, int timeout) {
        return executableClient.newGetClient(api, timeout);
    }

    /**
     * Get请求
     * @param api 请求地址
     * @param version 版本号
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api, String version) {
        return executableClient.newGetClient(api, version);
    }

    /**
     * Get请求
     * @param api 请求地址
     * @param version 版本号
     * @param timeout 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.GetClient
     **/
    public GetClient newGadGetClient(String api, String version, int timeout) {
        return executableClient.newGetClient(api, version, timeout);
    }

    /**
     * Post请求
     * @param api 请求地址
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api) {
        return executableClient.newPostClient(api);
    }

    /**
     * Post请求
     * @param api 请求地址
     * @param timeout 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api, int timeout) {
        return executableClient.newPostClient(api, timeout);
    }

    /**
     * Post请求
     * @param api 请求地址
     * @param version 版本号
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api, String version) {
        return executableClient.newPostClient(api, version);
    }

    /**
     * Post请求
     * @param api 请求地址
     * @param version 版本号
     * @param timeout 超时时间
     * @return com.alibaba.xxpt.gateway.shared.client.http.PostClient
     **/
    public PostClient newGadPostClient(String api, String version, int timeout) {
        return executableClient.newPostClient(api, version, timeout);
    }

    /**
     * 获取Uri
     * @return java.lang.String
     **/
    public String getGadUri() {
        return executableClient.getUri();
    }

    /**
     * 获取RoutePlanner
     * @return org.apache.http.conn.routing.HttpRoutePlanner
     **/
    public HttpRoutePlanner getGadRoutePlanner() {
        return executableClient.getRoutePlanner();
    }

    /**
     * 获取Idletime
     * @return long
     **/
    public long getGadIdletime() {
        return executableClient.getIdletime();
    }

    /**
     * 获取HttpClient
     * @return org.apache.http.impl.client.CloseableHttpClient
     **/
    public CloseableHttpClient getGadHttpClient() {
        return executableClient.getHttpClient();
    }

    /**
     * 设置routePlanner
     * @param routePlanner routePlanner
     **/
    private void setGadRoutePlanner(HttpRoutePlanner routePlanner) {
        executableClient.setRoutePlanner(routePlanner);
    }

    /**
     * 设置协议
     * @param protocol 协议类型
     **/
    private void setGadProtocol(String protocol) {
        executableClient.setProtocal(protocol);
    }

    /**
     * 设置idletime
     * @param idletime idletime
     **/
    private void setGadIdletime(long idletime) {
        executableClient.setIdletime(idletime);
    }

    /**
     * 设置网关域名
     * https://openplatform-portal.dg-work.cn/portal/#/helpdoc?docKey=kfzn&slug=zbyq0h
     * @param domainName 网关域名
     **/
    private void setGadDomainName(String domainName) {
        executableClient.setDomainName(domainName);
    }

    /**
     * 设置appSecret
     * @param secretKey appSecret
     **/
    private void setGadSecretKey(String secretKey) {
        executableClient.setSecretKey(secretKey);
    }

    /**
     * 设置appKey
     * @param accessKey appKey
     **/
    private void setGadAccessKey(String accessKey) {
        executableClient.setAccessKey(accessKey);
    }

    /**
     * 销毁方法
     **/
    public void destroyGad() {
        executableClient.destroy();
    }

}
