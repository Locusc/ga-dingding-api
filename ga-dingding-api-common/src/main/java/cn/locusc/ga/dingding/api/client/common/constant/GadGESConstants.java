package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉电子签章接口地址常量
 * 14:40 2020/8/6
 **/
public class GadGESConstants {

    /**
     * 获取签章机构列表
     **/
    public static final String GES_QUERY_ORGANIZATIONS = "/ges/query/organizations";

    /**
     * 获取签章管理员列表
     **/
    public static final String GES_QUERY_SEAL_KEEPERS = "/ges/query/sealKeepers";

    /**
     * 获取印章列表
     **/
    public static final String GES_QUERY_SEALS = "/ges/query/seals";

    /**
     * 发送签章验证码
     **/
    public static final String GES_STAMP_SEND_VERIFY_CODE = "/ges/stamp/sendVerifyCode";

    /**
     * 验证签章验证码
     **/
    public static final String GES_STAMP_CHECK_VERIFY_CODE = "/ges/stamp/checkVerifyCode";

    /**
     * 签署盖章
     **/
    public static final String GES_STAMP_SIGN = "/ges/stamp/sign";

}
