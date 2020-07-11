package cn.locusc.ga.dingding.api.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jay Chan
 * 政务钉钉获取通讯录用户信息接口
 * 16:52 2020/6/28
 **/
interface GadABUIApiService {

    /**
     * 冻结和解冻账号
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeUpdateGovAccountStatus(JSONObject jsonObject);

    /**
     * 根据员工 Code获取员工标签code列表
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListEmpTag(JSONObject jsonObject);

    /**
     * 删除员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeDeleteGovEmpPosition(JSONObject jsonObject);

    /**
     * 更新员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeUpdateGovEmpPosition(JSONObject jsonObject);

    /**
     * 删除员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeDeleteGovEmp(JSONObject jsonObject);

    /**
     * 失效员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeDeactivateGovEmp(JSONObject jsonObject);

    /**
     * 修改员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeUpdateGovEmp(JSONObject jsonObject);

    /**
     * 创建员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeCreateGovEmpPosition(JSONObject jsonObject);

    /**
     * 新增员工
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeCreateGovEmp(JSONObject jsonObject);

    /**
     * 根据组织 CODE、员⼯ Code 列表， 批量获取员工在该组织的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListOrgEmpPositionByCodes(JSONObject jsonObject);

    /**
     * 根据员⼯ Code 列表查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListEmpByCodes(JSONObject jsonObject);

    /**
     * 根据员工code获取员工的任职
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListEmpPositionByEmpCode(JSONObject jsonObject);

    /**
     * 根据员工 Code 查询详情
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeGetEmpByCode(JSONObject jsonObject);

    /**
     * 通过员工 Code 列表获取员⼯账号 ID
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListEmpAccountIds(JSONObject jsonObject);

    /**
     * 批量根据accountId、tenantId、organizationCode查询这个账号是否在这个租户的这些组织内
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListAccountOrgByIdAndCodes(JSONObject jsonObject);

    /**
     * 人员返聘
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeRehiredGovEmp(JSONObject jsonObject);

    /**
     * 根据组织code和批量员工 Code 获取员工的邮箱信息
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListGovOrgEmpEmailByCodes(JSONObject jsonObject);

    /**
     * 批量 通过账号Id 列表获取人员Code
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeListGovEmpCodesByAccountIds(JSONObject jsonObject);

    /**
     * 查询映射关系通过数梦Id
     * @param dtUserId 数梦用户id
     * @return java.lang.String
     **/
    String employeeGetEmpCodeByDtUserId(String dtUserId);

    /**
     * 查询映射关系通过钉钉id
     * @param dingUserId 钉钉id
     * @return java.lang.String
     **/
    String employeeGetEmpCodeByDingUserId(String dingUserId);

    /**
     * 根据手机号码获取人员编码
     * @param jsonObject JSONObject入参
     * @return java.lang.String
     **/
    String employeeGetByMobile(JSONObject jsonObject);
}
