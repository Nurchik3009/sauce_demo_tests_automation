package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Ainur Kaliakbarova")
@Feature("Авторизация и каталог Swag Labs")
public class SauceDemoTests extends TestBase {

    @Test
    @Story("Авторизация")
    @DisplayName("1. Успешный вход в систему")
    void shouldLoginSuccessfully() {
        step("Открыть страницу входа", () -> open("/"));

        step("Ввести логин и пароль", () -> {
            $("#user-name").setValue("standard_user");
            $("#password").setValue("secret_sauce");
            $("#login-button").click();
        });

        step("Проверить успешный вход и заголовок каталога", () -> {
            $(".title").shouldBe(visible).shouldHave(text("Products"));
        });
    }

    @Test
    @Story("Авторизация")
    @DisplayName("2. Ошибка при входе с неверным паролем")
    void shouldShowErrorOnInvalidPassword() {
        step("Открыть страницу входа", () -> open("/"));

        step("Ввести неверные данные", () -> {
            $("#user-name").setValue("standard_user");
            $("#password").setValue("wrong_password");
            $("#login-button").click();
        });

        step("Проверить появление сообщения об ошибке", () -> {
            $("[data-test='error']")
                    .shouldBe(visible)
                    .shouldHave(text("Username and password do not match any user in this service"));
        });
    }

    @Test
    @Story("Корзина")
    @DisplayName("3. Добавление товара в корзину")
    void shouldAddToCart() {
        step("Авторизоваться на сайте", () -> {
            open("/");
            $("#user-name").setValue("standard_user");
            $("#password").setValue("secret_sauce");
            $("#login-button").click();
        });

        step("Добавить рюкзак в корзину", () -> {
            $("#add-to-cart-sauce-labs-backpack").click();
        });

        step("Проверить счетчик товаров на иконке корзины", () -> {
            $(".shopping_cart_badge").shouldBe(visible).shouldHave(text("1"));
        });
    }

    @Test
    @Story("Сортировка")
    @DisplayName("4. Сортировка товаров по цене (low to high)")
    void shouldSortProductsByPrice() {
        step("Авторизоваться на сайте", () -> {
            open("/");
            $("#user-name").setValue("standard_user");
            $("#password").setValue("secret_sauce");
            $("#login-button").click();
        });

        step("Выбрать сортировку по возрастанию цены", () -> {
            $(".product_sort_container").selectOptionByValue("lohi");
        });

        step("Проверить, что первый товар — самый дешевый ($7.99)", () -> {
            $$(".inventory_item_price").first().shouldHave(text("$7.99"));
        });
    }

    @Test
    @Story("Навигация")
    @DisplayName("5. Разлогин из системы")
    void shouldLogoutSuccessfully() {
        step("Авторизоваться на сайте", () -> {
            open("/");
            $("#user-name").setValue("standard_user");
            $("#password").setValue("secret_sauce");
            $("#login-button").click();
        });

        step("Открыть боковое меню и нажать Logout", () -> {
            $("#react-burger-menu-btn").click();
            $("#logout_sidebar_link").click(com.codeborne.selenide.ClickOptions.usingJavaScript());
        });

        step("Проверить возврат на форму входа", () -> {
            $("#login-button").shouldBe(visible);
        });
    }
}