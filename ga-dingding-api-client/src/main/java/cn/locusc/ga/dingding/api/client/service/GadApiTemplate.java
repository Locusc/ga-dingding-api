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
        GadTraceService, GadFileStorageService, GadDingService, GadAMBApiService,
        GadYIDAOtherService, GadYIDAProcessService, GadYIDATaskCenterService, GadYIDAFormService,
        GadWaterMarkService, GadFaceRecognitionService, GadGESService, GadCommentsServices {

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
                .addParameter("creator", jsonObject.getJSONObject("creator").toJSONString())
                .addParameter("notifyType", jsonObject.getString("notifyType"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("textType", jsonObject.getString("textType"))
                .addParameter("body", jsonObject.getString("body"))
                .addParameter("bodyType", jsonObject.getString("bodyType"));
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("receivers"))) {
                jsonObject.getJSONArray("receivers").forEach(item -> {
                    postClient.addParameter("receivers", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("receivers").toJSONString() != null) {
                postClient.addParameter("receivers", jsonObject.getJSONObject("receivers").toJSONString());
            }
        }
        return postClient.post();
    }

    /* 评论接口实现 */
    /**
     * 根据条件删除点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeDeleteByConditions(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_DELETE_BY_CONDITIONS)
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("likeAccountId", String.valueOf(jsonObject.getLong("likeAccountId")))
                .addParameter("likeAccountTenantId", String.valueOf(jsonObject.getLong("likeAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("id", String.valueOf(jsonObject.getLong("id")));
        return postClient.post();
    }

    /**
     * 根据id查询点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeGet(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_GET)
                .addParameter("id", String.valueOf(jsonObject.getLong("id")));
        return postClient.post();
    }

    /**
     * 根据条件查询点赞数量
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeCountLike(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_COUNT_LIKE)
                .addParameter("sortBy", jsonObject.getString("sortBy"))
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("likeAccountId", String.valueOf(jsonObject.getLong("likeAccountId")))
                .addParameter("likeAccountTenantId", String.valueOf(jsonObject.getLong("likeAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("subjectKeyword", jsonObject.getString("subjectKeyword"));
        return postClient.post();
    }

    /**
     * 根据不同条件查询点赞,并限制返回数量，根据主题id分类
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeLimitQueryGroupBySubjectId(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_LIMIT_QUERY_GROUP_BY_SUBJECT_ID)
                .addParameter("sortBy", jsonObject.getString("sortBy"))
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("subjectIdStr", jsonObject.getString("subjectIdStr"))
                .addParameter("likeAccountId", String.valueOf(jsonObject.getLong("likeAccountId")))
                .addParameter("likeAccountTenantId", String.valueOf(jsonObject.getLong("likeAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("subjectKeyword", jsonObject.getString("subjectKeyword"))
                .addParameter("limitPerSubject", String.valueOf(jsonObject.getInteger("limitPerSubject")));
        return postClient.post();
    }

    /**
     * 根据不同条件查询点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeQuery(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_QUERY)
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("sortBy", jsonObject.getString("sortBy"))
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("subjectIdStr", jsonObject.getString("subjectIdStr"))
                .addParameter("likeAccountId", String.valueOf(jsonObject.getLong("likeAccountId")))
                .addParameter("likeAccountTenantId", String.valueOf(jsonObject.getLong("likeAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("isPage", String.valueOf(jsonObject.getInteger("isPage")))
                .addParameter("subjectKeyword", jsonObject.getString("subjectKeyword"));
        return postClient.post();
    }

    /**
     * 更新点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeUpdate(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_UPDATE)
                .addParameter("id", String.valueOf(jsonObject.getLong("id")))
                .addParameter("extendedField", jsonObject.getString("extendedField"))
                .addParameter("subjectKeyword", jsonObject.getString("subjectKeyword"));
        return postClient.post();
    }

    /**
     * 点赞
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipLikeAdd(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_LIKE_ADD)
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("extendedField", jsonObject.getString("extendedField"))
                .addParameter("subjectKeyword", jsonObject.getString("subjectKeyword"));
        return postClient.post();
    }

    /**
     * 根据条件删除评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentDeleteByConditions(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_DELETE_BY_CONDITIONS)
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("commentAccountId", String.valueOf(jsonObject.getLong("commentAccountId")))
                .addParameter("commentAccountTenantId", String.valueOf(jsonObject.getLong("commentAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("id", String.valueOf(jsonObject.getLong("id")))
                .addParameter("isRecursion", jsonObject.getString("isRecursion"));
        return postClient.post();
    }

    /**
     * 根据评论id查询评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentGet(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_GET)
                .addParameter("id", String.valueOf(jsonObject.getLong("id")));
        return postClient.post();
    }

    /**
     * 根据条件查询评论数量
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentCountComments(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_COUNT_COMMENTS)
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("sortBy", jsonObject.getString("sortBy"))
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("subjectIdStr", jsonObject.getString("subjectIdStr"))
                .addParameter("commentAccountId", String.valueOf(jsonObject.getLong("commentAccountId")))
                .addParameter("commentAccountTenantId", String.valueOf(jsonObject.getLong("commentAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("bizCode", jsonObject.getString("bizCode"));
        return postClient.post();
    }

    /**
     * 根据不同条件查询评论/回复评论,并限制返回数量,根据主题id分组返回
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentLimitQueryGroupBySubjectId(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_LIMIT_QUERY_GROUP_BY_SUBJECT_ID)
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("sortBy", jsonObject.getString("sortBy"))
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("subjectIdStr", jsonObject.getString("subjectIdStr"))
                .addParameter("commentAccountId", String.valueOf(jsonObject.getLong("commentAccountId")))
                .addParameter("commentAccountTenantId", String.valueOf(jsonObject.getLong("commentAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("limitPerSubject", String.valueOf(jsonObject.getInteger("limitPerSubject")));
        return postClient.post();
    }

    /**
     * 根据不同条件查询评论/回复评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentQuery(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_QUERY)
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("sortBy", jsonObject.getString("sortBy"))
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("subjectIdStr", jsonObject.getString("subjectIdStr"))
                .addParameter("commentAccountId", String.valueOf(jsonObject.getLong("commentAccountId")))
                .addParameter("commentAccountTenantId", String.valueOf(jsonObject.getLong("commentAccountTenantId")))
                .addParameter("subjectAccountId", String.valueOf(jsonObject.getLong("subjectAccountId")))
                .addParameter("subjectAccountTenantId", String.valueOf(jsonObject.getLong("subjectAccountTenantId")))
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("bizCode", jsonObject.getString("bizCode"))
                .addParameter("isPage", String.valueOf(jsonObject.getInteger("isPage")));
        return postClient.post();
    }

    /**
     * 更新评论/更新评论回复
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentUpdate(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_UPDATE)
                .addParameter("id", String.valueOf(jsonObject.getLong("id")))
                .addParameter("extendedField", jsonObject.getString("extendedField"));
        return postClient.post();
    }

    /**
     * 评论/评论回复
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipCommentAdd(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadCommentsConstants.BIP_COMMENT_ADD)
                .addParameter("subjectId", jsonObject.getString("subjectId"))
                .addParameter("type", jsonObject.getString("type"))
                .addParameter("replyCommentId", jsonObject.getString("replyCommentId"))
                .addParameter("content", jsonObject.getString("content"))
                .addParameter("subjectAccountId", jsonObject.getString("subjectAccountId"))
                .addParameter("subjectAccountTenantId", jsonObject.getString("subjectAccountTenantId"))
                .addParameter("extendedField", jsonObject.getString("extendedField"));
        return postClient.post();
    }

    /* 电子签章实现 */
    /**
     * 获取签章机构列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String gesQueryOrganizations(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadGESConstants.GES_QUERY_ORGANIZATIONS)
                .addParameter("organizationName", jsonObject.getString("organizationName"))
                .addParameter("essp", jsonObject.getString("essp"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")));
        return postClient.post();
    }

    /**
     * 获取签章管理员列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String gesQuerySealKeepers(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadGESConstants.GES_QUERY_SEAL_KEEPERS)
                .addParameter("organizationId", jsonObject.getString("organizationId"))
                .addParameter("essp", jsonObject.getString("essp"));
        return postClient.post();
    }

    /**
     * 获取印章列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String gesQuerySeals(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadGESConstants.GES_QUERY_SEALS)
                .addParameter("organizationId", jsonObject.getString("organizationId"))
                .addParameter("sealKeeperId", jsonObject.getString("sealKeeperId"))
                .addParameter("essp", jsonObject.getString("essp"));
        return postClient.post();
    }

    /**
     * 发送签章验证码
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String gesStampSendVerifyCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadGESConstants.GES_STAMP_SEND_VERIFY_CODE)
                .addParameter("sealKeeperId", jsonObject.getString("sealKeeperId"))
                .addParameter("essp", jsonObject.getString("essp"))
                .addParameter("businessId", jsonObject.getString("businessId"));
        return postClient.post();
    }

    /**
     * 验证签章验证码
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String gesStampCheckVerifyCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadGESConstants.GES_STAMP_CHECK_VERIFY_CODE)
                .addParameter("sealKeeperId", jsonObject.getString("sealKeeperId"))
                .addParameter("verifyCode", jsonObject.getString("verifyCode"))
                .addParameter("essp", jsonObject.getString("essp"))
                .addParameter("businessId", jsonObject.getString("businessId"));
        return postClient.post();
    }

    /**
     * 签署盖章
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String gesStampSign(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadGESConstants.GES_STAMP_SIGN)
                .addParameter("signPositions", jsonObject.getString("signPositions"))
                .addParameter("sealKeeperId", jsonObject.getString("sealKeeperId"))
                .addParameter("verifyCode", jsonObject.getString("verifyCode"))
                .addParameter("essp", jsonObject.getString("essp"))
                .addParameter("businessId", jsonObject.getString("businessId"))
                .addParameter("fileBase64Code", jsonObject.getString("fileBase64Code"));
        return postClient.post();
    }

    /* 人脸识别实现 */
    /**
     * 图片压缩，按照宽高压缩
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceCompressForBorder(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_COMPRESS_FOR_BORDER)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("content", jsonObject.getString("content"))
                .addParameter("url", jsonObject.getString("url"))
                .addParameter("width", jsonObject.getString("width"))
                .addParameter("height", jsonObject.getString("height"))
                .addParameter("force", jsonObject.getString("force"));
        return postClient.post();
    }

    /**
     * 图片压缩，按照比例，精度压缩
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceCompressForScale(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_COMPRESS_FOR_SCALE)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("content", jsonObject.getString("content"))
                .addParameter("url", jsonObject.getString("url"))
                .addParameter("accuracy", jsonObject.getString("accuracy"))
                .addParameter("quality", jsonObject.getString("quality"));
        return postClient.post();
    }

    /**
     * 压缩图片，根据需要的字节大小，精度压缩
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceCompressForSize(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_COMPRESS_FOR_SIZE)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("content", jsonObject.getString("content"))
                .addParameter("url", jsonObject.getString("url"))
                .addParameter("size", jsonObject.getString("size"))
                .addParameter("quality", jsonObject.getString("quality"));
        return postClient.post();
    }

    /**
     * 人脸属性识别
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceAttribute(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_ATTRIBUTE)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("imgUrl", jsonObject.getString("imgUrl"))
                .addParameter("imgBase64", jsonObject.getString("imgBase64"));
        return postClient.post();
    }

    /**
     * 人脸比对（上传两张图片比对）
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceVerifyWithOriginalImg(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_VERIFY_WITH_ORIGINAL_IMG)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("imgUrl", jsonObject.getString("imgUrl"))
                .addParameter("originalImgUrl", jsonObject.getString("originalImgUrl"))
                .addParameter("imgBase64", jsonObject.getString("imgBase64"))
                .addParameter("originalImgBase64", jsonObject.getString("originalImgBase64"));
        return postClient.post();
    }

    /**
     * 人脸比对(服务端事先录入原图)
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceVerify(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_VERIFY)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("imgUrl", jsonObject.getString("imgUrl"))
                .addParameter("imgBase64", jsonObject.getString("imgBase64"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("bizCode", jsonObject.getString("bizCode"));
        return postClient.post();
    }

    /**
     * 人脸检测
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipFaceDetect(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadFaceRecognitionConstants.BIP_FACE_DETECT)
                .addParameter("type", String.valueOf(jsonObject.getInteger("type")))
                .addParameter("imgUrl", jsonObject.getString("imgUrl"))
                .addParameter("imgBase64", jsonObject.getString("imgBase64"))
                .addParameter("isSave", jsonObject.getString("isSave"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /* 水印接口实现 */
    /**
     * 制作水印
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkDoWaterMark(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_DO_WATERMARK)
                .addParameter("lastName", jsonObject.getString("lastName"))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("isDefault", String.valueOf(jsonObject.getInteger("isDefault")))
                .addParameter("isSave", String.valueOf(jsonObject.getInteger("isSave")))
                .addParameter("wmType", String.valueOf(jsonObject.getInteger("wmType")))
                .addParameter("fileType", String.valueOf(jsonObject.getInteger("fileType")))
                .addParameter("srcImgUrl", jsonObject.getString("srcImgUrl"))
                .addParameter("base64Img", jsonObject.getString("base64Img"))
                .addParameter("srcFile", jsonObject.getString("srcFile"))
                .addParameter("templateId", String.valueOf(jsonObject.getLong("templateId")));
        return postClient.post();
    }

    /**
     * 添加水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkTemplateSave(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_TEMPLATE_SAVE)
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("xDistance", String.valueOf(jsonObject.getDouble("xDistance")))
                .addParameter("yDistance", String.valueOf(jsonObject.getDouble("yDistance")))
                .addParameter("templateType", String.valueOf(jsonObject.getInteger("templateType")))
                .addParameter("isDefault", String.valueOf(jsonObject.getInteger("isDefault")))
                .addParameter("contentsJson", jsonObject.getString("contentsJson"));
        return postClient.post();
    }

    /**
     * 修改水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkTemplateEdit(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_TEMPLATE_EDIT)
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("xDistance", String.valueOf(jsonObject.getDouble("xDistance")))
                .addParameter("yDistance", String.valueOf(jsonObject.getDouble("yDistance")))
                .addParameter("templateType", String.valueOf(jsonObject.getInteger("templateType")))
                .addParameter("isDefault", String.valueOf(jsonObject.getInteger("isDefault")))
                .addParameter("contentsJson", jsonObject.getString("contentsJson"))
                .addParameter("templateId", String.valueOf(jsonObject.getLong("templateId")));
        return postClient.post();
    }

    /**
     * 水印模板分页查询
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkTemplatePageQuery(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_TEMPLATE_PAGE_QUERY)
                .addParameter("pageSize", jsonObject.getString("pageSize"))
                .addParameter("pageNum", jsonObject.getString("pageNum"));
        return postClient.post();
    }

    /**
     * 删除水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkTemplateDel(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_TEMPLATE_PAGE_QUERY);
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("templateIds"))) {
                jsonObject.getJSONArray("templateIds").forEach(item -> {
                    postClient.addParameter("templateIds", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("templateIds"))) {
                postClient.addParameter("templateIds", jsonObject.getString("templateIds"));
            }
        }
        return postClient.post();
    }

    /**
     * 获取云端保存的水印文件（分页）
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkPage(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_PAGE)
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("pageNum", String.valueOf(jsonObject.getInteger("pageNum")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 移动端获取水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String bipWaterMarkTemplateQuery(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadWaterMarkConstants.BIP_WATERMARK_TEMPLATE_QUERY)
                .addParameter("templateId", String.valueOf(jsonObject.getInteger("templateId")));
        return postClient.post();
    }

    /* 政务钉钉宜搭其他接口实现 */
    /**
     * 获取应用下所有表单页面的列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaAppListNavigationByFormType(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAOtherConstants.YIDA_APP_LIST_NAVIGATION_BY_FORM_TYPE)
                .addParameter("formType", jsonObject.getString("formType"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 宜搭附件地址转临时免登地址
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFileGetOpenUrl(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAOtherConstants.YIDA_FILE_GET_OPEN_URL)
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("fileUrl", jsonObject.getString("fileUrl"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("timeout", String.valueOf(jsonObject.getLong("timeout")));
        return postClient.post();
    }

    /**
     * 增加评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaRemarkSave(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAOtherConstants.YIDA_REMARK_SAVE)
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formInstId", jsonObject.getString("formInstId"))
                .addParameter("replyId", String.valueOf(jsonObject.getLong("replyId")))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("atUserId", jsonObject.getString("atUserId"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("content", jsonObject.getString("content"));
        return postClient.post();
    }

    /* 政务钉钉宜搭任务中心接口实现 */
    /**
     * 查询已完成任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetDoneTasksInCorp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDATaskCenterConstants.YIDA_PROCESS_GET_DONE_TASKS_IN_COPY)
                .addParameter("taskFinishTo", String.valueOf(jsonObject.getLong("taskFinishTo")))
                .addParameter("corpId", jsonObject.getString("corpId"))
                .addParameter("instanceCreateFrom", String.valueOf(jsonObject.getLong("instanceCreateFrom")))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("token", jsonObject.getString("token"))
                .addParameter("createFrom", String.valueOf(jsonObject.getLong("createFrom")))
                .addParameter("processCodes", jsonObject.getString("processCodes"))
                .addParameter("taskFinishFrom", String.valueOf(jsonObject.getLong("taskFinishFrom")))
                .addParameter("createTo", String.valueOf(jsonObject.getLong("createTo")))
                .addParameter("limit", String.valueOf(jsonObject.getInteger("limit")))
                .addParameter("page", String.valueOf(jsonObject.getInteger("page")))
                .addParameter("appTypes", jsonObject.getString("appTypes"))
                .addParameter("keyword", jsonObject.getString("keyword"))
                .addParameter("instanceCreateTo", String.valueOf(jsonObject.getLong("instanceCreateTo")))
                .addParameter("status", jsonObject.getString("status"));
        return postClient.post();
    }

    /**
     * 查询待办任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetTodoTasksInCorp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDATaskCenterConstants.YIDA_PROCESS_GET_TODO_TASKS_IN_COPY)
                .addParameter("taskFinishTo", String.valueOf(jsonObject.getLong("taskFinishTo")))
                .addParameter("corpId", jsonObject.getString("corpId"))
                .addParameter("instanceCreateFrom", String.valueOf(jsonObject.getLong("instanceCreateFrom")))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("token", jsonObject.getString("token"))
                .addParameter("createFrom", String.valueOf(jsonObject.getLong("createFrom")))
                .addParameter("processCodes", jsonObject.getString("processCodes"))
                .addParameter("taskFinishFrom", String.valueOf(jsonObject.getLong("taskFinishFrom")))
                .addParameter("createTo", String.valueOf(jsonObject.getLong("createTo")))
                .addParameter("limit", String.valueOf(jsonObject.getInteger("limit")))
                .addParameter("page", String.valueOf(jsonObject.getInteger("page")))
                .addParameter("appTypes", jsonObject.getString("appTypes"))
                .addParameter("keyword", jsonObject.getString("keyword"))
                .addParameter("instanceCreateTo", String.valueOf(jsonObject.getLong("instanceCreateTo")))
                .addParameter("status", jsonObject.getString("status"));
        return postClient.post();
    }

    /**
     * 已提交任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetMySubmmitInCorp(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDATaskCenterConstants.YIDA_PROCESS_GET_MY_SUBMMIT_IN_COPY)
                .addParameter("taskFinishTo", String.valueOf(jsonObject.getLong("taskFinishTo")))
                .addParameter("corpId", jsonObject.getString("corpId"))
                .addParameter("instanceCreateFrom", String.valueOf(jsonObject.getLong("instanceCreateFrom")))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("token", jsonObject.getString("token"))
                .addParameter("createFrom", String.valueOf(jsonObject.getLong("createFrom")))
                .addParameter("processCodes", jsonObject.getString("processCodes"))
                .addParameter("taskFinishFrom", String.valueOf(jsonObject.getLong("taskFinishFrom")))
                .addParameter("createTo", String.valueOf(jsonObject.getLong("createTo")))
                .addParameter("limit", String.valueOf(jsonObject.getInteger("limit")))
                .addParameter("page", String.valueOf(jsonObject.getInteger("page")))
                .addParameter("appTypes", jsonObject.getString("appTypes"))
                .addParameter("keyword", jsonObject.getString("keyword"))
                .addParameter("instanceCreateTo", String.valueOf(jsonObject.getLong("instanceCreateTo")))
                .addParameter("status", jsonObject.getString("status"));
        return postClient.post();
    }

    /* 政务钉钉宜搭流程接口实现 */
    /**
     * 根据搜索条件获取实例详情列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetInstances(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_GET_INSTANCES)
                .addParameter("modifiedFrom", jsonObject.getString("modifiedFrom"))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("dynamicOrder", jsonObject.getString("dynamicOrder"))
                .addParameter("searchFieldJson", jsonObject.getString("searchFieldJson"))
                .addParameter("useOriginValue", jsonObject.getString("useOriginValue"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("instanceStatus", jsonObject.getString("instanceStatus"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("createFrom", jsonObject.getString("createFrom"))
                .addParameter("targetFieldJson", jsonObject.getString("targetFieldJson"))
                .addParameter("approvedResult", jsonObject.getString("approvedResult"))
                .addParameter("createTo", jsonObject.getString("createTo"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("originatorId", jsonObject.getString("originatorId"))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")))
                .addParameter("taskId", jsonObject.getString("taskId"))
                .addParameter("modifiedTo", jsonObject.getString("modifiedTo"));
        return postClient.post();
    }

    /**
     * 获取流程设计节点上的按钮列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetActivityButtonVOs(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_GET_ACTIVITY_BUTTON_VOS)
                .addParameter("activityId", jsonObject.getString("activityId"))
                .addParameter("processCode", jsonObject.getString("processCode"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 流程实例更新
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessUpdateInstance(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_UPDATE_INSTANCE)
                .addParameter("processInstanceId", jsonObject.getString("processInstanceId"))
                .addParameter("updateFormDataJson", jsonObject.getString("updateFormDataJson"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("ignoreEmpty", String.valueOf(jsonObject.getBoolean("ignoreEmpty")))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 执行虚拟节点任务
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessExecutePlatformTask(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_EXECUTE_PLATFORM_TASK)
                .addParameter("outResult", jsonObject.getString("outResult"))
                .addParameter("noExecuteExpressions", jsonObject.getString("noExecuteExpressions"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formDataJson", jsonObject.getString("formDataJson"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("remark", jsonObject.getString("remark"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("procInstId", jsonObject.getString("procInstId"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 获取审批记录
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetOperationRecords(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_GET_OPERATION_RECORDS)
                .addParameter("processInstanceId", jsonObject.getString("processInstanceId"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 执行单个任务接口
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessExecuteTask(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_EXECUTE_TASK)
                .addParameter("outResult", jsonObject.getString("outResult"))
                .addParameter("noExecuteExpressions", jsonObject.getString("noExecuteExpressions"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formDataJson", jsonObject.getString("formDataJson"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("remark", jsonObject.getString("remark"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("procInstId", jsonObject.getString("procInstId"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("taskId", jsonObject.getString("taskId"));
        return postClient.post();
    }

    /**
     * 终止流程实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessTerminateInstance(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_TERMINATE_INSTANCE)
                .addParameter("processInstanceId", jsonObject.getString("processInstanceId"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 删除流程实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessDeleteInstance(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_DELETE_INSTANCE)
                .addParameter("processInstanceId", jsonObject.getString("processInstanceId"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 根据实例ID获取流程实例详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetInstanceById(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_GET_INSTANCE_BY_ID)
                .addParameter("processInstanceId", jsonObject.getString("processInstanceId"))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("useOriginValue", String.valueOf(jsonObject.getBoolean("useOriginValue")))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 搜索流程实例ID
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessGetInstanceIds(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_GET_INSTANCE_IDS)
                .addParameter("modifiedFrom", jsonObject.getString("modifiedFrom"))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("dynamicOrder", jsonObject.getString("dynamicOrder"))
                .addParameter("searchFieldJson", jsonObject.getString("searchFieldJson"))
                .addParameter("useOriginValue", jsonObject.getString("useOriginValue"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("instanceStatus", jsonObject.getString("instanceStatus"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("createFrom", jsonObject.getString("createFrom"))
                .addParameter("targetFieldJson", jsonObject.getString("targetFieldJson"))
                .addParameter("approvedResult", jsonObject.getString("approvedResult"))
                .addParameter("createTo", jsonObject.getString("createTo"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("originatorId", jsonObject.getString("originatorId"))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")))
                .addParameter("taskId", jsonObject.getString("taskId"))
                .addParameter("modifiedTo", jsonObject.getString("modifiedTo"));
        return postClient.post();
    }

    /**
     * 流程发起
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaProcessStartInstance(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAProcessConstants.YIDA_PROCESS_START_INSTANCE)
                .addParameter("instValue", jsonObject.getString("instValue"))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("processCode", jsonObject.getString("processCode"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formDataJson", jsonObject.getString("formDataJson"))
                .addParameter("deptId", jsonObject.getString("deptId"))
                .addParameter("businessId", jsonObject.getString("businessId"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("useOriginInstValue", String.valueOf(jsonObject.getBoolean("useOriginInstValue")));
        return postClient.post();
    }

    /* 政务钉钉宜搭表单接口实现 */
    /**
     * 获取表单定义
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormDesignGetFormComponentDefinationList(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_DESIGN_GET_FORM_COMPONENT_DEFINATION_LIST)
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("version", String.valueOf(jsonObject.getLong("version")))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 根据条件搜索单据实例详情列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormSearchFormDatas(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_SEARCH_FORM_DATAS)
                .addParameter("modifiedFrom", jsonObject.getString("modifiedFrom"))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("dynamicOrder", jsonObject.getString("dynamicOrder"))
                .addParameter("searchFieldJson", jsonObject.getString("searchFieldJson"))
                .addParameter("useOriginValue", jsonObject.getString("useOriginValue"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("createFrom", jsonObject.getString("createFrom"))
                .addParameter("targetFieldJson", jsonObject.getString("targetFieldJson"))
                .addParameter("createTo", jsonObject.getString("createTo"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("originatorId", jsonObject.getString("originatorId"))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")))
                .addParameter("modifiedTo", jsonObject.getString("modifiedTo"));
        return postClient.post();
    }

    /**
     * 根据条件搜索单据实例ID列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormSearchFormDataIds(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_SEARCH_FORM_DATA_IDS)
                .addParameter("modifiedFrom", jsonObject.getString("modifiedFrom"))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("dynamicOrder", jsonObject.getString("dynamicOrder"))
                .addParameter("searchFieldJson", jsonObject.getString("searchFieldJson"))
                .addParameter("useOriginValue", jsonObject.getString("useOriginValue"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("createFrom", jsonObject.getString("createFrom"))
                .addParameter("targetFieldJson", jsonObject.getString("targetFieldJson"))
                .addParameter("createTo", jsonObject.getString("createTo"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("originatorId", jsonObject.getString("originatorId"))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")))
                .addParameter("modifiedTo", jsonObject.getString("modifiedTo"));
        return postClient.post();
    }

    /**
     * 根据单据实例ID查询单据实例详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormGetFormDataById(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_SEARCH_FORM_DATA_BY_ID)
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formInstId", jsonObject.getString("formInstId"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"))
                .addParameter("needInstValue", String.valueOf(jsonObject.getBoolean("needInstValue")));
        return postClient.post();
    }

    /**
     * 删除单据实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormDeleteFormData(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_DELETE_FORM_DATA)
                .addParameter("useLatestVersion", String.valueOf(jsonObject.getBoolean("useLatestVersion")))
                .addParameter("updateFormDataJson", jsonObject.getString("updateFormDataJson"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formInstId", jsonObject.getString("formInstId"))
                .addParameter("ignoreEmpty", String.valueOf(jsonObject.getBoolean("ignoreEmpty")))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 更新单据中指定组件值
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormUpdateFormData(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_UPDATE_FORM_DATA)
                .addParameter("useLatestVersion", String.valueOf(jsonObject.getBoolean("useLatestVersion")))
                .addParameter("updateFormDataJson", jsonObject.getString("updateFormDataJson"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formInstId", jsonObject.getString("formInstId"))
                .addParameter("ignoreEmpty", String.valueOf(jsonObject.getBoolean("ignoreEmpty")))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
        return postClient.post();
    }

    /**
     * 新增单据实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String yiDaFormSaveFormData(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadYIDAFormConstants.YIDA_FORM_SAVE_FORM_DATA)
                .addParameter("instValue", jsonObject.getString("instValue"))
                .addParameter("noExecExp", String.valueOf(jsonObject.getBoolean("noExecExp")))
                .addParameter("formUuid", jsonObject.getString("formUuid"))
                .addParameter("appType", jsonObject.getString("appType"))
                .addParameter("formInstId", jsonObject.getString("formInstId"))
                .addParameter("formDataJson", jsonObject.getString("formDataJson"))
                .addParameter("systemToken", jsonObject.getString("systemToken"))
                .addParameter("language", jsonObject.getString("language"))
                .addParameter("userId", jsonObject.getString("userId"));
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
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("startTime", String.valueOf(jsonObject.getLong("startTime")))
                .addParameter("endTime", String.valueOf(jsonObject.getLong("endTime")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
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
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("frequency", jsonObject.getJSONObject("frequency").toJSONString())
                .addParameter("employeeCode", jsonObject.getString("employeeCode"))
                .addParameter("reportPeriod", String.valueOf(jsonObject.getInteger("reportPeriod")))
                .addParameter("collectPeriod", String.valueOf(jsonObject.getInteger("collectPeriod")))
                .addParameter("pushPeriod", String.valueOf(jsonObject.getInteger("pushPeriod")));
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
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
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

    /**
     * 开启轨迹采集
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceStartTraceCollect(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_START_TRACE_COLLECT)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("accessToken", jsonObject.getString("accessToken"))
                .addParameter("deviceId", jsonObject.getString("deviceId"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("traceId", jsonObject.getString("traceId"))
                .addParameter("userId", String.valueOf(jsonObject.getLong("userId")))
                .addParameter("frequency", jsonObject.getJSONObject("frequency").toJSONString())
                .addParameter("reportPeriod", String.valueOf(jsonObject.getInteger("reportPeriod")))
                .addParameter("collectPeriod", String.valueOf(jsonObject.getInteger("collectPeriod")))
                .addParameter("pushPeriod", String.valueOf(jsonObject.getInteger("pushPeriod")));
        return postClient.post();
    }

    /**
     * 校验轨迹id
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceCheckTraceId(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_CHECK_TRACE_ID)
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
     * 根据位置范围查询用户
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    @Override
    public String GbsTraceQueryUserByGeoScope(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadTraceConstants.GBS_TRACE_QUERY_USER_BY_GEO_SCOPE)
                .addParameter("searchLimitTime", String.valueOf(jsonObject.getLong("searchLimitTime")))
                .addParameter("geoType", String.valueOf(jsonObject.getInteger("geoType")))
                .addParameter("latitude", String.valueOf(jsonObject.getDouble("latitude")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("radius", String.valueOf(jsonObject.getDouble("radius")))
                .addParameter("longitude", String.valueOf(jsonObject.getDouble("longitude")));
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
        try {
             if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("useridlist"))) {
                jsonObject.getJSONArray("useridlist").forEach(item -> {
                    postClient.addParameter("useridlist", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("useridlist"))) {
                postClient.addParameter("useridlist", jsonObject.getString("useridlist"));
            }
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

    /**
     * 更新群会话
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    public String chatGroupUpdate(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadChatApiConstants.CHAT_GROUP_UPDATE)
                .addParameter("chatId", jsonObject.getString("chatId"))
                .addParameter("newOwnerAccountId", String.valueOf(jsonObject.getInteger("newOwnerAccountId")))
                .addParameter("icon", jsonObject.getString("icon"))
                .addParameter("managementType", String.valueOf(jsonObject.getInteger("managementType")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("disableRead", String.valueOf(jsonObject.getInteger("disableRead")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("name", jsonObject.getString("name"))
                .addParameter("silenceAll", String.valueOf(jsonObject.getInteger("silenceAll")));
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("addUserIdList"))) {
                jsonObject.getJSONArray("addUserIdList").forEach(item -> {
                    postClient.addParameter("addUserIdList", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("addUserIdList"))) {
                postClient.addParameter("addUserIdList", jsonObject.getString("addUserIdList"));
            }
        }
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("delUserIdList"))) {
                jsonObject.getJSONArray("delUserIdList").forEach(item -> {
                    postClient.addParameter("delUserIdList", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("delUserIdList"))) {
                postClient.addParameter("delUserIdList", jsonObject.getString("delUserIdList"));
            }
        }
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
        PostClient postClient = this.newGadPostClient(GadScheduleApiConstants.CALENDAR_CANCEL_CALENDAR)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("summary", jsonObject.getString("summary"))
                .addParameter("creator", jsonObject.getJSONObject("creator").toJSONString())
                .addParameter("start", jsonObject.getJSONObject("start").toJSONString())
                .addParameter("description", jsonObject.getString("description"))
                .addParameter("eventType", jsonObject.getString("eventType"))
                .addParameter("calendarId", String.valueOf(jsonObject.getLong("calendarId")))
                .addParameter("attendeeNum", String.valueOf(jsonObject.getLong("attendeeNum")))
                .addParameter("sourceType", jsonObject.getString("sourceType"))
                .addParameter("bizId", jsonObject.getString("bizId"))
                .addParameter("confirmStatus", jsonObject.getString("confirmStatus"))
                .addParameter("acceptedNum", String.valueOf(jsonObject.getLong("acceptedNum")))
                .addParameter("end", jsonObject.getJSONObject("end").toJSONString())
                .addParameter("pageQueryDto", jsonObject.getJSONObject("pageQueryDto").toJSONString())
                .addParameter("sourceName", jsonObject.getString("sourceName"))
                .addParameter("event", jsonObject.getJSONObject("event").toJSONString())
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("timeStamp", String.valueOf(jsonObject.getLong("timeStamp")))
                .addParameter("dateTime", jsonObject.getString("dateTime"))
                .addParameter("timeZone", jsonObject.getString("timeZone"))
                .addParameter("organizationId", String.valueOf(jsonObject.getLong("organizationId")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("attendeeType", jsonObject.getString("attendeeType"))
                .addParameter("organizationId", String.valueOf(jsonObject.getLong("organizationId")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("attendeeType", jsonObject.getString("attendeeType"))
                .addParameter("timeStamp", String.valueOf(jsonObject.getLong("timeStamp")))
                .addParameter("dateTime", jsonObject.getString("dateTime"))
                .addParameter("timeZone", jsonObject.getString("timeZone"))
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("pageNoSize", String.valueOf(jsonObject.getInteger("pageNoSize")));
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("attendees"))) {
                jsonObject.getJSONArray("attendees").forEach(item -> {
                    postClient.addParameter("attendees", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("attendees").toJSONString() != null) {
                postClient.addParameter("attendees", jsonObject.getJSONObject("attendees").toJSONString());
            }
        }
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("attendeesAdd"))) {
                jsonObject.getJSONArray("attendeesAdd").forEach(item -> {
                    postClient.addParameter("attendeesAdd", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("attendeesAdd").toJSONString() != null) {
                postClient.addParameter("attendeesAdd", jsonObject.getJSONObject("attendeesAdd").toJSONString());
            }
        }
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("attendeesDel"))) {
                jsonObject.getJSONArray("attendeesDel").forEach(item -> {
                    postClient.addParameter("attendeesDel", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("attendeesDel").toJSONString() != null) {
                postClient.addParameter("attendeesDel", jsonObject.getJSONObject("attendeesDel").toJSONString());
            }
        }
        return postClient.post();
    }

    /**
     * 创建日历事件
     * @param jsonObject  JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarCreateCalendarEvent(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadScheduleApiConstants.CALENDAR_CREATE_CALENDAR)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("summary", jsonObject.getString("summary"))
                .addParameter("creator", jsonObject.getJSONObject("creator").toJSONString())
                .addParameter("start", jsonObject.getJSONObject("start").toJSONString())
                .addParameter("description", jsonObject.getString("description"))
                .addParameter("eventType", jsonObject.getString("eventType"))
                .addParameter("calendarId", String.valueOf(jsonObject.getLong("calendarId")))
                .addParameter("attendeeNum", String.valueOf(jsonObject.getLong("attendeeNum")))
                .addParameter("sourceType", jsonObject.getString("sourceType"))
                .addParameter("bizId", jsonObject.getString("bizId"))
                .addParameter("confirmStatus", jsonObject.getString("confirmStatus"))
                .addParameter("acceptedNum", String.valueOf(jsonObject.getLong("acceptedNum")))
                .addParameter("end", jsonObject.getJSONObject("end").toJSONString())
                .addParameter("pageQueryDto", jsonObject.getJSONObject("pageQueryDto").toJSONString())
                .addParameter("sourceName", jsonObject.getString("sourceName"))
                .addParameter("event", jsonObject.getJSONObject("event").toJSONString())
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("timeStamp", String.valueOf(jsonObject.getLong("timeStamp")))
                .addParameter("dateTime", jsonObject.getString("dateTime"))
                .addParameter("timeZone", jsonObject.getString("timeZone"))
                .addParameter("organizationId", String.valueOf(jsonObject.getLong("organizationId")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("attendeeType", jsonObject.getString("attendeeType"))
                .addParameter("organizationId", String.valueOf(jsonObject.getLong("organizationId")))
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("image", jsonObject.getString("image"))
                .addParameter("phone", jsonObject.getString("phone"))
                .addParameter("displayName", jsonObject.getString("displayName"))
                .addParameter("tenantId", jsonObject.getString("tenantId"))
                .addParameter("position", jsonObject.getString("position"))
                .addParameter("attendeeType", jsonObject.getString("attendeeType"))
                .addParameter("timeStamp", String.valueOf(jsonObject.getLong("timeStamp")))
                .addParameter("dateTime", jsonObject.getString("dateTime"))
                .addParameter("timeZone", jsonObject.getString("timeZone"))
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("pageNoSize", String.valueOf(jsonObject.getInteger("pageNoSize")));
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("attendees"))) {
                jsonObject.getJSONArray("attendees").forEach(item -> {
                    postClient.addParameter("attendees", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("attendees").toJSONString() != null) {
                postClient.addParameter("attendees", jsonObject.getJSONObject("attendees").toJSONString());
            }
        }
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("attendeesAdd"))) {
                jsonObject.getJSONArray("attendeesAdd").forEach(item -> {
                    postClient.addParameter("attendeesAdd", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("attendeesAdd").toJSONString() != null) {
                postClient.addParameter("attendeesAdd", jsonObject.getJSONObject("attendeesAdd").toJSONString());
            }
        }
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("attendeesDel"))) {
                jsonObject.getJSONArray("attendeesDel").forEach(item -> {
                    postClient.addParameter("attendeesDel", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(jsonObject.getJSONObject("attendeesDel").toJSONString() != null) {
                postClient.addParameter("attendeesDel", jsonObject.getJSONObject("attendeesDel").toJSONString());
            }
        }
        return postClient.post();
    }

    /**
     * 获取APP设置可见的用户Id
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarAppQueryAppVisibleList(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadScheduleApiConstants.CALENDAR_QUERY_APP_VISIBLE_LIST)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")));
        return postClient.post();
    }

    /**
     * 从可见用户列表中删除指定用户
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarAppRemoveUserFromAppVisibleList(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadScheduleApiConstants.CALENDAR_REMOVE_USER_FROM_APP_VISIBLE_LIST)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("accountIds"))) {
            jsonObject.getJSONArray("accountIds").forEach(item -> {
                postClient.addParameter("accountIds", String.valueOf(item));
            });
        }
        return postClient.post();
    }

    /**
     * 设置APP的用户可见性
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarAppAddUserToAppVisibleList(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadScheduleApiConstants.CALENDAR_ADD_USER_TO_APP_VISIBLE_LIST)
                .addParameter("appName", jsonObject.getString("appName"))
                .addParameter("bizScene", jsonObject.getString("bizScene"))
                .addParameter("clientType", jsonObject.getString("clientType"))
                .addParameter("osType", jsonObject.getString("osType"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("accountIds"))) {
            jsonObject.getJSONArray("accountIds").forEach(item -> {
                postClient.addParameter("accountIds", String.valueOf(item));
            });
        }
        return postClient.post();
    }

    /**
     * 获取用户可用的app
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String calendarAppUserVisibleApps(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadScheduleApiConstants.CALENDAR_USER_VISIBLE_APPS)
                .addParameter("accountId", String.valueOf(jsonObject.getLong("accountId")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("currentPage", String.valueOf(jsonObject.getInteger("currentPage")));
        return postClient.post();
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
                messageWorkNotificationObject.getOrganizationCodes().forEach(item -> {
                    postClient.addParameter("organizationCodes", item);
                });
            } else {
                throw new GadIndexOutOfBoundsException("The length of the organizationCodes is over 20 in messageWorkNotification");
            }
        }
        if(!CollectionUtils.isEmpty(messageWorkNotificationObject.getReceiverIds())) {
            messageWorkNotificationObject.getOrganizationCodes().forEach(item -> {
                postClient.addParameter("receiverIds", item);
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
        } else {
            throw new GadNullPointerException("msg is empty in messageWorkNotification");
        }

        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("organizationCodes"))) {
                jsonObject.getJSONArray("organizationCodes").forEach(item -> {
                    postClient.addParameter("organizationCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("organizationCodes"))){
                postClient.addParameter("organizationCodes", jsonObject.getString("organizationCodes"));
            }
        }

        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("receiverIds"))) {
                jsonObject.getJSONArray("receiverIds").forEach(item -> {
                    postClient.addParameter("receiverIds", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("receiverIds"))) {
                postClient.addParameter("receiverIds", jsonObject.getString("receiverIds"));
            }
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
            try {
                if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("bizMsgIds"))) {
                    jsonObject.getJSONArray("bizMsgIds").forEach(item -> {
                        postClient.addParameter("bizMsgIds", (String) item);
                    });
                }
            } catch (Exception e) {
                if(StringUtils.isNotEmpty(jsonObject.getString("bizMsgIds"))) {
                    postClient.addParameter("bizMsgIds", jsonObject.getString("bizMsgIds"));
                }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("bizMsgIds"))) {
                jsonObject.getJSONArray("bizMsgIds").forEach(item -> {
                    postClient.addParameter("bizMsgIds", (String) item);
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("bizMsgIds"))) {
                postClient.addParameter("bizMsgIds", jsonObject.getString("bizMsgIds"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govBusinessStripCodes"))) {
                jsonObject.getJSONArray("govBusinessStripCodes").forEach(item -> {
                    postClient.addParameter("govBusinessStripCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("govBusinessStripCodes"))) {
                postClient.addParameter("govBusinessStripCodes", jsonObject.getString("govBusinessStripCodes"));
            }
        }
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govResponsibleEmployeeCodes"))) {
                jsonObject.getJSONArray("govResponsibleEmployeeCodes").forEach(item -> {
                    postClient.addParameter("govResponsibleEmployeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("govResponsibleEmployeeCodes"))) {
                postClient.addParameter("govResponsibleEmployeeCodes", jsonObject.getString("govResponsibleEmployeeCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govBusinessStripCodes"))) {
                jsonObject.getJSONArray("govBusinessStripCodes").forEach(item -> {
                    postClient.addParameter("govBusinessStripCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("govBusinessStripCodes"))) {
                postClient.addParameter("govBusinessStripCodes", jsonObject.getString("govBusinessStripCodes"));
            }
        }
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("govResponsibleEmployeeCodes"))) {
                jsonObject.getJSONArray("govResponsibleEmployeeCodes").forEach(item -> {
                    postClient.addParameter("govResponsibleEmployeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("govResponsibleEmployeeCodes"))) {
                postClient.addParameter("govResponsibleEmployeeCodes", jsonObject.getString("govResponsibleEmployeeCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("organizationCodes"))){
                jsonObject.getJSONArray("organizationCodes").forEach(item -> {
                    postClient.addParameter("organizationCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("organizationCodes"))) {
                postClient.addParameter("organizationCodes", jsonObject.getString("organizationCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("divisionCodes"))){
                jsonObject.getJSONArray("divisionCodes").forEach(item -> {
                    postClient.addParameter("divisionCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("divisionCodes"))) {
                postClient.addParameter("divisionCodes", jsonObject.getString("divisionCodes"));
            }
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
        try {
             if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("businessStripCodes"))){
                if(jsonObject.getJSONArray("businessStripCodes").size() <= 100) {
                    jsonObject.getJSONArray("businessStripCodes").forEach(item -> {
                        postClient.addParameter("businessStripCodes", String.valueOf(item));
                    });
                } else {
                    throw new GadIndexOutOfBoundsException("The length of the businessStripCodes is over 100 in deptListGovBusinessStripsByCodes");
                }
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("businessStripCodes"))) {
                postClient.addParameter("businessStripCodes", jsonObject.getString("businessStripCodes"));
            }
        }
        return postClient.post();
    }

    /**
     * 组织ID转换接口
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String deptZzdDeptGetDepMapByType(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_ZZD_DEPT_GET_DEP_MAP_BY_TYPE)
                .addParameter("type", jsonObject.getString("type"))
                .addParameter("departmentIds", jsonObject.getString("departmentIds"))
                .addParameter("proxyTenantId", jsonObject.getString("proxyTenantId"));
        return postClient.post();
    }

    /**
     * 根据组织code查询组织下的员工人数
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    public String deptGetOrganizationEmployeeCount(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABDIApiConstants.ABDI_GET_ORGANIZATION_EMPLOYEE_COUNT)
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("employeeStatus", jsonObject.getString("employeeStatus"));
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                    postClient.addParameter("employeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                    postClient.addParameter("employeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if (StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                    postClient.addParameter("employeeCodes", (String) item);
                });
            }
        } catch (Exception e) {
            if (StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("organizationCodes"))) {
                if(jsonObject.getJSONArray("organizationCodes").size() <= 100) {
                    jsonObject.getJSONArray("organizationCodes").forEach(item -> {
                        postClient.addParameter("organizationCodes", (String) item);
                    });
                } else {
                    throw new GadIndexOutOfBoundsException("The length of the organizationCodes is over 100 in employeeListAccountOrgByIdAndCodes");
                }
            }
        } catch (Exception e) {
            if (StringUtils.isNotEmpty(jsonObject.getString("organizationCodes"))) {
                postClient.addParameter("organizationCodes", jsonObject.getString("organizationCodes"));
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                if(jsonObject.getJSONArray("employeeCodes").size() <= 100) {
                    jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                        postClient.addParameter("employeeCodes", (String) item);
                    });
                } else {
                    throw new GadIndexOutOfBoundsException("The length of the employeeCodes is over 100 in employeeListGovOrgEmpEmailByCodes");
                }
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
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
        try {
            if(!CollectionUtils.isEmpty(jsonObject.getJSONArray("accountIds"))) {
                jsonObject.getJSONArray("accountIds").forEach(item -> {
                    postClient.addParameter("accountIds", (String) item);
                });
            }
        } catch (Exception e) {
            if(jsonObject.getLong("accountIds") != null) {
                postClient.addParameter("accountIds", String.valueOf(jsonObject.getLong("accountIds")));
            }
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

    /**
     * 人员排序
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeReorderEmpPositionsByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_REORDER_EMP_POSITION_BY_CODES)
                .addParameter("organizationCode", jsonObject.getString("fromOrganizationCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"));
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                    postClient.addParameter("employeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
        }
        return postClient.post();
    }

    /**
     * 获取通讯录权限范围 v2
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeAuthScopesV2(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_AUTH_SCOPES_V2)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 查询角色授权详情信息
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeGetGrantRoleDataDetail(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_ACL_GET_GRANT_ROLE_DATA_DETAIL)
                .addParameter("roleCode", jsonObject.getString("roleCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("employeeCode", jsonObject.getString("employeeCode"));
        return postClient.post();
    }

    /**
     * 查询组织下人员详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeePageOrganizationEmployeePositions(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_PAGE_ORGANIZATION_EMP_POSITION)
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("employeeStatus", jsonObject.getString("employeeStatus"))
                .addParameter("organizationCode", jsonObject.getString("organizationCode"))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 批量新增人员标签
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeBatchCreateEmployeeTag(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_BATCH_CREATE_EMP_TAG)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"));
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("tagCodes"))) {
                jsonObject.getJSONArray("tagCodes").forEach(item -> {
                    postClient.addParameter("tagCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("tagCodes"))) {
                postClient.addParameter("tagCodes", jsonObject.getString("tagCodes"));
            }
        }
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                    postClient.addParameter("employeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
        }
        return postClient.post();
    }

    /**
     * 批量删除人员标签
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeBatchDeleteEmployeeTag(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_BATCH_DELETE_EMP_TAG)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"));
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("tagCodes"))) {
                jsonObject.getJSONArray("tagCodes").forEach(item -> {
                    postClient.addParameter("tagCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("tagCodes"))) {
                postClient.addParameter("tagCodes", jsonObject.getString("tagCodes"));
            }
        }
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("employeeCodes"))) {
                jsonObject.getJSONArray("employeeCodes").forEach(item -> {
                    postClient.addParameter("employeeCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("employeeCodes"))) {
                postClient.addParameter("employeeCodes", jsonObject.getString("employeeCodes"));
            }
        }
        return postClient.post();
    }

    /**
     * 根据标签code获取人员信息列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeePageEmployeesByTagCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_PAGE_EMP_BY_TAG_CODE)
                .addParameter("tagCode", jsonObject.getString("tagCode"))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 启用/停用标签
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeUpdateTagStatus(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_UPDATE_TAG_STATUS)
                .addParameter("tagCode", jsonObject.getString("tagCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("status", jsonObject.getString("status"));
        return postClient.post();
    }

    /**
     * 获取标签列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeePageTags(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_PAGE_TAGS)
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("keyword", jsonObject.getString("keyword"));
        return postClient.post();
    }

    /**
     * 删除标签
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeDeleteTag(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_DELETE_TAGS)
                .addParameter("tagCode", jsonObject.getString("tagCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("operator", jsonObject.getString("operator"));
        return postClient.post();
    }

    /**
     * 删除标签组
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeDeleteTagGroup(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_DELETE_TAG_GROUP)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("tagGroupCode", jsonObject.getString("tagGroupCode"))
                .addParameter("operator", jsonObject.getString("operator"));
        return postClient.post();
    }

    /**
     * 根据标签组code获取标签列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeePagTagsByGroupCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_PAGE_TAGS_BY_GROUP_CODE)
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("tagGroupCode", jsonObject.getString("tagGroupCode"))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("status", jsonObject.getString("status"));
        return postClient.post();
    }

    /**
     * 获取标签详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeGetTagDetail(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_GET_TAG_DETAIL)
                .addParameter("tagCode", jsonObject.getString("tagCode"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 根据标签code列表获取标签详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeGetTagsDetailByCodes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_GET_TAGS_DETAIL_BY_CODES)
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("tagCodes"))) {
                jsonObject.getJSONArray("tagCodes").forEach(item -> {
                    postClient.addParameter("tagCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("tagCodes"))) {
                postClient.addParameter("tagCodes", jsonObject.getString("tagCodes"));
            }
        }
        return postClient.post();
    }

    /**
     * 创建标签组
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeCreateTagGroup(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_CREATE_TAG_GROUP)
                .addParameter("creator", jsonObject.getString("creator"))
                .addParameter("tagGroupDescription", jsonObject.getString("tagGroupDescription"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("tagGroupName", jsonObject.getString("tagGroupName"));
        return postClient.post();
    }

    /**
     * 添加标签
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeAddTag(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_ADD_TAG)
                .addParameter("tagName", jsonObject.getString("tagName"))
                .addParameter("operator", jsonObject.getString("operator"))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("tagDescription", jsonObject.getString("tagDescription"));
        try {
            if (!CollectionUtils.isEmpty(jsonObject.getJSONArray("tagGroupCodes"))) {
                jsonObject.getJSONArray("tagGroupCodes").forEach(item -> {
                    postClient.addParameter("tagGroupCodes", String.valueOf(item));
                });
            }
        } catch (Exception e) {
            if(StringUtils.isNotEmpty(jsonObject.getString("tagGroupCodes"))) {
                postClient.addParameter("tagGroupCodes", jsonObject.getString("tagGroupCodes"));
            }
        }
        return postClient.post();
    }

    /**
     * 获取所有标签组
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeePageTagGroups(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_TAG_PAGE_TAG_GROUPS)
                .addParameter("returnTotalSize", String.valueOf(jsonObject.getBoolean("returnTotalSize")))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")))
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")));
        return postClient.post();
    }

    /**
     * 根据标签组code获取人员信息列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeePageEmployeesByTagGroupCode(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_PAGE_EMP_BY_TAG_GROUP_CODE)
                .addParameter("pageSize", String.valueOf(jsonObject.getInteger("pageSize")))
                .addParameter("tagGroupCode", jsonObject.getString("tagGroupCode"))
                .addParameter("pageNo", String.valueOf(jsonObject.getInteger("pageNo")))
                .addParameter("tenantId", String.valueOf(jsonObject.getLong("tenantId")));
        return postClient.post();
    }

    /**
     * 获取通讯录权限范围
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    @Override
    public String employeeAuthScopes(JSONObject jsonObject) {
        PostClient postClient = this.newGadPostClient(GadABUIApiConstants.ABUI_AUTH_SCOPES)
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
