import org.apache.commons.mail.*;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
//    WebDriver driver = new HtmlUnitDriver();
//    WebDriver driver = new ChromeDriver();
    WebDriver driver;
    String bookNames[] = {"'Ware Hawk", "100 malicious little mysteries", "101 family vacation games", "Your father forever"};
//    HomePage objHomePage = new HomePage(driver);
    HomePage objHomePage;
    Properties prop = new Properties();
    FileInputStream fis;
    {
        try {
            String currentDirectory = System.getProperty("user.dir");
            fis = new FileInputStream(currentDirectory + "/src/main/resources/Data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeSuite
    public void setUpProject() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        objHomePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        prop.load(fis);
        String url = prop.getProperty("url");
        driver.get(url);
    }
    @Test(priority = 1)
    public void verifyHomePage() {
        objHomePage.seesBookStoreHeading();
        objHomePage.seesSearchBar();
        objHomePage.seesCartButton();
        objHomePage.seesBooks();
        objHomePage.seesPageIndicator();
    }
    @Test(priority = 2)
    public void verifySearchFunctionality() throws InterruptedException {
        objHomePage.clickOnBookElement();
        objHomePage.getBookTitle();
        Thread.sleep(1000);
        objHomePage.clickOnCloseButton();
        Thread.sleep(2000);
        objHomePage.searchBookByName(bookNames[0]);
        Thread.sleep(2000);
        objHomePage.clickOnBookElement();
        Thread.sleep(2000);
        objHomePage.assertBookName(bookNames[0]);
        Thread.sleep(1000);
        objHomePage.clickOnCloseButton();
    }
    @Test(priority = 3)
    public void verifyBookScreen() throws InterruptedException {
        objHomePage.clickOnBookElement();
        objHomePage.verifyBooksPage();
        Thread.sleep(2000);
        objHomePage.clickOnCloseButton();
    }
    @Test(priority = 4)
    public void checkMoreBooksByAuthor() throws InterruptedException {
        objHomePage.clickOnBookElement();
        Thread.sleep(2000);
        objHomePage.clickOnAuthorName();
        Thread.sleep(2000);
        objHomePage.seesOtherBooksByAuthor();
        objHomePage.seesBooks();
        Thread.sleep(2000);
        objHomePage.backToHomePage();
    }
    @Test(priority = 5)
    public void addToCartFunctionality() throws InterruptedException {
        objHomePage.searchBookByName(bookNames[0]);
        objHomePage.clickOnBookElement();
        Thread.sleep(2000);
        objHomePage.clickOnAddToCartButton();
        Thread.sleep(2000);
        objHomePage.clickOnCloseButton();
        objHomePage.searchBookByName(bookNames[3]);
        Thread.sleep(2000);
        objHomePage.clickOnBookElement();
        Thread.sleep(2000);
        objHomePage.clickOnAddToCartButton();
        Thread.sleep(2000);
        objHomePage.clickOnCloseButton();
        Thread.sleep(2000);
        objHomePage.clickOnCartButton();
        Thread.sleep(3000);
        objHomePage.verifyCartPage();
        Thread.sleep(2000);
        objHomePage.clickOnCheckOutButton();
        Thread.sleep(2000);
        objHomePage.verifyCheckOutPage();
        objHomePage.clickOnCloseButtonInCheckOutPage();
    }
    @AfterSuite
    public void closeBrowser() throws Exception {
        driver.close();
        driver.quit();
//        Thread.sleep(10000);
//        EmailAttachment attachment = new EmailAttachment();
//        attachment.setPath("test-output/emailable-report.html");
//        attachment.setDisposition(EmailAttachment.ATTACHMENT);
//        attachment.setDescription("Report Selenium - emailable-report.html");
//        attachment.setName("Report Selenium - emailable-report.html");
//        MultiPartEmail email = new MultiPartEmail();
//        email.setHostName("smtp.googlemail.com");
//        email.setSmtpPort (465);
//        prop.load(fis);
//        email.setAuthenticator(new DefaultAuthenticator(prop.getProperty("userName"), prop.getProperty("password")));
//        email.setSSLOnConnect(true);
//        email.setFrom(prop.getProperty("userName"));
//        email.setSubject("Good job buddy: TestMail");
//        email.setMsg("This is a test mail from selenium:bookStoreDemo testcases:- Your testcases are successfully fine until now");
//        email.addTo(prop.getProperty("userName"));
//        email.attach(attachment);
//        email.send();
    }
}