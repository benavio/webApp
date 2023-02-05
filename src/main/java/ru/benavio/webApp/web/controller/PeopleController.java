package ru.benavio.webApp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.benavio.webApp.biz.model.Person;
import ru.benavio.webApp.data.PersonRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @GetMapping
    public String showPeoplePage(Model model){
        return "people";
    };

}
