package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉人脸识别接口地址常量
 * 14:33 2020/8/6
 **/
public class GadFaceRecognitionConstants {

    /**
     * 图片压缩，按照宽高压缩
     **/
    public static final String BIP_FACE_COMPRESS_FOR_BORDER = "/bip/face/compress/forBorder";

    /**
     * 图片压缩，按照比例，精度压缩
     **/
    public static final String BIP_FACE_COMPRESS_FOR_SCALE = "/bip/face/compress/forScale";

    /**
     * 压缩图片，根据需要的字节大小，精度压缩
     **/
    public static final String BIP_FACE_COMPRESS_FOR_SIZE = "/bip/face/compress/forSize";

    /**
     * 人脸属性识别
     **/
    public static final String BIP_FACE_ATTRIBUTE = "/bip/face/attribute";

    /**
     * 人脸比对（上传两张图片比对）
     **/
    public static final String BIP_FACE_VERIFY_WITH_ORIGINAL_IMG = "/bip/face/verifyWithOriginalImg";

    /**
     * 人脸比对(服务端事先录入原图)
     **/
    public static final String BIP_FACE_VERIFY = "/bip/face/verify";

    /**
     * 人脸检测
     **/
    public static final String BIP_FACE_DETECT = "/bip/face/detect";

}
