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
    public String showAllItems(Authentication auth, Model model) {
        model.addAttribute("lostList", lostAndFound.showAllItems());
        return "listitems";
    }

    @RequestMapping("/myItems")
    public String showMyItems(Authentication auth, Model model) {

        model.addAttribute("lostList", lostAndFound.showMyItems(auth));
        return "listitems";
    }

    @RequestMapping("/myfounditems")
    public String showMyFoundItems(Authentication auth, Model model) {

        model.addAttribute("lostList", lostAndFound.showMyFoundItems(auth));
        return "listitems";
    }

    @GetMapping("/additem")
    public String addLostItem(Model model) {
        model.addAttribute("lostIt", new LostItem());
        model.addAttribute("lostEnabled", false);
        model.addAttribute("categories", lostAndFound.showCategories());
        return "additem";
    }

    @GetMapping("/lostmyitem")
    public String addMyLostItem(Model model, Authentication auth) {
        LostItem l = new LostItem();
        l.setItemCategory(lostAndFound.findCategory("Other"));
        l.addOwner(lostAndFound.getUser(auth.getName()));
        model.addAttribute("lostIt", l);
        model.addAttribute("lostEnabled", false);
        model.addAttribute("addMyItem", true);
        model.addAttribute("categories", lostAndFound.showCategories());
        return "additem";
    }

    @GetMapping("/adminaddlost")
    public String adminAddingLostItem(Model model, Authentication auth) {
        LostItem l = new LostItem();
        model.addAttribute("lostIt", new LostItem());
        model.addAttribute("lostEnabled", false);

        //Displays list of users so admin user can select a user to whom the item belongs
        model.addAttribute("adminAdd", true);
        model.addAttribute("categories", lostAndFound.showCategories());
        model.addAttribute("ownerList", lostAndFound.showUsers());

        return "additem";
    }

    @PostMapping("/saveitem")
    public String saveLostItem(@Valid @ModelAttribute("lostIt") LostItem lost, BindingResult result, Model model) {
        System.out.println(lost.getItemCategory()+" saved as category id");
        if (result.hasErrors()) {
            return "additem";
        }
        if(lost.getImage().isEmpty())
        {
            lost.setImage(null);
        }
        lostAndFound.addLostItem(lost);
        model.addAttribute("lostList", lostAndFound.showAllItems());
        return "redirect:/";
    }

    @GetMapping("/find")
    public String foundItem(HttpServletRequest request) {
        LostItem theItem = lostAndFound.getItem(new Long(request.getParameter("id")));
        System.out.println("Lost Item:" + theItem.getTitle());
        lostAndFound.findItem(theItem);
        return "redirect:/";
    }

    @GetMapping("/lose")
    public String lostItem(HttpServletRequest request) {
        LostItem theItem = lostAndFound.getItem(new Long(request.getParameter("id")));
        System.out.println("Found Item:" + theItem.getTitle());
        lostAndFound.setToLost(theItem);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByCategory(Model model) {
        // TODO: 3/4/2018 Add a method to search through the entire database
        String search = "red";
        Category c = lostAndFound.findCategory("Pets");
        model.addAttribute("lostList", lostAndFound.findByCategoryAnd(c, search));
        return "listitems";

    }

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping("/showelements")
    public String showElements()
    {
        return "elements";
    }




}
