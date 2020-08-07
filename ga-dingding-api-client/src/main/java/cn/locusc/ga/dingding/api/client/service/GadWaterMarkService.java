package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉水印接口
 * 15:03 2020/8/6
 **/
interface GadWaterMarkService {

    /**
     * 制作水印
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkDoWaterMark(JSONObject jsonObject);

    /**
     * 添加水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkTemplateSave(JSONObject jsonObject);

    /**
     * 修改水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkTemplateEdit(JSONObject jsonObject);

    /**
     * 水印模板分页查询
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkTemplatePageQuery(JSONObject jsonObject);

    /**
     * 删除水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkTemplateDel(JSONObject jsonObject);

    /**
     * 获取云端保存的水印文件（分页）
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkPage(JSONObject jsonObject);

    /**
     * 移动端获取水印模板
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipWaterMarkTemplateQuery(JSONObject jsonObject);

}