package com.spring.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(){
		
		logger.info("GET /project/add");
		
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(){
       
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
}
