package com.mantra.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mantra.domain.Tender;
import com.mantra.repository.TenderRepository;

@Component
public class TenderDAO {
	@Autowired
	private TenderRepository tenderRepo;
	
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

	public Tender createTender(Tender tender) {		
		return tenderRepo.save(tender);
	}

	public List<Tender> changeTenderStatus(Tender tender) {		
		List<Tender> tenders = tenderRepo.findByPoNo(tender.getPoNo());		
		/*tenders.stream().forEach(t-> t.setStatus(tender.getStatus() ) ) ;*/
		List<Tender> tendersFinal = new ArrayList<Tender>(); 
		for(Tender t : tenders) {
			 //t.setId(null);
			 t.setStatus(tender.getStatus());
			 tendersFinal.add(tenderRepo.save(t));
		}
		System.out.println(tenders);
		return tendersFinal;
	}

	public List<Tender> findByPoNo(String poNum) {		
		return tenderRepo.findByPoNo(poNum);
	}

	public Long deleteByPoNo(String poNum) {
		return tenderRepo.deleteByPoNo(poNum);
	}
	

}
