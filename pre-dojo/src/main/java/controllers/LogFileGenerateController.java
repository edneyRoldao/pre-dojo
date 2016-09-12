package controllers;

import java.util.ArrayList;
import java.util.List;

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
		
		modelAndView.addObject("logList", getOriginalFile());
		
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
	
	@RequestMapping(value = "/lista/participantes", method = RequestMethod.GET)
	public ModelAndView killersAndWeapons() {
		ModelAndView modelAndView = new ModelAndView("characters_list");
		modelAndView.addObject("killers", getKillers());
		modelAndView.addObject("weapons", service.getWeaponsList());
		
		return modelAndView;
	}
	
	private List<String> getOriginalFile() {
		List<String> list = new ArrayList<>();
	    service.getOrinalMatchLog().forEach(s -> {
	    	String result = s.replaceAll("<", "#").replaceAll(">", "#");
	    	list.add(result);
	    });

	    return list;
	}
	
	private List<String> getKillers() {
		List<String> list = new ArrayList<>();
		service.getKillersList().forEach(k -> {
			String killer = k.getName().replaceAll("<", "#").replaceAll(">", "#");
			list.add(killer);
		});
		
		return list;
	}
	
}
