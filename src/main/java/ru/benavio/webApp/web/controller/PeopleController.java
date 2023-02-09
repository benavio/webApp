package ru.benavio.webApp.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.benavio.webApp.biz.model.Person;
import ru.benavio.webApp.data.PersonRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @ModelAttribute
    public Person getPerson(){
        return new Person();
    };


    @GetMapping
    public String showPeoplePage(){
        return "people";
    };

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors){
        if(!errors.hasErrors())
        {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){
        System.out.println(selections);
        if(selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";
    }

}
