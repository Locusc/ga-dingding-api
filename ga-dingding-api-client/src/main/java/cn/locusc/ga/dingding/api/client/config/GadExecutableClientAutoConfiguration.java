package cn.locusc.ga.dingding.api.client.config;

import cn.locusc.ga.dingding.api.client.properties.GadExecutableClientProperties;
import com.alibaba.xxpt.gateway.shared.client.http.ExecutableClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author Jay Chan
 * @Description 政务钉钉官方请求SDK Config
 * @Date 15:18 2020/6/24
 **/
@Configuration
@ComponentScan(basePackages = "cn.locusc.ga.dingding.api.client")
@EnableConfigurationProperties({GadExecutableClientProperties.class})
public
class GadExecutableClientAutoConfiguration {

    @Resource
    private GadExecutableClientProperties gadExecutableClientProperties;

    /**
     * @Description 初始政务钉钉官方请求SDK
     * @return com.alibaba.xxpt.gateway.shared.client.http.ExecutableClient
     **/
    @Bean
    protected ExecutableClient InitGadExecutableClient() {
        ExecutableClient executableClient = ExecutableClient.getInstance();
        executableClient.setAccessKey(gadExecutableClientProperties.getAccessKey());
        executableClient.setSecretKey(gadExecutableClientProperties.getSecretKey());
        executableClient.setDomainName(gadExecutableClientProperties.getDomainName());
        executableClient.setProtocal(gadExecutableClientProperties.getProtocol());
        executableClient.init();
        return executableClient;
    }

}
