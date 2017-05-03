package org.fiveware.test.repository;

import java.util.List;

import org.fiveware.test.dao.AbstractDAO;
import org.fiveware.test.dao.DepartmentDAO;
import org.fiveware.test.model.Department;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository extends AbstractDAO implements DepartmentDAO{

	@Override
	public Department findDepartmentById(Long id) {		
		return (Department) getSession().get(Department.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		Query query = getSession().createQuery("FROM Department");
		return query.list();
	}

}
