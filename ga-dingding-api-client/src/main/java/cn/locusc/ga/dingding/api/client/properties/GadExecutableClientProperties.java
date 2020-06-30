package cn.locusc.ga.dingding.api.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author Jay Chan
 * 政务钉钉官方请求SDK参数配置 自动装配类
 * 15:22 2020/6/24
 **/
@Data
@Validated
@ConfigurationProperties(prefix = "gad.api.client")
public class GadExecutableClientProperties {

    /**
     * 应用appKey
     **/
    @NotEmpty(message = "appKey is null")
    private String accessKey;

    /**
     * 应用secretKey
     **/
    @NotEmpty(message = "appSecret is null")
    private String secretKey;

    /**
     * 网关域名
     * https://openplatform-portal.dg-work.cn/portal/#/helpdoc?docKey=kfzn&slug=zbyq0h
     **/
    @NotEmpty(message = "domainName is null")
    private String domainName;

    /**
     * 协议类型: https
     **/
    @NotEmpty(message = "protocol is null")
    private String protocol;
}
