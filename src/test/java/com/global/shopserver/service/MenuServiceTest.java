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

        when(menuRepository.findAllByNameOrImageUrl(anyString(), anyString())).thenReturn(List.of(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));

        menuService.makeMenu(new MenuRegisterDTO());
    }

    @Test
    void testUpdateMenu() {

        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));
        when(menuRepository.findAllByNameOrImageUrl(anyString(), anyString())).thenReturn(List.of(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N')));

        menuService.updateMenu(new MenuUpdateDTO());
    }

    @Test
    void testDeleteMenu() {

        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));

        menuService.deleteMenu(new MenuDeleteDTO());
    }

    @Test
    void testShowMenuList() {

        when(subMenuRepository.findAllByMenu(any())).thenReturn(List.of(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'))));

        List<MenuDTO> result = menuService.showMenuList();

        Assertions.assertNotNull(result);
    }

    @Test
    void testShowMenu() {

        when(menuRepository.findMenuById(anyLong())).thenReturn(new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'));
        when(subMenuRepository.findAllByMenu(any())).thenReturn(List.of(new SubMenu(1L, "name", "imageUrl", "introduction", 0, 'N', new Menu(1L, "name", "imageUrl", "introduction", 0, 'N'))));

        MenuDTO result = menuService.showMenu("1");

        Assertions.assertNotNull(result);
    }
}