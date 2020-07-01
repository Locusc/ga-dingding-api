package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉轨迹服务接口
 * 9:47 2020/7/1
 **/
interface GadTraceService {

    /**
     * 外部服务查询用户轨迹
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceQueryUserByIsv(JSONObject jsonObject);

    /**
     * 外部服务查询用户轨迹
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceQueryUserTrace(JSONObject jsonObject);

    /**
     * 外部服务停止轨迹上报
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceStopTraceCollectByIsv(JSONObject jsonObject);

    /**
     * 外部服务开启轨迹采集
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceStartTraceCollectByIsv(JSONObject jsonObject);

    /**
     * isv或外部服务生成轨迹id
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceGenerateTraceIdByIsv(JSONObject jsonObject);

    /**
     * 接收轨迹数据
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceReceiveTraceData(JSONObject jsonObject);

    /**
     * 停止轨迹上报
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceStopTraceCollect(JSONObject jsonObject);

    /**
     * 轨迹id生成
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceGenerateTraceId(JSONObject jsonObject);
}
