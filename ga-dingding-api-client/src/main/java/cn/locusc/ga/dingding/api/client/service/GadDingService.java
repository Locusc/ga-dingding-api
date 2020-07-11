package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉DING API开放接口
 * 16:21 2020/7/1
 **/
interface GadDingService {

    /**
     * DING API开放
     * @param jsonObject jsonObject入参
     * @return java.lang.String
     **/
    String GovDingIsvSend(JSONObject jsonObject);
}
