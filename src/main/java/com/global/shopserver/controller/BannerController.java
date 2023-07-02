package com.global.shopserver.controller;

import com.global.shopserver.dto.BannerDTO;
import com.global.shopserver.dto.BannerDeleteDTO;
import com.global.shopserver.dto.BannerRegisterDTO;
import com.global.shopserver.dto.BannerUpdateDTO;
import com.global.shopserver.service.BannerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banner")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    // 배너 생성
    @PostMapping
    @ApiOperation(value = "새로운 배너 생성", notes = "이미지, 링크, 이름, 설명을 입력받아 새로운 배너를 생성합니다.")
    public ResponseEntity<Void> makeBanner(@Validated @RequestBody BannerRegisterDTO bannerRegisterDTO) {

        bannerService.makeBanner(bannerRegisterDTO);
        return ResponseEntity.ok().build();
    }

    // 배너 수정
    @PatchMapping("/update")
    @ApiOperation(value = "배너 수정", notes = "배너의 정보를 수정합니다.")
    public ResponseEntity<Void> updateBanner(@Validated @RequestBody BannerUpdateDTO bannerUpdateDTO) {

        bannerService.updateBanner(bannerUpdateDTO);
        return ResponseEntity.ok().build();
    }

    // 배너 삭제
    @PatchMapping("/delete")
    @ApiOperation(value = "배너 (논리적)삭제", notes = "논리적 삭제를 진행합니다.")
    public ResponseEntity<Void> deleteBanner(BannerDeleteDTO bannerDeleteDTO) {

        bannerService.deleteBanner(bannerDeleteDTO);
        return ResponseEntity.ok().build();
    }

    // 배너 리스트 반환
    @GetMapping("/list")
    @ApiOperation(value = "모든 배너 리스트 반환", notes = "모든 배너 리스트를 반환합니다.")
    public ResponseEntity<List<BannerDTO>> showBannerList() {

        return ResponseEntity.ok().body(bannerService.showBannerList());
    }

    // 특정 배너 반환
    @GetMapping("/{bannerId}")
    @ApiOperation(value = "특정 배너 정보 반환", notes = "특정 배너의 정보를 반환합니다.")
    @ApiImplicitParam(
            name = "bannerId"
            , value = "배너 id(Primary Key)"
            , required = true
            , dataType = "Long"
            , paramType = "path"
            , defaultValue = "None"
            , example = "1")
    public ResponseEntity<BannerDTO> showBanner(@PathVariable String bannerId) {

        return ResponseEntity.ok().body(bannerService.showBanner(bannerId));
    }
}
