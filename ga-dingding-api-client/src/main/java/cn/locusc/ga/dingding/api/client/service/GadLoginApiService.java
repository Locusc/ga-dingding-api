package cn.locusc.ga.dingding.api.client.service;

/**
 * @author Jay Chan
 * 政务钉钉企业内应用免登录接口
 * 9:34 2020/6/28
 **/
interface GadLoginApiService {

    /**
     * 根据authCode获取登录token
     * @param accessToken 应用access_token
     * @param authCode 临时授权码
     * @return java.lang.String
     **/
    String rpcOauth2DingTalkAppToken(String accessToken, String authCode);

    /**
     * 根据authCode换取用户信息
     * @param accessToken 应用access_token
     * @param authCode 临时授权码
     * @return java.lang.String
     **/
    String rpcOauth2DingTalkAppUser(String accessToken, String authCode);

    /**
     * 获取应用access_token
     * @return java.lang.String
     **/
    String rpcOauth2GetToken();
}
