package com.itwillbs.fintech.vo;

import java.sql.Date;

import lombok.Data;
/*
 CREATE TABLE member (
 		idx INT PRIMARY KEY AUTO_INCREMENT,
  		name VARCHAR(20) NOT NULL,
  		id VARCHAR(16) UNIQUE NOT NULL,
  		passwd VARCHAR(100) NOT NULL,
  		email VARCHAR(50) UNIQUE NOT NULL,
  		gender VARCHAR(1) NOT NULL,
  		date DATE NOT NULL,
  		auth_status CHAR(1) NOT NULL,
  		account_auth_status CHAR(1) NOT NULL
 );
 */
@Data
public class MemberVO {
	private int idx;
	private String name;
	private String id;
	private String passwd;
	private String email;
	// -----------------------------------
	// 분리된 이메일 처리를 위한 변수 추가
	private String email1;
	private String email2;
	// -----------------------------------
	private String gender;
	private Date date;
	private String auth_status;
	private String account_auth_status; // 계좌인증 여부("N", "Y")
	
}













