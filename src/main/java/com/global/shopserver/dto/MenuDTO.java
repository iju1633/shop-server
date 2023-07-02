package com.global.shopserver.dto;

import com.global.shopserver.entity.Menu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MenuDTO { // 상위 메뉴 조회 시 사용

    @ApiModelProperty(value = "상위 메뉴 id(Primary Key)", example = "1")
    private int menuId;

    @ApiModelProperty(value = "상위 메뉴 이름", example = "상위 메뉴 이름 예시")
    private String name;

    @ApiModelProperty(value = "상위 메뉴 이미지 url", example = "상위 이미지 url 예시")
    private String imageUrl;

    @ApiModelProperty(value = "상위 메뉴 설명", example = "상위 메뉴 설명 예시")
    private String introduction;

    @ApiModelProperty(value = "상위 메뉴 가격", example = "10000")
    private int price;

    @ApiModelProperty(value = "하위 메뉴 리스트")
    private List<SubMenuDTO> subMenus;

    // entity -> dto
    public static MenuDTO from(Menu entity) {

        return MenuDTO.builder()
                .menuId(entity.getId().intValue())
                .name(entity.getName())
                .imageUrl(entity.getImageUrl())
                .introduction(entity.getIntroduction())
                .price(entity.getPrice())
                .subMenus(null) // 서비스 단에서 주입
                .build();
    }
}
