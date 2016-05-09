package com.spring.helloworld;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Project;
import services.Projectservice;

@Controller
@RequestMapping(value="/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpSession session, Model model){
		
		session.setAttribute("token", "12345");
		
		model.addAttribute("project", new Project());
		
		List selectValues = new LinkedList(Arrays.asList(
				 new String[]{"single", "multi"}));
		model.addAttribute("selectValues", selectValues);
		
		List checkboxes = new LinkedList(Arrays.asList(
				new String[]{"Lead Time", "Special Rate", "Requires Approval"}));
		model.addAttribute("checkboxes", checkboxes);
		
		List radiobtns = new LinkedList(Arrays.asList(
				new String[]{"Hours", "Piece", "Tons"}));
		model.addAttribute("radiobtns", radiobtns);
		
		logger.info("GET /project/add");
		
		return "add";
	}
	
	/**
	 * Method Arguments
	 * @param Httpsession
	 * @param HttpServletRequest
	 * @param @RequestParam 
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@ModelAttribute Project project, HttpSession session, HttpServletRequest request, @RequestParam("email") String email){
        
		/**
		 * HttpSession Method Argument
		 */
		System.out.println("session value: " + session.getAttribute("token"));
        
        /**
         * HttpServletRequest Method Argument
         */
        System.out.println("name param: " + request.getParameter("name"));
        
        /**
         * @RequestParam Method Argument
         */
        System.out.println("email param: " + email);
        
        /**
         * DataBinding
         */
        System.out.println("DataBinding Project: " + project);
        
        
		logger.info("POST /project/add");
		
		return "home";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi"})
	public String saveMulti(){
		
		logger.info("POST {type=multi} /project/add");
		
		return "home";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi", "special"})
	public String saveMultiSpecial(){
		
		logger.info("POST {type=multi, special} /project/add");
		
		return "home";
	}
	
	/**
	 * initialize the service (ex: db service)
	 */
	@Autowired
	private Projectservice projectservice;
	
	@RequestMapping(value="/all")
	public String findAll(Model model){
		
		model.addAttribute("projects", projectservice.findall());
		
		return "projects";
	}
	
	@RequestMapping(value="/{projectId}")
	public String find(Model model, @PathVariable("projectId") int id){
		model.addAttribute("project", projectservice.find(id));
		return "project";
	}
}