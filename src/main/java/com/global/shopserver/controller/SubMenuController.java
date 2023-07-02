
package com.global.shopserver.controller;

import com.global.shopserver.dto.SubMenuDTO;
import com.global.shopserver.dto.SubMenuDeleteDTO;
import com.global.shopserver.dto.SubMenuRegisterDTO;
import com.global.shopserver.dto.SubMenuUpdateDTO;
import com.global.shopserver.service.SubMenuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subMenu")
public class SubMenuController {

    private final SubMenuService subMenuService;

    public SubMenuController(SubMenuService subMenuService) {
        this.subMenuService = subMenuService;
    }

    // 하위 메뉴 생성
    @PostMapping
    @ApiOperation(value = "새로운 하위 메뉴 생성", notes = "상위 메뉴 id(Primary Key), 이름, 이미지 링크, 설명, 가격을 입력받아 새로운 하위 메뉴를 생성합니다.")
    public ResponseEntity<Void> makeSubMenu(@Validated @RequestBody SubMenuRegisterDTO subMenuRegisterDTO) {

        subMenuService.makeSubMenu(subMenuRegisterDTO);
        return ResponseEntity.ok().build();
    }

    // 하위 메뉴 수정
    @PatchMapping("/update")
    @ApiOperation(value = "하위 메뉴 수정", notes = "하위 메뉴의 정보를 수정합니다. 수정된 새로운 하위 메뉴가 이미 존재하거나, 이미 상위 메뉴와 관계 설정이 있는 경우, 수정 불가능합니다.")
    public ResponseEntity<Void> updateSubMenu(@Validated @RequestBody SubMenuUpdateDTO subMenuUpdateDTO) {

        subMenuService.updateSubMenu(subMenuUpdateDTO);
        return ResponseEntity.ok().build();
    }

    // 하위 메뉴 삭제
    @PatchMapping("/delete")
    @ApiOperation(value = "하위 메뉴 (논리적)삭제", notes = "논리적 삭제를 진행합니다. 이미 상위 메뉴와 관계 설정이 있는 하위 메뉴의 경우, 삭제 불가능합니다.")
    public ResponseEntity<Void> deleteSubMenu(SubMenuDeleteDTO subMenuDeleteDTO) {

        subMenuService.deleteSubMenu(subMenuDeleteDTO);
        return ResponseEntity.ok().build();
    }

    // 하위 메뉴 리스트 반환
    @GetMapping("/list")
    @ApiOperation(value = "모든 하위 메뉴 리스트 반환", notes = "모든 하위 메뉴 리스트를 반환합니다.")
    public ResponseEntity<List<SubMenuDTO>> showSubMenuList() {

        return ResponseEntity.ok().body(subMenuService.showSubMenuList());
    }

    // 특정 하위 메뉴 반환
    @GetMapping("/{subMenuId}")
    @ApiOperation(value = "특정 하위 메뉴 정보 반환", notes = "하위 메뉴 id(Primary Key) 값을 매개변수로 받아 특정 하위 메뉴의 정보를 반환합니다.")
    @ApiImplicitParam(
            name = "subMenuId"
            , value = "하위 메뉴 id(Primary Key)"
            , required = true
            , dataType = "Long"
            , paramType = "path"
            , defaultValue = "None"
            , example = "1")
    public ResponseEntity<SubMenuDTO> showSubMenu(@PathVariable String subMenuId) {

        return ResponseEntity.ok().body(subMenuService.showSubMenu(subMenuId));
    }
}
