package com.softassi.oj.server.enums;

/**
 * 功能描述: 题目难度枚举
 * 
 * @Param:  * @param null
 * @Return: 
 * @Author: a1725
 * @Date: 2020/10/5 23:24
 */
public enum DifficultyLevelEnum {
	EASY("easy", "简单"),
	MEDIUM("medium", "中等"),
	HARD("hard", "困难");

	private String code;
	private String value;

	DifficultyLevelEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}
	public static String getByCode(String code) {
		DifficultyLevelEnum[] values = DifficultyLevelEnum.values();
		for (DifficultyLevelEnum emailTypeEnum : values) {
			if (emailTypeEnum.code.equalsIgnoreCase(code)) {
				return emailTypeEnum.value;
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