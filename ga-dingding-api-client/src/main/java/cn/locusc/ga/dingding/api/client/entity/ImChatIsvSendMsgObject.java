package cn.locusc.ga.dingding.api.client.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author Jay Chan
 * 政务钉钉会话接口入参实体
 * 15:37 2020/6/25
 **/
@Data
public class ImChatIsvSendMsgObject implements Serializable {

    /**
     * IM发送消息体
     **/
    @NonNull
    private String msg;

    /**
     * 发送者ID
     **/
    @NonNull
    private String senderId;

    /**
     * 消息接收者ID
     **/
    private String receiverId;

    /**
     * 群聊会话ID
     **/
    private String cid;

    /**
     * 聊天类型，单聊为1，群聊为2
     **/
    @NonNull
    private Integer chatType;

}
