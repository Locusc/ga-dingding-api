package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉日程接口
 * 10:32 2020/6/28
 **/
interface GadScheduleApiService {
    
    /**
     * 取消日历事件 JSONObject入参
     * @param jsonObject
     * @return java.lang.String
     **/
    String calendarCancelCalendarEvent(JSONObject jsonObject);

    /**
     * 创建日历事件 JSONObject入参
     * @param jsonObject
     * @return java.lang.String
     **/
    String calendarCreateCalendarEvent(JSONObject jsonObject);

    /**
     * 日程:获取日历详情
     * @param jsonObject
     * @return java.lang.String
     **/
    String calendarGetCalendarDetail(JSONObject jsonObject);
}
