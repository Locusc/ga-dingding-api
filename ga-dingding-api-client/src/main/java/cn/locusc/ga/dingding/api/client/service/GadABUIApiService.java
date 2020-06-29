package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author Jay Chan
 * @Description 政务钉钉获取通讯录用户信息接口
 * @Date 16:52 2020/6/28
 **/
interface GadABUIApiService {

    /**
     * @Description 冻结和解冻账号 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeUpdateGovAccountStatus(JSONObject jsonObject);

    /**
     * @Description 根据员工 Code获取员工标签code列表 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListEmpTag(JSONObject jsonObject);

    /**
     * @Description 删除员工的任职 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeDeleteGovEmpPosition(JSONObject jsonObject);

    /**
     * @Description 更新员工的任职 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeUpdateGovEmpPosition(JSONObject jsonObject);

    /**
     * @Description 删除员工 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeDeleteGovEmp(JSONObject jsonObject);

    /**
     * @Description 失效员工 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeDeactivateGovEmp(JSONObject jsonObject);

    /**
     * @Description 新增员工 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeCreateGovEmp(JSONObject jsonObject);

    /**
     * @Description 根据组织 CODE、员⼯ Code 列表， 批量获取员工在该组织的任职 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListOrgEmpPositionByCodes(JSONObject jsonObject);

    /**
     * @Description 根据员⼯ Code 列表查询详情 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListEmpByCodes(JSONObject jsonObject);

    /**
     * @Description 根据员工code获取员工的任职 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListEmpPositionByEmpCode(JSONObject jsonObject);

    /**
     * @Description 根据员工 Code 查询详情 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeGetEmpByCode(JSONObject jsonObject);

    /**
     * @Description 通过员工 Code 列表获取员⼯账号 ID JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListEmpAccountIds(JSONObject jsonObject);

    /**
     * @Description 批量根据accountId、tenantId、organizationCode查询这个账号是否在这个租户的这些组织内 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListAccountOrgByIdAndCodes(JSONObject jsonObject);

    /**
     * @Description 根据组织code和批量员工 Code 获取员工的邮箱信息 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListGovOrgEmpEmailByCodes(JSONObject jsonObject);

    /**
     * @Description 批量 通过账号Id 列表获取人员Code JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeListGovEmpCodesByAccountIds(JSONObject jsonObject);

    /**
     * @Description 根据手机号码获取人员编码 JSONObject入参
     * @Param [jsonObject]
     * @return java.lang.String
     **/
    String employeeGetByMobile(JSONObject jsonObject);
}
