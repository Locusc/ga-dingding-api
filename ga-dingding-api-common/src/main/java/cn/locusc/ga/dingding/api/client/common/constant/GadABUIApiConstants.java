package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉获取通讯录用户信息接口地址常量
 * 16:30 2020/6/24
 **/
public class GadABUIApiConstants {

    /**
     * 冻结和解冻账号
     **/
    public static final String ABUI_UPDATE_GOV_ACCOUNT_STATUS = "/mozi/account/updateGovAccountStatus";

    /**
     * 根据员工 Code获取员工标签code列表
     **/
    public static final String ABUI_LIST_EMPLOYEE_TAGS = "/mozi/employee/listEmployeeTags";

    /**
     * 删除员工的任职
     **/
    public static final String ABUI_DELETE_GOV_EMPLOYEE_POSITION = "/mozi/employee/deleteGovEmployeePosition";

    /**
     * 更新员工的任职
     **/
    public static final String ABUI_UPDATE_GOV_EMPLOYEE_POSITION = "/mozi/employee/updateGovEmployeePosition";

    /**
     * 删除员工
     **/
    public static final String ABUI_DELETE_GOV_EMPLOYEE = "/mozi/employee/deleteGovEmployee";

    /**
     * 失效员工
     **/
    public static final String ABUI_DEACTIVATE_GOV_EMPLOYEE = "/mozi/employee/deactivateGovEmployee";

    /**
     * 修改员工
     **/
    public static final String ABUI_UPDATE_GOV_EMPLOYEE = "/mozi/employee/updateGovEmployee";

    /**
     * 创建员工的任职
     **/
    public static final String ABUI_CREATE_GOV_EMPLOYEE_POSITION = "/mozi/employee/createGovEmployeePosition";

    /**
     * 新增员工
     **/
    public static final String ABUI_CREATE_GOV_EMPLOYEE = "/mozi/employee/createGovEmployee";

    /**
     * 根据组织 CODE、员⼯ Code 列表， 批量获取员工在该组织的任职
     **/
    public static final String ABUI_LIST_ORG_EMPLOYEE_POSITION_BY_CODES = "/mozi/employee/listOrgEmployeePositionsByCodes";

    /**
     * 根据员⼯ Code 列表查询详情
     **/
    public static final String ABUI_LIST_EMPLOYEES_BY_CODES = "/mozi/employee/listEmployeesByCodes";

    /**
     * 根据员工code获取员工的任职
     **/
    public static final String ABUI_LIST_EMPLOYEES_POSITION_BY_EMPLOYEE_CODE = "/mozi/employee/listEmployeePositionsByEmployeeCode";

    /**
     * 根据员工 Code 查询详情
     **/
    public static final String ABUI_GET_EMPLOYEE_BY_CODE = "/mozi/employee/getEmployeeByCode";

    /**
     * 通过员工 Code 列表获取员⼯账号 ID
     **/
    public static final String ABUI_LIST_EMPLOYEE_ACCOUNT_IDS = "/mozi/employee/listEmployeeAccountIds";

    /**
     * 批量根据accountId、tenantId、organizationCode查询这个账号是否在这个租户的这些组织内
     **/
    public static final String ABUI_LIST_ACCOUNT_ORG_BY_ID_AND_CODES = "/mozi/employee/listAccountOrgByIdAndCodes";

    /**
     * 人员返聘
     **/
    public static final String ABUI_REHIRED_GOV_EMPLOYEE= "/mozi/employee/rehiredGovEmployee";

    /**
     * 根据组织code和批量员工 Code 获取员工的邮箱信息
     **/
    public static final String ABUI_LIST_GOV_ORG_EMPLOYEE_EMAIL_BY_CODES = "/mozi/employee/listGovOrgEmployeeEmailByCodes";

    /**
     * 批量 通过账号Id 列表获取人员Code
     **/
    public static final String ABUI_LIST_GOV_EMPLOYEE_CODES_BY_ACCOUNT_IDS = "/mozi/employee/listGovEmployeeCodesByAccountIds";

    /**
     * 查询映射关系通过数梦Id
     **/
    public static final String ABUI_GET_EMP_CODE_BY_DT_USER_ID = "/zzd/idMap/getEmpCodeByDtUserId";

    /**
     * 查询映射关系通过钉钉id
     **/
    public static final String ABUI_GET_EMP_CODE_BY_DING_USER_ID = "/zzd/idMap/getEmpCodeByDingUserId";

    /**
     * 根据手机号码获取人员编码
     **/
    public static final String ABUI_GET_BY_MOBILE = "/mozi/employee/get_by_mobile";

    /**
     * 移动任职
     **/
    public static final String ABUI_GET_MOVE_EMP_POSITION = "/mozi/employee/moveEmployeePosition";

    /**
     * 人员排序
     **/
    public static final String ABUI_REORDER_EMP_POSITION_BY_CODES = "/mozi/employee/reorderEmpPositionsByCodes";

    /**
     * 获取通讯录权限范围 v2
     **/
    public static final String ABUI_AUTH_SCOPES_V2 = "/auth/scopesV2";

    /**
     * 查询角色授权详情信息
     **/
    public static final String ABUI_ACL_GET_GRANT_ROLE_DATA_DETAIL = "/mozi/acl/getGrantRoleDataDetail";

    /**
     * 查询组织下人员详情
     **/
    public static final String ABUI_PAGE_ORGANIZATION_EMP_POSITION = "/mozi/organization/pageOrganizationEmployeePositions";

    /**
     * 批量新增人员标签
     **/
    public static final String ABUI_BATCH_CREATE_EMP_TAG = "/mozi/employee/batchCreateEmployeeTag";

    /**
     * 批量删除人员标签
     **/
    public static final String ABUI_BATCH_DELETE_EMP_TAG = "/mozi/employee/batchDeleteEmployeeTag";

    /**
     * 根据标签code获取人员信息列表
     **/
    public static final String ABUI_PAGE_EMP_BY_TAG_CODE = "/mozi/employee/pageEmployeesByTagCode";

    /**
     * 启用/停用标签
     **/
    public static final String ABUI_TAG_UPDATE_TAG_STATUS = "/mozi/tag/updateTagStatus";

    /**
     * 获取标签列表
     **/
    public static final String ABUI_TAG_PAGE_TAGS = "/mozi/tag/pageTags";

    /**
     * 删除标签
     **/
    public static final String ABUI_TAG_DELETE_TAGS = "/mozi/tag/deleteTag";

    /**
     * 删除标签组
     **/
    public static final String ABUI_TAG_DELETE_TAG_GROUP = "/mozi/tag/deleteTagGroup";

    /**
     * 根据标签组code获取标签列表
     **/
    public static final String ABUI_TAG_PAGE_TAGS_BY_GROUP_CODE = "/mozi/tag/pagTagsByGroupCode";

    /**
     * 获取标签详情
     **/
    public static final String ABUI_TAG_GET_TAG_DETAIL = "/mozi/tag/getTagDetail";

    /**
     * 根据标签code列表获取标签详情
     **/
    public static final String ABUI_TAG_GET_TAGS_DETAIL_BY_CODES = "/mozi/tag/getTagsDetailByCodes";

    /**
     * 创建标签组
     **/
    public static final String ABUI_TAG_CREATE_TAG_GROUP = "/mozi/tag/createTagGroup";

    /**
     * 添加标签
     **/
    public static final String ABUI_TAG_ADD_TAG = "/mozi/tag/addTag";

    /**
     * 获取所有标签组
     **/
    public static final String ABUI_TAG_PAGE_TAG_GROUPS = "/mozi/tag/PageTagGroups";

    /**
     * 根据标签组code获取人员信息列表
     **/
    public static final String ABUI_PAGE_EMP_BY_TAG_GROUP_CODE = "/mozi/employee/pageEmployeesByTagGroupCode";

    /**
     * 获取通讯录权限范围
     **/
    public static final String ABUI_AUTH_SCOPES = "/auth/scopes";

}
