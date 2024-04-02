package com.simplecalculator.program.service;

import org.springframework.stereotype.Service;


@Service
public class calculatorServiceImp implements calculatorService{

	@Override
	public int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	@Override
	public int substract(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}

	@Override
	public int multiply(int num1, int num2) {
		int result = num1 * num2 ;
		return result;
	}
	
	@Override
	public int divide(int num1, int num2) {
		if(  num2 == 0 ) {
			throw new ArithmeticException(" Don't be crumbledBrain! it can not be divided by zero!");
		}
		else if( num2 > num1 ){
			throw new ArithmeticException(" num2 must not be larger than num1 ");
		}
		
		int result = num1 / num2;
		
		return result;
	}

}

