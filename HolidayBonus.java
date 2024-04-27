/*
 * Class: CMSC203 CRN: 30340
 * Instructor: Professor Khandan 
 * 
 * Description: 
 * 
	HolidayBonus:
	This class calculates holiday bonuses for stores based on their sales data in each category.
	It utilizes methods from the TwoDimRaggedArrayUtility class to perform calculations on the sales data.
	The class defines methods to calculate individual store bonuses and the total holiday bonus for the district based on specific bonus amounts for highest, lowest, and other stores in each category.
	It serves the purpose of computing holiday bonuses efficiently and accurately for retail district #5 based on sales performance.
*

 * Due: 4/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
*  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Dave| Dawit Hailu
*/
public class HolidayBonus {

	
	

		// Constant values of bonus amounts
		private static final double HIGHEST_BONUS_AMOUNT = 5000.0;
		private static final double LOWEST_BONUS_AMOUNT = 1000.0;
		private static final double OTHER_BONUS_AMOUNT = 2000.0;
	
		/**
		 * Calculates the holiday bonus for each store based on their sales in each category.
		 * 
		 * @param data A two-dimensional ragged array of doubles representing the sales for each store in each category.
		 * @return An array of doubles representing the holiday bonuses for each store.
		 */
		public static double[] calculateHolidayBonus(double[][] data) {
			double[] bonuses = new double[data.length];
	
			for (int category = 0; category < data[0].length; category++) {
				double[] categorySales = TwoDimRaggedArrayUtility.getColumn(data, category);
				int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, category);
				int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, category);
	
				if (highestIndex == lowestIndex) {
					bonuses[highestIndex] += HIGHEST_BONUS_AMOUNT;
				} else {
					bonuses[highestIndex] += HIGHEST_BONUS_AMOUNT;
					bonuses[lowestIndex] += LOWEST_BONUS_AMOUNT;
					for (int store = 0; store < data.length; store++) {
						if (store != highestIndex && store != lowestIndex && categorySales[store] > 0) {
							bonuses[store] += OTHER_BONUS_AMOUNT;
						}
					}
				}
			}
	
			return bonuses;
		}
	
		/**
		 * Calculates the total holiday bonuses for the district.
		 * 
		 * @param data A two-dimensional ragged array of doubles representing the sales for each store in each category.
		 * @return The total of all holiday bonuses.
		 */
		public static double calculateTotalHolidayBonus(double[][] data) {
			double[] storeBonuses = calculateHolidayBonus(data);
			double totalBonus = 0.0;
			for (double bonus : storeBonuses) {
				totalBonus += bonus;
			}
			return totalBonus;
		}
	
	
	
	
	}

