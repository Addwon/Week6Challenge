package me.afua.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    LostItemRepository lostItemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public void addLostItem(String title,  String description)
    {
        LostItem l = new LostItem(title,description);
        l.setLost(true);
        lostItemRepository.save(l);

    }

    public void addLostItem(LostItem l)
    {
        lostItemRepository.save(l);
    }

    public void setToLost(LostItem l)
    {
        l.setLost(true);
        lostItemRepository.save(l);
    }

    public void addLostItem(String title, String description, AppUser user)
    {
        
    }

    public Iterable <LostItem> showAllItems()
    {
        return lostItemRepository.findAll();
    }

    public Iterable <LostItem> showLostItems()
    {
        return lostItemRepository.findAllByLost(true);
    }

    public Iterable <LostItem>  showFoundItems()
    {
        return lostItemRepository.findAllByLost(false);

    }

    public LostItem getItem(long id)
    {
        return lostItemRepository.findById(id).get();
    }

    public void findItem(LostItem l)
    {
        l.setLost(false);
        lostItemRepository.save(l);
    }

    public Iterable<Category> showCategories()
    {
        return categoryRepository.findAll();
    }

}
