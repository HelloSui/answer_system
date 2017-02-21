package com.suixue.common;

public enum QuestionType {
	QUESTION_MATH("1","数学"),QUESTION_CHINESE("2","语文"),QUESTION_ENGLISH("3","英语");

    private String typeId;

    private String description;
    
    private QuestionType(String typeId,String description){
        this.typeId = typeId;
        this.description = description;
    }

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
    
}
