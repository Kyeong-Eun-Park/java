package com.example.and0605_volley_gson;
/*
JSON 객체의 각 파라미터에 해당하는 멤버변수를 선언하고
파싱된 데이터를 저장하는 용도의 클래스 = DTO(JavaBean) 클래스 역할
주의! JSON 객체의 파라미터 이름과 변수명 참조
http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101
 */
public class Movie {
    String rnum;
    String rank;
    String rankInten;
    String rankOldAndNew;
    String movieCd;
    String movieNm;
    String openDt;
    String salesAmt;
    String salesShare;
    String salesInten;
    String salesChange;
    String salesAcc;
    String audiCnt;
    String audiInten;
    String audiChange;
    String audiAcc;
    String scrnCnt;
    String showCnt;
}
