/* (Population projection) The U.S. Census Bureau projects population based on the following assumptions:
                                  One birth every 7 seconds
                                  One death every 13 seconds
                                  One new immigrant every 45 seconds
Write a program to display the population for each of the next five years. Assume the current population is 312,032,486 and one year has 365 days. Hint: In Java, if two integers perform division, the result is an integer. The fractional part is truncated. For example, 5 / 4 is 1 (not 1.25 ) and 10 / 4 is 2 (not 2.5 ). To get an accurate result with the fractional part, one of the values involved in the division must be a number with a decimal point. For example, 5.0 / 4 is 1.25 and 10 / 4.0 is 2.5 .
*/

public class Exercise_01_11 {
	public static void main(String[] args) {
		int birth = 7;
  		int death = 13;
  		int immigrant = 45;
  		int currentPopulation = 312032486;
  		int year = 365;
  		int yearBirths = (((60 * 60 * 24 * year) / birth));
  		int yearDeaths = (((60 * 60 * 24 * year) / death));
 		int yearImmigrants = (((60 * 60 * 24 * year) / immigrant));
 	 	int yearPopulation = (yearBirths + yearImmigrants - yearDeaths);

		System.out.println("Current Year Population = " + currentPopulation);
  		System.out.println("Next Year's Population = " + (currentPopulation + yearPopulation));
		System.out.println("Next Second Year's Population = " + (currentPopulation + (yearPopulation * 2)));
		System.out.println("Next Third Year's Population = " + (currentPopulation + (yearPopulation * 3)));
		System.out.println("Next Forth Year's Population = " + (currentPopulation + (yearPopulation * 4)));
		System.out.println("Next Fifth Year's Population = " + (currentPopulation + (yearPopulation * 5)));
	}
}
