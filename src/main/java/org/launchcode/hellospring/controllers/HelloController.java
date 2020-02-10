package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //lives at hello/hello
    //handles a request of the form /hello?name=LaunchCode
    @RequestMapping(value= "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting); //"hand to the template", first param is the name of the variable used in the template, the second param is the object that contains the value that the variable should have
        return "hello"; //return the template name
    }

    //handles a request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello"; //return the template name
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names); //first argument is the variable that the template will see/uses, the second is the value that that variable should have
        return "hello-list"; //want it to use/return the hello-list template (hello-list.html)
    }
}


