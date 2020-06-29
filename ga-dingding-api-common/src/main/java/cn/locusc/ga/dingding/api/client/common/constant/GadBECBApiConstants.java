package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @Author Jay Chan
 * @Description 政务钉钉业务事件回调接口地址常量
 * @Date 9:21 2020/6/25
 **/
public class GadBECBApiConstants {

    /**
     * @Description 移除失败的回调
     **/
    public static final String MESSAGE_REMOVE_CALLBACK_FAILED = "/openplatform/message/remove_callback_failed";

    /**
     * @Description 重试失败回调
     **/
    public static final String MESSAGE_RETRY_CALLBACK_FAILED = "/openplatform/message/retry_callback_failed";

    /**
     * @Description 查询回调失败信息
     **/
    public static final String MESSAGE_QUERY_CALLBACK_FAILED = "/openplatform/message/query_callback_failed";

    /**
     * @Description 删除事件回调的定义信息
     **/
    public static final String MESSAGE_DELETE_EVENT_CALLBACK_DEFINE = "/openplatform/message/delete_event_callback_define";

    /**
     * @Description 更新事件回调的定义信息
     **/
    public static final String MESSAGE_UPDATE_EVENT_CALLBACK_DEFINE = "/openplatform/message/update_event_callback_define";

    /**
     * @Description 查询定义的事件列表
     **/
    public static final String MESSAGE_QUERY_CALLBACK_DEFINE = "/openplatform/message/query_callback_define";

    /**
     * @Description 注册消息回调
     **/
    public static final String MESSAGE_REGISTER_EVENT_CALLBACK = "/openplatform/message/register_event_callback";

}
