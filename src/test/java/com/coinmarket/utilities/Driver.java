package com.coinmarket.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;


public class Driver {
    static String browser;

    //Creating a private constructor, so we are closing
    //access to the object of this class from outside the class
    private Driver() {
    }

    //We make WebDriver private, because we want to close access from outside the class.
    //We make it static because we will use it in a static method.
    //private static WebDriver driver;

    private static final InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            if (System.getProperty("BROWSER") == null){
                browser = ConfigurationReader.getProperty("browser");

            }else{
                browser = System.getProperty("BROWSER");
            }
            System.out.println(browser);

            //we will get our browser type value from config.properties file
            //we will use this value in the switch statement below:
            //String browserType = ConfigurationReader.getProperty("browser");

            switch(browser.toLowerCase()){

                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "18.212.10.44";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");

                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless=new");
                        //chromeOptions.addArguments("--allow-running-insecure-content");
                        //chromeOptions.addArguments("--ignore-certificate-errors");
                        //chromeOptions.addArguments("--ignore-certificate-errors");



//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
                        driverPool.get().manage().window().setSize(new Dimension(1920, 1080));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;


                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "18.212.10.44";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");

                        FirefoxOptions firefoxOptions = new FirefoxOptions();


                        firefoxOptions.addArguments("--headless");
                        //chromeOptions.addArguments("--allow-running-insecure-content");
                        //chromeOptions.addArguments("--ignore-certificate-errors");
                        //chromeOptions.addArguments("--ignore-certificate-errors");



//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName("chrome");
                        //WebDriverManager.firefoxdriver().setup();
                        //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
                        driverPool.set(new RemoteWebDriver(url, firefoxOptions));
                        driverPool.get().manage().window().setSize(new Dimension(1920, 1080));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;


                case "chrome":

                    ChromeOptions options = new ChromeOptions();

                    options.addArguments("--headless");
                    //options.addArguments("--disable-gpu");
                    //options.addArguments("--disable-dev-shm-usage");
                    //options.addArguments("--no-sandbox");
//
//
//                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    //driverPool.get().manage().window().maximize();
                    driverPool.get().manage().window().setSize(new Dimension(1920, 1080));
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
                    System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                    driverPool.set( new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


            }
        }
        return driverPool.get();


    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();//this line will terminate the existing session. the value will not even be null
            driverPool.remove();
        }
    }
}
