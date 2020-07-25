package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉应用管理后台免登接口
 * 15:10 2020/7/25
 **/
interface GadAMBApiService {

    /**
     * 服务端通过临时授权码获取授权用户的个人信息
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String rpcOauth2GetUserInfoByCode(JSONObject jsonObject);
}
