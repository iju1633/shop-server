package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OptionRegisterDTO { // 하위 메뉴 등록 시 사용

    @ApiModelProperty(value = "상위 메뉴 id(Primary Key)", example = "1")
    private int menuId;

    @NotBlank(message = "하위 메뉴 이름을 기입해주세요.")
    @ApiModelProperty(value = "하위 메뉴 이름", example = "하위 메뉴 이름 예시")
    private String name;

    @NotBlank(message = "하위 메뉴 이미지 url을 기입해주세요.")
    @ApiModelProperty(value = "하위 메뉴 이미지 url", example = "하위 메뉴 이미지 url 예시")
    private String imageUrl;

    @NotBlank(message = "하위 메뉴 설명을 기입해주세요.")
    @ApiModelProperty(value = "하위 메뉴 설명", example = "하위 메뉴 설명 예시")
    private String introduction;

    @NotBlank(message = "하위 메뉴 가격을 기입해주세요.")
    @ApiModelProperty(value = "하위 메뉴 가격", example = "10000")
    private int price;
}
