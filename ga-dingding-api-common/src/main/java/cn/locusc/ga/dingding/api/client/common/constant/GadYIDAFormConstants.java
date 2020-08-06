package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉宜搭表单接口地址常量
 * 15:27 2020/8/5
 **/
public class GadYIDAFormConstants {

    /**
     * 获取表单定义
     **/
    public static final String YIDA_FORM_DESIGN_GET_FORM_COMPONENT_DEFINATION_LIST = "/yida/formDesign/getFormComponentDefinationList.json";

    /**
     * 根据条件搜索单据实例详情列表
     **/
    public static final String YIDA_FORM_SEARCH_FORM_DATAS = "/yida/form/searchFormDatas.json";

    /**
     * 根据条件搜索单据实例ID列表
     **/
    public static final String YIDA_FORM_SEARCH_FORM_DATA_IDS = "/yida/form/searchFormDataIds.json";

    /**
     * 根据单据实例ID查询单据实例详情
     **/
    public static final String YIDA_FORM_SEARCH_FORM_DATA_BY_ID = "/yida/form/getFormDataById.json";

    /**
     * 删除单据实例
     **/
    public static final String YIDA_FORM_DELETE_FORM_DATA = "/yida/form/deleteFormData.json";

    /**
     * 更新单据中指定组件值
     **/
    public static final String YIDA_FORM_UPDATE_FORM_DATA = "/yida/form/updateFormData.json";

    /**
     * 新增单据实例
     **/
    public static final String YIDA_FORM_SAVE_FORM_DATA = "/yida/form/saveFormData.json";

}
