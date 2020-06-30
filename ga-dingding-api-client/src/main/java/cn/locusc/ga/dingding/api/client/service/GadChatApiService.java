package cn.locusc.ga.dingding.api.client.service;


import cn.locusc.ga.dingding.api.client.entity.ImChatIsvCreatGroupChatObject;
import cn.locusc.ga.dingding.api.client.entity.ImChatIsvSendMsgObject;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉会话接口
 * 14:40 2020/6/25
 **/
interface GadChatApiService {

    /**
     * 发送IM消息 JSONObject入参
     * @param jsonObject
     * @return java.lang.String
     **/
    String imChatIsvSendMsg(JSONObject jsonObject);

    /**
     * 发送IM消息 ImChatIsvSendMsgObject入参
     * @param imChatIsvSendMsgObject
     * @return java.lang.String
     **/
    String imChatIsvSendMsg(ImChatIsvSendMsgObject imChatIsvSendMsgObject);

    /**
     * 创建群聊会话 JSONObject入参
     * @param jsonObject
     * @return java.lang.String
     **/
    String imChatIsvCreatGroupChat(JSONObject jsonObject);

    /**
     * 创建群聊会话 ImChatIsvCreatGroupChatObject入参
     * @param imChatIsvCreatGroupChatObject
     * @return java.lang.String
     **/
    String imChatIsvCreatGroupChat(ImChatIsvCreatGroupChatObject imChatIsvCreatGroupChatObject);

}
