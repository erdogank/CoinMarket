package com.coinmarket.pages;

import com.coinmarket.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HomePage {
    public HomePage() throws IOException {

        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(css = "div[class='sc-aef7b723-0 sc-a4d63dad-0 ddLpEy']")
   public WebElement showRows;
    @FindBy(xpath = "//div[@class='tippy-content']/div/div/button")
    public List<WebElement> showRowValues;

    //WebElement rowButton = Driver.getDriver().findElement(By.xpath("//div[@class='sc-aef7b723-0 sc-7b9bb58a-0 cciXVV dropdown-container']/button[.='50']"));

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//div[@id='nprogress']")
    public WebElement progressBar;

    @FindBy(xpath = "/html[@class='nprogress-busy']")
    public WebElement progress;

    @FindBy(xpath ="//div/div[1]/div[3]/div[1]/span/button[1]")
    public WebElement filterButton;

    @FindBy(xpath = "(//li/button)[1]")
    public WebElement addFilter;

    @FindBy(xpath = "//button[.='Price']")
    public WebElement priceButton;

    @FindBy(xpath = "//input[@data-qa-id='range-filter-input-min']")
    public WebElement minPrice;

    @FindBy(xpath = "//input[@data-qa-id='range-filter-input-max']")
    public WebElement maxPrice;

    @FindBy(xpath = "//button[@data-qa-id='filter-dd-button-apply']")
    public WebElement applyFilter;

    @FindBy(xpath = "//button[.='Show results']")
    public WebElement showResultsButton;

    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> priceCells;

    @FindBy(css = "div:nth-child(3) > a > div")
    public WebElement excahangesLink;

    @FindBy(xpath = "//div/a[@href='/rankings/exchanges/derivatives/']")
    public WebElement derivatives;

    @FindBy(xpath = "//tbody/tr/td[2]/a/div/div/p[(.='Binance')]")
    public  WebElement binanceCell;

    @FindBy(linkText = "Fees")
   public WebElement feesLink;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/span" )
    public WebElement firstStar;

 @FindBy(xpath = "//tbody/tr[5]/td[1]/span" )
 public WebElement fifthStar;

 @FindBy(xpath = "//tbody/tr[1]/td[1]/span/span" )
 public WebElement firstStarAttr;

 @FindBy(xpath = "//tbody/tr[1]/td[3]/div/a/div/div/div/p")
 public WebElement nameOfFirstCoinCell;

 @FindBy(xpath = "(//a/span)[2]")
 public WebElement watchList;

 @FindBy(css = "body > div:nth-child(15) > div > div > svg > path")
 public WebElement XButtonToCloseWatchlist;

 @FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[3]")
 public WebElement createAnAccount;

 @FindBy(xpath = "//*[@id=\"onetrust-reject-all-handler\"]")
 public WebElement cookiesReject;

 @FindBy(xpath = "//tbody/tr")
 public List<WebElement> tableRows;

 @FindBy(xpath = "(//div[@class='sc-194d08f0-7 hKUAPU'])[1]")
 public WebElement CryptoCurrenciesLink;

 @FindBy(xpath = "(//div[@class='sc-194d08f0-9 hHCBVT'])[1]/a")
 public List<WebElement> CyrptocurrenciesMenuItems;

 @FindBy(xpath = "//div[@class='sc-194d08f0-3 cZeAph']/section/div")
 public List<WebElement> mainMenuItems;

    public WebElement coinCell(String coinName) throws IOException {
     String coinLocator = "//tbody/tr/td[2]/a/div/div/p[contains(.,'"+coinName+"')]";
     return Driver.getDriver().findElement(By.xpath(coinLocator));
    }

    /*
    sembol locator
    //td[3]/div/a/div/div/div/div/p[(.='BTC')]
     */





}
