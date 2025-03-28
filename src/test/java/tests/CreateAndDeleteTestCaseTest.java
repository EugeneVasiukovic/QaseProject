package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateAndDeleteTestCaseTest extends BaseTest{

    @Test
    public void createTestCasetest(){
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectListSteps
                .createProject("QA_TmS_Vasiukovich");
        projectSteps
                .createTestSuite("testSuite123");
        projectSteps
                .createTestCase("testCase123");

        Assert.assertTrue(projectPage.getNameTestCase("testCase123").shouldBe(Condition.visible).exists());
    }

    @Test
    public void deleteTestCaseTest(){
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectListSteps
                .createProject("QA_TmS_Vasiukovich");
        projectSteps
                .createTestSuite("testSuite123");
        projectSteps
                .createTestCase("testCase123");
        projectSteps
                .deleteTestCase("testCase123");

        Assert.assertTrue(projectPage.getNameTestCase("testCase123").exists());
    }

    @AfterMethod(alwaysRun = true)
    public void deleteProject(){
        projectListSteps
                .backToPageCreateProject();
        projectListSteps
                .deleteProject("QA_TmS_Vasiukovich");
    }
}