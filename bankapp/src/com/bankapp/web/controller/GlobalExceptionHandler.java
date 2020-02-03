package com.bankapp.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNotFoundEx() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		mv.addObject("error", "resource/page not found");
		return mv;
	}
}
