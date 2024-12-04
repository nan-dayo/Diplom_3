package pageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MainPage {

    private WebDriver driver;

    private By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath("//p[contains(text(), 'Личный Кабинет')]");
    private By bunSectionButton = By.xpath("(//div[contains(@class, 'tab_tab__1SPyG')])[1]");
    private By sauceSectionButton = By.xpath("(//div[contains(@class, 'tab_tab__1SPyG')])[2]");
    private By fillingSectionButton = By.xpath("(//div[contains(@class, 'tab_tab__1SPyG')])[3]");
    private By bunSectionSelected = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[1][contains(@class, 'tab_tab_type_current__2BEPc')]");
    private By sauceSectionSelected = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[2][contains(@class, 'tab_tab_type_current__2BEPc')]");
    private By fillingSectionSelected = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div//div[3][contains(@class, 'tab_tab_type_current__2BEPc')]");
    //кнопка Конструктор
    private By constructorButton = By.xpath("//p[contains(text(), 'Конструктор')]");
    //логотип Stellar Burgers
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка 'Оформить заказ'
    private By makeOrderButton = By.xpath("//button[contains(text(), 'Оформить заказ')]");

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

    @Step("Геттер для выбранной секции 'Булочки'")
    public By getBunSectionSelected() {
        return bunSectionSelected;
    }

    @Step("Геттер для выбранной секции 'Соусы'")
    public By getSauceSectionSelected() {
        return sauceSectionSelected;
    }

    @Step("Геттер для выбранной секции 'Начинки'")
    public By getFillingSectionSelected() {
        return fillingSectionSelected;
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

    @Step("Геттер для кнопки 'Оформить заказ'")
    public By getMakeOrderButton(){
        return makeOrderButton;
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

    @Step("Кликнуть на 'Конструктор'")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    @Step("Кликнуть на логотип Stellar Burgers")
    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }


}
