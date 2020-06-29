package cn.locusc.ga.dingding.api.client.common.exception;

/**
 * @Author Jay Chan
 * @Description 政务钉钉自定义空指针错误
 * @Date 9:57 2020/6/28
 **/
public class GadNullPointerException extends RuntimeException {

    public GadNullPointerException() {
        super();
    }

    public GadNullPointerException(String msg) {
        super(msg);
    }
}
