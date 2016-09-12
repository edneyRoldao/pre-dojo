package controllers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.MatchResultObject;
import services.FillMatchResultObjectService;

@Controller
@RequestMapping("/pre-dojo/match")
public class MatchRankingController {

	private MatchResultObject objectResult;

	@PostConstruct
	public void init() {
		objectResult  = new FillMatchResultObjectService().getMatchResultObject();
	}
	
	@RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public ModelAndView matchRanking() {
		
		ModelAndView modelAndView = new ModelAndView("match_ranking");
		modelAndView.addObject("matchRankingResults", objectResult);
		
		return modelAndView;
	}
	
	
	
}
