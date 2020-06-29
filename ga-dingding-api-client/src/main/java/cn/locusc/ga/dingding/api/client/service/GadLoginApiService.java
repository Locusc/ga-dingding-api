package cn.locusc.ga.dingding.api.client.service;

/**
 * @Author Jay Chan
 * @Description 政务钉钉企业内应用免登录接口
 * @Date 9:34 2020/6/28
 **/
interface GadLoginApiService {

    /**
     * @Description 根据authCode获取登录token
     * @Param [accessToken, authCode]
     * @return java.lang.String
     **/
    String rpcOauth2DingTalkAppToken(String accessToken, String authCode);

    /**
     * @Description 根据authCode换取用户信息
     * @Param [accessToken, authCode]
     * @return java.lang.String
     **/
    String rpcOauth2DingTalkAppUser(String accessToken, String authCode);

    /**
     * @Description 获取应用access_token
     * @Param [appKey, appSecret]
     * @return java.lang.String
     **/
    String rpcOauth2GetToken(String appKey, String appSecret);
}
