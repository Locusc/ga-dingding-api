package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉会话接口
 * 14:40 2020/6/25
 **/
interface GadChatApiService {

    /**
     * 创建群会话
     * @param jsonObject  JSONObject入参
     * @return java.lang.String
     **/
    String chatCreate(JSONObject jsonObject);

    /**
     * 发送消息
     * @param jsonObject  JSONObject入参
     * @return java.lang.String
     **/
    String chatSendMsg(JSONObject jsonObject);

    /**
     * 获取群成员
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String chatGroupGetUsers(JSONObject jsonObject);

    /**
     * 获取消息已读人数
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String chatGroupMessageReadUsers(JSONObject jsonObject);

    /**
     * 更新群会话
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String chatGroupUpdate(JSONObject jsonObject);

}
