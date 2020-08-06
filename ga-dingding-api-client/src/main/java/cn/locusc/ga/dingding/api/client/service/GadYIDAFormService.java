package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉宜搭表单接口
 * 15:55 2020/8/5
 **/
public interface GadYIDAFormService {

    /**
     * 获取表单定义
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormDesignGetFormComponentDefinationList(JSONObject jsonObject);

    /**
     * 根据条件搜索单据实例详情列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormSearchFormDatas(JSONObject jsonObject);

    /**
     * 根据条件搜索单据实例ID列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormSearchFormDataIds(JSONObject jsonObject);

    /**
     * 根据单据实例ID查询单据实例详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormGetFormDataById(JSONObject jsonObject);

    /**
     * 删除单据实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormDeleteFormData(JSONObject jsonObject);

    /**
     * 更新单据中指定组件值
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormUpdateFormData(JSONObject jsonObject);

    /**
     * 新增单据实例
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String yiDaFormSaveFormData(JSONObject jsonObject);

}
