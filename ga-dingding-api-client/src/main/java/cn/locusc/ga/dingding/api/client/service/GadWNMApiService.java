package cn.locusc.ga.dingding.api.client.service;

import cn.locusc.ga.dingding.api.client.entity.MessageSendSmsObject;
import cn.locusc.ga.dingding.api.client.entity.MessageWorkNotificationObject;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author Jay Chan
 * @Description 政务钉钉工作通知消息接口
 * @Date 19:33 2020/6/25
 **/
interface GadWNMApiService {
    
    /**
     * 工作通知消息 messageWorkNotificationObject入参
     * @param messageWorkNotificationObject
     * @return java.lang.String
     **/
    String messageWorkNotification(MessageWorkNotificationObject messageWorkNotificationObject);

    /**
     * 发送消息 messageSendSmsObject入参
     * @param messageSendSmsObject
     * @return java.lang.String
     **/
    String messageSendSms(MessageSendSmsObject messageSendSmsObject);

    /**
     * 工作通知消息 jsonObject入参
     * @param jsonObject
     * @return java.lang.String
     **/
    String messageWorkNotification(JSONObject jsonObject);

    /**
     * 发送消息 jsonObject入参
     * @param jsonObject
     * @return java.lang.String
     **/
    String messageSendSms(JSONObject jsonObject);
}
