package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉评论接口
 * 15:24 2020/8/6
 **/
interface GadCommentsServices {

    /**
     * 根据条件删除点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeDeleteByConditions(JSONObject jsonObject);

    /**
     * 根据id查询点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeGet(JSONObject jsonObject);

    /**
     * 根据条件查询点赞数量
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeCountLike(JSONObject jsonObject);

    /**
     * 根据不同条件查询点赞,并限制返回数量，根据主题id分类
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeLimitQueryGroupBySubjectId(JSONObject jsonObject);

    /**
     * 根据不同条件查询点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeQuery(JSONObject jsonObject);

    /**
     * 更新点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeUpdate(JSONObject jsonObject);

    /**
     * 点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipLikeAdd(JSONObject jsonObject);

    /**
     * 根据条件删除评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentDeleteByConditions(JSONObject jsonObject);

    /**
     * 根据评论id查询评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentGet(JSONObject jsonObject);

    /**
     * 根据条件查询评论数量
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentCountComments(JSONObject jsonObject);

    /**
     * 根据不同条件查询评论/回复评论,并限制返回数量,根据主题id分组返回
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentLimitQueryGroupBySubjectId(JSONObject jsonObject);

    /**
     * 根据不同条件查询评论/回复评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentQuery(JSONObject jsonObject);

    /**
     * 更新评论/更新评论回复
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentUpdate(JSONObject jsonObject);

    /**
     * 评论/评论回复
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipCommentAdd(JSONObject jsonObject);

}
