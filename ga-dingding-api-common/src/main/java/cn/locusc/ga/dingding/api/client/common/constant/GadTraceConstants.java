package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉轨迹服务接口地址常量
 * 9:48 2020/7/1
 **/
public class GadTraceConstants {

    /**
     * 外部服务查询用户轨迹
     **/
    public static final String GBS_TRACE_QUERY_USER_BY_ISV = "/gbs/traceQuery/queryUserTraceByIsv";

    /**
     * 外部服务停止轨迹上报
     **/
    public static final String GBS_TRACE_STOP_TRACE_COLLECT_BY_ISV = "/gbs/trace/stopTraceCollectByIsv";

    /**
     * 外部服务开启轨迹采集
     **/
    public static final String GBS_TRACE_START_TRACE_COLLECT_BY_ISV = "/gbs/trace/startTraceCollectByIsv";

    /**
     * isv或外部服务生成轨迹id
     **/
    public static final String GBS_TRACE_GENERATE_TRACE_ID_BY_ISV = "/gbs/trace/generateTraceIdByIsv";

    /**
     * 获取轨迹推送失败消息
     **/
    public static final String BIP_REGISTER_FAILED_TASKS = "/bip/register/failedTasks";

    /**
     * 应用注销轨迹推送
     **/
    public static final String BIP_REGISTER_CANCELL = "/bip/register/cancell";

    /**
     * 获取轨迹推送注册
     **/
    public static final String BIP_REGISTER_GET_EVENTS = "/bip/register/getEvents";

    /**
     * 应用更新轨迹推送事件数据
     **/
    public static final String BIP_REGISTER_UPDATE_EVENT = "/bip/register/updateEvent";

    /**
     * 轨迹推送注册
     **/
    public static final String BIP_REGISTER_REGISTER_APP = "/bip/register/registerApp";

    /**
     * 开启轨迹采集
     **/
    public static final String GBS_TRACE_START_TRACE_COLLECT = "/gbs/trace/startTraceCollect";

    /**
     * 校验轨迹id
     **/
    public static final String GBS_TRACE_CHECK_TRACE_ID = "/gbs/trace/checkTraceId";

    /**
     * 根据位置范围查询用户
     **/
    public static final String GBS_TRACE_QUERY_USER_BY_GEO_SCOPE = "/gbs/traceQuery/queryUserByGeoScope";

}
