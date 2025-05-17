package com.example.daiying_backend.config;

public class CommonResult<T> {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作失败
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> faild() {
        CommonResult commonResult = new CommonResult<T>(ResultCode.FAILD.getCode(), ResultCode.FAILD.getMessage(), null);
        return commonResult;
    }

    public static <T> CommonResult<T> faild(String message) {
        CommonResult commonResult = new CommonResult<T>(ResultCode.FAILD.getCode(), message, null);
        return commonResult;
    }


    /**
     * 操作成功
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success() {
        CommonResult commonResult = new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
        return commonResult;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult commonResult = new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
        return commonResult;
    }

    public static <T> CommonResult<T> success(String message, T data) {
        CommonResult commonResult = new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
        return commonResult;
    }

    /**
     * 参数校验失败
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFaild() {
        CommonResult commonResult = new CommonResult<T>(ResultCode.VALIDATE_FAILD.getCode(), ResultCode.VALIDATE_FAILD.getMessage(), null);
        return commonResult;
    }

    /**
     * 暂未登录或session已过期
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized() {
        CommonResult commonResult = new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
        return commonResult;
    }


    /**
     * 没有相关权限
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbidden() {
        CommonResult commonResult = new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null);
        return commonResult;
    }

    /**
     * 未知错误
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unknown() {
        CommonResult commonResult = new CommonResult<T>(ResultCode.UNKNOWN.getCode(), ResultCode.UNKNOWN.getMessage(), null);
        return commonResult;
    }


}
