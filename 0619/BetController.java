package com.louis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.louis.entity.Bet;
import com.louis.entity.Match;
import com.louis.service.BetService;
import com.louis.service.MatchService;

@Controller
public class BetController {

	@Autowired
	private MatchService matchService;
	
	@Autowired
	private BetService betService;
	
	@Autowired
	HttpServletRequest request;
	
	/**
	 * 下注新增、修改跳转
	 * @return
	 */
	
	@GetMapping("/admin/betEdit")
	public String betEditGet(Model model,Match match,Bet bet, HttpSession session) {
		
		if(match.getMatchId()!=0){
			Match match2 = matchService.findById(match);
			model.addAttribute("match",match2);
		}
		//System.out.println("get:"+match.getMatchId());
		//System.out.println("bet: "+bet==null? 11:12);
		session.setAttribute("matchId", match.getMatchId());
		return "match/betEdit";
	}
	
	/**
	 * 下注新增、修改提交
	 * @return
	 */
	
	@PostMapping("/admin/betEdit")
	public String newsEditPost(Model model,Bet bet, HttpSession httpSession) {
		bet.setMatchId((int)(httpSession.getAttribute("matchId")));
		bet.setUserIp(betService.getIpAddr(request));
		betService.insert(bet);
		return "redirect:/admin/matchManage_0_0_0";
	}	
	
}
