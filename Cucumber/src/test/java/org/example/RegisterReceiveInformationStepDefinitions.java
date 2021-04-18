package org.example;

import PageObjects.RegisterReceiveInformation;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterReceiveInformationStepDefinitions {
    WebDriver driver;
    RegisterReceiveInformation register;

    @Before
    public void iniDriver()
    {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @After
    public void close()
    {
        this.driver.close();
    }

    @Given("^The home page is displayed$")
    public void the_home_page_is_displayed() throws InterruptedException
    {
        this.driver.get("http://testmaster.vn/");
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        this.register = new RegisterReceiveInformation(this.driver);
    }

    @When("^User register with email \"([^\"]*)\"$")
    public void user_register_with_valid_email(String email)
    {
        this.register.Email.sendKeys(email);
    }

    @Then("^the extra information is displayed$")
    public void the_extra_information_is_displayed()
    {
        this.register.requestedForm.isDisplayed();
    }

    @Then("^the popup \"([^\"]*)\" should be displayed$")
    public void the_popup_something_should_be_displayed(String popupMessage)
    {
        Assert.assertEquals(popupMessage,this.register.getPopupContent());
    }

    @Then("^in-line error message \"([^\"]*)\" should be display$")
    public void inline_error_message_something_should_be_display(String errorMessage)
    {
        Assert.assertEquals(errorMessage,this.register.getFullNameErrorMessage());
    }

    @Then("^the success popup \"([^\"]*)\" should be displayed$")
    public void the_success_popup_something_should_be_displayed(String successMessage)
    {
        Assert.assertEquals(successMessage,this.register.getSuccessPopupContent());
    }

    @And("^user register with fullName \"([^\"]*)\"$")
    public void user_register_with_fullname_something_gender_something_and_newtype_something(String fullName) throws InterruptedException {
        Thread.sleep(1000);
        this.register.FullName.sendKeys(fullName);

    }
    @And("^select \"([^\"]*)\" at the gender dropdown list$")
    public void select_something_at_the_gender_dropdown_list(String gender) {
        this.register.Gender.sendKeys(gender);
    }

    @And("^select \"([^\"]*)\" at the newType dropdown list$")
    public void select_something_at_the_newtype_dropdown_list(String newType) {
        this.register.NewsType.sendKeys(newType);
    }
    @And("^click on \"([^\"]*)\" button on home page$")
    public void click_on_something_button_on_home_page(String strArg1) throws Throwable {
        this.register.btnRegister.click();
    }
    @And("^click on \"([^\"]*)\" button on extra form$")
    public void click_on_something_button_on_extra_form(String strArg1){
        this.register.btnAgree.click();
    }
}
