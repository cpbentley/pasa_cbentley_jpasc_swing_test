package pasa.cbentley.jpasc.swing.utils.tests;

import pasa.cbentley.jpasc.swing.tests.TestJPascSwingAbstract;
import pasa.cbentley.jpasc.swing.utils.PascalSwingUtils;

public class TestPascalSwingUtils extends TestJPascSwingAbstract {

   private PascalSwingUtils psu;

   public void setupAbstract() {
      setUpNoConnection();
      psu = psc.getPascalSwingUtils();
   }

   public void testBlockAge() {

      assertEquals(sc.getResString("text.blockfuture"), psu.computeTimeFromBlockAge(-1));
      assertEquals(sc.getResString("text.blocknow"), psu.computeTimeFromBlockAge(0));
      assertEquals("5 minutes ago", psu.computeTimeFromBlockAge(1));
      assertEquals("10 minutes ago", psu.computeTimeFromBlockAge(2));
      assertEquals("15 minutes ago", psu.computeTimeFromBlockAge(3));
      assertEquals("20 minutes ago", psu.computeTimeFromBlockAge(4));
      assertEquals("25 minutes ago", psu.computeTimeFromBlockAge(5));
      assertEquals("30 minutes ago", psu.computeTimeFromBlockAge(6));
      assertEquals("35 minutes ago", psu.computeTimeFromBlockAge(7));
      assertEquals("40 minutes ago", psu.computeTimeFromBlockAge(8));
      assertEquals("45 minutes ago", psu.computeTimeFromBlockAge(9));
      assertEquals("50 minutes ago", psu.computeTimeFromBlockAge(10));
      assertEquals("55 minutes ago", psu.computeTimeFromBlockAge(11));
     
      assertEquals("1 hour ago", psu.computeTimeFromBlockAge(12));
      assertEquals("1 hour ago", psu.computeTimeFromBlockAge(13));
      
      assertEquals("2 hours ago", psu.computeTimeFromBlockAge(24));
      assertEquals("2 hours ago", psu.computeTimeFromBlockAge(25));

      assertEquals("4 hours ago", psu.computeTimeFromBlockAge(48));
      assertEquals("4 hours ago", psu.computeTimeFromBlockAge(49));

      assertEquals("8 hours ago", psu.computeTimeFromBlockAge(96));
      assertEquals("16 hours ago", psu.computeTimeFromBlockAge(192));

      assertEquals("18 hours ago", psu.computeTimeFromBlockAge(216));

      assertEquals("20 hours ago", psu.computeTimeFromBlockAge(240));


      assertEquals("1 day ago", psu.computeTimeFromBlockAge(288));
      
      assertEquals("2 days ago", psu.computeTimeFromBlockAge(600));

      
      assertEquals("3 days ago", psu.computeTimeFromBlockAge(1000));

      assertEquals("5 months ago", psu.computeTimeFromBlockAge(50000));

      assertEquals("1 year ago", psu.computeTimeFromBlockAge(120000));
      
      assertEquals("1 year and 8 months ago", psu.computeTimeFromBlockAge(180000));
      
      assertEquals("1 year and 10 months ago", psu.computeTimeFromBlockAge(200000));
      assertEquals("2 years ago", psu.computeTimeFromBlockAge(220000));
      assertEquals("2 years and 4 months ago", psu.computeTimeFromBlockAge(250000));
      assertEquals("2 years and 9 months ago", psu.computeTimeFromBlockAge(300000));
      assertEquals("3 years and 6 months ago", psu.computeTimeFromBlockAge(380000));


      
   }
}
