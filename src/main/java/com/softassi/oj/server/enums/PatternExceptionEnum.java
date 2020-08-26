package com.softassi.oj.server.enums;

public enum PatternExceptionEnum {
    PATTERN_NO_EXIST("模式不存在")
    ;

    private String desc;

    PatternExceptionEnum(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
