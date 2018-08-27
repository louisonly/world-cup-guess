package com.louis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.louis.entity.Bet;
import com.louis.entity.Match;

@Mapper
public interface BetMapper {

	@Insert("INSERT INTO bet (bet_id,user_ip,match_id,wager,bet_time,bet_type) "
			+ "VALUES (NULL,#{userIp},#{matchId},#{wager},now(),#{betType});")
	int insert(Bet bet);
	
	@Select("SELECT user_ip,match_id,bet_time,wager,benefit "
			+ "FROM bet WHERE user_ip = #{userIp} limit " + "#{start},#{end}" )
	List<Bet> findByIp(Bet bet);
	
	//根据ip更新命中了的竞猜 的金额
	@Update("UPDATE bet b,`match` m SET b.benefit = b.wager * m.rate\r\n" + 
			"WHERE b.match_id = m.match_id AND b.bet_type = m.result_type "
			+ "AND b.user_ip = #{userIp}")
	int updateInfoByIp(Bet bet);
	
	//获取热门赛事总数
	@Select("SELECT count(*) FROM bet ")
	int countBets(Bet bet);
}
