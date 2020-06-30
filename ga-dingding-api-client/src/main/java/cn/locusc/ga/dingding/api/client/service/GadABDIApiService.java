package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉获取通讯录部门信息接口
 * 21:27 2020/6/24
 **/
interface GadABDIApiService {

    /**
     * 修改员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptUpdateGovEmployee(JSONObject jsonObject);

    /**
     * 创建员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptCreateGovEmployeePosition(JSONObject jsonObject);

    /**
     * 移动组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptMoveGovOrganization(JSONObject jsonObject);

    /**
     * 删除组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptDeleteGovOrganization(JSONObject jsonObject);

    /**
     * 更新组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptUpdateGovOrganization(JSONObject jsonObject);

    /**
     * 创建组织
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptCreateGovOrganization(JSONObject jsonObject);

    /**
     * 根据组织 Code 列表查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptListOrganizationByCodes(JSONObject jsonObject);

    /**
     * 根据组织查询组织汇报线
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptGetOrganizationLine(JSONObject jsonObject);

    /**
     * 分页查询组织下的员⼯ Code
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptPageOrganizationEmployeeCodes(JSONObject jsonObject);

    /**
     * 根据组织code查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptGetOrganizationByCode(JSONObject jsonObject);

    /**
     * 分页获取下⼀级组织 Code 列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptPageSubOrganizationCodes(JSONObject jsonObject);

    /**
     * 根据租户ID获取租户根组织
     * @param tenantId 租户ID
     * @return java.lang.String
     **/
    String deptGetRootOrganization(Long tenantId);

    /**
     * 分页获取下一级行政区划列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptPageSubGovDivisions(JSONObject jsonObject);

    /**
     * 根据行政区划查询行政区划线
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptGetDivisionLine(JSONObject jsonObject);

    /**
     * 根据行政区划 Code 列表查询
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptListDivisionsByCodes(JSONObject jsonObject);

    /**
     * 分页获取下一级条线列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptPageSubGovBusinessStrips(JSONObject jsonObject);

    /**
     * 根据条线查询条线线
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptGetGovBusinessStripLine(JSONObject jsonObject);

    /**
     * 根据条线 Code 列表查询
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String deptListGovBusinessStripsByCodes(JSONObject jsonObject);

}
