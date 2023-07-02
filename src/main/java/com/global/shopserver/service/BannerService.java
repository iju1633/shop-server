package com.global.shopserver.service;

import com.global.shopserver.dto.BannerDTO;
import com.global.shopserver.dto.BannerDeleteDTO;
import com.global.shopserver.dto.BannerRegisterDTO;
import com.global.shopserver.dto.BannerUpdateDTO;
import com.global.shopserver.entity.Banner;
import com.global.shopserver.repository.BannerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerService {

    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    // 배너 등록
    @Transactional
    public void makeBanner(BannerRegisterDTO bannerRegisterDTO) {

        // 이미 등록된 배너인지 검사 (배너 이미지이나 설명이 같은 것이 있다면 이미 등록된 배너라고 판단, 배너 클릭 시 이동하는 링크는 중복 가능)
        Banner banner = bannerRepository.findBannerByImageUrlOrIntroduction(bannerRegisterDTO.getImageUrl(), bannerRegisterDTO.getIntroduction());
        if (banner != null) {
            throw new IllegalArgumentException("이미 등록된 배너입니다.");
        }

        // 새로운 배너 등록
        Banner newBanner = Banner.builder()
                .imageUrl(bannerRegisterDTO.getImageUrl())
                .link(bannerRegisterDTO.getLink())
                .introduction(bannerRegisterDTO.getIntroduction())
                .build();

        // 배너 저장
        bannerRepository.save(newBanner);
    }

    // 배너 수정
    @Transactional
    public void updateBanner(BannerUpdateDTO bannerUpdateDTO) {

        Banner banner = bannerRepository.findBannerById((long) bannerUpdateDTO.getBannerId());

        // 수정할 배너가 존재하지 않는 경우
        if (banner == null) {
            throw new IllegalArgumentException("수정할 배너가 존재하지 않습니다.");
        }

        // 수정할 배너가 이미 삭제된 경우
        if (banner.getDeleted() == 'Y') {
            throw new IllegalArgumentException("이미 삭제된 배너입니다.");
        }

        // 배너 정보 수정
        banner.setImageUrl(bannerUpdateDTO.getNewImageUrl());
        banner.setLink(bannerUpdateDTO.getNewLink());
        banner.setIntroduction(bannerUpdateDTO.getNewIntroduction());

        // 배너 갱신
        bannerRepository.save(banner);
    }

    // 배너 (논리적) 삭제
    @Transactional
    public void deleteBanner(BannerDeleteDTO bannerDeleteDTO) {

        Banner banner = bannerRepository.findBannerById((long) bannerDeleteDTO.getBannerId());

        // 수정할 배너가 존재하지 않는 경우
        if (banner == null) {
            throw new IllegalArgumentException("삭제할 배너가 존재하지 않습니다.");
        }

        // 이미 삭제된 배너인 경우
        if (banner.getDeleted() == 'Y') {
            throw new IllegalArgumentException("이미 삭제된 배너입니다.");
        }

        // 논리적 삭제
        banner.setDeleted('Y');
        bannerRepository.save(banner);
    }

    // 배너 리스트 반환
    public List<BannerDTO> showBannerList() {

        List<BannerDTO> bannerDTOList = new ArrayList<>();

        // entity는 dto로 변경
        for (Banner banner : bannerRepository.findAll()) {

            BannerDTO bannerDTO = BannerDTO.from(banner);
            bannerDTOList.add(bannerDTO);
        }

        return bannerDTOList;
    }

    // 특정 배너 반환
    public BannerDTO showBanner(String bannerId) {

        Banner banner = bannerRepository.findBannerById(Long.valueOf(bannerId));

        // 배너가 존재하지 않는 경우
        if (banner == null) {
            throw new IllegalArgumentException("배너가 존재하지 않습니다.");
        }

        // 삭제된 배너인 경우
        if (banner.getDeleted() == 'Y') {
            throw new IllegalArgumentException("삭제된 배너입니다.");
        }

        // 배너 반환
        return BannerDTO.from(banner);
    }
}
