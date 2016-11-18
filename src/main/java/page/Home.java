package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home {

    private WebDriver webDriver;

    public Home(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebElement findLoginPageLink() {
        return webDriver.findElement(By.className("btnSignIn"));
    }

    public WebElement findLoginButton() {
        return webDriver.findElement(By.className("btnLogin"));
    }

    public List<WebElement> findProfileLink() {
        return webDriver.findElements(By.className("username"));
    }

    public void clickLoginLink() throws InterruptedException {
        findLoginPageLink().click();
        findLoginButton().click();
    }

    public boolean profileLinkExist() {
        // this is the most proper way to check if an element exists
        return !findProfileLink().isEmpty();
    }
}
