package me.afua.week6;

import org.springframework.data.repository.CrudRepository;

public interface LostItemRepository extends CrudRepository<LostItem,Long> {
    //Find all items that are either lost or found
    Iterable <LostItem> findAllByLost(boolean isLost);
    Iterable <LostItem> findAllByOwnersContaining(AppUser user);

    Iterable <LostItem> findAllByOwnersContains(AppUser user);
    Iterable <LostItem> findAllByOwnersContainsAndLost(AppUser user,boolean lost);
    Iterable <LostItem> findAllByItemCategoryAndTitleContainingIgnoreCase(Category c,String description);
    Iterable <LostItem> findAllByItemCategoryAndTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(Category c,String title,String description);
    Iterable <LostItem> findAllByItemCategory(Category c);
    Iterable <LostItem> findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}
