package com.projeto.demoprojeto.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.demoprojeto.domain.Promocoes;

public interface PromocaoRepository extends JpaRepository<Promocoes, Long>{
	
	@Query("select p from Promocoes p where p.site like :site")
	Page<Promocoes>findBySite(@Param("site") String site, Pageable pegeable);
	
	@Query("select distinct p.site from Promocoes p where p.site like %:site%")
	List<String> findSitesByTermo(@Param("site")String site);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("update Promocoes p set p.likes = p.likes + 1 where p.id = :id")
	void updateSomarLikes(@Param("id") Long id);
	
	@Query("select p.likes from Promocoes p where p.id = :id")
	int findLikesById(@Param("id") Long id);
}
