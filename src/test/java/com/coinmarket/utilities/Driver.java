package com.coinmarket.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
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

    public static WebDriver getDriver() {

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
                        String gridAddress = "192.168.157.128";
                        URL url = new URL("http://" + gridAddress + ":4444");
                        System.out.println(url);

                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless=new"); // Ensure the browser runs in headless mode
                        options.addArguments("--disable-gpu");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--no-sandbox");

                        System.out.println("Initializing RemoteWebDriver with URL: " + url);

                        //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");

                        driverPool.set(new RemoteWebDriver(url, options));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;


                case "remote-firefox":
                    try {

                        // Assign your grid server address
                        String gridAddress = "192.168.157.128";
                        URL url = new URL("http://" + gridAddress + ":4444");
                        System.out.println(url);

                        FirefoxOptions firefoxOptions = new FirefoxOptions();

// Add options to run Firefox in headless mode and improve compatibility
                        firefoxOptions.addArguments("--headless"); // Ensure the browser runs in headless mode
                        firefoxOptions.addArguments("--disable-gpu"); // Disable GPU acceleration
                        firefoxOptions.addArguments("--disable-dev-shm-usage"); // Avoid shared memory issues
                        firefoxOptions.addArguments("--no-sandbox"); // Bypass OS-level sandboxing for compatibility

// Log initialization details
                        System.out.println("Initializing RemoteWebDriver for Firefox with URL: " + url);

// Initialize the RemoteWebDriver
                        //WebDriverManager.firefoxdriver().setup();
                        //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
                        driverPool.set(new RemoteWebDriver(url, firefoxOptions));

// Maximize or set a fixed window size
                        driverPool.get().manage().window().setSize(new Dimension(1920, 1080));

// Set an implicit wait for element loading
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



                        //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "remote-edge":
                    try {
                        // Assign your Selenium Grid server address
                        String gridAddress = "192.168.157.128"; // Replace with your Grid server's IP address
                        URL url = new URL("http://" + gridAddress + ":4444"); // Ensure the Grid is running at this address
                        System.out.println(url);

                        // Configure Edge-specific options
                        EdgeOptions options = new EdgeOptions();
                        options.addArguments("--headless=new"); // Run in headless mode
                        options.addArguments("--disable-gpu");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--no-sandbox");

                        System.out.println("Initializing RemoteWebDriver with URL: " + url);

                        // Initialize the Remote WebDriver with Edge options
                        driverPool.set(new RemoteWebDriver(url, options));
                        driverPool.get().manage().window().maximize(); // Maximize the browser window
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
                    } catch (Exception e) {
                        e.printStackTrace(); // Print any exceptions for debugging
                    }
                    break;



                case "chrome":


                    //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                    //to disable chrome version check
                    //ChromeDriverService service = new ChromeDriverService.Builder().withBuildCheckDisabled(true).build();
//                    ChromeOptions options = new ChromeOptions();
//
//                    options.addArguments("--headless");
//                    options.addArguments("--disable-gpu");
//                    options.addArguments("--disable-dev-shm-usage");
//                    //options.addArguments("--no-sandbox");

                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    //driverPool.get().manage().window().setSize(new Dimension(1920, 1080));
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "edge":

                    // Setting up the Edge WebDriver using WebDriverManager
                    WebDriverManager.edgedriver().setup();

                    // Initializing the EdgeDriver
                    driverPool.set(new EdgeDriver());

                    // Maximizing the browser window
                    driverPool.get().manage().window().maximize();

                    // Optionally, set custom dimensions for the browser window
                    // driverPool.get().manage().window().setSize(new Dimension(1920, 1080));

                    // Setting an implicit wait timeout
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    firefoxOptions.setCapability("moz:debuggerAddress", true); // Enables BiDi support


//                    firefoxOptions.addArguments("--headless");
//                    firefoxOptions.addArguments("--disable-gpu");
//                    firefoxOptions.addArguments("--disable-dev-shm-usage");

                   WebDriverManager.firefoxdriver().setup();
                    //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");

                    driverPool.set( new FirefoxDriver(firefoxOptions));
                    driverPool.get().manage().window().maximize();
                    //driverPool.get().manage().window().setSize(new Dimension(1920, 1080));
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
