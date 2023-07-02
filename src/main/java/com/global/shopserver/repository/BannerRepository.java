package com.global.shopserver.repository;

import com.global.shopserver.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findBannerById(Long bannerId); // id 값으로 엔티티 찾음

    Banner findBannerByImageUrlOrIntroduction(String imageUrl, String introduction); // unique 함을 가지는 필드로 엔티티 찾음
}
