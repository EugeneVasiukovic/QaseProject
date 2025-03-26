package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAndDeleteProjectTest extends BaseTest{

    @Test
    public void createProjectTest(){
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectListSteps
                .createProject("QA_TmS_Vasiukovich");
        projectListSteps
                .backToPageCreateProject();

        Assert.assertTrue(projectListPage.getProjectElement("QA_TmS_Vasiukovich").shouldBe(Condition.visible).exists());
    }

    @Test
    public void deleteProjectTest(){
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectListSteps
                .createProject("QA_TmS_Vasiukovich");
        projectListSteps
                .backToPageCreateProject();
    }
}
