import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import pageObject.*;
import java.time.Duration;
import static org.junit.Assert.*;

public class ConstructorTest extends BaseTest{

    @Test
    @DisplayName("Переход к секции 'Булки' по клику")
    public void testBunSectionSelected(){
        MainPage mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getFillingSectionButton()));
        mainPage.clickFillingSectionButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getBunSectionButton()));
        mainPage.clickBunSectionButton();

        WebElement element = driver.findElement(mainPage.getBunSectionSelected());
        assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Переход к секции 'Соусы' по клику")
    public void testSauceSectionSelected(){
        MainPage mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getSauceSectionButton()));
        mainPage.clickSauceSectionButton();

        WebElement element = driver.findElement(mainPage.getSauceSectionSelected());
        assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Переход к секции 'Начинки' по клику")
    public void testFillingSectionSelected(){
        MainPage mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getFillingSectionButton()));
        mainPage.clickFillingSectionButton();

        WebElement element = driver.findElement(mainPage.getFillingSectionSelected());
        assertTrue(element.isDisplayed());
    }

}
