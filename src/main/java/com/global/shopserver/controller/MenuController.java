
package com.global.shopserver.controller;

import com.global.shopserver.dto.*;
import com.global.shopserver.service.MenuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 상위 메뉴 생성
    @PostMapping
    @ApiOperation(value = "새로운 상위 메뉴 생성", notes = "이름, 이미지 링크, 설명, 가격을 입력받아 새로운 상위 메뉴를 생성합니다.")
    public ResponseEntity<Void> makeMenu(@Validated @RequestBody MenuRegisterDTO menuRegisterDTO) {

        menuService.makeMenu(menuRegisterDTO);
        return ResponseEntity.ok().build();
    }

    // 상위 메뉴 수정
    @PatchMapping("/update")
    @ApiOperation(value = "상위 메뉴 수정", notes = "상위 메뉴의 정보를 수정합니다. 이미 하위 메뉴가 존재하는 경우, 수정 불가능합니다.")
    public ResponseEntity<Void> updateBanner(@Validated @RequestBody MenuUpdateDTO menuUpdateDTO) {

        menuService.updateBanner(menuUpdateDTO);
        return ResponseEntity.ok().build();
    }

    // 상위 메뉴 삭제
    @PatchMapping("/delete")
    @ApiOperation(value = "상위 메뉴 삭제", notes = "논리적 삭제를 진행합니다. 이미 하위 메뉴가 존재하는 경우, 삭제 불가능합니다.")
    public ResponseEntity<Void> deleteMenu(MenuDeleteDTO menuDeleteDTO) {

        menuService.deleteMenu(menuDeleteDTO);
        return ResponseEntity.ok().build();
    }

    // 상위 메뉴 리스트 반환
    @GetMapping("/list")
    @ApiOperation(value = "모든 상위 메뉴 리스트 반환", notes = "모든 상위 메뉴 리스트를 반환합니다. 상위 메뉴의 하위 메뉴 리스트 또한 반환합니다.")
    public ResponseEntity<List<MenuDTO>> menuList() {

        return ResponseEntity.ok().body(menuService.showMenuList());
    }

    // 특정 상위 메뉴 반환
    @GetMapping("/{menuId}")
    @ApiOperation(value = "특정 상위 메뉴 정보 반환", notes = "특정 상위 메뉴의 정보를 반환합니다. 상위 메뉴의 하위 메뉴 리스트 또한 반환합니다.")
    @ApiImplicitParam(
            name = "menuId"
            , value = "상위 메뉴 id(Primary Key)"
            , required = true
            , dataType = "Long"
            , paramType = "path"
            , defaultValue = "None"
            , example = "1")
    public ResponseEntity<MenuDTO> showMenu(@PathVariable String menuId) {

        return ResponseEntity.ok().body(menuService.showMenu(menuId));
    }
}
