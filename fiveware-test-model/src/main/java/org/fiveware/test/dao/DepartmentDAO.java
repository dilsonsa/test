package org.fiveware.test.dao;

import java.util.List;

import org.fiveware.test.model.Department;

public interface DepartmentDAO {

	Department findDepartmentById(Long id);

	List<Department> findAll();
}
