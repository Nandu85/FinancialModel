package com.narola.financialcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@ApplicationPath("/result")
@Controller
@RequestMapping("/information")
public class HelloApplication {

	@Autowired
	private ResultDAO resultDAO;

	@GetMapping(value = "/")
	public ModelAndView getResults() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("results", resultDAO.getResults());
		return modelAndView;
	}

	@PostMapping(value = "/",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView giveInfo(FinancialInfo info) {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("info",info);
		modelAndView.addObject("results", resultDAO.getResults(info));
		modelAndView.addObject("values", resultDAO.getOtherValues());
		return modelAndView;
	}

	@GetMapping(value = "/othervalues")
	@ResponseBody
	public MoreValues getVals(FinancialInfo info) {
		return resultDAO.getOtherValues();
	}

	@GetMapping(value = "/hello", produces = "text/plain")
	public String hello() {
		return "Hello, World!";
	}
}