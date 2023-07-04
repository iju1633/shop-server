package com.global.shopserver.service;

import com.global.shopserver.dto.SubMenuDTO;
import com.global.shopserver.dto.SubMenuDeleteDTO;
import com.global.shopserver.dto.SubMenuRegisterDTO;
import com.global.shopserver.dto.SubMenuUpdateDTO;
import com.global.shopserver.entity.Menu;
import com.global.shopserver.entity.SubMenu;
import com.global.shopserver.repository.MenuRepository;
import com.global.shopserver.repository.SubMenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class SubMenuServiceTest { // SubMenuService의 메서드별 테스트 진행
    @Mock
    MenuRepository menuRepository;
    @Mock
    SubMenuRepository subMenuRepository;
    @InjectMocks
    SubMenuService subMenuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMakeSubMenu() {

        // when
        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));
        when(subMenuRepository.findSubMenuByName(anyString())).thenReturn(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));

        // then
        subMenuService.makeSubMenu(new SubMenuRegisterDTO());
    }

    @Test
    void testUpdateSubMenu() {

        // when
        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));
        when(subMenuRepository.findSubMenuById(anyLong())).thenReturn(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));
        when(subMenuRepository.findSubMenuByName(anyString())).thenReturn(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));
        when(subMenuRepository.existsByMenuAndId(any(), anyLong())).thenReturn(true);


        // then
        subMenuService.updateSubMenu(new SubMenuUpdateDTO());
    }

    @Test
    void testDeleteSubMenu() {

        // when
        when(subMenuRepository.findSubMenuById(anyLong())).thenReturn(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));
        when(subMenuRepository.existsByMenuAndId(any(), anyLong())).thenReturn(true);

        // then
        subMenuService.deleteSubMenu(new SubMenuDeleteDTO());
    }

    @Test
    void testShowSubMenuList() {

        // given
        List<SubMenuDTO> result = subMenuService.showSubMenuList();

        // then
        Assertions.assertNotNull(result);
    }

    @Test
    void testShowSubMenu() {

        // when
        when(subMenuRepository.findSubMenuById(anyLong())).thenReturn(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));

        // then
        SubMenuDTO result = subMenuService.showSubMenu("1");
        Assertions.assertNotNull(result);
    }
}