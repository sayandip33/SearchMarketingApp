package com.search.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.search.dto.LeadDto;

@Component
public class LeadRestClient {
	
	public LeadDto getLeadById(long id) {
		//consume the api using restTemplate
		RestTemplate restTemplate =new RestTemplate();
		LeadDto leadDto = restTemplate.getForObject("http://localhost:8080/api/leads/"+id, LeadDto.class);
		return leadDto;
	}
	
}
