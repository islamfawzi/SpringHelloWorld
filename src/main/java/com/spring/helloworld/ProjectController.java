package com.spring.helloworld;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import services.Projectservice;

@Controller
@RequestMapping(value="/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpSession session){
		session.setAttribute("token", "12345");
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
	public String save(HttpSession session, HttpServletRequest request, @RequestParam("email") String email){
        System.out.println("session value: " + session.getAttribute("token"));
        System.out.println("name param: " + request.getParameter("name"));
        System.out.println("email param: " + email);
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