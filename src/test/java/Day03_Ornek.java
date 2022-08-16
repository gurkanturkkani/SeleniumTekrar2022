import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Ornek {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();// driveri kullanilabvilir hale getirdik
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //ÖDEV: 1-Dropdown da Books katagerosini secelim
             // 2- Arama kutusuna JAVA yazalim
             // 3- toplam sonuc sayisinin ekrana yazdir
             // 4- Ilk  sirada ki ürüne tiklayin
            //  5- Back to results linki varsa , testimiz True yoksa FALSE vermeli


    }
    @Test
    public void amazonDropdownTest(){
        driver.get("http://amazon.com");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);// burada Select klasini kullanarak bir nesne üretmis olduk
        // secili olan optionu (secimi) alabiliyoruz

        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();
        WebElement backToResultLinki = driver.findElement(By.partialLinkText("Back to results"));
        boolean varmi = backToResultLinki.isDisplayed();
        Assert.assertTrue(varmi);// TRUE gelirse testimiz dogru olacak



    }





}
