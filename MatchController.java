package com.louis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

@Controller
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@GetMapping("/admin/matchManage_{pageCurrent}_{pageSize}_{pageCount}")
	public String matchManage(Match match,@PathVariable Integer pageCurrent,
			@PathVariable Integer pageSize,@PathVariable Integer pageCount, Model model) {
		
		if(pageSize == 0) pageSize = 10;
		if(pageCurrent == 0) pageCurrent = 1;
		
		
		List<Match> matchs = matchService.findAll(match);
		model.addAttribute("matchs", matchs);
		return "match/matchManage";
	}
	
	/**
	 * 赛事新增、修改跳转
	 * @return
	 */
	@GetMapping("/admin/matchEdit")
	public String newsEditGet(Model model,Match match) {
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
	public String newsEditPost(Model model,Match match, HttpSession httpSession) {
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

	
}
