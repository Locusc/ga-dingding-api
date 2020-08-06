package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉宜搭流程接口
 * 15:48 2020/8/5
 **/
public interface GadYIDAProcessService {

    /**
     * 根据搜索条件获取实例详情列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetInstances(JSONObject jsonObject);

    /**
     * 获取流程设计节点上的按钮列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetActivityButtonVOs(JSONObject jsonObject);

    /**
     * 流程实例更新
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessUpdateInstance(JSONObject jsonObject);

    /**
     * 执行虚拟节点任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessExecutePlatformTask(JSONObject jsonObject);

    /**
     * 获取审批记录
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetOperationRecords(JSONObject jsonObject);

    /**
     * 执行单个任务接口
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessExecuteTask(JSONObject jsonObject);

    /**
     * 终止流程实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessTerminateInstance(JSONObject jsonObject);

    /**
     * 删除流程实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessDeleteInstance(JSONObject jsonObject);

    /**
     * 根据实例ID获取流程实例详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetInstanceById(JSONObject jsonObject);

    /**
     * 搜索流程实例ID
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessGetInstanceIds(JSONObject jsonObject);

    /**
     * 流程发起
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaProcessStartInstance(JSONObject jsonObject);

}
