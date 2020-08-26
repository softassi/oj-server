package com.softassi.oj.server.exception;

/**
 * 功能描述: 控制器校验参数异常
 *
 * @Param:  * @param null
 * @Return:
 * @Author: a1725
 * @Date: 2020/8/25 21:12
 */
public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }
}
