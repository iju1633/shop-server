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
public class MenuService {

    private final MenuRepository menuRepository;
    private final SubMenuRepository subMenuRepository;

    public MenuService(MenuRepository menuRepository, SubMenuRepository subMenuRepository) {
        this.menuRepository = menuRepository;
        this.subMenuRepository = subMenuRepository;
    }

    // 상위 메뉴 생성
    @Transactional
    public void makeMenu(MenuRegisterDTO menuRegisterDTO) {

        // 이미 등록된 상위 메뉴인지 검사 (같은 이름이 있다면 이미 등록된 상위 메뉴라고 판단)
        Menu menu = menuRepository.findMenuByName(menuRegisterDTO.getName());
        if (menu != null) {
            throw new IllegalArgumentException("이미 등록된 상위 메뉴입니다.");
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

        Menu menu = menuRepository.findMenuById((long) menuUpdateDTO.getMenuId());

        // 수정할 상위 메뉴가 존재하지 않는 경우
        if (menu == null) {
            throw new IllegalArgumentException("수정할 상위 메뉴가 존재하지 않습니다.");
        }

        // 수정할 상위 메뉴가 이미 삭제된 경우
        if (menu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("이미 삭제된 상위 메뉴입니다.");
        }

        // 이미 등록된 상위 메뉴인지 검사 (같은 이름이 있다면 이미 등록된 상위 메뉴라고 판단)
        if (menuRepository.findMenuByName(menuUpdateDTO.getNewName()) != null) {
            throw new IllegalArgumentException("이미 등록된 상위 메뉴입니다.");
        }

        // 상위 메뉴에 새로운 정보 setting
        menu.setName(menuUpdateDTO.getNewName());
        menu.setImageUrl(menuUpdateDTO.getNewImageUrl());
        menu.setIntroduction(menuUpdateDTO.getNewIntroduction());
        menu.setPrice(menuUpdateDTO.getNewPrice());

        // 상위 메뉴 갱신
        menuRepository.save(menu);
    }

    // 상위 메뉴 (논리적) 삭제
    @Transactional
    public void deleteMenu(MenuDeleteDTO menuDeleteDTO) {

        Menu menu = menuRepository.findMenuById((long) menuDeleteDTO.getMenuId());

        // 삭제할 상위 메뉴가 존재하지 않는 경우
        if (menu == null) {
            throw new IllegalArgumentException("삭제할 상위 메뉴가 존재하지 않습니다.");
        }

        // 이미 삭제된 상위 메뉴인 경우
        if (menu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("이미 삭제된 상위 메뉴입니다.");
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

        // 상위 메뉴가 존재하지 않는 경우
        if (menu == null) {
            throw new IllegalArgumentException("상위 메뉴가 존재하지 않습니다.");
        }

        // 삭제된 상위 메뉴인 경우
        if (menu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("삭제된 상위 메뉴입니다.");
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
