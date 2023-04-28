package enum_;

enum PayType {
	// ------ CASH -------
	ACCOUNT_TRANSFER("계좌이체"),
	REMITTANCE("무통장입금"),
	ON_SITE_PAYMENT("현장결제"),
	TOSS("토스"),
	
	// ------ CARD -------
	PAYCO("페이코"),
	CARD("신용카드"),
	KAKAO_PAY("카카오페이"),
	BEMIN_PAY("배민페이"),
	NAVER_PAY("네이버페이"),
	
	// ------ ETC -------
	POINT("포인트"),
	COUPON("쿠폰");
	
	String title;
	private PayType(String title) {
		this.title = title;
	}
}

enum PayGroup {
	CASH("현금", new PayType[] {PayType.ACCOUNT_TRANSFER, 
							   PayType.REMITTANCE, 
							   PayType.ON_SITE_PAYMENT, 
							   PayType.TOSS}),
	
	CARD("카드", new PayType[] {PayType.PAYCO, 
							   PayType.CARD, 
							   PayType.KAKAO_PAY, 
							   PayType.BEMIN_PAY,
							   PayType.NAVER_PAY}),
	
	ETC("기타", new PayType[] {PayType.POINT, PayType.COUPON}),
	EMPTY("없음", new PayType[] {});
	
	String title;
	PayType[] payTypes;
	
	private PayGroup(String title, PayType[] payTypes) {
		this.title = title;
		this.payTypes = payTypes;
	}
	
	public static PayGroup findByPayType(String data) {
		
		for(PayGroup pg : PayGroup.values()) {
			for(PayType pt : pg.payTypes) { 
				if(pt.title.equals(data))	return pg;
			}
		}
		
		return EMPTY;
	}
	
}

public class Ex3 {

	public static void main(String[] args) {

		String data = "네이버페이";
		
		PayGroup pg = PayGroup.findByPayType(data);
		
		switch(pg) {
		case CASH : System.out.println("현금 결재 로직으로 이동"); break;
		case CARD : System.out.println("카드 결재 로직으로 이동"); break;
		case ETC : System.out.println("기타 결재 로직으로 이동"); break;
		case EMPTY: 
			System.out.println("존재하지 않는 결재 코드 입니다.");
			System.out.println("에러 처리 로직으로 이동");
			break;
		}
	}
}
