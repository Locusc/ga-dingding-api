package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉企业内免登录接口地址常量
 * 10:02 2020/6/25
 **/
public class GadLoginApiConstants {

    /**
     * 根据authCode获取登录token 注: authCode只能在前端获取 并且只能在政务钉钉APP内部
     **/
    public static final String RPC_OAUTH2_DINGTALK_APP_TOKEN = "/rpc/oauth2/dingtalk_app_token.json";

    /**
     * 根据authCode换取用户信息
     **/
    public static final String RPC_OAUTH2_DINGTALK_APP_USER = "/rpc/oauth2/dingtalk_app_user.json";

    /**
     * 获取应用access_token
     **/
    public static final String RPC_OAUTH2_GET_TOKEN = "/gettoken.json";
}
