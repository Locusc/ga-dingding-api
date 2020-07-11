package cn.locusc.ga.dingding.api.client.service;

/**
 * @author Jay Chan
 * 政务钉钉媒体文件下载接口
 * 14:58 2020/7/11
 **/
public interface GadFileStorageService {

    /**
     * 媒体文件下载
     * @param accessToken 校验权限的appToken
     * @param mediaId 上传成功后返回的mediaId
     * @return java.lang.String
     **/
    String mediaDownload(String accessToken, String mediaId);
}
