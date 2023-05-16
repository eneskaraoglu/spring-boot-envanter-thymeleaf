package com.eneskaraoglu.ek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eneskaraoglu.ek.entity.Depo;
import com.eneskaraoglu.ek.entity.Envanter;
import com.eneskaraoglu.ek.entity.VEnvanterDepo;
import com.eneskaraoglu.ek.repository.DepoRepository;
import com.eneskaraoglu.ek.services.EnvanterService;

@Controller
@RequestMapping("/env")
public class EnvanterController {
	
	private EnvanterService service;
	private DepoRepository depoRepository;
	
	@Autowired
	public EnvanterController(EnvanterService theService, DepoRepository theDepoRepository) {
		service = theService;
		depoRepository = theDepoRepository;
	}	
	
	@GetMapping("/list-envanter")
	public String listEnvanter(Model theModel) {
		List<Envanter> result = service.findAll();
		theModel.addAttribute("envanterler",result);
		return "list-envanter";
	}
	
	@GetMapping("/list-depo")
	public String listDepo(Model theModel) {
		List<Depo> result = depoRepository.findAll();
		theModel.addAttribute("depolar",result);
		return "list-depo";
	}
	
	@GetMapping("/list-detail")
	public String listDetail(Model theModel) {
		 VEnvanterDepo theEntity = new VEnvanterDepo();
		List<VEnvanterDepo> result = service.findByEntity(theEntity);
		theModel.addAttribute("details",result);
		return "list-detail";
	}

}
