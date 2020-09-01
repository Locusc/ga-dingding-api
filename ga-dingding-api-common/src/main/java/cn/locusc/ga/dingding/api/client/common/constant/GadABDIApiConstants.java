package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉获取通讯录部门信息接口地址常量
 * 16:25 2020/6/24
 **/
public class GadABDIApiConstants {

    /**
     * 移动组织
     **/
    public static final String ABDI_MOVE_GOV_ORGANIZATION = "/mozi/organization/moveGovOrganization";

    /**
     * 删除组织
     **/
    public static final String ABDI_DELETE_GOV_ORGANIZATION = "/mozi/organization/deleteGovOrganization";

    /**
     * 更新组织
     **/
    public static final String ABDI_UPDATE_GOV_ORGANIZATION = "/mozi/organization/updateGovOrganization";

    /**
     * 创建组织
     **/
    public static final String ABDI_CREATE_GOV_ORGANIZATION = "/mozi/organization/createGovOrganization";

    /**
     * 根据组织 Code 列表查询详情
     **/
    public static final String ABDI_LIST_ORGANIZATION_BY_CODES = "/mozi/organization/listOrganizationsByCodes";

    /**
     * 根据组织查询组织汇报线
     **/
    public static final String ABDI_GET_ORGANIZATION_LINE = "/mozi/organization/getOrganizationLine";

    /**
     * 分页查询组织下的员⼯ Code
     **/
    public static final String ABDI_PAGE_ORGANIZATION_EMPLOYEE_CODES = "/mozi/organization/pageOrganizationEmployeeCodes";

    /**
     * 根据组织code查询详情
     **/
    public static final String ABDI_GET_ORGANIZATION_BY_CODE = "/mozi/organization/getOrganizationByCode";

    /**
     * 分页获取下⼀级组织 Code 列表
     **/
    public static final String ABDI_PAGE_SUB_ORGANIZATION_CODES = "/mozi/organization/pageSubOrganizationCodes";

    /**
     * 获取租户根组织
     **/
    public static final String ABDI_GET_ROOT_ORGANIZATION = "/mozi/organization/getRootOrganization";

    /**
     * 分页获取下一级行政区划列表
     **/
    public static final String ABDI_PAGE_SUB_GOV_DIVISIONS = "/mozi/organization/pageSubGovDivisions";

    /**
     * 根据行政区划查询行政区划线
     **/
    public static final String ABDI_GET_DIVISION_LINE = "/mozi/organization/getDivisionLine";

    /**
     * 根据行政区划 Code 列表查询
     **/
    public static final String ABDI_LIST_DIVISIONS_BY_CODES = "/mozi/organization/listDivisionsByCodes";

    /**
     * 分页获取下一级条线列表
     **/
    public static final String ABDI_PAGE_SUB_GOV_BUSINESS_STRIPS = "/mozi/organization/pageSubGovBusinessStrips";

    /**
     * 根据条线查询条线线
     **/
    public static final String ABDI_GET_GOV_BUSINESS_STRIP_LINE = "/mozi/organization/getGovBusinessStripLine";

    /**
     * 根据条线 Code 列表查询
     **/
    public static final String ABDI_LIST_GOV_BUSINESS_STRIPS_BY_CODES = "/mozi/organization/listGovBusinessStripsByCodes";

    /**
     * 组织ID转换接口
     **/
    public static final String ABDI_ZZD_DEPT_GET_DEP_MAP_BY_TYPE = "/zzd/dept/getDepMapByType";

    /**
     * 根据组织code查询组织下的员工人数
     **/
    public static final String ABDI_GET_ORGANIZATION_EMPLOYEE_COUNT = "/mozi/organization/getOrganizationEmployeeCount";

}
