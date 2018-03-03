package me.afua.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    AdministratorService lostAndFound;

    @RequestMapping("/")
    public String showAllItems(Authentication auth, Model model)
    {

//        if(auth!=null)
//         return "<h1>Helooooooo.."+auth.getName()+".</h1><br/>"+lostAndFound.showAllItems().toString();
//
       model.addAttribute("lostList",lostAndFound.showAllItems());
       return "listitems";
    }

    @GetMapping("/additem")
    public String addLostItem(Model model)
    {
        model.addAttribute("lostIt",new LostItem());
        model.addAttribute("lostEnabled",false);
        return "additem";
    }

    @PostMapping("/saveitem")
    public String saveLostItem(@Valid @ModelAttribute("lostIt") LostItem lost, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "additem";
        }
        lostAndFound.addLostItem(lost);
        model.addAttribute("lostList",lostAndFound.showAllItems());
        return "redirect:/";
    }

    @GetMapping("/find")
    public String foundItem(HttpServletRequest request)
    {
        LostItem theItem = lostAndFound.getItem(new Long(request.getParameter("id")));
        System.out.println("Lost Item:"+theItem.getTitle());
        lostAndFound.findItem(theItem);
        return "redirect:/";
    }

    @GetMapping("/lose")
    public String lostItem(HttpServletRequest request)
    {
        LostItem theItem = lostAndFound.getItem(new Long(request.getParameter("id")));
        System.out.println("Found Item:"+theItem.getTitle());
        lostAndFound.setToLost(theItem);
        return "redirect:/";
    }

}
