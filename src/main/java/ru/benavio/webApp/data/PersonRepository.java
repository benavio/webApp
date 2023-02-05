package ru.benavio.webApp.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.benavio.webApp.biz.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}
