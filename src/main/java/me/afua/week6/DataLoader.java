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
    @Override
    public void run(String... args) throws Exception {


        Category pets = new Category();
        pets.setName("Pets");
        category.save(pets);

        Category clothes = new Category();
        clothes.setName("Clothes");
        category.save(clothes);

        Category other  = new Category();
        other.setName("Other");
        category.save(other);

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

        l = new LostItem("Orange scarf","A beauriful silk scarf left at the Shady Grove bus station");
        l.setLost(true);
        l.setItemCategory(clothes);
        lostItem.save(l);






    }
}