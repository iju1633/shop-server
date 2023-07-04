package com.global.shopserver.service;

import com.global.shopserver.dto.MenuDTO;
import com.global.shopserver.dto.MenuDeleteDTO;
import com.global.shopserver.dto.MenuRegisterDTO;
import com.global.shopserver.dto.MenuUpdateDTO;
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

class MenuServiceTest { // MenuService의 메서드별 테스트 진행
    @Mock
    MenuRepository menuRepository;
    @Mock
    SubMenuRepository subMenuRepository;
    @InjectMocks
    MenuService menuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMakeMenu() {

        // when
        when(menuRepository.findMenuByName(anyString())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));

        // then
        menuService.makeMenu(new MenuRegisterDTO());
    }

    @Test
    void testUpdateMenu() {

        // when
        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));
        when(menuRepository.findMenuByName(anyString())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));

        // then
        menuService.updateMenu(new MenuUpdateDTO());
    }

    @Test
    void testDeleteMenu() {

        // when
        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));

        // then
        menuService.deleteMenu(new MenuDeleteDTO());
    }

    @Test
    void testShowMenuList() {

        // when
        when(subMenuRepository.findAllByMenu(any())).thenReturn(List.of(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'))));

        // then
        List<MenuDTO> result = menuService.showMenuList();
        Assertions.assertNotNull(result);
    }

    @Test
    void testShowMenu() {

        // when
        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));
        when(subMenuRepository.findAllByMenu(any())).thenReturn(List.of(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'))));

        // then
        MenuDTO result = menuService.showMenu("1");
        Assertions.assertNotNull(result);
    }
}