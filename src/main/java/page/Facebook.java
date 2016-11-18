package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Facebook {

    private WebDriver webDriver;

    public Facebook(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebElement findEmail() {
        return webDriver.findElement(By.id("email"));
    }

    public WebElement findPassword() {
        return webDriver.findElement(By.id("pass"));
    }

    public WebElement findLoginButton() {
        return webDriver.findElement(By.name("login"));
    }

    public void login() throws InterruptedException {
        findEmail().sendKeys("aysuan@outlook.com");
        findPassword().sendKeys("27121994sa");
        findLoginButton().click();
    }
}
