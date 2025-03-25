package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{
    private static final SelenideElement SING_IN = $x("//*[@type='submit']");

    public LoginPage() {
    }

    public LoginPage openPage(String url){
        open(url);
        return this;
    }

    public LoginPage isOpened(){
        SING_IN.shouldBe(Condition.visible);
        return this;
    }

    private LoginPage fillLoginForm(String email, String password){
        isOpened();
        new Input("email").write(email);
        new Input("password").write(password);
        new Button().click(SING_IN);
        return this;
    }

    public ProjectListPage login(String email, String password){
        fillLoginForm(email,password);
        return this;
    }
}
