package me.afua.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    LostItemRepository lostItem;


    @Autowired
    CategoryRepository category;

    @Autowired
    AppRoleRepository roleRepo;

    @Autowired
    AppUserRepository userRepo;


    @Override
    public void run(String... args) throws Exception {

        //Load Categories
        Category pets = new Category();
        pets.setName("Pets");
        category.save(pets);

        Category clothes = new Category();
        clothes.setName("Clothes");
        category.save(clothes);

        Category other  = new Category();
        other.setName("Other");
        category.save(other);

        //Load Roles

        AppRole r = new AppRole("ADMIN");
        roleRepo.save(r);

        r = new AppRole("USER");
        roleRepo.save(r);



        //Load lost items - clothes
        LostItem l = new LostItem("Red scarf","A beauriful silk scarf left at the Shady Grove bus station");
        l.setLost(true);
        l.setItemCategory(clothes);
        lostItem.save(l);

        l = new LostItem("Blue scarf","A beauriful silk scarf left at the Shady Grove bus station");
        l.setLost(true);
        l.setItemCategory(clothes);
        lostItem.save(l);

        l = new LostItem("Green scarf","A beauriful silk scarf left at the Shady Grove bus station");
        l.setLost(true);
        l.setItemCategory(clothes);
        lostItem.save(l);

        l = new LostItem("Yellow scarf","A beauriful silk scarf left at the Shady Grove bus station");
        l.setLost(true);
        l.setItemCategory(clothes);
        lostItem.save(l);

        l = new LostItem("Cockatoo","A red cheery bird with an unusual colour");
        l.setLost(true);
        l.setItemCategory(pets);
        lostItem.save(l);



        AppUser u = new AppUser("theuser","password",roleRepo.findAppRoleByRoleName("USER"));
        userRepo.save(u);

        l = new LostItem("Orange scarf","A beauriful silk scarf left at the Shady Grove bus station");
        l.setLost(true);
        l.setItemCategory(clothes);
        l.addOwner(u);
        lostItem.save(l);



        u = new AppUser("adminuser","password",roleRepo.findAppRoleByRoleName("ADMIN"));
        userRepo.save(u);
        System.out.println("READY TO ROLL");
    }
}
