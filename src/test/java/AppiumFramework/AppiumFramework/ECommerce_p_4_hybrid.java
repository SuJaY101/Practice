package AppiumFramework.AppiumFramework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumFramework.pageObjects.android.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ECommerce_p_4_hybrid extends BaseTest{
@Test
public void fillForm() throws InterruptedException
{
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sachin Tendulkar");
	FormPage formPage=new FormPage(driver);
	formPage.setNameField("Sachin Tendulkar");
	formPage.setGender("female");
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));     
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
	 List<WebElement>productPrices= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	int count=productPrices.size();
	double sum=0;
	
	for(int i=0;i<count; i++)
	{
		String amountString=productPrices.get(i).getText();
		Double price=getFormattedAmount(amountString);
		sum=sum+price;
	}
	String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	Double displayFormattedSum=getFormattedAmount(displaySum);
	Assert.assertEquals(sum, displayFormattedSum);
	
WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
longPressAction(ele); 
driver.findElement(By.id("android:id/button1")).click();
driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
Thread.sleep(6000);
Set<String>contexts=driver.getContextHandles();

for(String contextName :contexts)
{
	System.out.println(contextName);
}
driver.context("WEBVIEW_com.androidsample.generalstore");
driver.findElement(By.name("q")).sendKeys("Rahul shetty academy");
driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
driver.pressKey(new KeyEvent(AndroidKey.BACK));
driver.context("NATIVE_APP"); 
}
}
