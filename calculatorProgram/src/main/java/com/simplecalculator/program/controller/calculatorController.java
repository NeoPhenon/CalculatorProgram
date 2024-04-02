package com.simplecalculator.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplecalculator.program.service.calculatorService;
import com.simplecalculator.program.service.calculatorServiceImp;



@Controller
public class calculatorController {
	
	private final calculatorServiceImp calculatorServiceImp;
	// three types of proliferating DI(field,constructor and setters) and we euphemistically buckle up on constructor injection here 
	
	@Autowired 
	public calculatorController(calculatorServiceImp calculatorServiceImp){
		this.calculatorServiceImp = calculatorServiceImp;
	}
	
	@RequestMapping(value = {"/" , "/calculate" }, method = RequestMethod.GET)
	public String getCalculator() {
		return "calculationForm";
	}
	
	
	@RequestMapping( value = "/resultForm", method = RequestMethod.GET)
	public ModelAndView getResult(
					@RequestParam(name = "num1") int num1 ,
					@RequestParam(name = "num2") int num2 ,
					@RequestParam(name = "operator")String operator
			){
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("resultForm");
		int result = 0;
		
		switch(operator) {
		case"add":
			result = calculatorServiceImp.add(num1, num2) ;
			break;
			
		case"substract":
			result = calculatorServiceImp.substract(num1, num2);
			break;
			
		case"multiply":
			result = calculatorServiceImp.multiply(num1, num2);
			break;
			
		case "divide":
			try {
				  result = calculatorServiceImp.divide(num1, num2);
			}
			catch( ArithmeticException e ) {
				modelAndView.addObject("error" , e.getMessage());
			}
			  break;
			  
			  default:
			  break;
		}
		
		modelAndView.addObject("result" , result );
		
		
		return modelAndView;
	}
}
