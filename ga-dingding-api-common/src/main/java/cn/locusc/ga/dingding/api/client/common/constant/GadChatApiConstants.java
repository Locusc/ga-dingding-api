package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉会话接口地址常量
 * 9:16 2020/6/25
 **/
public class GadChatApiConstants {

    /**
     * 创建群会话
     **/
    public static final String CHAT_CREATE = "/chat/create";

    /**
     * 发送消息
     **/
    public static final String CHAT_SEND_MSG = "/chat/sendMsg";

    /**
     * 获取群成员
     **/
    public static final String CHAT_GROUP_GET_USERS = "/chat/group/getUsers";

    /**
     * 获取消息已读人数
     **/
    public static final String CHAT_GROUP_MESSAGE_READ_USERS = "/chat/group/messageReadUsers";

    /**
     * 更新群会话
     **/
    public static final String CHAT_GROUP_UPDATE = "/chat/group/update";


}
