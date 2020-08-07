package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉电子签章接口
 * 15:17 2020/8/6
 **/
interface GadGESService {

    /**
     * 获取签章机构列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String gesQueryOrganizations(JSONObject jsonObject);

    /**
     * 获取签章管理员列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String gesQuerySealKeepers(JSONObject jsonObject);

    /**
     * 获取印章列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String gesQuerySeals(JSONObject jsonObject);

    /**
     * 发送签章验证码
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String gesStampSendVerifyCode(JSONObject jsonObject);

    /**
     * 验证签章验证码
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String gesStampCheckVerifyCode(JSONObject jsonObject);

    /**
     * 签署盖章
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String gesStampSign(JSONObject jsonObject);

}
