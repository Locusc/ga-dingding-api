package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉宜搭流程接口地址常量
 * 15:15 2020/8/5
 **/
public class GadYIDAProcessConstants {

    /**
     * 根据搜索条件获取实例详情列表
     **/
    public static final String YIDA_PROCESS_GET_INSTANCES = "/yida/process/getInstances.json";

    /**
     * 获取流程设计节点上的按钮列表
     **/
    public static final String YIDA_PROCESS_GET_ACTIVITY_BUTTON_VOS = "/yida/process/getActivityButtonVOs.json";

    /**
     * 流程实例更新
     **/
    public static final String YIDA_PROCESS_UPDATE_INSTANCE = "/yida/process/updateInstance.json";

    /**
     * 执行虚拟节点任务
     **/
    public static final String YIDA_PROCESS_EXECUTE_PLATFORM_TASK = "/yida/process/executePlatformTask.json";

    /**
     * 获取审批记录
     **/
    public static final String YIDA_PROCESS_GET_OPERATION_RECORDS = "/yida/process/getOperationRecords.json";

    /**
     * 执行单个任务接口
     **/
    public static final String YIDA_PROCESS_EXECUTE_TASK = "/yida/task/executeTask.json";

    /**
     * 终止流程实例
     **/
    public static final String YIDA_PROCESS_TERMINATE_INSTANCE = "/yida/process/terminateInstance.json";

    /**
     * 删除流程实例
     **/
    public static final String YIDA_PROCESS_DELETE_INSTANCE = "/yida/process/deleteInstance.json";

    /**
     * 根据实例ID获取流程实例详情
     **/
    public static final String YIDA_PROCESS_GET_INSTANCE_BY_ID = "/yida/process/getInstanceById.json";

    /**
     * 搜索流程实例ID
     **/
    public static final String YIDA_PROCESS_GET_INSTANCE_IDS = "/yida/process/getInstanceIds.json";

    /**
     * 流程发起
     **/
    public static final String YIDA_PROCESS_START_INSTANCE = "/yida/process/startInstance.json";

}
