/* (Approximate pi) pi can be computed using the following formula:*/

public class Exercise_01_07 {
	public static void main(String[] args) {
		System.out.println("              1   1   1   1   1");
		System.out.println(" Pi = 4 x (1 - - + - - - + - - -  = " + (4 * (1.0 - (1.0 / 3) + (1.0 / 5) + (1.0 / 7) + (1.0 / 9) + (1.0 / 11))));
		System.out.println("              3   5   7   9   11");
		System.out.println();
		System.out.println("              1   1   1   1   1    1");
		System.out.println(" Pi = 4 x (1 - - + - - - + - - - + -  = " + (4 * (1.0 - (1.0 / 3) + (1.0 / 5) + (1.0 / 7) + (1.0 / 9) + (1.0 / 11) + (1.0 / 13))));
		System.out.println("              3   5   7   9   11   13");
	}
}
