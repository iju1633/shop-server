package com.global.shopserver.repository;

import com.global.shopserver.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findBannerById(Long bannerId);
    Banner findBannerByImageUrlOrIntroduction(String imageUrl, String introduction);
}
