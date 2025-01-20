package com.coinmarket.step_definitions;

import com.coinmarket.pages.HomePage;
import com.coinmarket.utilities.BrowserUtils;
import com.coinmarket.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Watchlist {

    HomePage homePage;

    {
        try {
            homePage = new HomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @When("the user clicks the star near the coin names")
    public void the_user_clicks_the_star_near_the_coin_names() {
        try {
            homePage.cookiesReject.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BrowserUtils.sleep(4);
        js.executeScript("window.scrollBy(0,-1500)");
        BrowserUtils.sleep(4);

        System.out.println("homePage.mainMenuItems.size() = " + homePage.mainMenuItems.size()+" items and they are:");

        for (WebElement each : homePage.mainMenuItems) {
            System.out.println(each.getText());

        }

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.CryptoCurrenciesLink).perform();
        BrowserUtils.sleep(5);
        List<String> cryptoMenuList = new ArrayList<>();

        for (WebElement cyrptocurrenciesMenuItem : homePage.CyrptocurrenciesMenuItems) {
            System.out.println("cyrptocurrenciesMenuItem.getDomProperty(\"text\") = " + cyrptocurrenciesMenuItem.getDomProperty("text"));
            cryptoMenuList.add(cyrptocurrenciesMenuItem.getDomProperty("text"));
        }
        System.out.println(cryptoMenuList);
        //System.out.println("homePage.CyrptocurrenciesMenuItems.getDomProperty(\"text\") = " + homePage.CyrptocurrenciesMenuItems.getDomProperty("text"));


        //System.out.println("text is= "+homePage.XButtonToCloseWatchlist.getDomProperty("text"));

        //BrowserUtils.sleep(5);


        homePage.firstStar.click();
        //BrowserUtils.sleep(5);
    }
    @Then("the user verifies that the star's color changes to yellow")
    public void the_user_verifies_that_the_star_s_color_changes_to_yellow() {

        System.out.println(homePage.nameOfFirstCoinCell.getText());
        homePage.firstStarAttr.getAttribute("class").equals("icon-Star-Filled");
        System.out.println(homePage.firstStarAttr.getAttribute("class"));
    }
    @Then("the user clicks the Watchlist")
    public void the_user_clicks_the_watchlist() {


        //BrowserUtils.sleep(5);

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(homePage.XButtonToCloseWatchlist));


        //js.executeScript("arguments[0].click();", homePage.XButtonToCloseWatchlist);
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true }));", homePage.XButtonToCloseWatchlist);
        //homePage.XButtonToCloseWatchlist.click();

        //homePage.XButtonToCloseWatchlist.click();

        homePage.fifthStar.click();


       homePage.watchList.click();
       //BrowserUtils.sleep(5);
    }
    @Then("the user verifies that the added coins are in the watchlist")
    public void the_user_verifies_that_the_added_coins_are_in_the_watchlist() {
        System.out.println(homePage.nameOfFirstCoinCell.getText());

        System.out.println("homePage.tableRows.size() = " + homePage.tableRows.size());

    }
}
