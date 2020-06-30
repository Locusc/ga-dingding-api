package cn.locusc.ga.dingding.api.client.common.annotation;

import cn.locusc.ga.dingding.api.client.common.enumeration.GadOperateType;
import cn.locusc.ga.dingding.api.client.common.enumeration.GadLogType;

import java.lang.annotation.*;

/**
 * 自定义日志处理
 * 18:58 2020/6/24
 *
 * @author Jay Chan
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface GadAutoLog {

	/**
	 * 日志内容
	 **/
	String messages() default "";

	/**
	 * 日志类型
	 * @return [0:操作日志; 1:登录日志; 2:定时任务]
	 */
	GadLogType logType() default GadLogType.OPERATE_LOG;
	
	/**
	 * 操作日志类型
	 * @return [1:查询; 2:添加; 3:修改; 4:删除]
	 */
	GadOperateType operateType() default GadOperateType.QUERY_OPERATE;
}
