package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉宜搭其他接口
 * 15:35 2020/8/5
 **/
interface GadYIDAOtherService {

    /**
     * 获取应用下所有表单页面的列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaAppListNavigationByFormType(JSONObject jsonObject);

    /**
     * 宜搭附件地址转临时免登地址
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFileGetOpenUrl(JSONObject jsonObject);

    /**
     * 增加评论
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaRemarkSave(JSONObject jsonObject);

}
