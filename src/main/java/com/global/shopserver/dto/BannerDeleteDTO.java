package com.global.shopserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerDeleteDTO { // 배너 삭제 시 사용

    @ApiModelProperty(value = "삭제할 배너 id(Primary Key)", example = "1")
    private int bannerId;
}
