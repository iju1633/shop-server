package com.global.shopserver.repository;

import com.global.shopserver.entity.Menu;
import com.global.shopserver.entity.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {

    List<SubMenu> findAllByMenu(Menu menu);

    SubMenu findSubMenuById(Long subMenuId);

    SubMenu findSubMenuByName(String name);

    boolean existsByMenuAndId(Menu menu, Long subMenuId);
}
