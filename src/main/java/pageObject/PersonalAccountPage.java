package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PersonalAccountPage {

    private WebDriver driver;

    //Кнопка Выйти
    private By logoutButton = By.xpath("//button[text()='Выход']");

    private By profileButtonBlock = By.xpath("//ul[contains(@class, 'Account_list__3KQQf')]");

    public By getLogoutButton() {
        return logoutButton;
    }

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Геттер для блока с кнопками личного профиля")
    public By getProfileButtonBlock(){
        return profileButtonBlock;
    }

    @Step("Клинуть по кнопке 'Выход' в личном кабинете")
    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }


}
