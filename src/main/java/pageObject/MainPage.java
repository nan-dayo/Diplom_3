package pageObject;
import com.sun.tools.javac.Main;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//////////////////////////////////ГЛАВНАЯ СТРАНИЦА//////////////////////////////////////////

public class MainPage {

    private WebDriver driver;

    //вход по кнопке «Войти в аккаунт» на главной
    private By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    //вход через кнопку «Личный кабинет»
    private By personalAccountButton = By.xpath("//p[contains(text(), 'Личный Кабинет')]");
    private By bunSectionButton = By.xpath("//span[contains(text(), 'Булки')]");
    private By sauceSectionButton = By.xpath("//span[contains(text(), 'Соусы')]");
    private By fillingSectionButton = By.xpath("//span[contains(text(), 'Начинки')]");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Геттер для кнопки Войти в аккаунт")
    public By getLoginAccountButton(){
        return loginAccountButton;
    }

    @Step("Геттер для кнопки Личный кабинет")
    public By getPersonalAccountButton(){
        return personalAccountButton;
    }

    @Step("Геттер для секции 'Булки'")
    public By getBunSectionButton(){
        return bunSectionButton;
    }

    @Step("Геттер для секции 'Соусы'")
    public By getSauceSectionButton(){
        return sauceSectionButton;
    }

    @Step("Геттер для секции 'Начинки'")
    public By getFillingSectionButton(){
        return fillingSectionButton;
    }



    @Step("Кликнуть по кнопке 'Войти в аккаунт' на главной странице")
    public void clickLoginAccountButton(){
        driver.findElement(loginAccountButton).click();
    }

    @Step("Кликнуть по кнопке 'Личный Кабинет' на главной странице")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    @Step("Кликнуть по секции 'Булки'")
    public void clickBunSectionButton(){
        driver.findElement(bunSectionButton).click();
    }

    @Step("Кликнуть по секции 'Соусы'")
    public void clickSauceSectionButton(){
        driver.findElement(sauceSectionButton).click();
    }

    @Step("Кликнуть по секции 'Начинки'")
    public void clickFillingSectionButton(){
        driver.findElement(fillingSectionButton).click();
    }


}
