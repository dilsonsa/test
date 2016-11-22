package org.fiveware.test.service;

import org.fiveware.test.dao.DepartmentDAO;
import org.fiveware.test.dao.UserDAO;
import org.fiveware.test.model.Department;
import org.fiveware.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Override
	public void savePerson(Person person, Long departmentId) {
		Department department = departmentDAO.findDepartmentById(departmentId);
		person.setDepartment(department);
		userDAO.savePerson(person);
	}

}