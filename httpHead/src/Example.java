
public class Example {
	static int ONE = 1;
	
	public static void main(String[] args) {
		int num =1;
		search:
			while(num<99999){
				num += 1;
				for (int i = 2; i <=Math.sqrt(num); i++) {
					if (num % i == 0) {
						continue search;
					}
				}
				System.out.print(num+",");
			}
	}
}
