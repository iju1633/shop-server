package com.global.shopserver.dto;

import com.global.shopserver.entity.Option;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OptionDTO { // 하위 메뉴 조회 시 사용

    @ApiModelProperty(value = "하위 메뉴 id(Primary Key)", example = "1")
    private int optionId;

    @ApiModelProperty(value = "하위 메뉴 이름", example = "하위 메뉴 이름 예시")
    private String name;

    @ApiModelProperty(value = "하위 메뉴 이미지 url", example = "하위 이미지 url 예시")
    private String imageUrl;

    @ApiModelProperty(value = "하위 메뉴 설명", example = "하위 메뉴 설명 예시")
    private String introduction;

    @ApiModelProperty(value = "하위 메뉴 가격", example = "10000")
    private int price;

    @ApiModelProperty(value = "상위 메뉴")
    private MenuDTO menuDTO;

    // entity -> dto
    public static OptionDTO from(Option entity) {

        return OptionDTO.builder()
                .optionId(entity.getId().intValue())
                .name(entity.getName())
                .imageUrl(entity.getImageUrl())
                .introduction(entity.getIntroduction())
                .price(entity.getPrice())
                .menuDTO(MenuDTO.from(entity.getMenu()))
                .build();
    }
}
