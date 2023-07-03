package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By bookElements = By.cssSelector("div#id-book-catalog>div");
    By cartButton = By.id("id-cart");
    By searchBar = By.cssSelector("form > input[name='search']");
    By searchIcon = By.cssSelector("button[type='submit']");
    By bookStoreHeading = By.xpath("//header/a/h1");
    By pageNumberIndicator = By.xpath("//footer/nav/ul/li");
    By addToCartButton = By.cssSelector("button[name=\"book_id\"]");
    By bookTitle = By.id("bookDetailsLabel");
    By authorName = By.cssSelector("a[data-bs-dismiss='modal']");
    By bookPrice = By.xpath("//h2[@class='mx-2 my-2']");
    By bookDescription = By.cssSelector("h4.py-3");
    By bookPublisher = By.cssSelector("div#id-book-details>div>div:nth-of-type(2)>p");
    By bookPublicationDate = By.xpath("(//div[@class='col']//p)[2]");
    By bookIsbn10 = By.xpath("(//div[@class='col']//p)[3]");
    By bookIsbn13 = By.xpath("(//div[@class='col']//p)[4]");
    By closeIcon = By.xpath("(//button[@aria-label='Close'])[1]");
    By closeButton = By.xpath("(//button[@type='button'])[2]");
    By inCartButton = By.xpath("//button[contains(text(),'in cart')]");
    By shoppingCartLabel = By.xpath("//h1[@id='cartLabel']");
    By shoppingCartItems = By.cssSelector("table#id-book-catalog>tbody>tr");
    By checkOutButton = By.id("id-checkout-button");
    By checkOutPage = By.cssSelector("h1.my-3");
    By checkOutCloseButton = By.xpath("(//button[text()='Close'])[2]");
    By authorsNameVerify = By.cssSelector("div > h5");



    public HomePage(WebDriver driver) {
        this.driver= driver;
    }

    public void seesBooks() {
        for (int i = 0; i < 10; i++) {
            driver.findElements(bookElements).get(i).isDisplayed();
            driver.findElements(addToCartButton).get(i).isDisplayed();
        }
    }
    public void seesCartButton() {
        driver.findElement(cartButton).isDisplayed();
    }
    public void clickOnAddToCartButton() {
        driver.findElement(addToCartButton).click();
        driver.findElement(inCartButton).isDisplayed();
    }
    public void seesSearchBar() {
        driver.findElement(searchBar).isDisplayed();
    }
    public void seesBookStoreHeading() {
        driver.findElement(bookStoreHeading).getText().equals("Bookstore");
    }
    public void seesPageIndicator() {
        driver.findElement(pageNumberIndicator).isDisplayed();
    }
    public void clickOnBookElement() {
        driver.findElements(bookElements).get(0).click();
    }
    public void getBookTitle() {
        driver.findElement(bookTitle).getText();
    }
    public void assertBookName(String name) {
        driver.findElement(bookTitle).getText().equals(name);
        System.out.println("Book names are matching");
    }
    public void verifyBooksPage() {
        driver.findElement(authorName).isDisplayed();
        String price = driver.findElement(bookPrice).getText();
        System.out.println(price);
        driver.findElement(bookDescription).isDisplayed();
        driver.findElement(bookPublisher).isDisplayed();
        driver.findElement(bookPublicationDate).isDisplayed();
        driver.findElement(bookIsbn10).isDisplayed();
        driver.findElement(bookIsbn13).isDisplayed();
        driver.findElement(closeIcon).isDisplayed();
        driver.findElement(closeButton).isDisplayed();
        driver.findElement(addToCartButton).isDisplayed();
    }
    public void clickOnCloseButton() {
        driver.findElement(closeIcon).click();
    }
    public void searchBookByName(String name) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(name);
        driver.findElement(searchIcon).click();
    }
    public void clickOnCartButton() {
        driver.findElement(cartButton).click();
    }
    public void verifyCartPage() {
        driver.findElement(shoppingCartLabel).getText().equals("Your Shopping Cart");
        for (int i = 0; i < 2; i++) {
            driver.findElements(shoppingCartItems).get(i).isDisplayed();
        }
        driver.findElement(checkOutButton).isDisplayed();
    }
    public void clickOnCheckOutButton() {
        driver.findElement(checkOutButton).click();
    }
    public void verifyCheckOutPage() {
        driver.findElement(checkOutPage).getText().equals("This is a demo store. You can't buy a real thing here.");
        driver.findElement(checkOutCloseButton).isDisplayed();
    }
    public void clickOnCloseButtonInCheckOutPage() {
        driver.findElement(checkOutCloseButton).click();
    }
    public void clickOnAuthorName() {
        System.out.println(driver.findElement(authorName).getText());
        driver.findElement(authorName).click();
    }
    public void seesOtherBooksByAuthor() {
        System.out.println(driver.findElement(authorsNameVerify).getText());
        driver.findElement(authorsNameVerify).isDisplayed();
    }
    public void backToHomePage() {
        driver.findElement(bookStoreHeading).click();
    }
}