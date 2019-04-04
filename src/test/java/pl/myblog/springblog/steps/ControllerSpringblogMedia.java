package pl.myblog.springblog.steps;
/**
 * moduł wykonujący printscreena zadanego obiektu klasy WebDriver
 */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.util.FileCopyUtils;
import static java.time.LocalDateTime.*;
import java.io.File;
import java.io.IOException;


public class ControllerSpringblogMedia {

  /**
   *
   * @param driver obiekt klasy WebDriver
   * @param name część nazwy pliku: Springblog
   * @throws IOException
   */
  static void takeScreenShot(WebDriver driver, String name) throws IOException {

    if (!(driver instanceof TakesScreenshot)) {
      return;
    }
    TakesScreenshot shot = (TakesScreenshot) driver;
    byte[] screenshotAs = shot.getScreenshotAs(OutputType.BYTES);
    /**
     * tworzenie ścieżki dostępu i nazwy pliku
     * w nazwie pliku jest data utworzenia oraz klasa obiektu driver
     */
    String prefix = String.format("%03d", 0) + "_";
    String newNow = "Failure" + now().toString().replace(":", "_");
    newNow = newNow.replace("-", "_");
    String nameOfPicture=driver.getClass().toString();
    File file = new File("build/" + prefix + name +nameOfPicture+ newNow + ".png");
    file.getParentFile().mkdirs();
    file.createNewFile();
    FileCopyUtils.copy(screenshotAs, file);


  }



}
