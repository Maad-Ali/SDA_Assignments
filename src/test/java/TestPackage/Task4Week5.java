package TestPackage;


import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class Task4Week5 extends TestBase {
      /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */

  @Test
    public void CookiesTest(){

      driver.navigate().to("http://facebook.com");
   // getCookies
    driver.manage().getCookies();
    //addCookie,
    driver.manage().addCookie(new Cookie("new", "Maad"));
    //deleteCookieNamed
    driver.manage().deleteCookieNamed("new");
    //deleteAllCookies
    driver.manage().deleteAllCookies();

  }

}
