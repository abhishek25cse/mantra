package com.mantra.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mantra.domain.Tender;

@Repository
public interface TenderRepository extends MongoRepository<Tender, String> {

	/*@Query(value= "{'poNo':?0, 'status':?1 }")
	Long updateTenderByPoNo(String poNum, String enableTender);*/
	
	
	@Modifying(clearAutomatically=true)
	@Query(value= "UPDATE Tender t SET t.status=:status where poNo=:poNum ")
	public Long changeStatus(@Param("poNum")String poNum, @Param("status") String status);
	
	public List<Tender> findByPoNo(String poNum);

	
	public Long deleteByPoNo(String poNum);

}
