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
     * 获取轨迹推送失败消息
     * @param eventTag 注册事件类型
     * @return java.lang.String
     **/
    String BipRegisterFailedTasks(String eventTag);

    /**
     * 应用注销轨迹推送
     * @param id 注册id
     * @return java.lang.String
     **/
    String BipRegisterCancell(String id);

    /**
     * 获取轨迹推送注册
     * @return java.lang.String
     **/
    String BipRegisterGetEvents();

    /**
     * 应用更新轨迹推送事件数据
     * @param id 应用注册id
     * @param callBackUrl 回调地址
     * @return java.lang.String
     **/
    String BipRegisterUpdateEvent(String id, String callBackUrl);

    /**
     * 轨迹推送注册
     * @param eventTag 注册事件类型，轨迹实时推送填：real_time_trace
     * @param callBackUrl 数据推送的回调地址
     * @return java.lang.String
     **/
    String BipRegisterRegisterApp(String eventTag, String callBackUrl);

    /**
     * 开启轨迹采集
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceStartTraceCollect(JSONObject jsonObject);

    /**
     * 校验轨迹id
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceCheckTraceId(JSONObject jsonObject);

    /**
     * 根据位置范围查询用户
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GbsTraceQueryUserByGeoScope(JSONObject jsonObject);
}
