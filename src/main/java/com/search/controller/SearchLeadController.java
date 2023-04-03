package com.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.dto.LeadDto;

@Controller
public class SearchLeadController {

	@Autowired
	private LeadRestClient restClient;
	
	// localhost:9090/search
	
	@RequestMapping("/search")
	public String viewSearchLeadForm() {
		return "search_lead";
	}
	
	
	// this will be call by the action attribute of the form 
	
	@RequestMapping("/findLeadById")
	public String findLeadById(@RequestParam("id") long id,Model m) {
		LeadDto leadDto = restClient.getLeadById(id);
		m.addAttribute("leadDto",leadDto);
		return "lead_info";
	}
}
