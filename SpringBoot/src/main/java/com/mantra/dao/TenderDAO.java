package com.mantra.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mantra.domain.Tender;
import com.mantra.repository.TenderDetailRepository;

@Component
public class TenderDAO {
	@Autowired
	private TenderDetailRepository tenderRepo;
	
	public List<Tender> fetchAllTenders() {
		List<Tender> tenders = new ArrayList<Tender>();
		tenders = tenderRepo.findAll();
		return tenders;
	}
	
	public Tender saveTender(String poNumber ) {
		Tender t = new Tender();
		t.setHead("DDUGJY HEAD");
		List<Tender> tenders = tenderRepo.findAll();
		t = tenders.get(0);
		t.setId(null);
		t.setPoNo(poNumber);
		 t  =  tenderRepo.save(t);
		return  t;
		
	}
	public void deleteAllTender() {
		 tenderRepo.deleteAll();
	}
	

}
