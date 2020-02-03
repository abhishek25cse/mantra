package com.mantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
