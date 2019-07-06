package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectJpaRepository projectJpaRepository;
	
	@GetMapping(value="/{number}")
	public Project find(@PathVariable int number) {
		return projectJpaRepository.findByNumber(number);
	}
	
	@GetMapping(value="/all")
	public List<Project> findAll() {
		return projectJpaRepository.findAll();
	}
	
	@PostMapping(value="/load/project")
	public void loadProject(@RequestBody final Project project) {
		projectJpaRepository.save(project);
	}
	
	@PostMapping(value="/load/projects")
	public void loadProjects(@RequestBody final List<Project> projects) {
		projectJpaRepository.saveAll(projects);
	}
}
