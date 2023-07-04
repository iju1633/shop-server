package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class BannerDeleteDTO { // 배너 삭제 시 사용

    @Min(value = 1, message = "삭제할 배너를 선택해주세요.")
    @ApiModelProperty(value = "삭제할 배너 id(Primary Key)", example = "1")
    private int bannerId;
}
