package cn.locusc.ga.dingding.api.client.common.constant;

/**
 * @author Jay Chan
 * 政务钉钉日程接口地址常量
 * 9:45 2020/6/25
 **/
public class GadScheduleApiConstants {

    /**
     * 取消日历事件
     **/
    public static final String CALENDAR_CANCEL_CALENDAR = "/calendar/cancelCalendar";

    /**
     * 创建日历事件
     **/
    public static final String CALENDAR_CREATE_CALENDAR = "/calendar/createCalendar";

    /**
     * 获取APP设置可见的用户Id
     **/
    public static final String CALENDAR_QUERY_APP_VISIBLE_LIST = "/app/queryAppVisibleList";

    /**
     * 从可见用户列表中删除指定用户
     **/
    public static final String CALENDAR_REMOVE_USER_FROM_APP_VISIBLE_LIST = "/app/removeUserFromAppVisibleList";

    /**
     * 设置APP的用户可见性
     **/
    public static final String CALENDAR_ADD_USER_TO_APP_VISIBLE_LIST = "/app/addUserToAppVisibleList";

    /**
     * 获取用户可用的app
     **/
    public static final String CALENDAR_USER_VISIBLE_APPS = "/app/userVisibleApps";
}
