package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Categories {

    private WebDriver webDriver;

    public Categories(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebElement findBookMainCategoryLink() {
        return webDriver.findElement(By.linkText("Kitap, Müzik, Film, Oyun"));
    }

    public WebElement findBookSubCategoryLink() {
        return webDriver.findElement(By.linkText("Kitap"));
    }

    public WebElement findAuthorsLink() {
        return webDriver.findElement(By.linkText("Yazarlar"));
    }

    public List<WebElement> findAuthorsList() {
        return webDriver.findElements(By.xpath("//*[@id='authorsList']//*/*/*/*"));
    }

    public WebElement findAlphabetPaging() {
        return webDriver.findElement(By.className("alphabetPaging"));
    }

    public void goToBookCategory() {
        findBookMainCategoryLink().click();
        findBookSubCategoryLink().click();
    }

    public void goToAuthorsLink() {
        findAuthorsLink().click();
    }

    public int authorsSize() {
        return findAuthorsList().size();
    }

    public List<WebElement> getListOfAlphabet() {
        return findAlphabetPaging().findElements(By.xpath(".//*"));
    }
}
