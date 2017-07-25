package face.api.utils;

import java.util.Random;

/**
 * 得分常量池
 * 
 * @author xh
 *
 */
public class NumberUtils {
	public static void main(String[] args) {

		System.out.println(new Random().nextInt(100 - (60) + 1) + (60));
	}

	private static Integer max = 99;

	private static Integer min = 61;

	private static Integer one = 0;

	private static Integer two = 0;

	private static Integer three = 0;

	private static Integer oneMax = 3;

	private static Integer twoMax = 5;

	private static Integer threeMax = 10;

	public static Integer carteNumber() {
		Integer number = new Random().nextInt(max - (min) + 1) + (min);
		if (number >= 90 && number <= 99) {
			if (one != oneMax) {
				one++;
			} else {
				number = 89;
			}
		} else if (number >= 80 && number <= 89) {
			if (two != twoMax) {
				two++;
			} else {
				number = 79;
			}
		} else if (number >= 70 && number <= 79) {
			if (three != threeMax) {
				three++;
			} else {
				number = 69;
			}
		}

		return number;
	}
}
