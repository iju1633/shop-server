package com.global.shopserver.repository;

import com.global.shopserver.entity.Menu;
import com.global.shopserver.entity.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {

    List<SubMenu> findAllByMenu(Menu menu); // 해당 상위 메뉴의 모든 하위 메뉴를 반환

    SubMenu findSubMenuById(Long subMenuId); // id로 엔티티 찾음

    List<SubMenu> findAllByName(String name); // 논리적 삭제를 하므로 중복(image, introduction)될 수 있기에 list를 반환 (등록과 수정에 사용)

    boolean existsByMenuAndId(Menu menu, Long subMenuId); // 상위 메뉴에 해당 하위 메뉴가 할당되어 있는 지 여부를 반환
}
