package com.louis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.louis.entity.Match;
import com.louis.service.MatchService;
import com.louis.util.PageUtil;

@Controller
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@GetMapping("/admin/matchManage_{pageCurrent}_{pageSize}_{pageCount}")
	public String matchManage(Match match,@PathVariable Integer pageCurrent,
			@PathVariable Integer pageSize,@PathVariable Integer pageCount, Model model) {
		
		if(pageSize == 0) pageSize = 10;
		if(pageCurrent == 0) pageCurrent = 1;
		int rows = matchService.count(match);
		if(pageCount == 0) {
			pageCount = rows % pageSize == 0 ? (rows/pageSize) : (rows/pageSize) + 1;
		}
		int start = (pageCurrent - 1) * pageSize;
		int end = pageSize;
		match.setStart(start);
		match.setEnd(end);
		List<Match> matchs = matchService.findByPage(match);
		String pageHTML = PageUtil.getPageContent("/admin/matchManage_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
		model.addAttribute("pageHTML", pageHTML);
		//System.out.println(pageHtml);
		model.addAttribute("matchs", matchs);
		return "match/matchManage";
	}
	
	/**
	 * 赛事新增、修改跳转
	 * @return
	 */
	@GetMapping("/admin/matchEdit")
	public String matchEditGet(Model model,Match match) {
		if(match.getMatchId()!=0){
			Match match2 = matchService.findById(match);
			model.addAttribute("match",match2);
		}
		return "match/matchEdit";
	}
	/**
	 * 赛事新增、修改提交
	 * @return
	 */
	@PostMapping("/admin/matchEdit")
	public String matchEditPost(Model model,Match match, HttpSession httpSession) {
		if(match.getMatchId()!=0){
			matchService.update(match);
		} else {
			matchService.insert(match);
		}
		return "redirect:/admin/matchManage_0_0_0";
	}
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //历史赛事
	@GetMapping("/admin/historyMatch_{pageCurrent}_{pageSize}_{pageCount}")
	public String getHistoryMatch(Match match,@PathVariable Integer pageCurrent,
			@PathVariable Integer pageSize,@PathVariable Integer pageCount, Model model) {
		
		if(pageSize == 0) pageSize = 10;
		if(pageCurrent == 0) pageCurrent = 1;
		//统计符合条件的总数
		int rows = matchService.count4History(match);
		if(pageCount == 0) {
			pageCount = rows % pageSize == 0 ? (rows/pageSize) : (rows/pageSize) + 1;
		}
		int start = (pageCurrent - 1) * pageSize;
		int end = pageSize;
		match.setStart(start);
		match.setEnd(end);
		List<Match> historyMatchs = matchService.findByPage4History(match);
		String pageHTML = PageUtil.getPageContent("/admin/historyMatch_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
		model.addAttribute("pageHTML", pageHTML);
		//System.out.println(pageHtml);
		model.addAttribute("historyMatchs", historyMatchs);
		return "match/historyMatch";
	}
	
    @GetMapping("/admin/historyEdit")
	public String historyEditGet(Model model,Match match,HttpSession session) {
		if(match.getMatchId()!=0){
			Match match2 = matchService.findById(match);
			model.addAttribute("match",match2);
			session.setAttribute("matchId", match2.getMatchId());
		}
		return "match/historyMatchEdit";
	}	
    
	@PostMapping("/admin/historyEdit")
	public String historyEditPost(Model model,Match match, HttpSession httpSession) {
		
		match.setMatchId((int)(httpSession.getAttribute("matchId")));
		if(match.getMatchId()!=0){
			matchService.updateScore(match);
			System.out.println(match.getScore());
		} else {
			matchService.insert(match);
			System.out.println("分数："+match.getScore());
		}
		return "redirect:/admin/historyMatch_0_0_0";
	}
    
	
}
