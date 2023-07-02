package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class BannerDeleteDTO { // 배너 삭제 시 사용

    @Min(value = 0, message = "값은 양수여야 합니다.")
    @ApiModelProperty(value = "삭제할 배너 id(Primary Key)", example = "1")
    private int bannerId;
}
