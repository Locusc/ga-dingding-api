package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @Author Jay Chan
 * @Description 政务钉钉获取通讯录用户信息接口地址常量
 * @Date 16:30 2020/6/24
 **/
public class GadABUIApiConstants {

    /**
     * @Description 冻结和解冻账号
     **/
    public static final String ABUI_UPDATE_GOV_ACCOUNT_STATUS = "/mozi/account/updateGovAccountStatus";

    /**
     * @Description 根据员工 Code获取员工标签code列表
     **/
    public static final String ABUI_LIST_EMPLOYEE_TAGS = "/mozi/employee/listEmployeeTags";

    /**
     * @Description 删除员工的任职
     **/
    public static final String ABUI_DELETE_GOV_EMPLOYEE_POSITION = "/mozi/employee/deleteGovEmployeePosition";

    /**
     * @Description 更新员工的任职
     **/
    public static final String ABUI_UPDATE_GOV_EMPLOYEE_POSITION = "/mozi/employee/updateGovEmployeePosition";

    /**
     * @Description 删除员工
     **/
    public static final String ABUI_DELETE_GOV_EMPLOYEE = "/mozi/employee/deleteGovEmployee";

    /**
     * @Description 失效员工
     **/
    public static final String ABUI_DEACTIVATE_GOV_EMPLOYEE = "/mozi/employee/deactivateGovEmployee";

    /**
     * @Description 新增员工
     **/
    public static final String ABUI_CREATE_GOV_EMPLOYEE = "/mozi/employee/createGovEmployee";

    /**
     * @Description 根据组织 CODE、员⼯ Code 列表， 批量获取员工在该组织的任职
     **/
    public static final String ABUI_LIST_ORG_EMPLOYEE_POSITION_BY_CODES = "/mozi/employee/listOrgEmployeePositionsByCodes";

    /**
     * @Description 根据员⼯ Code 列表查询详情
     **/
    public static final String ABUI_LIST_EMPLOYEES_BY_CODES = "/mozi/employee/listEmployeesByCodes";

    /**
     * @Description 根据员工code获取员工的任职
     **/
    public static final String ABUI_LIST_EMPLOYEES_POSITION_BY_EMPLOYEE_CODE = "/mozi/employee/listEmployeePositionsByEmployeeCode";

    /**
     * @Description 根据员工 Code 查询详情
     **/
    public static final String ABUI_GET_EMPLOYEE_BY_CODE = "/mozi/employee/getEmployeeByCode";

    /**
     * @Description 通过员工 Code 列表获取员⼯账号 ID
     **/
    public static final String ABUI_LIST_EMPLOYEE_ACCOUNT_IDS = "/mozi/employee/listEmployeeAccountIds";

    /**
     * @Description 批量根据accountId、tenantId、organizationCode查询这个账号是否在这个租户的这些组织内
     **/
    public static final String ABUI_LIST_ACCOUNT_ORG_BY_ID_AND_CODES = "/mozi/employee/listAccountOrgByIdAndCodes";

    /**
     * @Description 根据组织code和批量员工 Code 获取员工的邮箱信息
     **/
    public static final String ABUI_LIST_GOV_ORG_EMPLOYEE_EMAIL_BY_CODES = "/mozi/employee/listGovOrgEmployeeEmailByCodes";

    /**
     * @Description 批量 通过账号Id 列表获取人员Code
     **/
    public static final String ABUI_LIST_GOV_EMPLOYEE_CODES_BY_ACCOUNT_IDS = "/mozi/employee/listGovEmployeeCodesByAccountIds";

    /**
     * @Description 根据手机号码获取人员编码
     **/
    public static final String ABUI_GET_BY_MOBILE = "/mozi/employee/get_by_mobile";
}
