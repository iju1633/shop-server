package com.global.shopserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "banner")
public class Banner extends BaseTimeEntity { // 배너 entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유한 id

    private String imageUrl; // 이미지 url
    private String link; // 배너 클릭 시 이동할 url
    private String introduction; // 배너에 들어갈 문구 혹은 소개 문구
    private char deleted; // 논리 삭제 여부: 'Y'이면 삭제
}
