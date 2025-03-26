package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectListPage extends BasePage {
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement SELECT_DELETE_BUTTON = $x("//*[@data-testid='remove']");
    private static final SelenideElement BUTTON_DELETE_POPUP = $x("//*[@type='button']/span/span[text()='Delete project']");
    private static final SelenideElement NAV_MENU_ELEMENT = $(By.linkText("Projects"));
    private static final String NAVIGATE_PROJECT = "//*[@class='cx2QU4' and text()='%s']";
    private static final String NAME_PROJECT ="//*[@id='application-content']//*[a[text()='%s']]/a";
    private static final String PROJECT_DELETE = "//tr[td[3]/div/div/a[text()='%s']]//button[@type='button' and @aria-label='Open action menu']";

    public ProjectListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }
    public ProjectListPage openProject(String nameProject){
        SelenideElement projectNavigate = $x(String.format(NAVIGATE_PROJECT, nameProject));
        new Button().click(projectNavigate);
        return this;
    }

    private ProjectListPage fillFormCreateProject(String nameProject) {
        new Button().click(CREATE_NEW_PROJECT);
        new Input("project-name").writeForm(nameProject);
        new Button().clickButtonForm();
        return this;
    }

    public ProjectListPage createProject(String nameProject) {
        fillFormCreateProject(nameProject);
        return this;
    }

    public void backPageCreateProject(){
        new Button().click(NAV_MENU_ELEMENT);
    }

    public SelenideElement getProjectElement(String nameProject) {
        return $x(String.format(NAME_PROJECT, nameProject));
    }

    public ProjectListPage deleteProject(String nameProject) {
        SelenideElement deleteButton = $x(String.format(PROJECT_DELETE, nameProject));
        new Button().click(deleteButton);
        new Button().click(SELECT_DELETE_BUTTON);
        new Button().click(BUTTON_DELETE_POPUP);
        return this;
    }
}