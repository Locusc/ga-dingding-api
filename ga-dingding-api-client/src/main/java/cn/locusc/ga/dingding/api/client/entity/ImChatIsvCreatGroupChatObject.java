package cn.locusc.ga.dingding.api.client.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Jay Chan
 * @Description 政务钉钉会话接口入参实体
 * @Date 15:37 2020/6/25
 **/
@Data
public class ImChatIsvCreatGroupChatObject implements Serializable {

    /**
     * @Description 群聊用户IDs
     **/
    @NonNull
    private List<String> uids;

    /**
     * @Description 租户ID
     **/
    @NonNull
    private Long tenantId;

    /**
     * @Description 群管理员ID
     **/
    @NonNull
    private String ownerId;

    /**
     * @Description 群聊名称
     **/
    @NonNull
    private String title;
}
