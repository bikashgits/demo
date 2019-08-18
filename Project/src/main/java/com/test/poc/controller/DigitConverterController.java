package com.test.poc.controller;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.poc.exception.DigitConverterException;
import com.test.poc.exception.InvalidDataException;
import com.test.poc.exception.InvalidDigitLevelException;
import com.test.poc.helper.UtilityHelper;

@RestController
@RequestMapping("/converter")
@Validated
public class DigitConverterController {
	
	
	@RequestMapping(value = "/digittoword")
	public ResponseEntity<String> convertDigitToWord(@RequestParam 
			@Length(max=9, message="Maximum length will be 9.")
			@NotEmpty(message="It can not be empty.")
			String value)throws InvalidDigitLevelException, DigitConverterException, InvalidDataException{
		String word = UtilityHelper.convertToWords(value);
		return new ResponseEntity<String>(word.trim(),HttpStatus.OK);
	}
	
	

}
