import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusStudentTest {

	private double[][] dataSet1 = { { 10, 20, 30 }, { 40, 50 }, { 60, 70, 80 } };

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	public void testCalculateHolidayBonusA() {
	    try {
	        double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
	        assertEquals(3000.0, result[0], .001);  // First store in first category
	        assertEquals(4000.0, result[1], .001);  // First store in second category
	        assertEquals(15000.0, result[2], .001); // First store in third category
	    } catch (Exception e) {
	        fail("This should not have caused an Exception");
	    }
	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
	    assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001); // Total of all categories
	}

}
