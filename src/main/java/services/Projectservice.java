package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Project;

public class Projectservice {

	List<Project> projects = new ArrayList<Project>();
	
	public Projectservice(){
		createProject(1,"project1", "info@project1.com", "single", true);
		createProject(2,"project2", "info@project2.com", "multi", false);
		createProject(3,"project3", "info@project4.com", "single", true);
	}
	
	public void createProject(int id,String name, String email, String type, boolean special){
		
	   Project project = new Project();
	   project.setId(id);
	   project.setName(name);
	   project.setEmail(email);
	   project.setType(type);
	   project.setSpecial(special);
	   
	   projects.add(project);
	}
	
	public List findall(){
		
		return projects;
	}
	
	public Project find(int id){
		
		return (Project) projects.stream().filter(p ->
		{
			return p.getId() == id; 
		}).collect(Collectors.toList()).get(0);
		
	}
}
