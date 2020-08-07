package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉评论接口地址常量
 * 14:47 2020/8/6
 **/
public class GadCommentsConstants {

    /**
     * 根据条件删除点赞
     **/
    public static final String BIP_LIKE_DELETE_BY_CONDITIONS = "/bip/like/deleteByConditions";

    /**
     * 根据id查询点赞
     **/
    public static final String BIP_LIKE_GET = "/bip/like/get";

    /**
     * 根据条件查询点赞数量
     **/
    public static final String BIP_LIKE_COUNT_LIKE = "/bip/like/countLike";

    /**
     * 根据不同条件查询点赞,并限制返回数量，根据主题id分类
     **/
    public static final String BIP_LIKE_LIMIT_QUERY_GROUP_BY_SUBJECT_ID = "/bip/like/limitQueryGroupBySubjectId";

    /**
     * 根据不同条件查询点赞
     **/
    public static final String BIP_LIKE_QUERY = "/bip/like/query";

    /**
     * 更新点赞
     **/
    public static final String BIP_LIKE_UPDATE = "/bip/like/update";

    /**
     * 点赞
     **/
    public static final String BIP_LIKE_ADD = "/bip/like/add";

    /**
     * 根据条件删除评论
     **/
    public static final String BIP_COMMENT_DELETE_BY_CONDITIONS = "/bip/comment/deleteByConditions";

    /**
     * 根据评论id查询评论
     **/
    public static final String BIP_COMMENT_GET = "/bip/comment/get";

    /**
     * 根据条件查询评论数量
     **/
    public static final String BIP_COMMENT_COUNT_COMMENTS = "/bip/comment/countComments";

    /**
     * 根据不同条件查询评论/回复评论,并限制返回数量,根据主题id分组返回
     **/
    public static final String BIP_COMMENT_LIMIT_QUERY_GROUP_BY_SUBJECT_ID = "/bip/comment/limitQueryGroupBySubjectId";

    /**
     * 根据不同条件查询评论/回复评论
     **/
    public static final String BIP_COMMENT_QUERY= "/bip/comment/query";

    /**
     * 更新评论/更新评论回复
     **/
    public static final String BIP_COMMENT_UPDATE = "/bip/comment/update";

    /**
     * 评论/评论回复
     **/
    public static final String BIP_COMMENT_ADD = "/bip/comment/add";

}
