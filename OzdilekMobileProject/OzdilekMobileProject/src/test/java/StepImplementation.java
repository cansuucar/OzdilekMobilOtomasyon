import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest{  //Base metodlarımızı yazdıgımız yer


    @Step("<time> saniye kadar bekle")
    public void waitForseconds(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }

    @Step("id <id> li elemente tıkla") //Tıklama metodu
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("xpath <xpath> li elemente tıkla") // xpath tıklama metodu
    public void clickXpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
    }


    @Step("id <id> li elementi bul ve <text> değerini yaz")
    public void sendkeysByid(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }


    @Step("Android klavyeyi kapat")
    public void closeKeyboardonAndroid(){
        appiumDriver.hideKeyboard();


    }
   // o sayfada mıyım kontrolü
    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreacontrol(String id,String text){
        Assert.assertTrue("Element text değerini içeriyor",appiumDriver.findElement(By.id(id)).getText().contains(text));
    }


    @Step("Sayfayı hareket ettir")
    public void swipeLeft() {
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 300; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point( dims.width / 2, edgeBorder);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();

    }

    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String xpath){
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
    }





    }




