package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

public class СreateAndDeleteSuiteTest extends BaseTest {

    @Test
    public void createTestSuiteTest(){
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectListSteps
                .createProject("QA_Tms_Vasiukovich");
        projectSteps
                .createTestSuite("testSuite123");

        Assert.assertTrue(projectPage.getNameSuite("testSuite123").shouldBe(Condition.visible).exists());
    }

    @Test
    public void deleteTestSuiteTest(){
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectListSteps
                .createProject("QA_Tms_Vasiukovich");
        projectSteps
                .createTestSuite("testSuite123");
        projectSteps
                .deleteTestSuite("testSuite123");

        Assert.assertTrue(projectPage.getNameSuite("testSuite123").exists());
    }
}
