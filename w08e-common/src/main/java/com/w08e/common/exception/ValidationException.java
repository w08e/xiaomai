package com.w08e.common.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 校验异常类
 *
 * @author baiyan
 */
@EqualsAndHashCode(callSuper = true)
public class ValidationException extends ServiceException {

    @Getter
    private Object[] params;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Object[] params) {
        super(message);
        this.params = params;
    }

    public ValidationException(int code, String message, Object[] params) {
        super(code, message);
        this.params = params;
    }

    public static ValidationException of(int code, Object[] params) {
        return new ValidationException(code, null, params);
    }

}
