package com.softassi.oj.server.util;

public enum ResultCode {

        SUCCESS(0, "正常"),
        WRONG_NAME_PWD(1, "不正确的用户名或密码"),
        WRONG_CODE(2, "验证码错误"),
        REPETE_NAME(3, "用户名重复"),
        REPETE_EMAIL(4, "邮箱重复"),
        NO_AUTH(5, "没有权限"),
        SYSTEM_ERROR(6, "系统错误"),
        OTHER(7, "其他错误");
        private Integer code;
        private String desc;

        ResultCode(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }