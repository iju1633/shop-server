package com.global.shopserver.repository;

import com.global.shopserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Menu findMenuById(Long menuId); // id 값으로 엔티티 찾음

    List<Menu> findAllByName(String name); // 논리적 삭제를 하므로 중복(image, introduction)될 수 있기에 list를 반환 (등록과 수정에 사용)
}
