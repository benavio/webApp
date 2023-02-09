package ru.benavio.webApp.data;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.benavio.webApp.biz.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(personRepository.count() == 0){
            List<Person> people = List.of(
                    new Person(null, "Jake", "Smith", LocalDate.of(1950, 1, 1),"wdqwd@sera.com", new BigDecimal("50000")),
                    new Person(null, "Jake", "Smith", LocalDate.of(1940, 1, 1),"ggrgr@feat.ru", new BigDecimal("50000"))
            );
            personRepository.saveAll(people);
        }
    }
}
