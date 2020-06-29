package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @Author Jay Chan
 * @Description 政务钉钉获取通讯录部门信息接口地址常量
 * @Date 16:25 2020/6/24
 **/
public class GadABDIApiConstants {

    /**
     * @Description 修改员工
     **/
    public static final String ABDI_UPDATE_GOV_EMPLOYEE = "/mozi/employee/updateGovEmployee";

    /**
     * @Description 创建员工的任职
     **/
    public static final String ABDI_CREATE_GOV_EMPLOYEE_POSITION = "/mozi/employee/createGovEmployeePosition";

    /**
     * @Description 移动组织
     **/
    public static final String ABDI_MOVE_GOV_ORGANIZATION = "/mozi/organization/moveGovOrganization";

    /**
     * @Description 删除组织
     **/
    public static final String ABDI_DELETE_GOV_ORGANIZATION = "/mozi/organization/deleteGovOrganization";

    /**
     * @Description 更新组织
     **/
    public static final String ABDI_UPDATE_GOV_ORGANIZATION = "/mozi/organization/updateGovOrganization";

    /**
     * @Description 创建组织
     **/
    public static final String ABDI_CREATE_GOV_ORGANIZATION = "/mozi/organization/createGovOrganization";

    /**
     * @Description 根据组织 Code 列表查询详情
     **/
    public static final String ABDI_LIST_ORGANIZATION_BY_CODES = "/mozi/organization/listOrganizationsByCodes";
    /**
     * @Description 根据组织查询组织汇报线
     **/
    public static final String ABDI_GET_ORGANIZATION_LINE = "/mozi/organization/getOrganizationLine";

    /**
     * @Description 分页查询组织下的员⼯ Code
     **/
    public static final String ABDI_PAGE_ORGANIZATION_EMPLOYEE_CODES = "/mozi/organization/pageOrganizationEmployeeCodes";

    /**
     * @Description 根据组织code查询详情
     **/
    public static final String ABDI_GET_ORGANIZATION_BY_CODE = "/mozi/organization/getOrganizationByCode";

    /**
     * @Description 分页获取下⼀级组织 Code 列表
     **/
    public static final String ABDI_PAGE_SUB_ORGANIZATION_CODES = "/mozi/organization/pageSubOrganizationCodes";

    /**
     * @Description 获取租户根组织
     **/
    public static final String ABDI_GET_ROOT_ORGANIZATION = "/mozi/organization/getRootOrganization";

    /**
     * @Description 分页获取下一级行政区划列表
     **/
    public static final String ABDI_PAGE_SUB_GOV_DIVISIONS = "/mozi/organization/pageSubGovDivisions";

    /**
     * @Description 根据行政区划查询行政区划线
     **/
    public static final String ABDI_GET_DIVISION_LINE = "/mozi/organization/getDivisionLine";

    /**
     * @Description 根据行政区划 Code 列表查询
     **/
    public static final String ABDI_LIST_DIVISIONS_BY_CODES = "/mozi/organization/listDivisionsByCodes";

    /**
     * @Description 分页获取下一级条线列表
     **/
    public static final String ABDI_PAGE_SUB_GOV_BUSINESS_STRIPS = "/mozi/organization/pageSubGovBusinessStrips";

    /**
     * @Description 根据条线查询条线线
     **/
    public static final String ABDI_GET_GOV_BUSINESS_STRIP_LINE = "/mozi/organization/getGovBusinessStripLine";

    /**
     * @Description 根据条线 Code 列表查询
     **/
    public static final String ABDI_LIST_GOV_BUSINESS_STRIPS_BY_CODES = "/mozi/organization/listGovBusinessStripsByCodes";

}
