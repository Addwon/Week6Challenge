package me.afua.week6;

import org.springframework.data.repository.CrudRepository;

public interface LostItemRepository extends CrudRepository<LostItem,Long> {
    //Find all items that are either lost or found
    Iterable <LostItem> findAllByLost(boolean isLost);


}
