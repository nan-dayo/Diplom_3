package pageObject;

import io.qameta.allure.Step;
import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//////////////////////////////////ЛИЧНЫЙ КАБИНЕТ/////////////////////////////////////////////////

public class PersonalAccountPage {

    private WebDriver driver;

    //кнопка Конструктор
    private By constructorButton = By.xpath("//p[contains(text(), 'Конструктор')]");
    //логотип Stellar Burgers
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка Выйти
    private By logoutButton = By.xpath("//button[text()='Выход']");


    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликнуть на 'Конструктор'")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    @Step("Кликнуть на логотип Stellar Burgers")
    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }

    @Step("Клинуть по кнопке 'Выход' в личном кабинете")
    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }


}
