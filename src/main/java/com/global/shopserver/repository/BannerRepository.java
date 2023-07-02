package com.global.shopserver.repository;

import com.global.shopserver.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findBannerById(Long bannerId);
    Banner findBannerByImageUrlOrIntroduction(String imageUrl, String introduction);
}
