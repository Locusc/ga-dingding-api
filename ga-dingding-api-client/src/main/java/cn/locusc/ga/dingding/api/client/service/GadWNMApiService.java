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
     * 工作通知消息
     * @param messageWorkNotificationObject messageWorkNotificationObject入参
     * @return java.lang.String
     **/
    String messageWorkNotification(MessageWorkNotificationObject messageWorkNotificationObject);

    /**
     * 工作通知消息
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String messageWorkNotification(JSONObject jsonObject);

    /**
     * 发送工作台红点
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String messageSendPortalNotification(JSONObject jsonObject);

    /**
     * 清除工作台红点
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String messageClearPortalNotification(JSONObject jsonObject);

    /**
     * 查询工作台红点
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String messageQueryPortalNotification(JSONObject jsonObject);


}
