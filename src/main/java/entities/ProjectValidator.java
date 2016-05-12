package entities;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
		
		Project project = (Project) obj;
		
		ValidationUtils.rejectIfEmpty(error, "name", "name.required");
		
		System.out.println(project.getName().length());
		
		if(project.getName().length() < 5){
		
			System.out.println("less than 5");
			
			error.rejectValue("name", "name.short",
				      "The name is too short");		
		}

	}

}
