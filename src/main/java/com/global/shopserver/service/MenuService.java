package com.global.shopserver.service;

import com.global.shopserver.dto.*;
import com.global.shopserver.entity.Menu;
import com.global.shopserver.entity.SubMenu;
import com.global.shopserver.repository.MenuRepository;
import com.global.shopserver.repository.SubMenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService { // 상위 메뉴 관련 서비스 로직 구현

    private final MenuRepository menuRepository;
    private final SubMenuRepository subMenuRepository;

    public MenuService(MenuRepository menuRepository, SubMenuRepository subMenuRepository) {
        this.menuRepository = menuRepository;
        this.subMenuRepository = subMenuRepository;
    }

    // 상위 메뉴 생성
    @Transactional
    public void makeMenu(MenuRegisterDTO menuRegisterDTO) {

        // 이미 등록된 상위 메뉴인지 검사 (같은 이름이나 이미지가 있다면 이미 등록된 상위 메뉴라고 판단)
        List<Menu> menus = menuRepository.findAllByNameOrImageUrl(menuRegisterDTO.getName(), menuRegisterDTO.getImageUrl());
        for (Menu menu : menus) {
            if (menu.getDeleted() == 'N') {
                throw new IllegalArgumentException("이미 등록된 상위 메뉴입니다.");
            }
        }

        // 새로운 상위 메뉴 등록
        Menu newMenu = Menu.builder()
                .name(menuRegisterDTO.getName())
                .imageUrl(menuRegisterDTO.getImageUrl())
                .introduction(menuRegisterDTO.getIntroduction())
                .price(menuRegisterDTO.getPrice())
                .deleted('N')
                .build();

        // 상위 메뉴 저장
        menuRepository.save(newMenu);
    }

    // 상위 메뉴 수정
    @Transactional
    public void updateMenu(MenuUpdateDTO menuUpdateDTO) {

        Menu existingMenu = menuRepository.findMenuById((long) menuUpdateDTO.getMenuId());

        // 수정할 상위 메뉴가 존재하지 않는 경우 / 삭제된 상위 메뉴를 수정하려는 경우
        if (existingMenu == null || existingMenu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("수정할 상위 메뉴가 존재하지 않습니다.");
        }

        // 이미 등록된 상위 메뉴인지 검사 (같은 이름이 있다면 이미 등록된 상위 메뉴라고 판단)
        List<Menu> menus = menuRepository.findAllByNameOrImageUrl(menuUpdateDTO.getNewName(), menuUpdateDTO.getNewImageUrl());
        for (Menu menu : menus) {
            if (menu.getDeleted() == 'N' && !menu.getId().equals(existingMenu.getId())) { // 삭제되지 않은 상태이고 수정하려는 엔티티를 제외하고 중복이 일어나는 경우
                throw new IllegalArgumentException("이미 등록된 상위 메뉴입니다.");
            }
        }

        // 상위 메뉴에 새로운 정보 setting
        existingMenu.setName(menuUpdateDTO.getNewName());
        existingMenu.setImageUrl(menuUpdateDTO.getNewImageUrl());
        existingMenu.setIntroduction(menuUpdateDTO.getNewIntroduction());
        existingMenu.setPrice(menuUpdateDTO.getNewPrice());

        // 상위 메뉴 갱신
        menuRepository.save(existingMenu);
    }

    // 상위 메뉴 (논리적) 삭제
    @Transactional
    public void deleteMenu(MenuDeleteDTO menuDeleteDTO) {

        Menu menu = menuRepository.findMenuById((long) menuDeleteDTO.getMenuId());

        // 삭제할 상위 메뉴가 존재하지 않는 경우 / 삭제된 상위 메뉴를 또 삭제하려는 경우
        if (menu == null || menu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("삭제할 상위 메뉴가 존재하지 않습니다.");
        }

        // 연결되어 있는 하위 메뉴 모두 논리적 삭제 (링크를 없앰, 하위 메뉴의 경우 여러 상위 메뉴와 링크 가능하기 때문)
        for (SubMenu subMenu : subMenuRepository.findAllByMenu(menu)) {
            subMenu.setDeleted('Y');
            subMenuRepository.save(subMenu);
        }

        // 논리적 삭제 및 저장
        menu.setDeleted('Y');
        menuRepository.save(menu);
    }

    // 모든 상위 메뉴 리스트 반환
    public List<MenuDTO> showMenuList() {

        // 반환한 데이터를 담을 리스트
        List<MenuDTO> menuDTOList = new ArrayList<>();

        // 상위 메뉴 구성 및 하위 메뉴 할당
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getDeleted() == 'N') {
                MenuDTO menuDTO = MenuDTO.from(menu);
                List<SubMenuDTO> subMenuDTOList = new ArrayList<>();
                for (SubMenu subMenu : subMenuRepository.findAllByMenu(menu)) {
                    if (subMenu.getDeleted() == 'N') { // 논리적으로 삭제된 하위 메뉴는 제외
                        SubMenuDTO subMenuDTO = SubMenuDTO.from(subMenu);
                        subMenuDTOList.add(subMenuDTO);
                    }
                }
                menuDTO.setSubMenus(subMenuDTOList);

                // 반환할 리스트에 menuDTO 추가
                menuDTOList.add(menuDTO);
            }
        }

        // 상위 메뉴 반환
        return menuDTOList;
    }

    // 특정 상위 메뉴 반환
    public MenuDTO showMenu(String menuId) {

        Menu menu = menuRepository.findMenuById(Long.valueOf(menuId));

        // 상위 메뉴가 존재하지 않는 경우 / 삭제된 상위 메뉴를 조회히려는 경우
        if (menu == null || menu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("상위 메뉴가 존재하지 않습니다.");
        }

        // 상위 메뉴의 하위 메뉴 할당
        MenuDTO menuDTO = MenuDTO.from(menu);
        List<SubMenuDTO> subMenuDTOList = new ArrayList<>();
        for (SubMenu subMenu : subMenuRepository.findAllByMenu(menu)) {
            if (subMenu.getDeleted() == 'N') { // 논리적으로 삭제된 하위 메뉴는 제외
                SubMenuDTO subMenuDTO = SubMenuDTO.from(subMenu);
                subMenuDTOList.add(subMenuDTO);
            }
        }
        menuDTO.setSubMenus(subMenuDTOList);

        // 상위 메뉴 반환
        return menuDTO;
    }
}
