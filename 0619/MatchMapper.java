package com.louis.mapper;

import java.util.List;

import javax.xml.stream.events.StartDocument;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.louis.entity.Match;

@Mapper
public interface MatchMapper {

	@Select("SELECT m.match_id, m.home, m.away, m.match_date, "
			+ "m.home_odds	,m.draw_odds, m.away_odds, m.guess_deadline  FROM `match` AS m WHERE m.match_date > now()")
	List<Match> findAllHot(Match match);
	
	
	@Select("SELECT m.match_id, m.home, m.away, m.match_date, "
			+ "m.home_odds	,m.draw_odds, m.away_odds, m.guess_deadline  FROM `match` AS m WHERE m.match_date >= now() limit " + "#{start},#{end}" )
	List<Match> findByPage(Match match);
	
	@Select("SELECT m.match_id, m.home, m.away, m.match_date, "
			+ "m.result_type, m.score  FROM `match` AS m WHERE m.match_date < now() limit " + "#{start},#{end}" )
	List<Match> findByPage4History(Match match);
	
	
	//获取热门赛事总数
	@Select("SELECT count(*) FROM `match` AS m WHERE m.match_date >= NOW()")
	int count(Match match);
	
	//获取热门赛事总数
	@Select("SELECT count(*) FROM `match` AS m WHERE m.match_date < NOW()")
	int count4History(Match match);
		
	
	
	//根据ID获取赛事信息
	
	@Select("SELECT * FROM `match` AS m WHERE m.match_id = #{matchId};")
	Match findById(Match match);

	
	@Insert("INSERT INTO `match` (match_id,match_date,home,away,home_odds,draw_odds,away_odds,guess_deadline) "
			+ "VALUES(NULL,#{matchDate},#{home},#{away},#{homeOdds},#{drawOdds},#{awayOdds},#{guessDeadline});")
	int insert(Match match);

	@Update("UPDATE `match` SET `match_date` = #{matchDate}, `home` = #{home}, `away` = #{away}, `home_odds` = #{homeOdds}, `draw_odds` = #{drawOdds}, `away_odds` = #{awayOdds}, 'guess_deadline' = #{guessDeadline} WHERE `match_id` = #{matchId};")
	int update(Match match);
	
	//更新比分
	@Update("UPDATE `match` SET score = #{score},result_type = #{resultType} WHERE match_id = #{matchId}")
	int updateScore(Match match);

	
}
