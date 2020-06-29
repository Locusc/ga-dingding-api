package cn.locusc.ga.dingding.api.client.service;

/**
 * @Author Jay Chan
 * @Description 政务钉钉JSAPI鉴权接口
 * @Date 19:24 2020/6/25
 **/
interface GadJsApiAuthService {

    /**
     * @Description /get_jsapi_token.json JSAPI鉴权
     * @Param [accessToken]
     * @return java.lang.String
     **/
    String getJsApiToken(String accessToken);
}
