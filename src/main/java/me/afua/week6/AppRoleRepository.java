package me.afua.week6;

import org.springframework.data.repository.CrudRepository;

public interface AppRoleRepository extends CrudRepository<AppRole, Long> {
    AppRole findAppRoleByRoleName(String role);
}
