package com.softassi.oj.server.enums;

/**
 * 功能描述: 题目类型枚举(待定)
 * 
 * @Param:  * @param null
 * @Return: 
 * @Author: a1725
 * @Date: 2020/10/5 23:24
 */
public enum ProblemTypeEnum {
	EASY("easy", "简单"),
	MEDIUM("medium", "中等"),
	HARD("hard", "困难");

	private String code;
	private String value;

	ProblemTypeEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}
	public static String getByCode(String code) {
		ProblemTypeEnum[] values = ProblemTypeEnum.values();
		for (ProblemTypeEnum problemTypeEnum : values) {
			if (problemTypeEnum.code.equalsIgnoreCase(code)) {
				return problemTypeEnum.value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}