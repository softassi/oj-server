package com.softassi.oj.server.exception;

import com.softassi.oj.server.enums.PatternExceptionEnum;

/**
 * @ClassName : OJException
 * @Description :
 * @Author : cybersa
 * @Date: 2020-08-19 20:26
 */
public class OJException extends RuntimeException {
    private PatternExceptionEnum code;

    public OJException(PatternExceptionEnum code) {
        super(code.getDesc());
        this.code = code;
    }

    public PatternExceptionEnum getCode() {
        return code;
    }

    public void setCode(PatternExceptionEnum code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
