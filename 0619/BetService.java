package com.louis.service;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.entity.Bet;
import com.louis.mapper.BetMapper;

@Service
public class BetService {

	@Autowired
	private BetMapper betMapper;
	
	public int insert(Bet bet) {
		return betMapper.insert(bet);
	}
	
	//竞猜下单
	public void insertOrder(HttpServletRequest request, Bet bet) {
		String ip = getIpAddr(request);
		bet.setUserIp(ip);
		
	}
    public String getIpAddr(HttpServletRequest request) {   
        String ip = request.getHeader("x-forwarded-for");   
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
            ip = request.getHeader("Proxy-Client-IP");   
        }   
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
            ip = request.getHeader("WL-Proxy-Client-IP");   
        }   
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
            ip = request.getRemoteAddr();   
            if(ip.equals("127.0.0.1")){     
                //根据网卡取本机配置的IP     
                InetAddress inet=null;     
                try {     
                    inet = InetAddress.getLocalHost();     
                } catch (Exception e) {     
                    e.printStackTrace();     
                }     
                ip= inet.getHostAddress();     
            }  
        }   
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
        if(ip != null && ip.length() > 15){    
            if(ip.indexOf(",")>0){     
                ip = ip.substring(0,ip.indexOf(","));     
            }     
        }     
        return ip;   
 }  	
}
