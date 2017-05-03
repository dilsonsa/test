package org.fiveware.test.repository;

import org.fiveware.test.dao.AbstractDAO;
import org.fiveware.test.dao.UserDAO;
import org.fiveware.test.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractDAO implements UserDAO{

	@Override
	public void savePerson(Person person) {
		persist(person);
	}

}
