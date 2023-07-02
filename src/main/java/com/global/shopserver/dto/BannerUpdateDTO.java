package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerUpdateDTO { // 배너 수정 시 사용

    @ApiModelProperty(value = "새로운 배너 id(Primary Key)", example = "1")
    private int bannerId;

    @ApiModelProperty(value = "새로운 배너 이미지 url", example = "이미지 url 예시")
    private String newImageUrl;

    @ApiModelProperty(value = "새로운 배너 클릭 시 이동할 링크", example = "link 예시")
    private String newLink;

    @ApiModelProperty(value = "새로운 배너에 들어갈 새로운 설명", example = "배너 설명 예시")
    private String newIntroduction;
}
