package me.afua.week6;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/")
    public @ResponseBody String showAllItems(Authentication auth)
    {

        if(auth!=null)
         return "<h1>Helooooooo.."+auth.getName()+".</h1>";
        else return "WELCOME. SIGN IN.";
    }
}
