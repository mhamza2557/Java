/* (Area and perimeter of a circle) Write a program that displays the area and perimeter of a circle that has a radius of 5.5 using the following formula:
                        perimeter = 2 * radius * pi
                        area = radius * radius * pi
*/

public class Exercise_01_08 {
	public static void main(String[] args) {
		double radius = 5.5;
		double pi = 3.14159265359;
		double perimeter = 2 * radius * pi;
		double area = radius * radius * pi;
		System.out.println("Perimeter of a circle = " + perimeter);
		System.out.println("Area of a circle  = " + area);
		
	}
}
