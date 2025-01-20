package com.coinmarket.step_definitions;

import com.coinmarket.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class Driverless {

    @When("This is to print hello")
    public void this_is_to_print_hello() {
        System.out.println("Hello Jenkins");
    }
    @Then("This is goodbye")
    public void this_is_goodbye() throws IOException {
        System.out.println("Hope it works and Good Bye");
        Driver.getDriver();
        Driver.getDriver().get("https://www.google.com/");
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

    }



}
