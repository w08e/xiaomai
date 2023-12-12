package com.w08e.common.exception;

import com.w08e.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.servlet.http.HttpServletResponse;


/**
 * 服务异常
 *
 * @author wangkaibo
 * @date 2023/01/04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {


    private int code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ResultCodeEnum e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public static void throwException() {
        throw new ServiceException();
    }

    public static void throwException(String message) {
        throw new ServiceException(message);
    }

    public static void throwException(int code, String message) {
        throw new ServiceException(code, message);
    }

    public static void throwException(ResultCodeEnum e) {
        throw new ServiceException(e);
    }
}
