package uz.pdp.SpringBootProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ViewResolver;

@Controller
public class HelloController {


    @Autowired
    ViewResolver viewResolver;
    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hello World!");
        return "/hello";

    }
}
