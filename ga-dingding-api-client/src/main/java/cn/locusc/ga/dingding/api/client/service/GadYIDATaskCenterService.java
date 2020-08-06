package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉宜搭任务中心接口
 * 15:45 2020/8/5
 **/
public interface GadYIDATaskCenterService {

    /**
     * 查询已完成任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetDoneTasksInCorp(JSONObject jsonObject);

    /**
     * 查询待办任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetTodoTasksInCorp(JSONObject jsonObject);

    /**
     * 已提交任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetMySubmmitInCorp(JSONObject jsonObject);

}
