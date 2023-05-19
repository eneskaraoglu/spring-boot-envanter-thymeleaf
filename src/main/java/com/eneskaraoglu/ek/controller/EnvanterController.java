package com.eneskaraoglu.ek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eneskaraoglu.ek.entity.Depo;
import com.eneskaraoglu.ek.entity.DepoEnvanter;
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
		return "envanter/list-envanter";
	}
	
	@GetMapping("/addEnvanterForm")
	public String addEnvanterForm(Model theModel) {
		Envanter theEnvater = new Envanter();
		theModel.addAttribute("envanter",theEnvater);
		return "envanter/envanter-form";
		
	}
	
	@PostMapping("/envanterKaydet")
	public String envanterKaydet(@ModelAttribute("envanter") Envanter theEntity) 
	{
		DepoEnvanter depoEnvanter = new DepoEnvanter();
		depoEnvanter.setDepoId(1);
		theEntity.setDepoEnvanter(depoEnvanter);
		service.save(theEntity);
		return "redirect:/env/list-envanter";
	}
	
	@GetMapping("/updateEnvanterForm")
	public String updateEnvanterForm(@RequestParam("envanterId") int envanterId,  Model theModel) {
		Envanter theEnvater = service.findById(envanterId);
		
		theModel.addAttribute("envanter",theEnvater);
		return "envanter/update-envanter-form";
		
	}
	
	@GetMapping("/deleteEnvanter")
	public String deleteEnvanter(@RequestParam("envanterId") int envanterId,  Model theModel) {
		service.deleteById(envanterId);
		return "redirect:/env/list-envanter";
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
