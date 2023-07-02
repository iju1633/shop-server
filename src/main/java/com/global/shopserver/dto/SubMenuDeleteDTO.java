package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class SubMenuDeleteDTO { // 하위 메뉴 삭제 시 사용

    @Min(value = 0, message = "값은 양수여야 합니다.")
    @ApiModelProperty(value = "하위 메뉴 id(Primary Key)", example = "1")
    private int subMenuId;
}
