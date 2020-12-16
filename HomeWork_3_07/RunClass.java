package HomeWork_3_07;

import HomeWork_3_07.Annotations.AfterSuite;
import HomeWork_3_07.Annotations.BeforeSuite;
import HomeWork_3_07.Annotations.Test;

public class RunClass {

    @Test
    private void firstTest() { System.out.println(" FIRST TEST "); }

    @AfterSuite
    private void afterSuite()  { System.out.println(" AFTER "); }

    @BeforeSuite
    private void beforeTest() { System.out.println(" BEFORE "); }

    @Test(priority = 2)
    private void secondTest() { System.out.println(" SECOND  TEST "); }

    @Test(priority = 9)
    private void ninthTest() { System.out.println(" NINTH TEST "); }

    @Test(priority = 3)
    private void thirdTest() { System.out.println(" THIRD TEST "); }

    @Test(priority = 5)
    private void fifthTest() { System.out.println(" FIFTH TEST "); }

}
