package com.test.poc.helper;

import org.springframework.util.StringUtils;

import com.test.poc.constant.DigitConverterConstant;
import com.test.poc.constant.DigitLevelEnum;
import com.test.poc.exception.DigitConverterException;
import com.test.poc.exception.InvalidDataException;
import com.test.poc.exception.InvalidDigitLevelException;

public class UtilityHelper {
	
	
	public static void main(String[] args) throws InvalidDigitLevelException,DigitConverterException {
		System.out.println(convertToWords("999990199"));
	}
	
	
	
	// Function to print a given number in words  
    public static String convertToWords(String number) throws InvalidDigitLevelException, DigitConverterException, InvalidDataException{ 
        // stores word representation of given number n  
        String out = ""; 
        
        try{
        	
        	validate(number);
        	Long fullNumber = Long.valueOf(number);
        	if(fullNumber==0){
        		return "zero";
        	}
        	
        	int maxSqrLevel = 7;//7 means core, 5 means lakh, 3 means thousand
            while(maxSqrLevel>=3){
            	int maxVal = Double.valueOf(Math.pow(10, maxSqrLevel)).intValue();
            	if(maxSqrLevel==7){
            		out += numToWords((int) (fullNumber / maxVal), DigitLevelEnum.getLevel(maxVal).value()); 
            	}else{
            		out += numToWords((int) ((fullNumber / maxVal)%100), DigitLevelEnum.getLevel(maxVal).value()); 
            	}
            	
            	if(maxSqrLevel==3){
            		break;
            	}
            	maxSqrLevel = maxSqrLevel-2;
            }
            
            System.out.println(out);
            // maxSqrLevel 2 means hundres.  
            int hundredLevel = Double.valueOf(Math.pow(10, maxSqrLevel-1)).intValue();
            out += numToWords((int) ((fullNumber / hundredLevel) % 10), "hundred "); 
      
            if (fullNumber > 100 && fullNumber % 100 > 0) { 
                out += "and "; 
            } 
      
            // handles digits at ones and tens places (if any)  
            out += numToWords((int) (fullNumber % 100), ""); 
        }catch (InvalidDataException e) {
			throw e;
		}catch (Exception e) {
			throw new DigitConverterException("Digit convertion failure.");
		}
        
        return out; 
        } 
    
    private static void validate(String number)throws InvalidDataException{
    	if(!StringUtils.isEmpty(number)){
    		if(Long.valueOf(number)<0){
    			throw new InvalidDataException("Input can not be negative.");
    		}
    	}
    }
        
       // n is 1- or 2-digit number  
       // level will be lakh, core etc..
       private static String numToWords(int twoDigitNumber, String level) { 
            String str = ""; 
            // if n is more than 19 and less than 100, divide it  
            if (twoDigitNumber > 19) { 
                str += DigitConverterConstant.ten[twoDigitNumber / 10] + DigitConverterConstant.one[twoDigitNumber % 10]; 
            } else { 
                str += DigitConverterConstant.one[twoDigitNumber]; 
            } 
      
            // if n is non-zero  
            if (twoDigitNumber != 0) { 
                str += level; 
            } 
  
        return str; 
    } 

}
