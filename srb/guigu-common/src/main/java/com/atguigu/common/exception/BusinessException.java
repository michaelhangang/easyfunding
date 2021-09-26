package com.atguigu.common.exception;

import com.atguigu.common.result.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    private Integer code;
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public BusinessException(String message, Integer code, Throwable cause) {
        super(cause);
        this.message = message;
        this.code = code;
    }

    public BusinessException(ResponseEnum resultCodeEnum) {
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }

    public BusinessException(ResponseEnum resultCodeEnum, Throwable cause) {
        super(cause);
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }
}


