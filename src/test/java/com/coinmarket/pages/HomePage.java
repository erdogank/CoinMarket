package com.coinmarket.pages;

import com.coinmarket.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(){

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

    @FindBy(css ="div>button.sc-44910c32-0.joPzXo.sc-c97dd8af-0.kHBmSh.table-control-filter")
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

    @FindBy(css = "div[class='sc-d598dd22-1 hiGkfq menu-item-1']>a")
    public WebElement excahangesLink;

    @FindBy(css = "div[class='sc-d598dd22-2 kqJhxB submenu']>a[href='/rankings/exchanges/derivatives/']")
    public WebElement derivatives;

    @FindBy(xpath = "//tbody/tr/td[2]/a/div/div/p[contains(.,'Binance')]")
    public  WebElement binanceCell;

    @FindBy(linkText = "Fees")
   public WebElement feesLink;

    public WebElement coinCell(String coinName){
     String coinLocator = "//tbody/tr/td[2]/a/div/div/p[contains(.,'"+coinName+"')]";
     return Driver.getDriver().findElement(By.xpath(coinLocator));
    }





}
