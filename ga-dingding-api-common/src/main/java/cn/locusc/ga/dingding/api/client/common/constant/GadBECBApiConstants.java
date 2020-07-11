package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉业务事件回调接口地址常量
 * 9:21 2020/6/25
 **/
public class GadBECBApiConstants {

    /**
     * 移除失败的回调
     **/
    public static final String MESSAGE_REMOVE_CALLBACK_FAILED = "/openplatform/message/remove_callback_failed";

    /**
     * 重试失败回调
     **/
    public static final String MESSAGE_RETRY_CALLBACK_FAILED = "/openplatform/message/retry_callback_failed";

    /**
     * 查询回调失败信息
     **/
    public static final String MESSAGE_QUERY_CALLBACK_FAILED = "/openplatform/message/query_callback_failed";

    /**
     * 删除事件回调的定义信息
     **/
    public static final String MESSAGE_DELETE_EVENT_CALLBACK_DEFINE = "/openplatform/message/delete_event_callback_define";

    /**
     * 更新事件回调的定义信息
     **/
    public static final String MESSAGE_UPDATE_EVENT_CALLBACK_DEFINE = "/openplatform/message/update_event_callback_define";

    /**
     * 查询定义的事件列表
     **/
    public static final String MESSAGE_QUERY_CALLBACK_DEFINE = "/openplatform/message/query_callback_define";

    /**
     * 注册消息回调
     **/
    public static final String MESSAGE_REGISTER_EVENT_CALLBACK = "/openplatform/message/register_event_callback";

    /**
     * 注册消息回调（支持加密、签名）
     **/
    public static final String MESSAGE_V2_REGISTER_EVENT_CALLBACK = "/openplatform/message/v2/register_event_callback";


}
