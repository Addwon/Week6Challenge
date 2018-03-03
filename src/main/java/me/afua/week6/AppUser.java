package me.afua.week6;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    private String displayName;

    @ManyToMany
    Set<AppRole> roles;

    @ManyToMany(mappedBy="owners")
    private Set<LostItem> lostItems;

    public AppUser() {
        this.roles = new HashSet<>();
        this.lostItems = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }

    public Set<LostItem> getLostItems() {
        return lostItems;
    }

    public void setLostItems(Set<LostItem> lostItems) {
        this.lostItems = lostItems;
    }

    public void addRole(AppRole r)
    {
        this.roles.add(r);
    }



}
