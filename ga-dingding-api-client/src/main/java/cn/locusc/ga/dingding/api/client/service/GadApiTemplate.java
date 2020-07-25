package cn.locusc.ga.dingding.api.client.service;

import cn.locusc.ga.dingding.api.client.component.GadClientTemplate;
import cn.locusc.ga.dingding.api.client.common.constant.*;
import cn.locusc.ga.dingding.api.client.entity.*;
import cn.locusc.ga.dingding.api.client.common.exception.GadIndexOutOfBoundsException;
import cn.locusc.ga.dingding.api.client.common.exception.GadNullPointerException;
import cn.locusc.ga.dingding.api.client.properties.GadExecutableClientProperties;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.xxpt.gateway.shared.client.http.PostClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;


/**
 * @author Jay Chan
 * 政务钉钉请求api总类
 * 20:51 2020/6/24
 **/
@Service
public class GadApiTemplate extends GadClientTemplate implements GadBECBApiService,
        GadChatApiService, GadJsApiAuthService, GadLoginApiService, GadScheduleApiService,
        GadToDoApiService, GadWNMApiService, GadABUIApiService, GadABDIApiService,
        GadTraceService, GadFileStorageService, GadDingService, GadAMBApiService {

    @Resource
    private GadExecutableClientProperties gadExecutableClientProperties;

    /* DING接口实现 */
    /**
     * DING API开放
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GovDingIsvSend(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadDingConstants.GOV_DING_ISV_SEND)
                .addParameter("notifyType", jsonObject.getJSONObject("creator").toJSONString())
                .addParameter("notifyType", jsonObject.getString("notifyType"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("textType", jsonObject.getString("textType"))
                .addParameter("body", jsonObject.getString("body"))
                .addParameter("bodyType", jsonObject.getString("bodyType"));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("receivers"))) {
            jsonObject.getJSONArray("receivers").forEach(receiver -> {
                postClient.addParameter("bodyType", String.valueOf(receiver));
            });
        } else {
            postClient.addParameter("receivers", jsonObject.getJSONObject("receivers").toJSONString());
        }
        return postClient.post();
    }

    /* 轨迹服务接口实现 */
    /**
     * 外部服务查询用户轨迹
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceQueryUserByIsv(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_QUERY_USER_BY_ISV)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("startTime", String.valueOf(jsonObject.getLong("startTime")))
                .addParameter("endTime", String.valueOf(jsonObject.getLong("endTime")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 查询用户轨迹
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceQueryUserTrace(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_QUERY_USER_TRACE)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("startTime", String.valueOf(jsonObject.getLong("startTime")))
                .addParameter("endTime", String.valueOf(jsonObject.getLong("endTime")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")));
        return postClient.post();
    }

    /**
     * 外部服务停止轨迹上报
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceStopTraceCollectByIsv(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_STOP_TRACE_COLLECT_BY_ISV)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 外部服务开启轨迹采集
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceStartTraceCollectByIsv(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_START_TRACE_COLLECT_BY_ISV)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("frequency", jsonObject.getJSONObject("frequency").toJSONString())
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("reportPeriod", String.valueOf(jsonObject.getInteger("reportPeriod")))
                .addParameter("collectPeriod", String.valueOf(jsonObject.getInteger("collectPeriod")))
                .addParameter("pushPeriod", String.valueOf(jsonObject.getInteger("pushPeriod")));
//        jsonObject.forEach((k, v) -> {
//            postClient.addParameter(k, (String) v);
//        });
        return postClient.post();
    }

    /**
     * isv或外部服务生成轨迹id
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceGenerateTraceIdByIsv(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_GENERATE_TRACE_ID_BY_ISV)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 接收轨迹数据
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceReceiveTraceData(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_RECEIVE_TRACE_DATA)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("positions", jsonObject.getString("positions"));
        return postClient.post();
    }

    /**
     * 停止轨迹上报
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceStopTraceCollect(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_STOP_TRACE_COLLECT)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")));
        return postClient.post();
    }

    /**
     * 轨迹id生成
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceGenerateTraceId(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_GENERATE_TRACE_ID)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")));
        return postClient.post();
    }

    /**
     * 获取轨迹推送失败消息
     * @param eventTag 注册事件类型
     * @return java.lang.String
     **/
    @Override
    public String BipRegisterFailedTasks(String eventTag) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.BIP_REGISTER_FAILED_TASKS)
                .addParameter("eventTag", eventTag);
        return postClient.post();
    }

    /**
     * 应用注销轨迹推送
     * @param id 注册id
     * @return java.lang.String
     **/
    @Override
    public String BipRegisterCancell(String id) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.BIP_REGISTER_CANCELL)
                .addParameter("id", id);
        return postClient.post();
    }

    /**
     * 获取轨迹推送注册
     * @return java.lang.String
     **/
    @Override
    public String BipRegisterGetEvents() {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.BIP_REGISTER_GET_EVENTS);
        return postClient.post();
    }

    /**
     * 应用更新轨迹推送事件数据
     * @param id 应用注册id
     * @param callBackUrl 回调地址
     * @return java.lang.String
     **/
    @Override
    public String BipRegisterUpdateEvent(String id, String callBackUrl) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.BIP_REGISTER_UPDATE_EVENT)
                .addParameter("id", id)
                .addParameter("callBackUrl", callBackUrl);
        return postClient.post();
    }

    /**
     * 轨迹推送注册
     * @param eventTag 注册事件类型，轨迹实时推送填：real_time_trace
     * @param callBackUrl 数据推送的回调地址
     * @return java.lang.String
     **/
    @Override
    public String BipRegisterRegisterApp(String eventTag, String callBackUrl) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.BIP_REGISTER_REGISTER_APP)
                .addParameter("eventTag", eventTag)
                .addParameter("callBackUrl", callBackUrl);
        return postClient.post();
    }

    /* 消息会话接口实现 */
    /**
     * 创建群会话
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String chatCreate(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadChatApiConstants.CHAT_CREATE)
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("disableRead", String.valueOf(jsonObject.getInteger("disableRead")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("name", jsonObject.getString("name"))
                .addParameter("managementType", String.valueOf(jsonObject.getInteger("managementType")));
        if(StringUtils.isNotEmpty(jsonObject.getString("useridlist"))) {
            postClient.addParameter("useridlist", jsonObject.getString("useridlist"));
        } else if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("useridlist"))) {
            jsonObject.getJSONArray("useridlist").forEach(uid -> {
                postClient.addParameter("useridlist", String.valueOf(uid));
            });
        } else {
            throw new GadNullPointerException("useridlist is empty in chatCreate.");
        }
        return postClient.post();
    }

    /**
     * 发送消息
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String chatSendMsg(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadChatApiConstants.CHAT_SEND_MSG)
                .addParameter("msg", jsonObject.getString("msg"))
                .addParameter("senderId", jsonObject.getString("senderId"))
                .addParameter("receiverId", jsonObject.getString("receiverId"))
                .addParameter("chatId", jsonObject.getString("chatId"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("chatType", String.valueOf(jsonObject.getInteger("chatType")));
        return postClient.post();
    }

    /**
     * 获取群成员
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String chatGroupGetUsers(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadChatApiConstants.CHAT_GROUP_GET_USERS)
                .addParameter("chatId", jsonObject.getString("chatId"));
        return postClient.post();
    }

    /**
     * 获取消息已读人数
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String chatGroupMessageReadUsers(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadChatApiConstants.CHAT_GROUP_MESSAGE_READ_USERS)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("messageId", jsonObject.getString("messageId"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("cursor", String.valueOf(jsonObject.getLong("cursor")));
        return postClient.post();
    }

    /* 业务实事件回调接口实现 */
    /**
     * 移除失败回调
     * @param eventCallbackFailedId eventCallbackFailedId
     * @return java.lang.String
     **/
    @Override
    public String messageRemoveCallbackFailed(Long eventCallbackFailedId) {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_REMOVE_CALLBACK_FAILED);
        if(eventCallbackFailedId != null) {
            postClient.addParameter("eventCallbackFailedId", String.valueOf(eventCallbackFailedId));
        } else {
            throw new GadNullPointerException("eventCallbackFailedId is null in messageRemoveCallbackFailed.");
        }
        return postClient.post();
    }

    /**
     * 重试失败回调
     * @param eventCallbackFailedId eventCallbackFailedId
     * @return java.lang.String
     **/
    @Override
    public String messageRetryCallbackFailed(Long eventCallbackFailedId) {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_RETRY_CALLBACK_FAILED);
        if(eventCallbackFailedId != null) {
            postClient.addParameter("eventCallbackFailedId", String.valueOf(eventCallbackFailedId));
        } else {
            throw new GadNullPointerException("eventCallbackFailedId is null in messageRetryCallbackFailed.");
        }
        return postClient.post();
    }

    /**
     * 查询回调失败信息
     * @return java.lang.String
     **/
    @Override
    public String messageQueryCallbackFailed() {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_QUERY_CALLBACK_FAILED);
        return postClient.post();
    }

    /**
     * 删除事件回调的定义信息
     * @param eventCallbackId eventCallbackId
     * @return java.lang.String
     **/
    @Override
    public String messageDeleteEventCallbackDefine(Long eventCallbackId) {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_DELETE_EVENT_CALLBACK_DEFINE);
        if(eventCallbackId != null) {
            postClient.addParameter("eventCallbackId", String.valueOf(eventCallbackId));
        } else {
            throw new GadNullPointerException("eventCallbackId is null in messageDeleteEventCallbackDefine.");
        }
        return postClient.post();
    }

    /**
     * 更新事件回调的定义信息
     * @param eventCallbackId eventCallbackId
     * @param callbackUrl callbackUrl
     * @return java.lang.String
     **/
    @Override
    public String messageUpdateEventCallbackDefined(Long eventCallbackId, String callbackUrl) {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_UPDATE_EVENT_CALLBACK_DEFINE);
        if(eventCallbackId != null) {
            postClient.addParameter("eventCallbackId", String.valueOf(eventCallbackId));
        } else {
            throw new GadNullPointerException("eventCallbackId is null in messageUpdateEventCallbackDefined.");
        }
        if(StringUtils.isNotEmpty(callbackUrl)) {
            postClient.addParameter("callbackUrl", callbackUrl);
        } else {
            throw new GadNullPointerException("callbackUrl is empty in messageUpdateEventCallbackDefined.");
        }
        return postClient.post();
    }

    /**
     * 查询定义的事件列表
     * @return java.lang.String
     **/
    @Override
    public String messageQueryCallbackDefine() {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_QUERY_CALLBACK_DEFINE);
        return postClient.post();
    }

    /**
     * 注册消息回调
     * @param eventTag eventTag
     * @param callbackUrl callbackUrl
     * @return java.lang.String
     **/
    @Override
    public String messageRegisterEventCallback(String eventTag, String callbackUrl) {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_REGISTER_EVENT_CALLBACK);
        if(StringUtils.isNotEmpty(eventTag)) {
            postClient.addParameter("eventTag", eventTag);
        } else {
            throw new GadNullPointerException("eventTag is empty in messageRegisterEventCallback");
        }
        if(StringUtils.isNotEmpty(callbackUrl)) {
            postClient.addParameter("callbackUrl", callbackUrl);
        } else {
            throw new GadNullPointerException("callbackUrl is empty in messageRegisterEventCallback");
        }
        return postClient.post();
    }

    /**
     * 注册消息回调（支持加密、签名）
     * @param eventTag eventTag
     * @param callbackUrl callbackUrl
     * @return java.lang.String
     **/
    @Override
    public String messageV2RegisterEventCallback(String eventTag, String callbackUrl) {
        PostClient postClient = this.newGadPostClient(GadBECBApiConstants.MESSAGE_V2_REGISTER_EVENT_CALLBACK);
        if(StringUtils.isEmpty(eventTag)) {
            throw new GadNullPointerException("eventTag is empty in messageRegisterEventCallback");
        } else {
            postClient.addParameter("eventTag", eventTag);
        }
        if(StringUtils.isEmpty(callbackUrl)) {
            throw new GadNullPointerException("callbackUrl is empty in messageRegisterEventCallback");
        } else {
            postClient.addParameter("callbackUrl", callbackUrl);
        }
        return postClient.post();
    }

    /* JSAPI鉴权接口实现 */
    /**
     * /get_jsapi_token.json JSAPI鉴权
     * @param accessToken accessToken
     * @return java.lang.String
     **/
    @Override
    public String getJsApiToken(String accessToken) {
        PostClient postClient = this.newGadPostClient(GadJsApiAuthConstants.GET_JS_API_TOKEN);
        if(StringUtils.isNotEmpty(accessToken)) {
            postClient.addParameter("accessToken", accessToken);
        } else {
            throw new GadNullPointerException("accessToken is empty in getJsApiToken");
        }
        return postClient.post();
    }

    /* 文件存储接口实现 */
    /**
     * 媒体文件下载
     * @param accessToken 校验权限的appToken
     * @param mediaId 上传成功后返回的mediaId
     * @return java.lang.String
     **/
    @Override
    public String mediaDownload(String accessToken, String mediaId) {
        PostClient postClient = this.newGadPostClient(GadJsApiAuthConstants.GET_JS_API_TOKEN)
                .addParameter("access_token", accessToken)
                .addParameter("media_id", mediaId);
        return postClient.post();
    }

    /* 日程接口实现 */
    /**
     * 取消日历事件
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarCancelCalendarEvent(JSONObject jsonObject) {
        return null;
    }

    /**
     * 创建日历事件
     * @param jsonObject  JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarCreateCalendarEvent(JSONObject jsonObject) {
        return null;
    }

    /* 待办接口实现 */
    /**
     * 取消实例接口
     * @param userId 用户ID
     * @param packageUuid 实例唯一ID
     * @return java.lang.String
     **/
    @Override
    public String tcOpenApiPackageCancel(String userId, String packageUuid) {
        PostClient postClient = this.newGadPostClient(GadToDoApiConstants.TC_OPEN_API_PACKAGE_CANCEL)
                .addParameter("userId", userId)
                .addParameter("packageUuid", packageUuid);
        return postClient.post();
    }

    /**
     * 关闭实例接口
     * @param userId 用户ID
     * @param packageUuid 实例唯一ID
     * @return java.lang.String
     **/
    @Override
    public String tcOpenApiPackageClose(String userId, String packageUuid) {
        PostClient postClient = this.newGadPostClient(GadToDoApiConstants.TC_OPEN_API_PACKAGE_CLOSE)
                .addParameter("userId", userId)
                .addParameter("packageUuid", packageUuid);
        return postClient.post();
    }

    /**
     * 取消待办任务
     * @param cancelPakcage 同步处理实例
     * @param userId 用户ID
     * @param taskUuid 任务唯一ID
     * @return java.lang.String
     **/
    @Override
    public String tcOpenApiTaskCancel(Boolean cancelPakcage, String userId, String taskUuid) {
        PostClient postClient = this.newGadPostClient(GadToDoApiConstants.TC_OPEN_API_TASK_CANCEL)
                .addParameter("cancelPakcage", String.valueOf(cancelPakcage))
                .addParameter("userId", userId)
                .addParameter("taskUuid", taskUuid);
        return postClient.post();
    }

    /**
     * 完成待办任务
     * @param closePackage 同步处理实例
     * @param userId 用户ID
     * @param taskUuid 任务唯一ID
     * @return java.lang.String
     **/
    @Override
    public String tcOpenApiTaskFinish(Boolean closePackage, String userId, String taskUuid) {
        PostClient postClient = this.newGadPostClient(GadToDoApiConstants.TC_OPEN_API_TASK_FINISH)
                .addParameter("closePackage", String.valueOf(closePackage))
                .addParameter("userId", userId)
                .addParameter("taskUuid", taskUuid);
        return postClient.post();
    }

    /**
     * 创建待办接口v2
     * @param tcV2OpenApiTaskCreateObject tcV2OpenApiTaskCreateObject入参
     * @return java.lang.String
     **/
    @Override
    public String tcV2OpenApiTaskCreate(TcV2OpenApiTaskCreateObject tcV2OpenApiTaskCreateObject) {
        PostClient postClient = this.newGadPostClient(GadToDoApiConstants.TC_V2_OPEN_API_TASK_CREATE)
                .addParameter("assigneeInfo", tcV2OpenApiTaskCreateObject.getAssigneeInfo())
                .addParameter("subject", tcV2OpenApiTaskCreateObject.getSubject())
                .addParameter("creatorInfo", tcV2OpenApiTaskCreateObject.getCreatorInfo())
                .addParameter("creatorId", tcV2OpenApiTaskCreateObject.getCreatorId())
                .addParameter("tenantId", tcV2OpenApiTaskCreateObject.getTenantId())
                .addParameter("bizTaskId", tcV2OpenApiTaskCreateObject.getBizTaskId())
                .addParameter("mobileUrl", tcV2OpenApiTaskCreateObject.getMobileUrl())
                .addParameter("assigneeId", tcV2OpenApiTaskCreateObject.getAssigneeId())
                .addParameter("url", tcV2OpenApiTaskCreateObject.getUrl())
                .addParameter("packageUuid", tcV2OpenApiTaskCreateObject.getPackageUuid());
        return postClient.post();
    }

    /**
     * 创建待办接口v2
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String tcV2OpenApiTaskCreate(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadToDoApiConstants.TC_V2_OPEN_API_TASK_CREATE)
                .addParameter("assigneeInfo", jsonObject.getString("assigneeInfo"))
                .addParameter("subject", jsonObject.getString("subject"))
                .addParameter("creatorInfo", jsonObject.getString("creatorInfo"))
                .addParameter("creatorId", jsonObject.getString("creatorId"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("bizTaskId", jsonObject.getString("bizTaskId"))
                .addParameter("mobileUrl", jsonObject.getString("mobileUrl"))
                .addParameter("assigneeId", jsonObject.getString("assigneeId"))
                .addParameter("url", jsonObject.getString("url"))
                .addParameter("packageUuid", jsonObject.getString("packageUuid"));
        return postClient.post();
    }

    /* 工作通知消息接口实现 */
    /**
     * 工作通知消息
     * @param messageWorkNotificationObject messageWorkNotificationObject入参
     * @return java.lang.String
     **/
    @Override
    public String messageWorkNotification(MessageWorkNotificationObject messageWorkNotificationObject) {
        PostClient postClient = this.newGadPostClient(GadWNMApiConstants.MESSAGE_WORK_NOTIFICATION)
                .addParameter("bizMsgId", messageWorkNotificationObject.getBizMsgId());
        if(StringUtils.isNotEmpty(messageWorkNotificationObject.getTenantId())) {
            postClient.addParameter("tenantId", messageWorkNotificationObject.getTenantId());
        } else {
            throw new GadNullPointerException("tenantId is empty in messageWorkNotification");
        }
        if(messageWorkNotificationObject.getMsg() != null) {
            postClient.addParameter("msg", messageWorkNotificationObject.getMsg().toJSONString());
        } else {
            throw new GadNullPointerException("msg is null in messageWorkNotification");
        }
        if(!CollectionUtils.isEmpty(messageWorkNotificationObject.getOrganizationCodes())) {
            if(messageWorkNotificationObject.getOrganizationCodes().size() <= 20) {
                messageWorkNotificationObject.getOrganizationCodes().forEach(code -> {
                    postClient.addParameter("organizationCodes", code);
                });
            } else {
                throw new GadIndexOutOfBoundsException("The length of the organizationCodes is over 20 in messageWorkNotification");
            }
        }
        if(!CollectionUtils.isEmpty(messageWorkNotificationObject.getReceiverIds())) {
            messageWorkNotificationObject.getOrganizationCodes().forEach(id -> {
                postClient.addParameter("receiverIds", id);
            });
        }
        return postClient.post();
    }

    /**
     * 工作通知消息
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String messageWorkNotification(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWNMApiConstants.MESSAGE_WORK_NOTIFICATION)
                .addParameter("bizMsgId", jsonObject.getString("bizMsgId"));
        if(StringUtils.isNotEmpty(jsonObject.getString("tenantId"))) {
            postClient.addParameter("tenantId", jsonObject.getString("tenantId"));
        } else {
            throw new GadNullPointerException("tenantId is empty in messageWorkNotification");
        }
        if(StringUtils.isNotEmpty(jsonObject.getString("msg"))) {
            postClient.addParameter("msg", jsonObject.getString("msg"));
        } else if(!jsonObject.getJSONObject("msg").isEmpty()) {
            postClient.addParameter("msg", jsonObject.getJSONObject("msg").toJSONString());
        } else {
            throw new GadNullPointerException("msg is empty in messageWorkNotification");
        }
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("organizationCodes"))) {
            jsonObject.getJSONArray("organizationCodes").forEach(code -> {
                postClient.addParameter("organizationCodes", String.valueOf(code));
            });
        } else if(StringUtils.isNotEmpty(jsonObject.getString("organizationCodes"))){
            postClient.addParameter("organizationCodes", jsonObject.getString("organizationCodes"));
        }
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("receiverIds"))) {
            jsonObject.getJSONArray("receiverIds").forEach(id -> {
                postClient.addParameter("receiverIds", String.valueOf(id));
            });
        } else if(StringUtils.isNotEmpty(jsonObject.getString("receiverIds"))) {
            postClient.addParameter("receiverIds", jsonObject.getString("receiverIds"));
        }
        return postClient.post();
    }

    /**
     * 发送工作台红点
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String messageSendPortalNotification(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWNMApiConstants.NOTIFICATION_MESSAGE_SEND_PORTAL_NOTIFICATION)
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(StringUtils.isNotEmpty(jsonObject.getString("addNum"))) {
            postClient.addParameter("addNum", jsonObject.getString("addNum"));
        } else {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("bizMsgIds"))) {
                jsonObject.getJSONArray("bizMsgIds").forEach(id -> {
                    postClient.addParameter("bizMsgIds", (String) id);
                });
            } else {
                postClient.addParameter("bizMsgIds", jsonObject.getString("bizMsgIds"));
            }
        }
        return postClient.post();
    }

    /**
     * 清除工作台红点
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String messageClearPortalNotification(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWNMApiConstants.NOTIFICATION_MESSAGE_CLEAR_PORTAL_NOTIFICATION)
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("bizMsgIds"))) {
            jsonObject.getJSONArray("bizMsgIds").forEach(id -> {
                postClient.addParameter("bizMsgIds", (String) id);
            });
        } else {
            postClient.addParameter("bizMsgIds", jsonObject.getString("bizMsgIds"));
        }
        return postClient.post();
    }

    /**
     * 查询工作台红点
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String messageQueryPortalNotification(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWNMApiConstants.NOTIFICATION_MESSAGE_QUERY_PORTAL_NOTIFICATION)
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /* 获取通讯录部门信息接口实现 */
    /**
     * 移动组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptMoveGovOrganization(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_MOVE_GOV_ORGANIZATION)
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("parentCode", jsonObject.getString("parentCode"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 删除组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptDeleteGovOrganization(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_DELETE_GOV_ORGANIZATION)
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 更新组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptUpdateGovOrganization(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_UPDATE_GOV_ORGANIZATION)
                .addParameter("organizationName", jsonObject.getString("organizationName"))
                .addParameter("displayOrder", String.valueOf(jsonObject.getLong("displayOrder")))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("organizationType", jsonObject.getString("organizationType"))
                .addParameter("govDivisionCode", jsonObject.getString("govDivisionCode"))
                .addParameter("govShortName", jsonObject.getString("govShortName"))
                .addParameter("govOtherName", jsonObject.getString("govOtherName"))
                .addParameter("govInstitutionCode", jsonObject.getString("govInstitutionCode"))
                .addParameter("govUnifiedSocialCreditCode", jsonObject.getString("govUnifiedSocialCreditCode"))
                .addParameter("govInstitutionLevelCode",jsonObject.getString("govInstitutionLevelCode"))
                .addParameter("govPostalCode", jsonObject.getString("govPostalCode"))
                .addParameter("govRemarks", jsonObject.getString("govRemarks"))
                .addParameter("govContactEmployeeCode", jsonObject.getString("govContactEmployeeCode"))
                .addParameter("govContactNumber", jsonObject.getString("govContactNumber"))
                .addParameter("govAddress", jsonObject.getString("govAddress"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(StringUtils.isNotEmpty(jsonObject.getString("govBusinessStripCodes"))) {
            postClient.addParameter("govBusinessStripCodes", jsonObject.getString("govBusinessStripCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govBusinessStripCodes"))) {
            jsonObject.getJSONArray("govBusinessStripCodes").forEach(code -> {
                postClient.addParameter("govBusinessStripCodes", String.valueOf(code));
            });
        }
        if(StringUtils.isNotEmpty(jsonObject.getString("govResponsibleEmployeeCodes"))) {
            postClient.addParameter("govResponsibleEmployeeCodes", jsonObject.getString("govResponsibleEmployeeCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govResponsibleEmployeeCodes"))) {
            jsonObject.getJSONArray("govResponsibleEmployeeCodes").forEach(code -> {
                postClient.addParameter("govResponsibleEmployeeCodes", String.valueOf(code));
            });
        }
        return postClient.post();
    }

    /**
     * 创建组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptCreateGovOrganization(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_CREATE_GOV_ORGANIZATION)
                .addParameter("creator", jsonObject.getString("creator"))
                .addParameter("organizationName", jsonObject.getString("organizationName"))
                .addParameter("displayOrder", String.valueOf(jsonObject.getLong("displayOrder")))
                .addParameter("parentCode", jsonObject.getString("parentCode"))
                .addParameter("organizationType", jsonObject.getString("organizationType"))
                .addParameter("govDivisionCode", jsonObject.getString("govDivisionCode"))
                .addParameter("govShortName", jsonObject.getString("govShortName"))
                .addParameter("govOtherName", jsonObject.getString("govOtherName"))
                .addParameter("govInstitutionCode", jsonObject.getString("govInstitutionCode"))
                .addParameter("govUnifiedSocialCreditCode", jsonObject.getString("govUnifiedSocialCreditCode"))
                .addParameter("govInstitutionLevelCode",jsonObject.getString("govInstitutionLevelCode"))
                .addParameter("govPostalCode", jsonObject.getString("govPostalCode"))
                .addParameter("govRemarks", jsonObject.getString("govRemarks"))
                .addParameter("govContactEmployeeCode", jsonObject.getString("govContactEmployeeCode"))
                .addParameter("govContactNumber", jsonObject.getString("govContactNumber"))
                .addParameter("govAddress", jsonObject.getString("govAddress"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govBusinessStripCodes"))) {
            jsonObject.getJSONArray("govBusinessStripCodes").forEach(code -> {
                postClient.addParameter("govBusinessStripCodes", String.valueOf(code));
            });
        } else if(StringUtils.isNotEmpty(jsonObject.getString("govBusinessStripCodes"))) {
            postClient.addParameter("govBusinessStripCodes", jsonObject.getString("govBusinessStripCodes"));
        }
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govResponsibleEmployeeCodes"))) {
            jsonObject.getJSONArray("govResponsibleEmployeeCodes").forEach(code -> {
                postClient.addParameter("govResponsibleEmployeeCodes", String.valueOf(code));
            });
        } else if(StringUtils.isNotEmpty(jsonObject.getString("govResponsibleEmployeeCodes"))) {
            postClient.addParameter("govResponsibleEmployeeCodes", jsonObject.getString("govResponsibleEmployeeCodes"));
        }
        return postClient.post();
    }

    /**
     * 根据组织 Code 列表查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptListOrganizationByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_LIST_ORGANIZATION_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(StringUtils.isNotEmpty(jsonObject.getString("organizationCodes"))) {
            postClient.addParameter("organizationCodes", jsonObject.getString("organizationCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("organizationCodes"))){
            jsonObject.getJSONArray("organizationCodes").forEach(code -> {
                postClient.addParameter("organizationCodes", String.valueOf(code));
            });
        }
        return postClient.post();
    }

    /**
     * 根据组织查询组织汇报线
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptGetOrganizationLine(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_GET_ORGANIZATION_LINE)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"));
        return postClient.post();
    }

    /**
     * 分页查询组织下的员⼯ Code
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptPageOrganizationEmployeeCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_PAGE_ORGANIZATION_EMPLOYEE_CODES)
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("employeePositionStatus", jsonObject.getString("employeePositionStatus"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"));
        return postClient.post();
    }

    /**
     * 根据组织code查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptGetOrganizationByCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_GET_ORGANIZATION_BY_CODE)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"));
        return postClient.post();
    }

    /**
     * 分页获取下⼀级组织 Code 列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptPageSubOrganizationCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_PAGE_SUB_ORGANIZATION_CODES)
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("status", jsonObject.getString("status"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据租户ID获取租户根组织
     * @param tenantId 租户ID
     * @return java.lang.String
     **/
    @Override
    public String deptGetRootOrganization(Long tenantId) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_GET_ROOT_ORGANIZATION)
                .addParameter("tenantId", String.valueOf(tenantId));
        return postClient.post();
    }

    /**
     * 分页获取下一级行政区划列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptPageSubGovDivisions(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_PAGE_SUB_GOV_DIVISIONS)
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("divisionCode", jsonObject.getString("divisionCode"))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据行政区划查询行政区划线
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptGetDivisionLine(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_GET_DIVISION_LINE)
                .addParameter("divisionCode", jsonObject.getString("divisionCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据行政区划 Code 列表查询
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptListDivisionsByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_LIST_DIVISIONS_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(StringUtils.isNotEmpty(jsonObject.getString("divisionCodes"))) {
            postClient.addParameter("divisionCodes", jsonObject.getString("divisionCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("divisionCodes"))){
            jsonObject.getJSONArray("divisionCodes").forEach(code -> {
                postClient.addParameter("divisionCodes", String.valueOf(code));
            });
        }
        return postClient.post();
    }

    /**
     * 分页获取下一级条线列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptPageSubGovBusinessStrips(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_PAGE_SUB_GOV_BUSINESS_STRIPS)
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("businessStripCode", jsonObject.getString("businessStripCode"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据条线查询条线线
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptGetGovBusinessStripLine(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_GET_GOV_BUSINESS_STRIP_LINE)
                .addParameter("businessStripCode", jsonObject.getString("businessStripCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据条线 Code 列表查询
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptListGovBusinessStripsByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_LIST_GOV_BUSINESS_STRIPS_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(StringUtils.isNotEmpty(jsonObject.getString("businessStripCodes"))) {
            postClient.addParameter("businessStripCodes", jsonObject.getString("businessStripCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("businessStripCodes"))){
            if(jsonObject.getJSONArray("businessStripCodes").size() <= 100) {
                jsonObject.getJSONArray("businessStripCodes").forEach(code -> {
                    postClient.addParameter("businessStripCodes", String.valueOf(code));
                });
            } else {
                throw new GadIndexOutOfBoundsException("The length of the businessStripCodes is over 100 in deptListGovBusinessStripsByCodes");
            }
        }
        return postClient.post();
    }

    /* 获取通讯录用户信息接口实现 */
    /**
     * 冻结和解冻账号
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeUpdateGovAccountStatus(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_UPDATE_GOV_ACCOUNT_STATUS)
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("namespace", jsonObject.getString("namespace"))
                .addParameter("status", jsonObject.getString("status"))
                .addParameter("account", jsonObject.getString("account"));
        return postClient.post();
    }

    /**
     * 根据员工 Code获取员工标签code列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListEmpTag(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_EMPLOYEE_TAGS)
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 删除员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeDeleteGovEmpPosition(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_DELETE_GOV_EMPLOYEE_POSITION)
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"));
        return postClient.post();
    }

    /**
     * 更新员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeUpdateGovEmpPosition(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_UPDATE_GOV_EMPLOYEE_POSITION)
                .addParameter("posJobRankCode", jsonObject.getString("posJobRankCode"))
                .addParameter("govEmpPosPhoneNo", jsonObject.getString("govEmpPosPhoneNo"))
                .addParameter("govJobAttributesCode", jsonObject.getString("govJobAttributesCode"))
                .addParameter("orderInOrganization", String.valueOf(jsonObject.getLong("orderInOrganization")))
                .addParameter("mainJob", String.valueOf(jsonObject.getBoolean("mainJob")))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("govEmpPosEmail", jsonObject.getString("govEmpPosEmail"))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("govEmpPosEmployeeRoleCode", jsonObject.getString("govEmpPosEmployeeRoleCode"))
                .addParameter("govEmpPosFaxNo", jsonObject.getString("govEmpPosFaxNo"))
                .addParameter("govEmpPosJob", jsonObject.getString("govEmpPosJob"))
                .addParameter("govEmpPosAddress", jsonObject.getString("govEmpPosAddress"))
                .addParameter("order", String.valueOf(jsonObject.getLong("order")));
        return postClient.post();
    }

    /**
     * 删除员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeDeleteGovEmp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_DELETE_GOV_EMPLOYEE)
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"));
        return postClient.post();
    }

    /**
     * 失效员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeDeactivateGovEmp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_DEACTIVATE_GOV_EMPLOYEE)
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"));
        return postClient.post();
    }

    /**
     * 修改员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeUpdateGovEmp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_UPDATE_GOV_EMPLOYEE)
                .addParameter("govEmpJobLevelCode", jsonObject.getString("govEmpJobLevelCode"))
                .addParameter("govEmpBudgetedPostCode", jsonObject.getString("govEmpBudgetedPostCode"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("govEmpCellPhoneShortNo", jsonObject.getString("govEmpCellPhoneShortNo"))
                .addParameter("govEmpGenderCode", jsonObject.getString("govEmpGenderCode"))
                .addParameter("govEmpRemarks", jsonObject.getString("govEmpRemarks"))
                .addParameter("govEmpBirthDate", jsonObject.getDate("govEmpBirthDate").toString())
                .addParameter("employeeName", jsonObject.getString("employeeName"))
                .addParameter("govEmpCellPhoneNo", jsonObject.getString("govEmpCellPhoneNo"))
                .addParameter("govEmpHomeAddress", jsonObject.getString("govEmpHomeAddress"))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("areaCode", jsonObject.getString("areaCode"))
                .addParameter("govEmpAvatar", jsonObject.getString("govEmpAvatar"))
                .addParameter("govEmpIdentityCardNo", jsonObject.getString("govEmpIdentityCardNo"))
                .addParameter("govEmpPoliticalStatusCode", jsonObject.getString("govEmpPoliticalStatusCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 创建员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeCreateGovEmpPosition(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_CREATE_GOV_EMPLOYEE_POSITION)
                .addParameter("creator", jsonObject.getString("creator"))
                .addParameter("posJobRankCode", jsonObject.getString("posJobRankCode"))
                .addParameter("govEmpPosPhoneNo", jsonObject.getString("govEmpPosPhoneNo"))
                .addParameter("govJobAttributesCode", jsonObject.getString("govJobAttributesCode"))
                .addParameter("orderInOrganization", String.valueOf(jsonObject.getLong("orderInOrganization")))
                .addParameter("mainJob", String.valueOf(jsonObject.getBoolean("mainJob")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("govEmpPosEmail", jsonObject.getString("govEmpPosEmail"))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("govEmpPosEmployeeRoleCode", jsonObject.getString("govEmpPosEmployeeRoleCode"))
                .addParameter("govEmpPosFaxNo", jsonObject.getString("govEmpPosFaxNo"))
                .addParameter("govEmpPosJob", jsonObject.getString("govEmpPosJob"))
                .addParameter("govEmpPosAddress", jsonObject.getString("govEmpPosAddress"))
                .addParameter("order", String.valueOf(jsonObject.getLong("order")));
        return postClient.post();
    }

    /**
     * 新增员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeCreateGovEmp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_CREATE_GOV_EMPLOYEE)
                .addParameter("sendActiveSms", String.valueOf(jsonObject.getBoolean("sendActiveSms")))
                .addParameter("govEmpJobLevelCode", jsonObject.getString("govEmpJobLevelCode"))
                .addParameter("govEmpBudgetedPostCode", jsonObject.getString("govEmpBudgetedPostCode"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("govEmpCellPhoneShortNo", jsonObject.getString("govEmpCellPhoneShortNo"))
                .addParameter("password", jsonObject.getString("password"))
                .addParameter("govEmpGenderCode", jsonObject.getString("govEmpGenderCode"))
                .addParameter("govEmpRemarks", jsonObject.getString("govEmpRemarks"))
                .addParameter("govEmpBirthDate", jsonObject.getDate("govEmpBirthDate").toString())
                .addParameter("employeeName", jsonObject.getString("employeeName"))
                .addParameter("govEmpCellPhoneNo", jsonObject.getString("govEmpCellPhoneNo"))
                .addParameter("govEmpHomeAddress", jsonObject.getString("govEmpHomeAddress"))
                .addParameter("areaCode", jsonObject.getString("areaCode"))
                .addParameter("govEmpAvatar", jsonObject.getString("govEmpAvatar"))
                .addParameter("govEmpIdentityCardNo", jsonObject.getString("govEmpIdentityCardNo"))
                .addParameter("namespace", jsonObject.getString("namespace"))
                .addParameter("account", jsonObject.getString("account"))
                .addParameter("govEmpPoliticalStatusCode", jsonObject.getString("govEmpPoliticalStatusCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据组织 CODE、员⼯ Code 列表， 批量获取员工在该组织的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListOrgEmpPositionByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_ORG_EMPLOYEE_POSITION_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
            jsonObject.getJSONArray("employeeCodes").forEach(code -> {
                postClient.addParameter("employeeCodes", String.valueOf(code));
            });
        } else if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
            postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
        }
        return postClient.post();
    }

    /**
     * 根据员⼯ Code 列表查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListEmpByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_EMPLOYEES_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if (StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
            postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
            jsonObject.getJSONArray("employeeCodes").forEach(code -> {
                postClient.addParameter("employeeCodes", String.valueOf(code));
            });
        }
        return postClient.post();
    }

    /**
     * 根据员工code获取员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListEmpPositionByEmpCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_EMPLOYEES_POSITION_BY_EMPLOYEE_CODE)
                .addParameter("employeePositionStatus", jsonObject.getString("employeePositionStatus"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("employeePositionType", jsonObject.getString("employeePositionType"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 根据员工 Code 查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeGetEmpByCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_GET_EMPLOYEE_BY_CODE)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 通过员工 Code 列表获取员⼯账号 ID
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListEmpAccountIds(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_EMPLOYEE_ACCOUNT_IDS)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if (StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
            postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
            jsonObject.getJSONArray("employeeCodes").forEach(code -> {
                postClient.addParameter("employeeCodes", (String) code);
            });
        }
        return postClient.post();
    }

    /**
     * 批量根据accountId、tenantId、organizationCode查询这个账号是否在这个租户的这些组织内
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListAccountOrgByIdAndCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_ACCOUNT_ORG_BY_ID_AND_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")));
        if (StringUtils.isNotEmpty(jsonObject.getString("organizationCodes"))) {
            postClient.addParameter("organizationCodes", jsonObject.getString("organizationCodes"));
        } else if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("organizationCodes"))) {
            if(jsonObject.getJSONArray("organizationCodes").size() <= 100) {
                jsonObject.getJSONArray("organizationCodes").forEach(code -> {
                    postClient.addParameter("organizationCodes", (String) code);
                });
            } else {
                throw new GadIndexOutOfBoundsException("The length of the organizationCodes is over 100 in employeeListAccountOrgByIdAndCodes");
            }
        }
        return postClient.post();
    }

    /**
     * 人员返聘
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeRehiredGovEmp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_REHIRED_GOV_EMPLOYEE)
                .addParameter("govEmpPosPhoneNo", jsonObject.getString("govEmpPosPhoneNo"))
                .addParameter("orderInOrganization", String.valueOf(jsonObject.getLong("orderInOrganization")))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("govEmpPosEmail", jsonObject.getString("govEmpPosEmail"))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("govEmpPosEmployeeRoleCode", jsonObject.getString("govEmpPosEmployeeRoleCode"))
                .addParameter("govEmpPosFaxNo", jsonObject.getString("govEmpPosFaxNo"))
                .addParameter("govEmpPosJob", jsonObject.getString("govEmpPosJob"))
                .addParameter("govEmpPosAddress", jsonObject.getString("govEmpPosAddress"));
        return postClient.post();
    }

    /**
     * 根据组织code和批量员工 Code 获取员工的邮箱信息
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListGovOrgEmpEmailByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_GOV_ORG_EMPLOYEE_EMAIL_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("organizationCode", String.valueOf(jsonObject.getLong("organizationCode")));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
            if(jsonObject.getJSONArray("employeeCodes").size() <= 100) {
                jsonObject.getJSONArray("employeeCodes").forEach(code -> {
                    postClient.addParameter("employeeCodes", (String) code);
                });
            } else {
                throw new GadIndexOutOfBoundsException("The length of the employeeCodes is over 100 in employeeListGovOrgEmpEmailByCodes");
            }
        } else if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
            postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
        }
        return postClient.post();
    }

    /**
     * 批量 通过账号Id 列表获取人员Code
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeListGovEmpCodesByAccountIds(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_LIST_GOV_EMPLOYEE_CODES_BY_ACCOUNT_IDS)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("accountIds"))) {
            jsonObject.getJSONArray("accountIds").forEach(id -> {
                postClient.addParameter("accountIds", (String) id);
            });
        } else if(jsonObject.getLong("accountIds") != null) {
            postClient.addParameter("accountIds", String.valueOf(jsonObject.getLong("accountIds")));
        }
        return postClient.post();
    }

    /**
     * 查询映射关系通过数梦Id
     * @param dtUserId 数梦用户id
     * @return java.lang.String
     **/
    @Override
    public String employeeGetEmpCodeByDtUserId(String dtUserId) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_GET_EMP_CODE_BY_DT_USER_ID)
                .addParameter("dtUserId", dtUserId);
        return postClient.post();
    }

    /**
     * 查询映射关系通过钉钉id
     * @param dingUserId 钉钉id
     * @return java.lang.String
     **/
    @Override
    public String employeeGetEmpCodeByDingUserId(String dingUserId) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_GET_EMP_CODE_BY_DING_USER_ID)
                .addParameter("dingUserId", dingUserId);
        return postClient.post();
    }

    /**
     * 根据手机号码获取人员编码
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeGetByMobile(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_GET_BY_MOBILE)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("areaCode", jsonObject.getString("areaCode"))
                .addParameter("namespace", jsonObject.getString("namespace"))
                .addParameter("mobile", jsonObject.getString("mobile"));
        return postClient.post();
    }

    /**
     * 移动任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeGetMoveEmpPosition(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_GET_MOVE_EMP_POSITION)
                .addParameter("toOrganizationCode", jsonObject.getString("toOrganizationCode"))
                .addParameter("fromOrganizationCode", jsonObject.getString("fromOrganizationCode"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /* 应用管理后台免登接口实现 */
    /**
     * 服务端通过临时授权码获取授权用户的个人信息
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String rpcOauth2GetUserInfoByCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadAMBApiConstants.RPC_OAUTH2_GET_USER_INFO_BY_CODE)
                .addParameter("code", jsonObject.getString("code"))
                .addParameter("access_token", jsonObject.getString("access_token"));
        return postClient.post();
    }

    /* 企业内免登录接口实现 */
    /**
     * 根据authCode获取登录token
     * @param accessToken 应用access_token
     * @param authCode 临时授权码
     * @return java.lang.String
     **/
    @Override
    public String rpcOauth2DingTalkAppToken(String accessToken, String authCode) {
        PostClient postClient = this.newGadPostClient(GadLoginApiConstants.RPC_OAUTH2_DINGTALK_APP_TOKEN);
        if(StringUtils.isEmpty(accessToken)) {
            throw new GadNullPointerException("accessToken is empty in rpcOauth2DingTalkAppToken");
        } else {
            postClient.addParameter("access_token", accessToken);
        }
        if(StringUtils.isEmpty(authCode)) {
            throw new GadNullPointerException("authCode is empty in rpcOauth2DingTalkAppToken");
        } else {
            postClient.addParameter("auth_code", authCode);
        }
        return postClient.post();
    }

    /**
     * 根据authCode换取用户信息
     * @param accessToken 应用access_token
     * @param authCode 临时授权码
     * @return java.lang.String
     **/
    @Override
    public String rpcOauth2DingTalkAppUser(String accessToken, String authCode) {
        PostClient postClient = this.newGadPostClient(GadLoginApiConstants.RPC_OAUTH2_DINGTALK_APP_USER);
        if(StringUtils.isEmpty(accessToken)) {
            throw new GadNullPointerException("accessToken is empty in rpcOauth2DingTalkAppUser");
        } else {
            postClient.addParameter("access_token", accessToken);
        }
        if(StringUtils.isEmpty(authCode)) {
            throw new GadNullPointerException("authCode is empty in rpcOauth2DingTalkAppUser");
        } else {
            postClient.addParameter("auth_code", authCode);
        }
        return postClient.post();
    }

    /**
     * 获取应用access_token
     * @return java.lang.String
     **/
    @Override
    public String rpcOauth2GetToken() {
        PostClient postClient = this.newGadPostClient(GadLoginApiConstants.RPC_OAUTH2_GET_TOKEN)
                .addParameter("appKey", gadExecutableClientProperties.getAccessKey())
                .addParameter("appSecret", gadExecutableClientProperties.getSecretKey());
        return postClient.post();
    }

}
