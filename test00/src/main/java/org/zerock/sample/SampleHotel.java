package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component // 빈에 등록 하는 역할
@ToString // tostring 
@Getter // getter  => @data -> get/set 둘다 만들어버림 
@RequiredArgsConstructor // @NonNull -> 붙은 변수에 대해서만 생성자 만든다.
//@AllArgsConstructor // 생성자를 만들어줌
public class SampleHotel {
	
	@NonNull // 
	private Chef chef;
	
	
}
