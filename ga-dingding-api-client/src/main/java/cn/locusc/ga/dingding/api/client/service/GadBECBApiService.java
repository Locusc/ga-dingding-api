package cn.locusc.ga.dingding.api.client.service;

/**
 * @Author Jay Chan
 * @Description 政务钉钉业务事件回调接口
 * @Date 18:55 2020/6/25
 **/
interface GadBECBApiService {

    /**
     * @Description 移除失败回调
     * @Param [eventCallbackFailedId]
     * @return java.lang.String
     **/
    String messageRemoveCallbackFailed(Long eventCallbackFailedId);

    /**
     * @Description 重试失败回调
     * @Param [eventCallbackFailedId]
     * @return java.lang.String
     **/
    String messageRetryCallbackFailed(Long eventCallbackFailedId);

    /**
     * @Description 查询回调失败信息
     * @Param []
     * @return java.lang.String
     **/
    String messageQueryCallbackFailed();

    /**
     * @Description 删除事件回调的定义信息
     * @Param [eventCallbackId]
     * @return java.lang.String
     **/
    String messageDeleteEventCallbackDefine(Long eventCallbackId);

    /**
     * @Description 更新事件回调的定义信息
     * @Param [eventCallbackId, callbackUrl]
     * @return java.lang.String
     **/
    String messageUpdateEventCallbackDefined(Long eventCallbackId, String callbackUrl);

    /**
     * @Description 查询定义的事件列表
     * @Param []
     * @return java.lang.String
     **/
    String messageQueryCallbackDefine();

    /**
     * @Description 注册消息回调
     * @Param [eventTag, callbackUrl]
     * @return java.lang.String
     **/
    String messageRegisterEventCallback(String eventTag, String callbackUrl);
}
