package com.spring.helloworld;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import entities.Project;
import entities.ProjectValidator;
import services.Projectservice;

@Controller
@RequestMapping(value="/project")
@SessionAttributes("project")   // only applicable to a single controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpSession session, Model model){
	
		session.setAttribute("token", "12345");
		
		/**
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
		**/
		
		logger.info("GET /project/add");
		
		return "add";
	}
	
	@ModelAttribute("project")
	public Project getProject(){
		System.out.println("add Project instance");
		return new Project();
	}
	
	/**
	 *  assign List for the (select, checkboxes, radioBtns) on the view
	 */
	@ModelAttribute("selectValues")
	public List<String> getSelectValues(){
		return new LinkedList(Arrays.asList(
				 new String[]{"single", "multi"}));
	}
	
	@ModelAttribute("checkboxes")
	public List<String> getCheckboxes(){
		return new LinkedList(Arrays.asList(
				new String[]{"Lead Time", "Special Rate", "Requires Approval"}));
	}
	
	@ModelAttribute("radiobtns")
	public List<String> getRadioBtns(){
		return new LinkedList(Arrays.asList(
				new String[]{"Hours", "Piece", "Tons"}));
	}

	@RequestMapping(value="/review")
	public String review(@ModelAttribute Project project){
		return "review";
	}
	/**
	 * Method Arguments
	 * @param Httpsession
	 * @param HttpServletRequest
	 * @param @RequestParam 
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute Project project,
			           HttpSession session, 
			           HttpServletRequest request, 
			           @RequestParam("email") String email,
			           BindingResult binding){
        
		ProjectValidator validator = new ProjectValidator();
		validator.validate(project, binding);
		
		if(binding.hasErrors()){
			System.out.println("not valid");
			return "add";
		}else{
			System.out.println("valid");
		}
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
	
	@RequestMapping(value="/save")
	public String save(@ModelAttribute Project project, SessionStatus status){
		System.out.println("save method: " + project);
		status.setComplete();
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
	
	/**
	 * Exception handler
	 */
	
	@RequestMapping(value="exception")
	public void exception(){
		if(1==1){
			throw new RuntimeException("There is an error");
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request){
		
		return "handle_exceptions";
	}
}