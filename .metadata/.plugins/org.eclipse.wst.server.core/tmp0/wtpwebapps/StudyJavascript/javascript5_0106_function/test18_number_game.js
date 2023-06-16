/**
 * 정수 입력받아 Up/Down 판별을 통해 정답을 맞추는 게임을 numberGame() 함수로 구현
 */
function numberGame() {
	let correctNum = 10; // 정답
	let count = 0; // 입력 횟수를 카운팅 할 변수(입력받을 때마다 1씩 증가)
	
	while(true) { // while 무한루프(주로 사용) (for(;;) {} // for 무한루프)
		// 1개의 정수를 입력받아 변수에 저장 => 반복
		let num = prompt("정수 1개를 입력하세요");
		
		// 입력받은 횟수 카운팅하기 위해 카운트 변수값 1 증가
		count++;
		
		// 정답 판별
		if(num < correctNum) { // 입력값이 정답보다 작을 경우
			alert(num + " : 정답보다 작습니다!");
		} else if(num > correctNum) { // 입력값이 정답보다 클 경우
			alert(num + " : 정답보다 큽니다!");
		} else { // 정답일 경우
			alert(num + " : 정답입니다!");
			// 반복문을 종료하기 위해(= while 문을 빠져나가기 위해)
			// 특정 조건에서 break 문을 수행
			break; // 현재 작업중인 블록(반복문)을 빠져나감
		}
		
	}
	
	// 최종 횟수 출력
	document.write(count + "번만에 정답입니다!");
}


