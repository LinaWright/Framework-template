package IQ;

import com.project.utilities.Driver;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Problem_Solving {
    /*
        Write a Java program to reverse the string str = "java";
         */



    @Test
    public void apiTest() {
        ///https://jsonplaceholder.typicode.com/posts

        /*
        requestBody = "{\r\n" + "  title: 'spidey',\r\n" + "  body: 'bar',\r\n" + "  userId: 101,\r\n" + " }";
         */

        given().accept(ContentType.JSON)
                .and().body("{\r\n" + "  title: 'spidey',\r\n" + "  body: 'bar',\r\n" + "  userId: 101,\r\n" + " }")
                .when().post("https://jsonplaceholder.typicode.com/posts").prettyPeek()
                        .then().statusCode(201);

    }

    @Test
    public void uiTest() throws InterruptedException {
             /*
        Navigate to https://www.hiscox.com/partner-agent/btis

        Click on 'Get Started>' link

        Select State and Profession as "Georgia" and "Accounting" respectively, and click on "Get a Quote" button

        4. Verify recommended Products page is loaded
         */


        Driver.getDriver().get("https://www.hiscox.com/partner-agent/btis");
        //hsx_ss_dpl_guest_link
        WebElement getStartedLink = Driver.getDriver().findElement(By.id("hsx_ss_dpl_guest_link"));
        getStartedLink.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement clientNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@id = 'hsx_ss_businesname_an']"));
        clientNameInputBox.sendKeys("Lina");
        WebElement clientState = Driver.getDriver().findElement(By.xpath("//div[@data-value='GA'a]"));
        Select select = new Select(clientState);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hsx_ss_state_an")));
        select.selectByValue("GA");
        WebElement acounting = Driver.getDriver().findElement(By.xpath("//select[@id = 'hsx_ss_occupation_an']"));
        Select select2 = new Select(acounting);
        select2.selectByValue("Accounting");

        WebElement startQuoteBtn = Driver.getDriver().findElement(By.id("hsx_ss_submitnewquote_btn"));
        startQuoteBtn.click();

        WebElement textVerify = Driver.getDriver().findElement(By.xpath("//h1[.='Please confirm the agent of record for this risk']"));
        textVerify.isDisplayed();
    }

    @Test
    public void test(){
        Driver.getDriver().get("https://www.cvs.com/");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement miniteClinic = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > cvs-footer-container > footer > div > section.upper-footer-container > div.upper-footer-firstrow > cvs-link-block\").shadowRoot.querySelector(\"div:nth-child(2) > ul > li:nth-child(5) > a\")");

        miniteClinic.click();

        WebElement zipCodeSearchBox = Driver.getDriver().findElement(By.id("zip"));
        zipCodeSearchBox.sendKeys("33916");
    }
}

