package com.itwillbs.fintech.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.fintech.service.BankApiService;
import com.itwillbs.fintech.service.BankService;
import com.itwillbs.fintech.vo.ResponseTokenVO;

@Controller
public class BankController {
	@Autowired
	private BankApiService apiService;
	
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@GetMapping("/callback")
	public String responseAuthCode(@RequestParam Map<String, String> authResponse) {
		logger.info(authResponse.toString());
		
		// 토큰 발급 요청(REST 방식 = REST API 활용)
		// BankApiService - requestToken() 메서드를 호출하여 엑세스 토큰 발급 요청
		// => 파라미터 : 사용자 인증을 통해 전달받은 정보(Map 객체)
		// => 리턴타입 : 응답되는 엑세스토큰 관련 정보를 관리할 ResponseTokenVO 타입
		ResponseTokenVO responseToken = apiService.requestToken(authResponse);
		logger.info("★★★★★ Access Token : " + responseToken.toString());
		
		return "";
	}
}














