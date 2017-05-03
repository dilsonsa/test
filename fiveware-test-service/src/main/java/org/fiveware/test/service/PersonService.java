package org.fiveware.test.service;

import org.fiveware.test.model.Person;

public interface PersonService {

	void savePerson(Person person, Long departmentId);
}
