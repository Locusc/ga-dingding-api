package cn.locusc.ga.dingding.api.client.service;

/**
 * @author Jay Chan
 * 政务钉钉JSAPI鉴权接口
 * 19:24 2020/6/25
 **/
interface GadJsApiAuthService {

    /**
     * /get_jsapi_token.json JSAPI鉴权
     * @param accessToken accessToken
     * @return java.lang.String
     **/
    String getJsApiToken(String accessToken);
}
