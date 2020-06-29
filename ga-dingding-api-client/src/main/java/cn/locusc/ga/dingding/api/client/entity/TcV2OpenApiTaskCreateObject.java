package cn.locusc.ga.dingding.api.client.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @Author Jay Chan
 * @Description 政务钉钉创建待办接口v2入参实体
 * @Date 19:42 2020/6/25
 **/
@Data
public class TcV2OpenApiTaskCreateObject implements Serializable {

    /**
     * @Description 待办人信息
     **/
    private String assigneeInfo;

    /**
     * @Description 标题
     **/
    @NonNull
    private String subject;


    /**
     * @Description 创建人信息
     **/
    private String creatorInfo;


    /**
     * @Description 创建人ID
     **/
    @NonNull
    private String creatorId;

    /**
     * @Description 租户ID
     **/
    @NonNull
    private String tenantId;


    /**
     * @Description 业务系统自定义ID
     **/
    @NonNull
    private String bizTaskId;


    /**
     * @Description 移动端URL
     **/
    @NonNull
    private String mobileUrl;

    /**
     * @Description 待办人ID
     **/
    @NonNull
    private String assigneeId;


    /**
     * @Description URL
     **/
    @NonNull
    private String url;


    /**
     * @Description 实例唯一ID，任务会关联在这个实例下，不传的时候会同步创建一个新的实例
     **/
    private String packageUuid;

}
