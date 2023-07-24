package com.cheery.abadatacollector.target;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cheery.abadatacollector.exception.StudentNotFoundException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
//@SessionAttributes("studentId")
public class TargetController {
//	private String getLoggedinUsername(ModelMap model) {
//		Authentication authentication = 
//				SecurityContextHolder.getContext().getAuthentication();
//		return authentication.getName();
//	}
//	
	private TargetRepository targetRepository;
	private StudentRepository studentRepository;
	
	public TargetController(TargetRepository targetRepository, StudentRepository studentRepository) {
		super();
		this.targetRepository = targetRepository;
		this.studentRepository = studentRepository;
	}

//	@GetMapping("/list-targets")
//	public String listAllTargets(ModelMap model) {
//		List<Target> targets = targetRepository.findAll();
//		model.put("targets", targets);
//		return "listTargets";
//	}
	
	@GetMapping("/list-targets-from-students-page")
	public String listTargetsForStudent(@RequestParam int id, ModelMap model, HttpSession session) {
		Optional<Student> student=  studentRepository.findById(id);
		
		if (student.isEmpty()) {
			throw new StudentNotFoundException("id: " + id);
		}
		
		List<Target> targets = student.get().getTargets();
		model.put("targets", targets);
		session.setAttribute("studentId", id);
		
		return "listTargets";
	}
	
	@GetMapping("/list-targets")
	public String listTargets(ModelMap model, HttpSession session) {
		int id =  ((Integer) session.getAttribute("studentId")).intValue();
		Optional<Student> student=  studentRepository.findById(id);
		
		if (student.isEmpty()) {
			throw new StudentNotFoundException("id: " + id);
		}
		
		List<Target> targets = student.get().getTargets();
		model.put("targets", targets);
		session.setAttribute("studentId", id);
		
		return "listTargets";
	}

	@GetMapping("/add-target")
	public String gotoNewTargetPage(ModelMap model) {
		Target target = new Target(0, "", LocalDate.now(), LocalDate.now(), "", true);
		model.put("target", target);
		return "target";
	}

	@PostMapping("add-target")
	public String addTarget(ModelMap model, @Valid Target target, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "target";
		}
		
		int studentId =  ((Integer) session.getAttribute("studentId")).intValue();
		Optional<Student> student = studentRepository.findById(studentId);
		
		if (student.isEmpty()) {
			throw new StudentNotFoundException("id: " + studentId);
		}
		
		target.setStudent(student.get());
		targetRepository.save(target);
		return "redirect:list-targets";
	}
	
	@GetMapping("/update-target")
	public String showUpdateTargetPage(@RequestParam int id, ModelMap model) {
		Target target = targetRepository.findById(id).get();
		model.put("target", target);
		return "target";
	}
	
	@PostMapping("/update-target")
	public String updateTarget(ModelMap model, @Valid Target target, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "target";
		}
		
		int studentId =  ((Integer) session.getAttribute("studentId")).intValue();
		Optional<Student> student = studentRepository.findById(studentId);
		
		if (student.isEmpty()) {
			throw new StudentNotFoundException("id: " + studentId);
		}
		
		target.setStudent(student.get());
		
		targetRepository.save(target);
		
		return "redirect:list-targets";
	}
	
	@GetMapping("delete-target")
	public String deleteTarget(@RequestParam int id) {
		targetRepository.deleteById(id);
		return "redirect:list-targets";
	}
	
	@GetMapping("/list-students")
	public String listAllStudents(ModelMap model) {
		List<Student> students = studentRepository.findAll();
		model.put("students", students);
		return "listStudents";
	}
	
//	@PostMapping("/aba/students")
//	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
//		Student savedStudent = studentRepository.save(student);
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(savedStudent.getStudentId())
//				.toUri();
//		
//		return ResponseEntity.created(location).build();
//	
//	}
	
	@GetMapping("/update-student")
	public String showUpdateStudentPage(@RequestParam int id, ModelMap model) {
		Student student = studentRepository.findById(id).get();
		model.put("student", student);
		return "student";
	}
	
	@PostMapping("/update-student")
	public String updateStudent(ModelMap model, @Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student";
		}
		studentRepository.save(student);
		
		return "redirect:list-students";
	}
	
	@GetMapping("/add-student")
	public String goToNewStudentPage(ModelMap model) {
		Student student = new Student(0, "", "", LocalDate.now());
		model.put("student", student);
		return "student";
	}
	
	@PostMapping("/add-student")
	public String addStudent(ModelMap model, @Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student";
		}
		studentRepository.save(student);
		return "redirect:list-students";
	}
	
	@GetMapping("/delete-student")
	public String deleteStudent(@RequestParam int id) {
		
		studentRepository.deleteById(id);
		return "redirect:list-students";
	}
}
