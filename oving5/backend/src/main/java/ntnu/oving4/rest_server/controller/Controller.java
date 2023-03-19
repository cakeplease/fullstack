package ntnu.oving4.rest_server.controller;

import jakarta.servlet.http.HttpServletResponse;
import ntnu.oving4.rest_server.model.LoginRequest;
import ntnu.oving4.rest_server.repository.UserRepository;
import ntnu.oving4.rest_server.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @CrossOrigin(origins = "http://localhost:5173")

    @GetMapping("/")
    public String calculate(@RequestParam("calculate") String equation, HttpServletResponse response) {
        Logger logger = LoggerFactory.getLogger(Controller.class);
        logger.info("GET request to calculate "+equation);

        Service service = new Service();

        double ans = 0.0;
        try {
            ans = service.calculateEquation(equation);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            logger.info("GET request to calculate "+equation+" succeeded. The answer is "+ans);
            return Double.toString(ans);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("GET request to calculate "+equation+" failed. Exception thrown: "+e);
            return Double.toString(ans);
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public int login(@RequestBody LoginRequest loginDetails) {
        Logger logger = LoggerFactory.getLogger(Controller.class);
        logger.info("Login request from "+loginDetails.username());
        Service service = new Service();
        int userID = service.login(loginDetails.username(), loginDetails.password());
        return userID;
    }
}
