package cn.locusc.ga.dingding.api.client.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jay Chan
 * 政务钉钉会话接口入参实体
 * 15:37 2020/6/25
 **/
@Data
public class ImChatIsvCreatGroupChatObject implements Serializable {

    /**
     * 群聊用户IDs
     **/
    @NonNull
    private List<String> uids;

    /**
     * 租户ID
     **/
    @NonNull
    private Long tenantId;

    /**
     * 群管理员ID
     **/
    @NonNull
    private String ownerId;

    /**
     * 群聊名称
     **/
    @NonNull
    private String title;
}
