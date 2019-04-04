package pl.myblog.springblog.steps;


/**
 * Automatyczne testowanie wybranej części interfesju aplikacji webowej
 * przy zastosowaniu technologii:
 * selenium
 * ququmber
 *
 * @Author: Sławomir Ciecierski
 * <p>
 * <strong>
 * </b>Aplikacja powstała w ramach projektu po kursie prowadzone go przez
 * <a href="http://sdacademy.pl">Software Development Academy</a>
 * </p>
 * </strong>
 * Cel: wykonać sprawdzenie interfejsu dodawania komentarzy do wybranego
 * posta tzn. sprawdzenie zadziałania formularza na stronie
 * localhost:8080/allposts/1
 * Post spowoduje wielokrotne wykonanie czynności
 * wypełnienie pól formularza:
 * text field, id="message"
 * text field, id="name"
 * potwierdzenie wysłanie danych poprzez kliknięcie
 * button, id="sendMessageButton"
 * Parametryzacja:
 * Liczba powtórzeń:  do ustalenia 1000
 * Test uznaje się za zakończony powodzeniem gdy wszystkie operacje
 * zakończą się powodzeniem
 * Uwaga1: testowanie powinno umożliwić wykonanie współbieżne np 10 otwarć jednocześnie
 * lub do ustaenia jako parametr
 * Uwaga2: do parametryzowania użyć języka Gherkin
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

import static java.time.LocalDateTime.*;
import static org.junit.Assert.assertTrue;
import static pl.myblog.springblog.steps.ControllerSpringblogMedia.takeScreenShot;


public class SiteSteps {

  long countOfFailures = 0;

  private RemoteWebDriver driver;


//  private String springBlogWebdriver;
//  private String pathToWebdriver;
//  private String websiteUrlSpringblog;
//  private String comment;
//  private long countOfComments;


  //-----------------------------------Before, Given, When, Then, After
//  @Before
//  public void setUp() {
//    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
//    driver = new ChromeDriver();
//
//  }


  //----------------------------------------------------
  @Given("Użytkownik otworzy stronę komentarzy postu {string} w przeglądarce {string}")
  public void userOpensSiteSpringblog(final String websiteUrlSpringblog, String browser) {

    switch (browser) {
      case "chrome":
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        break;
      case "ie":
        System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        break;
      case "firefox":
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        break;
    }
    driver.get(websiteUrlSpringblog);

  }

  @When("Użytkownik umieści komentarz o treści {string} oraz {string}")
  public void insertCommentsInto(String comment, String content) throws IOException {


    try {
      final WebElement searchBoxElement1 = driver.findElement(By.id("message"));
      final WebElement searchBoxElement2 = driver.findElement(By.id("name"));
      final WebElement searchBoxElement3 = driver.findElement(By.id("sendMessageButton"));


      content = String.format("%s %s", content, now());
      searchBoxElement1.sendKeys(content);

      String nameDriver = driver.getClass().toString();
      comment = comment + nameDriver;
      searchBoxElement2.sendKeys(comment);

      searchBoxElement3.sendKeys(Keys.ENTER);

    } catch (Exception e) {

      takeScreenShot(driver, "Springblog");
      countOfFailures++;
      System.out.println("Niepowodzenie operacji. Ilość błędów: " + countOfFailures);

    } finally {

      System.out.println("niepowodzeń : " + countOfFailures);

    }

  }

  @Then("Użytkownik spodziewa się bezawaryjnego działania w każdej ilości powtórzeń")
  public void userLearnsCountOfFailures() {

    assertTrue("Warunek: ilość niepowodzeń: --> " + countOfFailures + " <-- jest rózna od 0 <-- ",
            countOfFailures == 0);

  }

  @After
  public void finish() {
    driver.close();
  }


}


