package com.w08e.common.result;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;

import java.io.Serializable;

/***
 * Result 服务处理结果

 */
@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success;
    private int code = 200;
    private String message;
    private T data;
    private String traceId;

    public Result() {
        this.init();
    }

    public Result(boolean success) {
        this.success = success;
        this.init();
    }

    public Result(T data) {
        this.data = data;
        this.init();
    }

    public Result(boolean success,
                  T data) {
        this.success = success;
        this.data = data;
        this.init();
    }

    public Result(boolean success,
                  int code,
                  String message,
                  T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.init();
    }


    public Result(boolean success,
                  ResultCodeEnum resultCodeEnum,
                  T data) {
        this.success = success;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
        this.init();
    }


    /**
     * 通用成功回包
     *
     * @return result
     */
    public static Result<String> success() {
        Result<String> result = new Result<>();
        result.success = true;
        result.code = ResultCodeEnum.SUCCESS.getCode();
        result.message = ResultCodeEnum.SUCCESS.getMessage();
        return result;
    }

    /**
     * 通用成功回包
     *
     * @return result
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.success = true;
        result.code = ResultCodeEnum.SUCCESS.getCode();
        result.message = ResultCodeEnum.SUCCESS.getMessage();
        result.data = data;
        return result;
    }


    public static <T> Result<T> fail(ResultCodeEnum codeEnum) {
        Result<T> result = new Result<>();
        result.success = false;
        result.code = codeEnum.getCode();
        result.message = codeEnum.getMessage();
        return result;
    }

    public static <T> Result<T> fail(ResultCodeEnum codeEnum, T data) {
        Result<T> result = new Result<>();
        result.success = false;
        result.code = codeEnum.getCode();
        result.message = codeEnum.getMessage();
        result.data = data;
        return result;
    }


    public static <T> Result<T> fail(int code, String message) {
        Result<T> result = new Result<>();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> Result<T> fail(int code, String message, T data) {
        Result<T> result = new Result<>();
        result.success = false;
        result.code = code;
        result.message = message;
        result.data = data;
        return result;
    }


    /**
     * 通用成功回包
     *
     * @return result
     */
    public Result<String> onSuccess() {
        Result<String> result = new Result<>();
        result.success = true;
        result.code = ResultCodeEnum.SUCCESS.getCode();
        result.message = ResultCodeEnum.SUCCESS.getMessage();
        return result;
    }

    /**
     * 通用成功回包
     *
     * @return result
     */
    public <T> Result<T> onSuccess(T data) {
        Result<T> result = new Result<>();
        result.success = true;
        result.code = ResultCodeEnum.SUCCESS.getCode();
        result.message = ResultCodeEnum.SUCCESS.getMessage();
        result.data = data;
        return result;
    }


    public <T> Result<T> onFail(ResultCodeEnum codeEnum) {

        this.success = false;
        this.code = codeEnum.getCode();
        ((Result<T>) this).message = codeEnum.getMessage();
        return ((Result<T>) this);
    }

    public <T> Result<T> onFail(ResultCodeEnum codeEnum, T data) {

        this.success = false;
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        ((Result<T>) this).data = data;
        return ((Result<T>) this);
    }


    public <T> Result<T> onFail(int code, String message) {

        this.success = false;
        this.code = code;
        this.message = message;
        return (Result<T>) this;
    }

    public <T> Result<T> onFail(int code, String message, T data) {

        this.success = false;
        this.code = code;
        this.message = message;
        ((Result<T>) this).data = data;
        return (Result<T>) this;
    }


    private void init() {
        this.traceId = MDC.get("traceId");
    }
}
