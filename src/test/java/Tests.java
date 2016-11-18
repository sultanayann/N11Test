import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Categories;
import page.Facebook;
import page.Home;

import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void shouldGoToBookCategory() {
        webDriver.get("http://www.n11.com");
        Categories categoryPage = new Categories(webDriver);
        categoryPage.goToBookCategory();
        Assert.assertEquals("urls must be same", webDriver.getCurrentUrl(), "http://www.n11.com/kitap");
        webDriver.close();
    }

    @Test
    public void shouldGoToAllAuthors() {
        webDriver.get("https://www.n11.com");
        Categories categoryPage = new Categories(webDriver);
        categoryPage.goToBookCategory();
        categoryPage.goToAuthorsLink();
        Assert.assertEquals("urls must be same", webDriver.getCurrentUrl(), "http://www.n11.com/yazarlar");
        webDriver.close();
    }

    @Test
    public void authorsSize() {
        webDriver.get("https://www.n11.com");
        Categories categoryPage = new Categories(webDriver);
        categoryPage.goToBookCategory();
        categoryPage.goToAuthorsLink();
        int alphabetSize = categoryPage.getListOfAlphabet().size();

        for (int i = 0; i < alphabetSize; i++) {
            categoryPage.getListOfAlphabet().get(i).click();
            Assert.assertTrue("must be true", categoryPage.authorsSize() <= 80);
        }

        webDriver.close();
    }

    @Test
    public void shouldLoginFacebook() throws InterruptedException {
        String windowHandle = webDriver.getWindowHandle();
        webDriver.get("https://www.n11.com");
        Home homePage = new Home(webDriver);
        homePage.clickLoginLink();
        for (String currentWindow: webDriver.getWindowHandles()) {
            webDriver.switchTo().window(currentWindow);
        }
        Facebook facebookWindow = new Facebook(webDriver);
        facebookWindow.login();
        webDriver.switchTo().window(windowHandle);
        Assert.assertTrue("profile link should exist", homePage.profileLinkExist());
    }

    @Test
    public void checkAuthors() {
        webDriver.get("https://www.n11.com");
        Categories categories = new Categories(webDriver);
        categories.goToBookCategory();
        categories.goToAuthorsLink();
        int alphabetSize = categories.getListOfAlphabet().size();

        for (int i = 0; i < alphabetSize; i++) {
            int size = categories.authorsSize();
            String lastAuthor = categories.findAuthorsList().get(size-1).getAttribute("title");
            webDriver.navigate().to(webDriver.getCurrentUrl() + "?pg=2");
            String firstAuthor = categories.findAuthorsList().get(0).getAttribute("title");
            Assert.assertFalse("must be false", lastAuthor.equals(firstAuthor));
        }

        webDriver.close();
    }
}
