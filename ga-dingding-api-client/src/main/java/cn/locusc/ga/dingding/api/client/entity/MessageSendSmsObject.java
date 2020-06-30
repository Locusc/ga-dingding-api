package cn.locusc.ga.dingding.api.client.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jay Chan
 * 政务钉钉发送短信入参实体
 * 20:07 2020/6/25
 **/
@Data
public class MessageSendSmsObject implements Serializable {

    /**
     * 模版id，找政务钉钉申请
     **/
    private String templateId;

    /**
     * 自定义的替换参数，例如{"name":"张三"}
     **/
    private JSONObject jsonContent;

    /**
     * 接受人手机号，多个人以”,“分割
     **/
    private List<String> phoneNumber;

}
