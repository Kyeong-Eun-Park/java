package com.itwillbs.fintech.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;

/*
 mvc_board3.board 테이블 생성
 ------------------------------------
 글번호(board_num) : 정수, PK
 작성자(board_name) : 문자 20글자, NN
 제목(board_subject) : 문자 50글자, NN
 내용(board_content) : 문자 2000글자, NN
 파일명(board_file) : 문자 200글자, NN
 업로드경로(board_file_path) : 문자 50글자, NN
 참조글번호(board_re_ref) : 정수, NN
 들여쓰기레벨(board_re_lev) : 정수, NN
 순서번호(board_re_seq) : 정수, NN
 조회수(board_readcount) : 정수, NN
 작성일(board_date) : 날짜 및 시각(DATETIME), NN
 --------------------------------------
 CREATE TABLE board (
	board_num INT PRIMARY KEY,
	board_name VARCHAR(20) NOT NULL,
	board_subject VARCHAR(50) NOT NULL,
	board_content VARCHAR(2000) NOT NULL,
	board_file VARCHAR(200) NOT NULL,
	board_file_path VARCHAR(50) NOT NULL,
	board_re_ref INT NOT NULL,
	board_re_lev INT NOT NULL,
	board_re_seq INT NOT NULL,
	board_readcount INT NOT NULL,
	board_date DATETIME
 );
 */
@Data
public class BoardVO {
	// board 테이블의 각 컬럼에 대응하는 멤버변수 선언 및 Getter/Setter 정의
	private int board_num;
	private String board_name;
	private String board_subject;
	private String board_content;
	private String board_file; // 파일명
	private String board_file_path; // 파일 업로드 경로
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private int board_readcount;
	private Timestamp board_date; // java.sql.TimeStamp(날짜 및 시각 관리)
	// MultipartFile 타입 객체를 통한 파일 업로드 처리를 위해 MultipartFile 타입 변수 선언
	// => 반드시 <input type="file"> 태그의 name 속성과 변수명이 일치해야한다!
	private MultipartFile file;
	// 만약, 복수개의 파일 업로드 시 MultipartFile 타입 배열로 선언
//	private MultipartFile[] files;
	
	
}









