import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        // driveri kullanilabvilir hale getirdik
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdown1() {
        driver.get("http://amazon.com");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        // secili olan optionu (secimi) alabiliyoruz
        select.getFirstSelectedOption();
        // farkli bir secenek secmek istersek ?
        // üc farkli secenegimiz var
        // 1.: selectByVisibleText: secnegin görpnen yazisini kullanaraak secim yazmamizi sagliyor
        select.selectByVisibleText("Baby");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //2.: selectByIndext() sesecimin siralamda ki konumuna gore secim yapmamiza olarak salar
        select.selectByIndex(5);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //3. : selctByvalue : bize value sine gore secim yapma olanagi sagliyor
        select.selectByValue("search-alias=computers-intl-ship");

        // drobdown icerisinde ki tüm secenekleri almak stersek ::: list yöntemi ile alabiliyoruz
        List<WebElement> tumSecenekler = select.getOptions();
        for (WebElement w: tumSecenekler) {
            System.out.println(w.getText());
        }
        //sedece secilen secengi bize return eder.
        WebElement secili = select.getFirstSelectedOption();
        System.out.println("suan Secili olan: "+ secili);
        

    }
}
