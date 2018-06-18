package com.louis.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.entity.Match;
import com.louis.mapper.MatchMapper;

@Service
public class MatchService {

	@Autowired
	private MatchMapper matchMapper;
	
	public List<Match> findAll(Match match){
		List<Match> matchs = matchMapper.findAll(match);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for(Match m:matchs) {
//			
//			m.setMatchDate(sdf.format(m.getMatchDate());
//		}
		return matchMapper.findAll(match);
	}
	
	public Match findById(Match match) {
		return matchMapper.findById(match);
	}
	
	public int insert(Match match) {
		return matchMapper.insert(match);
	}
	
	public int update(Match match) {
		return matchMapper.update(match);
	}
}
