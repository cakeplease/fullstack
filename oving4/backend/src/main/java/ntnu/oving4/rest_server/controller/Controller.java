package ntnu.oving4.rest_server.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Controller {
    @GetMapping("/")
    public String hello(@RequestParam("calculate") String equation) {


        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("([0-9]*[.])?[0-9]+").matcher(equation);
        while (m.find()) {
            allMatches.add(m.group());
        }

        return String.format(Arrays.toString(allMatches.toArray()));
    }
}
