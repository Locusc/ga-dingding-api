package cn.locusc.ga.dingding.api.client.service;


import cn.locusc.ga.dingding.api.client.entity.ImChatIsvCreatGroupChatObject;
import cn.locusc.ga.dingding.api.client.entity.ImChatIsvSendMsgObject;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author Jay Chan
 * @Description 政务钉钉会话接口
 * @Date 14:40 2020/6/25
 **/
interface GadChatApiService {

    /**
     * @Description 发送IM消息 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String imChatIsvSendMsg(JSONObject jsonObject);

    /**
     * @Description 发送IM消息 ImChatIsvSendMsgObject入参
     * @Param [imChatIsvSendMsgObject]
     * @return java.lang.String
     **/
    String imChatIsvSendMsg(ImChatIsvSendMsgObject imChatIsvSendMsgObject);

    /**
     * @Description 创建群聊会话 JSONObject入参
     * @Param [object]
     * @return java.lang.String
     **/
    String imChatIsvCreatGroupChat(JSONObject jsonObject);

    /**
     * @Description 创建群聊会话 ImChatIsvCreatGroupChatObject入参
     * @Param [imChatIsvCreatGroupChatObject]
     * @return java.lang.String
     **/
    String imChatIsvCreatGroupChat(ImChatIsvCreatGroupChatObject imChatIsvCreatGroupChatObject);

}
