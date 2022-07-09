package com.jojoldu.book.springboot.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * FileName : HelloResponseDtoTest
 * Created By PARKPRO on 2022-07-09(토)
 * Version : 0.1
 */
public class HelloResponseDtoTest {
    
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;
        
        //when 
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        
        //then
        /* asserThat() : assertj라는 테스트 검증 라이브러리의 검증 메소드
            - 검증받고 싶은 대상을 parameter로 받음.
            - 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용가능
            
           isEqualTo() : assertj의 동등비교 메소드
            - assertThat(A).isEqualTo(B) : A와 B의 값을 비교하여 같으면 성공
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
