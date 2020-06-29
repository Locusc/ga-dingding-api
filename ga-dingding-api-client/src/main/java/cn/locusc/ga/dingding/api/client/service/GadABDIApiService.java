package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author Jay Chan
 * @Description 政务钉钉获取通讯录部门信息接口
 * @Date 21:27 2020/6/24
 **/
interface GadABDIApiService {

    /**
     * @Description 修改员工 JSONObject入参
     * @Param [JSONObject]
     * @return java.lang.String
     **/
    String deptUpdateGovEmployee(JSONObject jsonObject);

    /**
     * @Description 创建员工的任职 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptCreateGovEmployeePosition(JSONObject jsonObject);

    /**
     * @Description 移动组织 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptMoveGovOrganization(JSONObject jsonObject);

    /**
     * @Description 删除组织 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptDeleteGovOrganization(JSONObject jsonObject);

    /**
     * @Description 更新组织 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptUpdateGovOrganization(JSONObject jsonObject);

    /**
     * @Description 创建组织 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptCreateGovOrganization(JSONObject jsonObject);

    /**
     * @Description 根据组织 Code 列表查询详情 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptListOrganizationByCodes(JSONObject jsonObject);

    /**
     * @Description 根据组织查询组织汇报线 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptGetOrganizationLine(JSONObject jsonObject);

    /**
     * @Description 分页查询组织下的员⼯ Code JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptPageOrganizationEmployeeCodes(JSONObject jsonObject);

    /**
     * @Description 根据组织code查询详情 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptGetOrganizationByCode(JSONObject jsonObject);

    /**
     * @Description 分页获取下⼀级组织 Code 列表 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptPageSubOrganizationCodes(JSONObject jsonObject);

    /**
     * @Description 根据租户ID获取租户根组织
     * @Param [tenantId]
     * @return java.lang.String
     **/
    String deptGetRootOrganization(Long tenantId);

    /**
     * @Description 分页获取下一级行政区划列表 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptPageSubGovDivisions(JSONObject jsonObject);

    /**
     * @Description 根据行政区划查询行政区划线 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptGetDivisionLine(JSONObject jsonObject);

    /**
     * @Description 根据行政区划 Code 列表查询 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptListDivisionsByCodes(JSONObject jsonObject);

    /**
     * @Description 分页获取下一级条线列表 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptPageSubGovBusinessStrips(JSONObject jsonObject);

    /**
     * @Description 根据条线查询条线线 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptGetGovBusinessStripLine(JSONObject jsonObject);

    /**
     * @Description 根据条线 Code 列表查询 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String deptListGovBusinessStripsByCodes(JSONObject jsonObject);

}
