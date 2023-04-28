package static_;

public class Test4 {

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
		Road north = new Road(new int[] {70, 80, 60, 20, 30, 50, 10, 80, 77, 89});
		Road south = new Road(70, 60, 40, 50, 55, 65, 23, 44, 37, 88);
		north.roadInfo();
		south.roadInfo();
		System.out.println(north.sum(0, 2) + south.sum(2, 9));
		
//		Bridge b1 = new Bridge(2);
//		Bridge b2 = new Bridge(4);
//		Bridge b3 = new Bridge(6);
		
//		b1.total = north.sum(0, b1.index) + south.sum(b1.index, south.arr.length - 1);
//		b2.total = north.sum(0, 4) + south.sum(4, 9);
//		b3.total = north.sum(0, 6) + south.sum(6, 9);
		
//		int[] arr = {1, 2, 3};
//		Bridge[] bridges = {b1, b2, b3};
		
//		for(int i = 0; i < bridges.length; i++) {
//			Bridge b = bridges[i];
//			b.total = north.sum(0, b.index) + south.sum(b.index, south.arr.length - 1);
////			bridges[i].total = north.sum(0, bridges[i].index) + south.sum(bridges[i].index, south.arr.length - 1);
//		}
		
		Bridge[] bridges = {new Bridge(2), new Bridge(4), new Bridge(6)};
		
		for(Bridge b : bridges) {
			b.total = north.sum(0, b.index) + south.sum(b.index, south.arr.length - 1);
		}
		
//		b1.bridgeInfo();
//		b2.bridgeInfo();
//		b3.bridgeInfo();
		
//		Bridge min = b1.min(bridges);
//		b2.min(bridges);
		
		Bridge minBridge = Bridge.min(bridges);
		minBridge.bridgeInfo();
	}
}

class Bridge {
	int index;
	int total;
	
	public Bridge(int index) {
		this.index = index;
	}
	
	public void bridgeInfo() {
		System.out.println("다리번호: " + index);
		System.out.println("총시간: " + total);
	}
	
	// 다리배열(Bridge[])을 전달받아 total 값이 가장낮은 다리(Bridge)를 리턴하는 메서드 작성
	public static Bridge min(Bridge[] arr) {
		Bridge min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(min.total > arr[i].total) {
				min = arr[i];
			}
		}
		return min;
	}
	
}

class Road {
	int[] arr;
//	public Road(int[] arr) {
//		this.arr = arr;
//	}
	
	public Road(int...nums) {
		this.arr = nums;
	}
	
	public void roadInfo() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public int sum(int startIndex, int endIndex) {
		int sum = 0;
		for(int i = startIndex; i <= endIndex; i++) {
			sum += arr[i];
		}
		return sum;
	}
}






