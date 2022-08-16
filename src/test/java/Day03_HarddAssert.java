import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HarddAssert {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        // driveri kullanilabvilir hale getirdik
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    @Test
    public void test(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        if(baslik.contains("car")){
            System.out.println("Geciyor : "+baslik);
        }else {
            System.out.println("Gecmiyot : "+baslik);
        }
        boolean iceriyormu = baslik.contains("car");
        Assert.assertTrue(iceriyormu);
    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        //sayfa basliginda google kelimesinin gememesi durumunu kontrol ediyoruz
        //google kelimesi yoksa test basarili
        // goole kelimesi varsa test basarisiz
        boolean iceriyormu = baslik.contains("Google");
        Assert.assertFalse(iceriyormu);
    }
    @Test
    public void test3() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        Assert.assertEquals("Amazon.com",baslik);

    }
    @Test
    public void softAssertTest(){
        driver.get("http://amazon.com");
        // softun hard dan farklari: softa nesne üretmek zorundayiz ve test fail olsa bile calismaya devam eder .
        // bundan dolayi cok tercih edilmez

    }




}
