import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class JUnitNotasyonlar {
    static WebDriver driver;

    @BeforeAll
    public static void ilkIslemler() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options;
        options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable notifications");
        options.addArguments("--incognito");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);

        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterAll
    public static void sonIslemler() {
        driver.quit();

    }
    @Test
    public void test01(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
    @Test
    public void test02(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
    @Test
    public void test03(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

}

