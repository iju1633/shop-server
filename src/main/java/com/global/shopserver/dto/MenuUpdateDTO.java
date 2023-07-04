package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MenuUpdateDTO { // 상위 메뉴 수정 시 사용

    @Min(value = 1, message = "수정할 상위 메뉴를 선택해주세요.")
    @ApiModelProperty(value = "수정할 상위 메뉴 id(Primary Key)", example = "1")
    private int menuId;

    @NotBlank(message = "새로운 상위 메뉴 이름을 기입해주세요.")
    @ApiModelProperty(value = "상위 메뉴 이름", example = "새로운 상위 메뉴 이름 예시")
    private String newName;

    @NotBlank(message = "새로운 상위 메뉴 이미지 url을 기입해주세요.")
    @ApiModelProperty(value = "상위 메뉴 이미지 url", example = "새로운 상위 메뉴 이미지 url 예시")
    private String newImageUrl;

    @NotBlank(message = "새로운 상위 메뉴 설명을 기입해주세요.")
    @ApiModelProperty(value = "상위 메뉴 설명", example = "새로운 상위 메뉴 설명 예시")
    private String newIntroduction;

    @Min(value = 0, message = "가격은 음수일 수 없습니다.")
    @ApiModelProperty(value = "상위 메뉴 가격", example = "10000")
    private int newPrice;
}
