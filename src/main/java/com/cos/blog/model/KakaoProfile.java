package com.cos.blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoProfile {
    @JsonProperty("id")
    private String id;

    private String username;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    // KakaoAccount 클래스도 정의해야 할 수 있습니다.
    @Data
    public class KakaoAccount {
        @JsonProperty("profile_nickname")
        private String profileNickname;

        @JsonProperty("profile_image_url")
        private String profileImageUrl;

        // 기타 필요한 계정 정보 변수 및 getter/setter 메서드를 추가합니다.
    }
}






