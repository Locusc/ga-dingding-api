package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author Jay Chan
 * @Description 政务钉钉日程接口
 * @Date 10:32 2020/6/28
 **/
interface GadScheduleApiService {
    
    /**
     * @Description 取消日历事件 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String calendarCancelCalendarEvent(JSONObject jsonObject);

    /**
     * @Description 创建日历事件 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String calendarCreateCalendarEvent(JSONObject jsonObject);

    /**
     * @Description 创建日历事件 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String calendarGetCalendarDetail(JSONObject jsonObject);
}
