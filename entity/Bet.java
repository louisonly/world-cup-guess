package com.louis.entity;

import java.util.Date;

public class Bet {

	private int betId;
	private String userName;
	private String userIp;
	private int matchId;
	private int wager;
	private String betType;
	private Date betTime;
	private int betHome;
	private int betAway;
	private int betDraw;
	private int hit;
	private double benefit;
	private int start;
	private int end;
	public int getBetId() {
		return betId;
	}
	public void setBetId(int betId) {
		this.betId = betId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getWager() {
		return wager;
	}
	public void setWager(int wager) {
		this.wager = wager;
	}
	public Date getBetTime() {
		return betTime;
	}
	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}
	public int getBetHome() {
		return betHome;
	}
	public void setBetHome(int betHome) {
		this.betHome = betHome;
	}
	public int getBetAway() {
		return betAway;
	}
	public void setBetAway(int betAway) {
		this.betAway = betAway;
	}
	public int getBetDraw() {
		return betDraw;
	}
	public void setBetDraw(int betDraw) {
		this.betDraw = betDraw;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getBenefit() {
		return benefit;
	}
	public void setBenefit(double benefit) {
		this.benefit = benefit;
	}
	public String getBetType() {
		return betType;
	}
	public void setBetType(String betType) {
		this.betType = betType;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
