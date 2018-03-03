package me.afua.week6;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class LostItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String image;

    private String description;

    private boolean lost;

    @ManyToOne
    private Category itemCategory;

    @ManyToMany
    private Set<AppUser> owners;

    public LostItem() {
        setLost(true);
        this.owners = new HashSet<>();
    }

    public LostItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Set<AppUser> getOwners() {
        return owners;
    }

    public void setOwners(Set<AppUser> owners) {
        this.owners = owners;
    }

    public void addOwner(AppUser u)
    {
        this.owners.add(u);
    }

    @Override
    public String toString() {
        return "LostItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lost=" + lost +
                ", itemCategory=" + itemCategory +
                '}';
    }

}
