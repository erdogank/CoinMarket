package com.coinmarket.step_definitions;

import com.coinmarket.pages.HomePage;
import com.coinmarket.utilities.BrowserUtils;
import com.coinmarket.utilities.ConfigurationReader;
import com.coinmarket.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class sampleSteps {
    
    HomePage homePage;

    {
        try {
            homePage = new HomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

    }
    @When("The user clicks on Show rows")
    public void the_user_clicks_on_show_rows() {
        BrowserUtils.sleep(2);
//        Actions action = new Actions(Driver.getDriver());
//        action.click(homePage.showRows);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.showRows));

        homePage.showRows.click();
        BrowserUtils.sleep(2);
    }

    @Then("The user should see below options")
    public void the_user_should_see_below_options(List<Integer> rowValues) {
        
        List<WebElement> actualRowValues=  homePage.showRowValues;
        System.out.println("actualRowValues.size() = " + actualRowValues.size());
        
        List<Integer> actualRowValueInteger= new ArrayList<>();

        for (WebElement actualRowValue : actualRowValues) {
            
            actualRowValueInteger.add(Integer.parseInt(actualRowValue.getText()));
        }

        System.out.println("actualRowValueInteger = " + actualRowValueInteger);
        Assert.assertEquals(actualRowValueInteger,rowValues);


        boolean isequal = actualRowValueInteger.equals(rowValues);
        System.out.println("isequal = " + isequal);

    }

    @When("User click a number from {string}")
    public void user_click_a_number_from(String number) throws InterruptedException {

        String locator = "//div[@class='sc-aef7b723-0 sc-7b9bb58a-0 cciXVV dropdown-container']/button[.='"+number+"']";
        System.out.println(number);


        WebElement rowButton = Driver.getDriver().findElement(By.xpath("//div[@class='sc-aef7b723-0 sc-7b9bb58a-0 cciXVV dropdown-container']/button[.='"+number+"']"));
        rowButton.click();

        wait.until(ExpectedConditions.visibilityOf(homePage.progressBar));
        wait.until(ExpectedConditions.invisibilityOf(homePage.progressBar));

        //Thread.sleep(1500);
        System.out.println("homePage.rows.size() = " + homePage.rows.size());






    }
    @Then("The {string} number should match")
    public void the_number_should_match(String option) {
        System.out.println("option = " + option);
        System.out.println("homePage.rows.size() = " + homePage.rows.size());
        Assert.assertEquals(Integer.parseInt(option),homePage.rows.size());
    }

    @When("user clicks on filters")
    public void user_clicks_on_filters() {
        BrowserUtils.sleep(3);
        System.out.println("waited 3 seconds");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", homePage.filterButton);
        //wait.until(ExpectedConditions.elementToBeClickable(homePage.filterButton));
       // homePage.filterButton.click();
        //actions.click(homePage.filterButton);

    }
    @When("click on add filter")
    public void click_on_add_filter() {
        //wait.until(ExpectedConditions.elementToBeClickable(homePage.addFilter));
        BrowserUtils.sleep(2);
        System.out.println("waited 2 seconds");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", homePage.addFilter);


        //homePage.addFilter.click();

    }
    @When("clicks on price")
    public void clicks_on_price() {
        BrowserUtils.sleep(1);
       homePage.priceButton.click();

    }
    @When("writes price range {int} to {int}")
    public void writes_price_range_to(Integer min, Integer max) {
        BrowserUtils.sleep(1);
       homePage.minPrice.sendKeys(min+"");
       homePage.maxPrice.sendKeys(max+"");

    }
    @When("click apply filter")
    public void click_apply_filter() {
        //wait.until(ExpectedConditions.visibilityOf(homePage.applyFilter));
        BrowserUtils.sleep(1);
        homePage.applyFilter.click();

    }
    @When("click show results")
    public void click_show_results() {
        //wait.until(ExpectedConditions.visibilityOf(homePage.showResultsButton));
        BrowserUtils.sleep(1);
        homePage.showResultsButton.click();

    }
    @Then("all prices should be more then {int} and less then {int}")
    public void all_prices_should_be_more_then_and_less_then(Integer min, Integer max) {

        for (WebElement priceCell : homePage.priceCells) {
            String eachPrice = priceCell.getText().substring(1);
            System.out.println(eachPrice);
            Double eachPriceDouble = Double.parseDouble(eachPrice);

            Assert.assertTrue(eachPriceDouble>min&&eachPriceDouble<max);

            System.out.println("eachPrice = " + eachPrice);


        }
    }



}
