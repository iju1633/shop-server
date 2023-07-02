package com.global.shopserver.repository;

import com.global.shopserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Menu findMenuById(Long menuId);
    Menu findMenuByName(String name);
}
