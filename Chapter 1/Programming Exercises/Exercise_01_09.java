/* (Area and perimeter of a rectangle) Write a program that displays the area and perimeter of a rectangle with the width of 4.5 and height of 7.9 using the following
                               formula:-
                                        area = width * height
*/

public class Exercise_01_09 {
	public static void main(String[] args) {
		double height = 7.9;
		double width = 4.5;
		double area = height * width;
		double perimeter = 2 * (height + width);
		System.out.println("Area and perimeter of a rectangle");
		System.out.println("Area of a rectangle = " + area);
		System.out.println("perimeter of a rectangle = " + perimeter);
	}
}
