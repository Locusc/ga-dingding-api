package cn.locusc.ga.dingding.api.client.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Jay Chan
 * @Description 政务钉钉工作通知消息入参实体
 * @Date 20:07 2020/6/25
 **/
@Data
public class MessageWorkNotificationObject implements Serializable {

    /**
     * @Description 接收者的部门id列表，最大列表长度：20, 接收者是部门id下(包括子部门下)的所有用户
     **/
    private List<String> organizationCodes;

    /**
     * @Description 接收人用户ID(accountId)，多个人时使用半角逗号分隔 list类型
     **/
    private List<String> receiverIds;

    /**
     * @Description 租户ID
     **/
    @NonNull
    private String tenantId;

    /**
     * @Description 业务消息id，自定义，有去重功能 调用者的业务数据ID，同样的ID调用多次会提示"重复"错误
     **/
    private String bizMsgId;

    /**
     * @Description json对象 必须 {"msgtype":"text","text":{"content":"消息内容"}} 消息内容，
     *              消息类型和样例参考消息类型。最长不超过2048个字节 JsonObject类型
     **/
    @NonNull
    private JSONObject msg;

}
