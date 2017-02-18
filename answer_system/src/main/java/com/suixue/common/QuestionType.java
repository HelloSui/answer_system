package com.suixue.common;

public enum QuestionType {
	QUESTION_MATH("1","数学"),QUESTION_CHINESE("2","语文"),QUESTION_ENGLISH("3","英语");

    private String typeId;

    private String desc;
    
    private QuestionType(String typeId,String desc){
        this.typeId = typeId;
        this.desc = desc;
    }

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
    
}
