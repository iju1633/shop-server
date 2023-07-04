package com.global.shopserver.service;

import com.global.shopserver.dto.BannerDTO;
import com.global.shopserver.dto.BannerDeleteDTO;
import com.global.shopserver.dto.BannerRegisterDTO;
import com.global.shopserver.dto.BannerUpdateDTO;
import com.global.shopserver.entity.Banner;
import com.global.shopserver.repository.BannerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class BannerServiceTest { // BannerService의 메서드 별 테스트 진행
    @Mock
    BannerRepository bannerRepository;
    @InjectMocks
    BannerService bannerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMakeBanner() {

        // when
        when(bannerRepository.findBannerByImageUrlOrIntroduction(anyString(), anyString())).thenReturn(new Banner(1L, "imageUrl", "link", "introduction", 'N'));

        // then
        bannerService.makeBanner(new BannerRegisterDTO());
    }

    @Test
    void testUpdateBanner() {

        // when
        when(bannerRepository.findBannerById(anyLong())).thenReturn(new Banner(1L, "imageUrl", "link", "introduction", 'N'));
        when(bannerRepository.findBannerByImageUrlOrIntroduction(anyString(), anyString())).thenReturn(new Banner(1L, "imageUrl", "link", "introduction", 'N'));

        // then
        bannerService.updateBanner(new BannerUpdateDTO());
    }

    @Test
    void testDeleteBanner() {

        // when
        when(bannerRepository.findBannerById(anyLong())).thenReturn(new Banner(1L, "imageUrl", "link", "introduction", 'N'));

        // then
        bannerService.deleteBanner(new BannerDeleteDTO());
    }

    @Test
    void testShowBannerList() {

        // given
        List<BannerDTO> result = bannerService.showBannerList();

        // then
        Assertions.assertNotNull(result);
    }

    @Test
    void testShowBanner() {

        // when
        when(bannerRepository.findBannerById(anyLong())).thenReturn(new Banner(1L, "imageUrl", "link", "introduction", 'N'));

        // then
        BannerDTO result = bannerService.showBanner("1");
        Assertions.assertNotNull(result);
    }
}