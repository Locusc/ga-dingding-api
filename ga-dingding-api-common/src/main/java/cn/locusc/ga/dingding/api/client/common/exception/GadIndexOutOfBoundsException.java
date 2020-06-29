package cn.locusc.ga.dingding.api.client.common.exception;

/**
 * @Author Jay Chan
 * @Description 政务钉钉自定义数组下标越界错误
 * @Date 11:31 2020/6/28
 **/
public class GadIndexOutOfBoundsException extends RuntimeException {

    public GadIndexOutOfBoundsException() { super(); }

    public GadIndexOutOfBoundsException(String msg) { super(msg); }
}
