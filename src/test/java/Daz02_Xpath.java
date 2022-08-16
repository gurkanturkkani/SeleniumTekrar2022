import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Daz02_Xpath {
    static  WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();// driveri kullanilabvilir hale getirdik
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1() {

        driver.get("http://a.testaddressbook.com");
        //<a id="sign-in" class="nav-item nav-link" data-test="sign-in"
        //  href="/sign_in">Sign in</a>
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        // soru cikan sayfadaki tüm linkleri bulan kodu yaz
        // ip uclari: 1- tagName si a olan webElementleri linktir
        //            2- Bir sayfada ki tüm webElementleri bulmak istiyorsaniz , findElements kullanmalisiniz

        try {
            Thread.sleep(2000);

        } catch (InterruptedException ignored) {

        }
        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
        for (WebElement w : tumLinkler) {
            System.out.println(w.getText());
        }
        // ZENI HEDEF: Possort ve IM kutucuklarini sening kullanarak SCS selöktör ile bulun.
        // ve kutulara yazdirin..
        //<input type="email" class="form-control" placeholder="Email"
        // data-test="email" name="session[email]" id="session_email">
        WebElement kullaniciAdi = driver.findElement(By.cssSelector(".form-control"));
        kullaniciAdi.sendKeys("testtechproed@gmail.com");
        //<input class="form-control" placeholder="Password" data-test="password"
        // type="password" name="session[password]" id="session_password">

        WebElement sifre =driver.findElement(By.cssSelector("#session_password"));
        sifre.sendKeys("Test1234");

        //<input type="submit" name="commit" value="Sign in" class="btn btn-primary"
        //  data-test="submit" data-disable-with="Sign in">

        WebElement singIn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        singIn.click();

        // YENI SORU,
        // acilan sayfadaa ki tüm yazilari gösterinnnn
        // ip ucu:: findElements Byxpath("//*")

        List<WebElement> tumElementler = driver.findElements(By.xpath("//*"));
        for (WebElement w : tumElementler){
            System.out.println(w.getText());

        }

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
