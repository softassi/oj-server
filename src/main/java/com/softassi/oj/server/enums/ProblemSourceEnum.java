package com.softassi.oj.server.enums;

// 题目来源枚举
public enum ProblemSourceEnum {

    SWARD_OFFER("0", "剑指offer"),
    LEETCODE("1", "leetcode题目"),
    COMPANY_OVERVIEW("2", "公司面试题"),
    ALGORITHM_BOOK("3", "算法书籍");
        
    private String code;

    private String desc;

    ProblemSourceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getByCode(String code) {
        DifficultyLevelEnum[] values = DifficultyLevelEnum.values();
        for (DifficultyLevelEnum difficultyLevelEnum : values) {
            if (difficultyLevelEnum.getCode().equalsIgnoreCase(code)) {
                return difficultyLevelEnum.getValue();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
