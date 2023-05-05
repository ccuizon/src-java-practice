package com.cheery.abadatacollector.target;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class TargetController {
//	private String getLoggedinUsername(ModelMap model) {
//		Authentication authentication = 
//				SecurityContextHolder.getContext().getAuthentication();
//		return authentication.getName();
//	}
//	
	private TargetService targetService;

	public TargetController(TargetService targetService) {
		super();
		this.targetService = targetService;
	}

	@GetMapping("/list-targets")
	public String listAllTodos(ModelMap model) {
//		String username = getLoggedinUsername(model);
		List<Target> targets = TargetService.targets;
		model.put("targets", targets);
		return "listTargets";
	}

	@GetMapping("/add-target")
	public String gotoNewTargetPage(ModelMap model) {
		Target target = new Target(0, "", LocalDate.now(), LocalDate.now(), "", true);
		model.put("target", target);
		return "target";
	}

	@PostMapping("add-target")
	public String addTarget(ModelMap model, @Valid Target target, BindingResult result) {
		if (result.hasErrors()) {
			return "target";
		}
		
		targetService.addTarget(target.getDescription(), target.getStartDate(), target.getEndDate(), target.getOutcome(), target.isActive());
		return "redirect:list-targets";
	}
}
