package cn.locusc.ga.dingding.api.client.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Jay Chan
 * @Description 政务钉钉发送短信入参实体
 * @Date 20:07 2020/6/25
 **/
@Data
public class MessageSendSmsObject implements Serializable {

    /**
     * @Description 模版id，找政务钉钉申请
     **/
    private String templateId;

    /**
     * @Description 自定义的替换参数，例如{"name":"张三"}
     **/
    private JSONObject jsonContent;

    /**
     * @Description 接受人手机号，多个人以”,“分割
     **/
    private List<String> phoneNumber;

}
