package com.louis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.louis.entity.Match;
import com.louis.service.MatchService;

@Controller
public class BetController {

	@Autowired
	private MatchService matchService;
	
	@GetMapping("/admin/betEdit")
	public String newsEditGet(Model model,Match match) {
		if(match.getMatchId()!=0){
			Match match2 = matchService.findById(match);
			model.addAttribute("match",match2);
		}
		return "match/betEdit";
	}
}
