package com.global.shopserver.error;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@Getter
@Setter
public class ErrorResponse {
    private String timeStamp; // 에러 일시
    private String code; // 에러 코드 (http status code)
    private String message; // 에러 메시지

    public ErrorResponse(String code, String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        this.code = code;
        this.message = message;
        this.timeStamp = formatter.format(Calendar.getInstance().getTime());
    }
}
