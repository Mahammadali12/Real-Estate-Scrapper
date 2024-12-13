package grad;

import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RController {
    
    @GetMapping("/register")
    String getRegisterPage()  {
        return "form";  
    }


    @GetMapping("/login")
    String getLoginPage()  {
        return "log";  
    }

}
