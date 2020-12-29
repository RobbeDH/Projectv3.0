import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.seleniumhq.jetty9.util.LazyList.contains;

public class TestKampZoeken {
    private WebDriver driver;
    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\robbe\\Documents\\UCLL\\2de jaar\\Semester 1\\Web 2\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.get(url + "zoekKamp.jsp");
    }

   // @After
    public void clean() {
        driver.quit();
    }


    @Test
    public void test_Formulier_toont_opnieuw_met_error_Als_het_veld_leeg_is(){
        WebElement jaarInput = driver.findElement(By.id("jaar"));
        jaarInput.clear();
        jaarInput.sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Kampen | zoeken", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een jaar in."));

    }

    @Test
    public void test_Resultaat_wordt_getoond_Als_veld_juist_ingevuld_is(){
        WebElement naamInput = driver.findElement(By.id("jaar"));
        naamInput.clear();
        naamInput.sendKeys("2010");

        driver.findElement(By.id("submit")).click();
        assertEquals("Kampen | gevonden", driver.getTitle());
        ArrayList<WebElement> hs = (ArrayList<WebElement>) driver.findElements(By.tagName("h1"));
        assertTrue(containsWebElementsWithText(hs, "Kamp 2010 gevonden"));
    }



    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
