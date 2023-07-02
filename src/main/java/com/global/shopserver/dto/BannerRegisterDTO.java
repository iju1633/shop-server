package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BannerRegisterDTO { // 배너 등록 시 사용

    @NotBlank(message = "배너 이미지 url을 입력해주세요.")
    @ApiModelProperty(value = "배너 이미지 url", example = "이미지 url 예시", required = true)
    private String imageUrl;

    @NotBlank(message = "배너 클릭 시 이동할 링크를 기입해주세요.")
    @ApiModelProperty(value = "배너 클릭 시 이동할 링크", example = "link 예시", required = true)
    private String link;

    @NotBlank(message = "배너의 설명을 기입해주세요.")
    @ApiModelProperty(value = "배너에 들어갈 설명", example = "배너 설명 예시", required = true)
    private String introduction;
}
