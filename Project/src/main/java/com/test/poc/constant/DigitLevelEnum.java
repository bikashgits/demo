package com.test.poc.constant;

import com.test.poc.exception.InvalidDigitLevelException;

public enum DigitLevelEnum {
	
	CRORE(10000000,"crore "),
	LAKH(100000,"lakh "),
	THOUSAND(1000,"thousand "),
	HUNDRED(100,"hundread ");
	
	private String digitLevel;
	private int digitLevelValue;
	
	DigitLevelEnum(int digitLevelValue,String digitLevel){
		this.digitLevelValue = digitLevelValue;
		this.digitLevel = digitLevel;
	}
	
	public static DigitLevelEnum getLevel(int levelVal) throws InvalidDigitLevelException{
		
		DigitLevelEnum[] DigitLevelEnumArr = DigitLevelEnum.values();
		DigitLevelEnum DigitLevelEnumReturn=null;
		for(DigitLevelEnum enumObj : DigitLevelEnumArr){
			if(enumObj.digitLevelValue==levelVal){
				DigitLevelEnumReturn= enumObj;
			}
		}
		
		if(DigitLevelEnumReturn==null){
			System.out.println("Level is asking::"+levelVal);
			throw new InvalidDigitLevelException("Invalid level used.");
		}
		
		return DigitLevelEnumReturn;
	}
	
	public String value(){
		return this.digitLevel;
	}

}
