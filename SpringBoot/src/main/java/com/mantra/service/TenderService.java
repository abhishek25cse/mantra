package com.mantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantra.dao.TenderDAO;
import com.mantra.domain.Tender;
import com.mantra.dto.TenderTO;

@Service
public class TenderService {
	
	@Autowired
	TenderDAO tenderDAO;
	
	
	public List<Tender> fetchAllTenders() {
		List<Tender> tenderTO = tenderDAO.fetchAllTenders();
		return  tenderTO;
	}
	@Transactional
	public Tender saveTender(String poNumber ) {
		return tenderDAO.saveTender(poNumber);	
		
	}
	@Transactional
	public void deleteAllTender() {
		tenderDAO.deleteAllTender();
	}
	@Transactional
	public Tender createTender(Tender tender) {
		return tenderDAO.createTender(tender);		
	}
	@Transactional
	public List<Tender> enabledisableTender(String poNum, String status) {
		Tender tender = new Tender();
		tender.setPoNo(poNum);
		tender.setStatus(status);		
		return tenderDAO.changeTenderStatus(tender);	
	}
	public List<Tender> findByPoNo(String poNum) {		
		return tenderDAO.findByPoNo(poNum);	
	}
	@Transactional
	public Long deleteByPoNo(String poNum) {
		return tenderDAO.deleteByPoNo(poNum);	
	}
	
	

}
