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
     * @Description 工作通知消息 messageWorkNotificationObject入参
     * @Param [messageWorkNotificationObject]
     * @return java.lang.String
     **/
    String messageWorkNotification(MessageWorkNotificationObject messageWorkNotificationObject);

    /**
     * @Description 工作通知消息 messageSendSmsObject入参
     * @Param [messageWorkNotificationObject]
     * @return java.lang.String
     **/
    String messageSendSms(MessageSendSmsObject messageSendSmsObject);

    /**
     * @Description 工作通知消息 jsonObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String messageWorkNotification(JSONObject jsonObject);

    /**
     * @Description 工作通知消息 jsonObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String messageSendSms(JSONObject jsonObject);
}
