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

public class TestVoegKampToe {
    private WebDriver driver;
    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\robbe\\Documents\\UCLL\\2de jaar\\Semester 1\\Web 2\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.get(url + "toevoegen.jsp");

    }

    //@After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_all_fields_are_empty() {
        WebElement jaarInput = driver.findElement(By.id("jaar"));
        jaarInput.clear();
        jaarInput.sendKeys("");

        WebElement kampplaatsInput = driver.findElement(By.id("kampplaats"));
        kampplaatsInput.clear();
        kampplaatsInput.sendKeys("");

        WebElement kampthemaInput = driver.findElement(By.id("kampthema"));
        kampthemaInput.clear();
        kampthemaInput.sendKeys("");

        WebElement scoreInput = driver.findElement(By.id("score"));
        scoreInput.clear();
        scoreInput.sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Kampen | Toevoegen", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een jaar in."));
        assertTrue(containsWebElementsWithText(lis, "Vul een plaats in."));
        assertTrue(containsWebElementsWithText(lis, "Vul een kampthema in."));
        assertTrue(containsWebElementsWithText(lis, "Vul een score tussen 0 en 10 in!"));
    }

    @Test
    public void test_Overzicht_toont_Als_alle_velden_correct_ingevuld_zijn(){
        WebElement jaarInput = driver.findElement(By.id("jaar"));
        jaarInput.clear();
        jaarInput.sendKeys("2019");

        WebElement kampplaatsInput = driver.findElement(By.id("kampplaats"));
        kampplaatsInput.clear();
        kampplaatsInput.sendKeys("Kaulille");

        WebElement kampthemaInput = driver.findElement(By.id("kampthema"));
        kampthemaInput.clear();
        kampthemaInput.sendKeys("De vikingen");

        WebElement scoreInput = driver.findElement(By.id("score"));
        scoreInput.clear();
        scoreInput.sendKeys("9");

        driver.findElement(By.id("submit")).click();

        assertEquals("Kampen | Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebElementsWithText(tds,"2019"));
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
