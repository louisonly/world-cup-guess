package com.louis.entity;

import java.sql.Timestamp;
import java.util.Date;


public class Match {

	private int matchId;
	private Date matchDate;
	//private Timestamp matchDate;
	private String home;
	private String away;
	private double homeOdds;
	private double drawOdds;
	private double awayOdds;
	private Date guessDeadline;
	//private Timestamp guessDeadline;
	private String score;
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getAway() {
		return away;
	}
	public void setAway(String away) {
		this.away = away;
	}
	public double getHomeOdds() {
		return homeOdds;
	}
	public void setHomeOdds(double homeOdds) {
		this.homeOdds = homeOdds;
	}
	public double getDrawOdds() {
		return drawOdds;
	}
	public void setDrawOdds(double drawOdds) {
		this.drawOdds = drawOdds;
	}
	public double getAwayOdds() {
		return awayOdds;
	}
	public void setAwayOdds(double awayOdds) {
		this.awayOdds = awayOdds;
	}
	public Date getGuessDeadline() {
		return guessDeadline;
	}
	public void setGuessDeadline(Date guessDeadline) {
		this.guessDeadline = guessDeadline;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
