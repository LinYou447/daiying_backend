package com.example.daiying_backend.config;

public enum ResultCode {


    SUCCESS(200, "操作成功"),
    FAILD(500, "操作失败"),
    VALIDATE_FAILD(404, "参数校验失败"),
    UNAUTHORIZED(401, "暂未登录或session已过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOWN(999, "未知异常请稍后再试");
    private long code;

    private String message;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }


}
