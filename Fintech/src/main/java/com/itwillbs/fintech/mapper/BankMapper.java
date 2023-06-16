package com.itwillbs.fintech.mapper;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.fintech.vo.AccountVO;
import com.itwillbs.fintech.vo.ResponseTokenVO;

public interface BankMapper {
	
	// 토큰 정보 저장
	int insertToken(@Param("id") String id, @Param("token") ResponseTokenVO responseToken);

	// 계좌 인증 상태 변경
	int updateAccountAuthStatus(String id);

	// 계좌 정보 조회
	AccountVO selectAccount(String id);

}
