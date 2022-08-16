import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    //*1.AMAZON:COM GIT
    //2. Arama kutusuna "baby stroller" yazdir
    //3.2. siradaki ürünü tiklayiniz
    //4. ürün sayfasina gittiketn sonra , ürünün toplam fiyatini alacagiz
    //5. Ürünün ortalama puanini (bes üzerin den ) alacagiz

    WebDriver driver;

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://Amazon.com");
       // driver.navigate().to("http://Amazon.com");
        //WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("baby stroller"+ Keys.ENTER);
        //WebElement ikinciSiradakiUrun = driver.findElement(By.xpath("(//a[@class='a-link-normal s-link-style a-text-normal'])[2]"));
        //ikinciSiradakiUrun.click();
        // Merhabayin

        driver.navigate().to("http://google.com");
        WebElement googleAramaKutusu = driver.findElement(By.name("q"));
        googleAramaKutusu.sendKeys("Gürkan türkkani");
        googleAramaKutusu.submit();







    }


}
