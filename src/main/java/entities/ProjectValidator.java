package entities;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ProjectValidator implements Validator {

	 private Pattern pattern;
	 private Matcher matcher;

	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
		
		Project project = (Project) obj;
		
		/**
		 * validate project name
		 */
		ValidationUtils.rejectIfEmpty(error, "name", "name.required", "The name is required");
		
		if(project.getName().length() < 5 && !project.getName().isEmpty()){
			
			System.out.println("less than 5");
			
			error.rejectValue("name", "name.short",
				      "The name is too short");		
		}
		
		/**
		 * validate project email
		 */
		ValidationUtils.rejectIfEmpty(error, "email", "email.required", "The email is required");
		
		if(!project.getEmail().isEmpty()){
			
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(project.getEmail().toString());
			
			if(!matcher.matches()){
				error.rejectValue("email", "email.not_match",
					      "Not Valid Email");	
			}			
		}
	}
}
