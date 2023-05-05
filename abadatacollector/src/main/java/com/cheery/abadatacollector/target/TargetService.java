package com.cheery.abadatacollector.target;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TargetService {
	
	public static List<Target> targets = new ArrayList<Target>();
	private static int targetCount = 0;
	
	static {
		targets.add(new Target(++targetCount, "Attend to a specific task", LocalDate.now(), LocalDate.now().plusMonths(6), "good", true));
		targets.add(new Target(++targetCount, "Have less tantrums", LocalDate.now(), LocalDate.now().plusMonths(6), "good", true));
		targets.add(new Target(++targetCount, "Have less scripting", LocalDate.now(), LocalDate.now().plusMonths(6), "good", true));
	}
	
	public void addTarget(String description, LocalDate startDate, LocalDate endDate, String outcome, boolean active) {
		int size = targets.size();
		System.out.println("Targets size is: " + size);
		
		targets.add(new Target(++targetCount, description, startDate, endDate, outcome, active));
	}
	
	
}
