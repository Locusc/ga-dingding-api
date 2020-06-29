package cn.locusc.ga.dingding.api.client.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @Author Jay Chan
 * @Description 政务钉钉会话接口入参实体
 * @Date 15:37 2020/6/25
 **/
@Data
public class ImChatIsvSendMsgObject implements Serializable {

    /**
     * @Description IM发送消息体
     **/
    @NonNull
    private String msg;

    /**
     * @Description 发送者ID
     **/
    @NonNull
    private String senderId;

    /**
     * @Description 消息接收者ID
     **/
    private String receiverId;

    /**
     * @Description 群聊会话ID
     **/
    private String cid;

    /**
     * @Description 聊天类型，单聊为1，群聊为2
     **/
    @NonNull
    private Integer chatType;

}
