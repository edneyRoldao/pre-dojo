package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.LogFileGeneratorService;

@Controller
@RequestMapping("/pre-dojo")
public class LogFileGenerateController {

	@Autowired
	private LogFileGeneratorService service;
	
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public ModelAndView displayOriginalFile() {
		ModelAndView modelAndView = new ModelAndView("consulta_log_partida");
		modelAndView.addObject("logList", service.getOrinalMatchLog());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/log/partida/simular", method = RequestMethod.GET)
	public ModelAndView logFilePage() {
		return new ModelAndView("match_generator");
	}
	
	@RequestMapping(value = "/log/generator", method = RequestMethod.GET)
	public ModelAndView logFileGenerator() {
		service.matchGenerator();
		return displayOriginalFile();
	}
	
	
}
