package me.afua.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    LostItemRepository lostItem;

    @Override
    public void run(String... args) throws Exception {


        LostItem l = new LostItem("Red scarf","A beauriful silk scarf left at the Shady Grove bus station");
        lostItem.save(l);


    }
}
