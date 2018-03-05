package me.afua.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdministratorService lostAndFound;

    @RequestMapping("/lost")
    public String showLostItemsAdmin(Model model)
    {
        model.addAttribute("ownerList", lostAndFound.showUsers());
        model.addAttribute("lostList",lostAndFound.showLostItems());
        return "listitems";
    }

    @RequestMapping("/found")
    public String showFoundItemsAdmin(Model model)
    {
        model.addAttribute("ownerList", lostAndFound.showUsers());
        model.addAttribute("lostList",lostAndFound.showFoundItems());
        return "listitems";
    }

    @GetMapping("/additemforuser")
    public String addLostItem(Model model) {
        model.addAttribute("lostIt", new LostItem());
        model.addAttribute("lostEnabled", false);
        model.addAttribute("adminAdd", true);
        model.addAttribute("ownerList", lostAndFound.showUsers());
        model.addAttribute("categories", lostAndFound.showCategories());
        return "additem";
    }
}
