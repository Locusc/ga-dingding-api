package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉人脸识别接口
 * 15:09 2020/8/6
 **/
interface GadFaceRecognitionService {

    /**
     * 图片压缩，按照宽高压缩
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceCompressForBorder(JSONObject jsonObject);

    /**
     * 图片压缩，按照比例，精度压缩
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceCompressForScale(JSONObject jsonObject);

    /**
     * 压缩图片，根据需要的字节大小，精度压缩
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceCompressForSize(JSONObject jsonObject);

    /**
     * 人脸属性识别
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceAttribute(JSONObject jsonObject);

    /**
     * 人脸比对（上传两张图片比对）
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceVerifyWithOriginalImg(JSONObject jsonObject);

    /**
     * 人脸比对(服务端事先录入原图)
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceVerify(JSONObject jsonObject);

    /**
     * 人脸检测
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String bipFaceDetect(JSONObject jsonObject);

}
