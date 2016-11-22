package org.fiveware.test.web;

import org.fiveware.test.model.Gender;
import org.fiveware.test.model.Person;
import org.fiveware.test.service.DepartmentService;
import org.fiveware.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("departments", departmentService.departmentList());
		model.addObject("person", new Person());
		return model;
	}
	
	@RequestMapping(value = "person/save", method = RequestMethod.POST)
	public void cadastrar(@RequestParam("name") String name,
						  @RequestParam("gender") String gender,
						  @RequestParam("sports") String sports,
						  @RequestParam("department") Long department){
		
		Person person = new Person();
		person.setGender(Gender.valueOf(gender));
		person.setName(name);
		person.setSports(sports);
		personService.savePerson(person, department);
	}
}
