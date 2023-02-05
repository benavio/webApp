package ru.benavio.webApp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.benavio.webApp.biz.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @GetMapping
    public String getPeople(Model model){
        List<Person> people = List.of(
                new Person(10l,"Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000")),
                new Person(10l,"Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000")),
                new Person(10l,"Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000")),
                new Person(10l,"Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000")),
                new Person(10l,"Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000")),
                new Person(10l,"Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000"))
        );
        model.addAttribute("people", people);
        return "people";
    };

}
