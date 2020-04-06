package co.agital.fundraiser.controllers;

import co.agital.fundraiser.model.Key;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ListingRestController {

    @GetMapping("/rest")
    public Key key(@RequestParam(required = false,
            defaultValue = "") String myKey)
    {
        if (!myKey.isBlank()) {
            return new Key(myKey);
        }

        return null;
    }

}
