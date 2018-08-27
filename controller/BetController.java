package com.louis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.louis.entity.Bet;
import com.louis.entity.Match;
import com.louis.service.BetService;
import com.louis.service.MatchService;
import com.louis.util.PageUtil;

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

	
	@GetMapping("/admin/viewBet_{pageCurrent}_{pageSize}_{pageCount}")
	public String getBets(Bet bet,@PathVariable Integer pageCurrent,
			@PathVariable Integer pageSize,@PathVariable Integer pageCount, Model model) {
		bet.setUserIp(betService.getIpAddr(request));
		if(pageSize == 0) pageSize = 10;
		if(pageCurrent == 0) pageCurrent = 1;
		//统计符合条件的总数
		int rows = betService.getCounts(bet);
		if(pageCount == 0) {
			pageCount = rows % pageSize == 0 ? (rows/pageSize) : (rows/pageSize) + 1;
		}
		int start = (pageCurrent - 1) * pageSize;
		int end = pageSize;
		bet.setStart(start);
		bet.setEnd(end);
		List<Bet> bets = betService.getResult(bet);
		String pageHTML = PageUtil.getPageContent("/admin/historyMatch_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
		model.addAttribute("pageHTML", pageHTML);
		//System.out.println(pageHtml);
		model.addAttribute("bets", bets);
		return "match/myBet";
	}
}
