package com.global.shopserver.repository;

import com.global.shopserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Menu findMenuById(Long menuId); // id 값으로 엔티티 찾음

    Menu findMenuByName(String name); // unique 함을 가지는 필드로 엔티티 찾음
}
