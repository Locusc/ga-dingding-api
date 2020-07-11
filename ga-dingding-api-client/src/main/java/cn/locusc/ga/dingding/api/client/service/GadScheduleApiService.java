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

}
