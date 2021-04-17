package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterReceiveInformation {
    @FindBy(xpath = "//input[@type=\"email\"]")
    public WebElement Email;
    @FindBy(xpath = "//input[@id=\"fullname\"]")
    public WebElement FullName;
    @FindBy(xpath = "//button[@id=\"ddlGender\"]")
    public WebElement Gender;
    @FindBy(xpath = "//button[@id=\"ddlNewsType\"]")
    public WebElement NewsType;
    @FindBy(xpath = "//button[@class=\"next-btn-primary\"]")
    public WebElement btnRegister;
    @FindBy(xpath = "//button[@id=\"allow-button\"]")
    public WebElement btnAgree;
    @FindBy(xpath = "//div[@id=\"popover\"]")
    public WebElement requestedForm;
    @FindBy(xpath = "//div[@class=\"_9q4i\"]")
    public WebElement close;

    By fullNameErrorMessage = By.xpath("//div[@class=\"error\"]");

    By popupMessageLocator = By.xpath("//div[@id=\"popover\"]//div[@class=\"body-message\"]");

    By successMessageLocator = By.xpath("//div[@class=\"body-message\"]");
    ////div[@class="error"]

    WebDriver driver;
    public RegisterReceiveInformation(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getPopupContent()
    {
        WebDriverWait wait = new WebDriverWait(this.driver, 12);
        WebElement lbMessage = wait.until(ExpectedConditions.presenceOfElementLocated(popupMessageLocator));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lbMessage.getText();
    }

    public String getFullNameErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(this.driver, 12);
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(fullNameErrorMessage));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorMessage.getText();
    }

    public String getSuccessPopupContent()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,15);
        WebElement lbMessage = wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lbMessage.getText();
    }
}
