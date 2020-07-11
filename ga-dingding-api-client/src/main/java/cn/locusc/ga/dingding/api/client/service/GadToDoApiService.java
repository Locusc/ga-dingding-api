package cn.locusc.ga.dingding.api.client.service;

import cn.locusc.ga.dingding.api.client.entity.TcV2OpenApiTaskCreateObject;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉待办接口
 * 19:33 2020/6/25
 **/
interface GadToDoApiService {

    /**
     * 取消实例接口
     * @param userId 用户ID
     * @param packageUuid 实例唯一ID
     * @return java.lang.String
     **/
    String tcOpenApiPackageCancel(String userId, String packageUuid);

    /**
     * 关闭实例接口
     * @param userId 用户ID
     * @param packageUuid 实例唯一ID
     * @return java.lang.String
     **/
    String tcOpenApiPackageClose(String userId, String packageUuid);

    /**
     * 取消待办任务
     * @param cancelPakcage 同步处理实例
     * @param userId 用户ID
     * @param taskUuid 任务唯一ID
     * @return java.lang.String
     **/
    String tcOpenApiTaskCancel(Boolean cancelPakcage, String userId, String taskUuid);

    /**
     * 完成待办任务
     * @param closePackage 同步处理实例
     * @param userId 用户ID
     * @param taskUuid 任务唯一ID
     * @return java.lang.String
     **/
    String tcOpenApiTaskFinish(Boolean closePackage, String userId, String taskUuid);

    /**
     * 创建待办接口v2
     * @param tcV2OpenApiTaskCreateObject tcV2OpenApiTaskCreateObject入参
     * @return java.lang.String
     **/
    String tcV2OpenApiTaskCreate(TcV2OpenApiTaskCreateObject tcV2OpenApiTaskCreateObject);

    /**
     * 创建待办接口v2
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String tcV2OpenApiTaskCreate(JSONObject jsonObject);

}
