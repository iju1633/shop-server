package com.global.shopserver.dto;

import com.global.shopserver.entity.Banner;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BannerDTO { // 배너 조회 시 사용

    @ApiModelProperty(value = "배너 id(Primary Key)", example = "1")
    private int bannerId;

    @ApiModelProperty(value = "배너 이미지 url", example = "이미지 url 예시")
    private String imageUrl;

    @ApiModelProperty(value = "배너 클릭 시 이동할 링크", example = "link 예시")
    private String link;

    @ApiModelProperty(value = "배너에 들어갈 설명", example = "배너 설명 예시")
    private String introduction;

    // entity -> dto
    public static BannerDTO from(Banner entity) {

        return BannerDTO.builder()
                .bannerId(entity.getId().intValue())
                .imageUrl(entity.getImageUrl())
                .link(entity.getLink())
                .introduction(entity.getIntroduction())
                .build();
    }
}
