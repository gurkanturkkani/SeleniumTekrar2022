import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

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
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        ////*[="Dynamic Controls"]
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyormu = baslik.isDisplayed();// bunun cevabi truu ya da false dir
        System.out.println("Gorunuyor mu?: "+gorunuyormu);
    }
    @Test
    public void isSelected(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));

        // eger bir webelement secili ise t yoksa f yazar
        boolean secilimi = secimElementi.isSelected();
        System.out.println("Secili mi 1?:  "+ secilimi);

        secimElementi.click();

        boolean secilimi2 = secimElementi.isSelected();
        System.out.println("secili mi 2?:" +secilimi2);
    }
    @Test
    public void isEnable(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputkutusu = driver.findElement(By.xpath("//input[@type ='text']"));
        boolean aktifmi = inputkutusu.isEnabled();
        System.out.println("aktif mi?: "+aktifmi);

        WebElement enableButonu = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButonu.click();

        try {
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();

        }
        boolean aktifmi2 = inputkutusu.isEnabled();
        System.out.println("Aktif mi?: "+ aktifmi2); 
    }



}
