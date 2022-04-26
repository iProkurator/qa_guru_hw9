import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideRepositoryTest {

    @Test
    @DisplayName("2) Тест поиска в GitHub")
    public void testSelenideOnGitHub(){
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue("selenide").pressEnter();
        $(By.linkText("selenide/selenide")).click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(By.linkText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").
                parent().
                shouldHave(exactText("3. Using JUnit5 extend test class:"));
    }

    @Test
    @DisplayName("3) Тест Drag'n'Drop")
    void testDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }


}
