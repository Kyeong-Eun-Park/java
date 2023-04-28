
public class Test2 {

	public static void main(String[] args) {
//		도로 교통상황이 숫자로 주어진다.
		
//		출발 70 80 60 20 30 50 10 80 77 89
//			      ||    ||    ||
//		    70 60 40 50 55 65 23 44 37 88 도착
		
//		북쪽도로에서 남쪽도로로 건널수 있는 다리는 index번호로 주어진다.
//		이때, 가장 최소 시간이 소요되는 다리는 몇번 다리인지 출력하고 최소시간을 함께 출력해보자!
		
//		출력 예시) 다리번호: 6
//				 최소시간: 512
		
//		주의사항.
//		1. 무조건 다리를 1번 건너야함 (도착지점이 남쪽이기 때문에)
//		2. 다리를 여러번 건널수 없고 딱, 한번만 가능
//		3. 다리를 건널때에는 남쪽, 분쪽 소요시간이 같이 소요됨. (즉, 같이 합산해야함)
//		4. 소요시간이 같은 경우가 발생하면 낮은 다리번호를 출력
		
		int[] north = {70 ,80 ,60 ,20 ,30 ,50 ,10 ,80 ,77 ,89};	// 북쪽 도로
		int[] south = {70 ,60 ,40 ,50 ,55 ,65 ,23 ,44 ,37 ,88};	// 남쪽 도로
		
//		int[] north = {10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10};	// 북쪽 도로
//		int[] south = {10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10};	// 남쪽 도로
		
		int[] bridge = {2, 4, 6};
		int[] total = new int[bridge.length];
		
		for(int i = 0; i < bridge.length; i++) {
			total[i] = sum(north, south, bridge[i]);
		}
//		System.out.println(total[0] + " " + total[1] + " " + total[2]);
		// 최소값 구하기
		int min = total[0];
		int minIndex = 0;
		for(int i = 0; i < total.length; i++) {
			if(min > total[i]) {
				min = total[i];
				minIndex = i;
			}
		}
		System.out.println("다리번호: " + bridge[minIndex]);
		System.out.println("최소시간: " + min);
		
	} // main() 메서드 끝

	public static int sum(int[] north, int[] south, int bridgeNum) {
		int sum = 0;
		for(int i = 0; i <= bridgeNum; i++) {
			sum += north[i];
		}
		for(int i = bridgeNum; i < south.length; i++) {
			sum += south[i];
		}
		return sum;
	}
	
	
	
	
	
	
	
	
}
