package cn.locusc.ga.dingding.api.client.service;

/**
 * @author Jay Chan
 * 政务钉钉业务事件回调接口
 * 18:55 2020/6/25
 **/
interface GadBECBApiService {

    /**
     * 移除失败回调
     * @param eventCallbackFailedId 失败的id
     * @return java.lang.String
     **/
    String messageRemoveCallbackFailed(Long eventCallbackFailedId);

    /**
     * 重试失败回调
     * @param eventCallbackFailedId 回调失败的id
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
     * @param eventCallbackId 订阅回调的id
     * @return java.lang.String
     **/
    String messageDeleteEventCallbackDefine(Long eventCallbackId);

    /**
     * 更新事件回调的定义信息
     * @param eventCallbackId 注册的回调id
     * @param callbackUrl 注册的http地址
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
     * @param eventTag 消息事件标识
     * @param callbackUrl 消息回调http地址
     * @return java.lang.String
     **/
    String messageRegisterEventCallback(String eventTag, String callbackUrl);

    /**
     * 注册消息回调
     * @param eventTag 消息事件标识
     * @param callbackUrl 消息回调http地址
     * @return java.lang.String
     **/
    String messageV2RegisterEventCallback(String eventTag, String callbackUrl);
}
