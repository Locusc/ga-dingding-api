package cn.locusc.ga.dingding.api.client.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author Jay Chan
 * 政务钉钉创建待办接口v2入参实体
 * 19:42 2020/6/25
 **/
@Data
public class TcV2OpenApiTaskCreateObject implements Serializable {

    /**
     * 待办人信息
     **/
    private String assigneeInfo;

    /**
     * 标题
     **/
    @NonNull
    private String subject;


    /**
     * 创建人信息
     **/
    private String creatorInfo;


    /**
     * 创建人ID
     **/
    @NonNull
    private String creatorId;

    /**
     * 租户ID
     **/
    @NonNull
    private String tenantId;


    /**
     * 业务系统自定义ID
     **/
    @NonNull
    private String bizTaskId;


    /**
     * 移动端URL
     **/
    @NonNull
    private String mobileUrl;

    /**
     * 待办人ID
     **/
    @NonNull
    private String assigneeId;


    /**
     * URL
     **/
    @NonNull
    private String url;


    /**
     * 实例唯一ID，任务会关联在这个实例下，不传的时候会同步创建一个新的实例
     **/
    private String packageUuid;

}
