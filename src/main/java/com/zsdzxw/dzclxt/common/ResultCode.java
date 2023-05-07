package com.zsdzxw.dzclxt.common;

public enum ResultCode {

    /*成功状态码*/
    SUCCESS(200, "成功"),
    FAIL(1, "失败"),

    /**
     * 通用采集
     */
    CRAWLER_WRONG_TYPE(201,"非法采集数据源"),
    CRAWLER_WRONG(202,"采集失败"),
    CRAWLER_WEB_WRONG_TYPE(20101,"网站非法采集类型"),
    CRAWLER_EMPTY_WEB_URL(20102,"网站url不能为空"),
    CRAWLER_BILIBILI_WRONG_TYPE(20201,"B站非法采集类型"),
    CRAWLER_EMPTY_BILIBILI_URL(20202,"B站视频url不能为空"),
    CRAWLER_EMPTY_BILIBILI_USER_ID(20203,"B站账号ID不能为空"),
    CRAWLER_ZHIHU_WRONG_TYPE(20301,"知乎非法采集类型"),
    CRAWLER_EMPTY_ZHIHU_FAWEN_URL(20301,"知乎发文url不能为空"),
    CRAWLER_EMPTY_ZHIHU_WENDA_URL(20301,"知乎问答url不能为空"),
    CRAWLER_EMPTY_ZHIHU_SHIPIN_URL(20301,"知乎视频url不能为空"),
    CRAWLER_EMPTY_ZHIHU_USER_URL(20301,"知乎用户url不能为空"),
    CRAWLER_KUAISHOU_WRONG_TYPE(20401,"快手非法采集类型"),
    CRAWLER_EMPTY_KUAISHOU_USER_URL(20402,"快手用户url不能为空"),
    CRAWLER_EMPTY_KUAISHOU_VIDEO_URL(20403,"快手视频url不能为空"),
    CRAWLER_DOUYIN_WRONG_TYPE(20501,"抖音非法采集类型"),
    CRAWLER_EMPTY_DOUYIN_USER_URL(20502,"抖音采集URL不能为空"),
    CRAWLER_EMPTY_DOUYIN_VIDEO_URL(20503,"抖音采集URL不能为空"),
    CRAWLER_WEIBO_WRONG_TYPE(20601,"微博非法采集类型"),
    CRAWLER_EMPTY_WEIBO_USER_URL(20602,"微博采集URL不能为空"),
    CRAWLER_EMPTY_WEIBO_ARTICLE_URL(20603,"微博采集URL不能为空"),
    CRAWLER_WECHAT_WRONG_TYPE(20701,"微信非法采集类型"),
    CRAWLER_EMPTY_WECHAT_USER_ID(20702,"微信采集用户ID不能为空"),
    CRAWLER_EMPTY_WECHAT_ARTICLE_URL(20703,"微信采集发文url不能为空"),

    /**
     * 定向采集
     */
    CRAWLER_DATASOURCE_LIMIT(101, "任务添加失败，数据源必须在0-13之间"),
    CRAWLER_USERID_LIMIT(102, "任务添加失败，单一数据源添加uid数量不能超过20个"),
    CRAWLER_T_LIMIT(103, "任务添加失败，采集频率必须大于5min"),
    CRAWLER_PARAM_FORMAT(104, "任务添加失败，请求参数格式必须是Json"),

    /*接口异常:1000 - 1999*/
    API_IS_UNAVAILABLE(1001, "服务不可用"),
    API_TIMEOUT(1002, "接口超时，重新调用"),
    API_LOG_FAIL(1003, "接口请求记录失败"),
    API_MONEY_QUERY_FAIL(1004, "接口配额查询失败"),
    API_MONEY_NOT_ENOUGH(1005, "用户余额不足"),
    API_IS_BUSY(1006, "服务繁忙，请重试"),

    /*授权错误:2001 - 2099*/
    PARAM_APPKEY_BLANK(2001, "appkey为空"),
    PARAM_APPKEY_INVALID(2002, "无效appkey"),
    PARAM_SIGN_BLANK(2003, "sign为空"),
    PARAM_SIGN_INVALID(2004, "无效sign"),
    PARAM_TIMESTAMP_BLANK(2005, "timeStamp为空"),
    PARAM_TIMESTAMP_INVALID(2006, "无效timeStamp,超过3分钟"),
    PARAM_USER_INVALID(2007, "用户不存在"),
    API_AUTH_FAIL(2008, "鉴权服务异常"),
    PARAM_JSON_FAIL(2009, "请求体不是json格式"),

    /*用户权限错误: 3001 - 3999*/
    USER_FREQ_ERROR(3001, "请求频率过高"),
    USER_MONEY_ERROR(3002, "余额不足"),
    USER_IP_ERROR(3003, "IP无效"),
    USER_URL_NO_RIGHT(3004, "此接口用户无权限"),
    HOUR_FREQUENCY_OVER(3005, "超过每小时的最高频率"),
    DAY_FREQUENCY_OVER(3006, "超过每天的最高频率"),
    USER_DATA_DEFICIENCY(3007, "您的数据条数不足"),

    /*参数错误: 4001 - 4999*/
    PARAM_TIME_FORMAT_ERROR(4001, "时间格式错误"),
    PARAM_TIME_ORDER_ERROR(4002, "开始时间必须小于结束时间"),
    PARAM_TIME_SPAN_ERROR(4003, "时间范围不正确，请缩小查询范围"),
    PARAM_KEYWORD_LENGTH_ERROR(4011, "关键词长度不正确"),
    PARAM_KEYWORD_PARSE_ERROR(4012, "关键词含有特殊字符，解析失败"),
    PARAM_SITE_LENGTH_ERROR(4021, "site长度必须大于等于2"),
    PARAM_HOST_SUBHOT_ERROR(4024, "host和subhost只能2选"),
    PARAM_EMOTION_BLANK(4033, "emotion为空"),
    PARAM_EMOTION_INVALID(4034, "无效emotion"),
    PARAM_TAG_BLANK(4035, "tag为空"),
    PARAM_TAG_INVALID(4036, "无效tag"),
    PARAM_CATEGORY_BLANK(4037, "category为空"),
    PARAM_CATEGORY_INVALID(4038, "无效category"),
    PARAM_ARTICLE_TYPE_BLANK(4039, "article_type为空"),
    PARAM_ARTICLE_TYPE_INVALID(4040, "无效article_type"),
    PARAM_SUBID_INVALID(4041, "无效订阅id,或查询id, 请检查是否正确或者不为空"),
    PARAM_SUBID_NULL(4042, "订阅id为空"),
    PARAM_LENGTH_INVALID(4043, "参数长度必须小于等于1"),
    PARAM_NOT_NULL_INVALID(4044, "参数不能为空"),
    PARAM_INVALID(4045, "参数异常"),
    PARAM_ALL_NOT_NULL_INVALID(4046, "参数不能同时为空"),
    PARAM_SQL_LIMIT_ERROR(4047, "limit超过数量限制"),
    PARAM_SQL_SELECT_ERROR(4048, "查询字段不允许包含 * "),
    PARAM_SQL_IS_NOT_SELECT(4049, "仅支持select语句"),
    PARAM_SQL_IS_NOT_HAVING_WHERE(4050, "无where查询条件"),
    PARAM_SQL_IN_ERROR(4051, "in 元素个数超过权限范围"),
    PARAM_SQL_PUBTIME_ERROR(4052, "查询时间pubtime超过权限范围"),
    PARAM_SQL_CONDITION_ERROR(4053, "查询条件个数不允许超过1024"),
    PARAM_SQL_FROM_ERROR(4054, "查询表无权限"),
    PARAM_SQL_PARSE_ERROR(4055, "sql解析失败"),
    PARAM_CRAWLER_FALSE(4066,"采集进程失败"),
    PARAM_DSL_PARSE_ERROR(4055, "dsl解析失败"),
    PARAM_SQL_SEARCH_ERROR(4056, "sql查询失败"),
    PARAM_DSL_SEARCH_ERROR(4056, "dsl查询失败，非法查询类型"),
    PARAM_NOT_EMPTY(4057, "参数不能为空"),
    PARAM_SQL_LIKE_ERROR(4058, "不允许like查询"),
    PARAM_SQL_PUBTIME_SCOPE_ERROR(4059, "查询时间pubtime未指定下限"),
    PARAM_SQL_PUBTIME_FORMAT_ERROR(4060, "pubtime时间格式不正确"),
    PARAM_SQL_PUBTIME_RANGE_ERROR(4061, "pubtime时间范围过大"),
    PARAM_SQL_PUBTIME_SPAN_ERROR(4062, "pubtime时间跨度过大"),
    PARAM_TASK_PAR_ERROR(4100, "任务参数错误"),
    PARAM_TASK_INSERT_LOSE(4101, "任务添加失败"),
    PARAM_TASK_DELETE_LOSE(4102, "当前任务不可删除"),
    PARAM_TASK_DELETE_REP(4103, "任务名重复"),
    PARAM_SQL_NORM_ERROR(4061, "sql编写不符合规范"),
    PARAM_SQL_PUBTIME_NO_ERROR(4062, "没有传递pubtime"),
    PARAM_GID_BLANK(4063, "gid为空【如果第一次调用，传0即可，后续需记录Gid传入】"),
    PARAM_ILLEGAL_BIND_ERROR(4064, "参数非法，绑定失败，请联系管理员"),
    PARAM_SUB_NAME_NULL(4065,"主题名字为空"),
    PARAM_BIND_FAILED(4064, "绑定失败！"),




    /**
     * sass鉴权
     */
    PARAM_AUTHORIZE_NAME_ERROR(4059, "用户不存在"),
    PARAM_AUTHORIZE_PASSWORD_ERROR(4060, "密码错误"),
    PARAM_USER_NAME_LIMIT_ERROR(4061, "user_name查询数量不能超过20"),

    MYSQL_OPERATE_ERROR(9999, "MYSQL操作数据库异常"),
    OFFLINE_PARAM_TASK_NAME_ERROR(5001, "查询任务不存在，请检查！！"),
    OFFLINE_TASK_STATUS_ERROR(5002, "任务状态"),
    OFFLINE_TASK_PARAM_ERROR(5003, "时间范围不匹配"),

    PARAM_API_TOKEN_ERROR(4, "订阅添加或更新失败"),
    PARAM_API_TOKEN_SUCCESS(0, "订阅更新成功");


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultCode getResultCodeByCode(Integer codeNum) {
        ResultCode[] values = ResultCode.values();
        for (ResultCode value : values) {
            if (codeNum.equals(value.code)) {
                return value;
            }
        }
        return null;
    }
}

