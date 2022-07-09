package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * FileName : HelloResponseDto
 * Created By PARKPRO on 2022-07-09(토)
 * Version : 0.1
 *
 * 스프링부트에서 테스트코드 작성하기 - 2.4 HelloController 코드를 Lombok으로 리팩토링하기
 */

@Getter //선언된 모든 필드의 Getter() 생성
@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
