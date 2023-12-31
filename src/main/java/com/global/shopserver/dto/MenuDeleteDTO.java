package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class MenuDeleteDTO { // 상위 메뉴 삭제 시 사용

    @Min(value = 1, message = "삭제할 상위 메뉴를 선택해주세요.")
    @ApiModelProperty(value = "삭제할 상위 메뉴 id(Primary Key)", example = "1")
    private int menuId;
}
