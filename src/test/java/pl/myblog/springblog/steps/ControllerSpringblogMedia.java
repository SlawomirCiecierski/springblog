package pl.myblog.springblog.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.util.FileCopyUtils;

import static java.time.LocalDateTime.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ControllerSpringblogMedia {


  static void takeScreenShot(WebDriver driver, String name) throws IOException {

    if (!(driver instanceof TakesScreenshot)) {
      return;
    }
    TakesScreenshot shot = (TakesScreenshot) driver;
    byte[] screenshotAs = shot.getScreenshotAs(OutputType.BYTES);
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
