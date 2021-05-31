package com.santos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.domain.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long>{
	
	List<Ranking> findTop5ByLevelOrderByScoreDescId(String level);
	
//	@Query(value = "select distinct r.score, u.username from ranking r inner join user u on u.id = r.user_id where r.level = ?:level order by r.score desc, r.idlimit 5;", nativeQuery = true)
//	List<Ranking> findyByLevelRanking(String level);
	
//	@Query(value = "call sp_ranking (\":level\");", nativeQuery = true)
//	Page<Ranking> findyByLevel(String level, PageRequest pageRequest);
//	@Query(value = "call sp_ranking (\"?level\");", nativeQuery = true)
//	List<Ranking> findyByLevel(String level);
	
}
