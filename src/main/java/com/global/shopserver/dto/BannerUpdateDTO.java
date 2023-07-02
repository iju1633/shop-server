package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BannerUpdateDTO { // 배너 수정 시 사용

    @Min(value = 0, message = "값은 양수여야 합니다.")
    @ApiModelProperty(value = "수정할 배너 id(Primary Key)", example = "1")
    private int bannerId;

    @NotBlank(message = "새로운 배너 이미지 url을 기입해주세요.")
    @ApiModelProperty(value = "새로운 배너 이미지 url", example = "새로운 이미지 url 예시")
    private String newImageUrl;

    @NotBlank(message = "새로운 link를 기입해주세요.")
    @ApiModelProperty(value = "새로운 배너 클릭 시 이동할 링크", example = "새로운 link 예시")
    private String newLink;

    @NotBlank(message = "새로운 배너에 들어갈 새로운 설명을 기입해주세요.")
    @ApiModelProperty(value = "새로운 배너에 들어갈 새로운 설명", example = "새로운 배너 설명 예시")
    private String newIntroduction;
}
