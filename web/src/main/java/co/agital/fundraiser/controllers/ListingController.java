package co.agital.fundraiser.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@EnableAutoConfiguration
public class ListingController {

    @RequestMapping("/")
    String home()
    {
        return String.format("Hello! Today is %s", (new Date()).toString());
    }

    @RequestMapping("/key")
    public String key(@RequestParam(required = false,
            defaultValue = "") String key, Model model) {
        model.addAttribute("userkey", key);
        return key;
    }

}
