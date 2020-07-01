package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉轨迹服务地址常量
 * 9:48 2020/7/1
 **/
public class GadTraceConstants {

    /**
     * 外部服务查询用户轨迹
     **/
    public static final String GBS_TRACE_QUERY_USER_BY_ISV = "/gbs/traceQuery/queryUserTraceByIsv";

    /**
     * 外部服务查询用户轨迹
     **/
    public static final String GBS_TRACE_QUERY_USER_TRACE = "/gbs/traceQuery/queryUserTrace";

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
     * 接收轨迹数据
     **/
    public static final String GBS_TRACE_RECEIVE_TRACE_DATA = "/gbs/trace/receiveTraceData";

    /**
     * 停止轨迹上报
     **/
    public static final String GBS_TRACE_STOP_TRACE_COLLECT = "/gbs/trace/stopTraceCollect";

    /**
     * 轨迹id生成
     **/
    public static final String GBS_TRACE_GENERATE_TRACE_ID= "/gbs/trace/generateTraceId";
}
