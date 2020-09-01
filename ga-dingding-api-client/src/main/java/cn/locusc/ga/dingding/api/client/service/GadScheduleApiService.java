package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉日程接口
 * 10:32 2020/6/28
 **/
interface GadScheduleApiService {
    
    /**
     * 取消日历事件
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String calendarCancelCalendarEvent(JSONObject jsonObject);

    /**
     * 创建日历事件
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String calendarCreateCalendarEvent(JSONObject jsonObject);

    /**
     * 获取APP设置可见的用户Id
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String calendarAppQueryAppVisibleList(JSONObject jsonObject);

    /**
     * 从可见用户列表中删除指定用户
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String calendarAppRemoveUserFromAppVisibleList(JSONObject jsonObject);

    /**
     * 设置APP的用户可见性
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String calendarAppAddUserToAppVisibleList(JSONObject jsonObject);

    /**
     * 获取用户可用的app
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String calendarAppUserVisibleApps(JSONObject jsonObject);

}
