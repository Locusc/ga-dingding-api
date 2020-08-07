package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉水印接口地址常量
 * 14:22 2020/8/6
 **/
public class GadWaterMarkConstants {

    /**
     * 制作水印
     **/
    public static final String BIP_WATERMARK_DO_WATERMARK = "/bip/watermark/doWatermark";

    /**
     * 添加水印模板
     **/
    public static final String BIP_WATERMARK_TEMPLATE_SAVE = "/bip/watermark/template/save";

    /**
     * 修改水印模板
     **/
    public static final String BIP_WATERMARK_TEMPLATE_EDIT = "/bip/watermark/template/edit";

    /**
     * 水印模板分页查询
     **/
    public static final String BIP_WATERMARK_TEMPLATE_PAGE_QUERY = "/bip/watermark/template/pageQuery";

    /**
     * 删除水印模板
     **/
    public static final String BIP_WATERMARK_TEMPLATE_DEL = "/bip/watermark/template/del";

    /**
     * 获取云端保存的水印文件（分页）
     **/
    public static final String BIP_WATERMARK_PAGE = "/bip/watermark/page";

    /**
     * 移动端获取水印模板
     **/
    public static final String BIP_WATERMARK_TEMPLATE_QUERY = "/bip/watermark/template/query";

}
