package com.coinmarket.step_definitions;

import com.coinmarket.pages.HomePage;
import com.coinmarket.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.Set;

public class Tugrahan {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    String windowHande="";
    Set<String> windowHandles = new HashSet<>();

    @Then("users clicks the derivatives under the Exchanges")
    public void users_clicks_the_derivatives_under_the_exchanges() {
        actions.moveToElement(homePage.excahangesLink).pause(200)
                .click(homePage.derivatives)
                .perform();
    }
    @Then("users clicks the Binance")
    public void users_clicks_the_binance() {

        homePage.binanceCell.click();
    }
    @Then("user clicks the fees link")
    public void user_clicks_the_fees_link() {
        windowHande = Driver.getDriver().getWindowHandle();
        homePage.feesLink.click();
        windowHandles = Driver.getDriver().getWindowHandles();
        System.out.println(windowHandles);

    }
    @Then("users looks at the new open tab")
    public void users_looks_at_the_new_open_tab() {

        for (String eachWindowHandle : windowHandles) {
            if(eachWindowHandle!=windowHande){
                Driver.getDriver().switchTo().window(eachWindowHandle);
            }

        }
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Binance"));
    }

    @Then("users clicks the {string}")
    public void users_clicks_the(String coin) {
        homePage.coinCell(coin).click();
    }
    @Then("users sees {string} in new tab")
    public void users_sees_in_new_tab(String coin) {
        for (String eachWindowHandle : windowHandles) {
            if(eachWindowHandle!=windowHande){
                Driver.getDriver().switchTo().window(eachWindowHandle);
            }

        }
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().contains(coin));
    }
}
