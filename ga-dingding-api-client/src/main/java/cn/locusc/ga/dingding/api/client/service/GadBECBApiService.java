package cn.locusc.ga.dingding.api.client.service;

/**
 * @author Jay Chan
 * 政务钉钉业务事件回调接口
 * 18:55 2020/6/25
 **/
interface GadBECBApiService {

    /**
     * 移除失败回调
     * @param eventCallbackFailedId
     * @return java.lang.String
     **/
    String messageRemoveCallbackFailed(Long eventCallbackFailedId);

    /**
     * 重试失败回调
     * @param eventCallbackFailedId
     * @return java.lang.String
     **/
    String messageRetryCallbackFailed(Long eventCallbackFailedId);

    /**
     * 查询回调失败信息
     * @return java.lang.String
     **/
    String messageQueryCallbackFailed();

    /**
     * 删除事件回调的定义信息
     * @param eventCallbackId
     * @return java.lang.String
     **/
    String messageDeleteEventCallbackDefine(Long eventCallbackId);

    /**
     * 更新事件回调的定义信息
     * @param eventCallbackId
     * @param callbackUrl
     * @return java.lang.String
     **/
    String messageUpdateEventCallbackDefined(Long eventCallbackId, String callbackUrl);

    /**
     * 查询定义的事件列表
     * @return java.lang.String
     **/
    String messageQueryCallbackDefine();

    /**
     * 注册消息回调
     * @param eventTag
     * @param callbackUrl
     * @return java.lang.String
     **/
    String messageRegisterEventCallback(String eventTag, String callbackUrl);
}
