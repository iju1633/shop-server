package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDeleteDTO { // 상위 메뉴 삭제 시 사용

    @ApiModelProperty(value = "삭제할 상위 메뉴 id(Primary Key)", example = "1")
    private int menuId;
}
