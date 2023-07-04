package com.global.shopserver.service;

import com.global.shopserver.dto.SubMenuDTO;
import com.global.shopserver.dto.SubMenuDeleteDTO;
import com.global.shopserver.dto.SubMenuRegisterDTO;
import com.global.shopserver.dto.SubMenuUpdateDTO;
import com.global.shopserver.entity.Menu;
import com.global.shopserver.entity.SubMenu;
import com.global.shopserver.repository.MenuRepository;
import com.global.shopserver.repository.SubMenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubMenuService { // 하위 메뉴 관련 서비스 로직 구현

    private final MenuRepository menuRepository;
    private final SubMenuRepository subMenuRepository;

    public SubMenuService(MenuRepository menuRepository, SubMenuRepository subMenuRepository) {
        this.menuRepository = menuRepository;
        this.subMenuRepository = subMenuRepository;
    }

    // 하위 메뉴 생성
    @Transactional
    public void makeSubMenu(SubMenuRegisterDTO subMenuRegisterDTO) {

        Menu menu = menuRepository.findMenuById((long) subMenuRegisterDTO.getMenuId());
        // 등록할 상위 메뉴가 존재하지 않는 경우
        if (menu == null) {
            throw new IllegalArgumentException("등록할 상위 메뉴가 존재하지 않습니다.");
        }

        // 이미 할당된 경우 (같은 이름이 있다면 이미 할당된 하위 메뉴라고 판단)
        for (SubMenu subMenu : subMenuRepository.findAllByMenu(menu)) {
            if (subMenu.getName().equals(subMenuRegisterDTO.getName()) && subMenu.getDeleted() == 'N') {
                throw new IllegalArgumentException("이미 등록된 하위 메뉴입니다.");
            }
        }

        // 새로운 하위 메뉴 생성
        SubMenu newSubMenu = SubMenu.builder()
                .menu(menuRepository.findMenuById((long) subMenuRegisterDTO.getMenuId()))
                .name(subMenuRegisterDTO.getName())
                .imageUrl(subMenuRegisterDTO.getImageUrl())
                .introduction(subMenuRegisterDTO.getIntroduction())
                .price(subMenuRegisterDTO.getPrice())
                .deleted('N')
                .build();

        // 하위 메뉴 등록
        subMenuRepository.save(newSubMenu);
    }

    // 하위 메뉴 수정
    @Transactional
    public void updateSubMenu(SubMenuUpdateDTO subMenuUpdateDTO) {

        SubMenu exisingSubMenu = subMenuRepository.findSubMenuById((long) subMenuUpdateDTO.getSubMenuId());

        // 수정할 하위 메뉴가 존재하지 않는 경우 / 삭제된 하위 메뉴를 수정하려는 경우
        if (exisingSubMenu == null || exisingSubMenu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("수정할 하위 메뉴가 존재하지 않습니다.");
        }

        // 이미 등록된 하위 메뉴인지 검사 (같은 이름이 있다면 이미 등록된 하위 메뉴라고 판단)
        for (SubMenu subMenu : subMenuRepository.findAllByName(subMenuUpdateDTO.getNewName())) {
            if (subMenu.getDeleted() == 'N') {
                throw new IllegalArgumentException("이미 등록된 하위 메뉴입니다.");
            }
        }

        // 하위 메뉴에 새로운 정보 setting
        exisingSubMenu.setMenu(menuRepository.findMenuById((long) subMenuUpdateDTO.getSubMenuId()));
        exisingSubMenu.setName(subMenuUpdateDTO.getNewName());
        exisingSubMenu.setImageUrl(subMenuUpdateDTO.getNewImageUrl());
        exisingSubMenu.setIntroduction(subMenuUpdateDTO.getNewIntroduction());
        exisingSubMenu.setPrice(subMenuUpdateDTO.getNewPrice());

        // 하위 메뉴 갱신
        subMenuRepository.save(exisingSubMenu);
    }

    // 하위 메뉴 (논리적) 삭제
    @Transactional
    public void deleteSubMenu(SubMenuDeleteDTO subMenuDeleteDTO) {

        SubMenu subMenu = subMenuRepository.findSubMenuById((long) subMenuDeleteDTO.getSubMenuId());

        // 삭제할 하위 메뉴가 존재하지 않는 경우 / 삭제된 하위 메뉴를 또 삭제하려는 경우
        if (subMenu == null || subMenu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("삭제할 하위 메뉴가 존재하지 않습니다.");
        }

        // 논리적 삭제 및 저장
        subMenu.setDeleted('Y');
        subMenuRepository.save(subMenu);
    }

    // 모든 하위 메뉴 리스트 반환
    public List<SubMenuDTO> showSubMenuList() {

        // 반환한 데이터를 담을 리스트
        List<SubMenuDTO> subMenuDTOList = new ArrayList<>();

        // 하위 메뉴 구성
        for (SubMenu subMenu : subMenuRepository.findAll()) {
            if (subMenu.getDeleted() == 'N') {
                SubMenuDTO subMenuDTO = SubMenuDTO.from(subMenu);

                // 반환할 리스트에 menuDTO 추가
                subMenuDTOList.add(subMenuDTO);
            }
        }

        // 하위 메뉴 반환
        return subMenuDTOList;
    }

    // 특정 하위 메뉴 반환
    public SubMenuDTO showSubMenu(String subMenuId) {

        SubMenu subMenu = subMenuRepository.findSubMenuById(Long.valueOf(subMenuId));

        // 하위 메뉴가 존재하지 않는 경우 / 삭제된 하위 메뉴를 조회하려는 경우
        if (subMenu == null || subMenu.getDeleted() == 'Y') {
            throw new IllegalArgumentException("하위 메뉴가 존재하지 않습니다.");
        }

        // 하위 메뉴 반환
        return SubMenuDTO.from(subMenu);
    }
}
