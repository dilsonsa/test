package org.fiveware.test.service;

import java.util.List;

import org.fiveware.test.dao.DepartmentDAO;
import org.fiveware.test.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public List<Department> departmentList() {		
		return departmentDAO.findAll();
	}
	

}