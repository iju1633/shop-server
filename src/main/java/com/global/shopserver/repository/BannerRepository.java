package com.global.shopserver.repository;

import com.global.shopserver.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findBannerById(Long bannerId); // id 값으로 엔티티 찾음

    List<Banner> findAllByImageUrl(String imageUrl); // 논리적 삭제를 하므로 중복(image url)될 수 있기에 list를 반환 (등록과 수정에 사용)
}
