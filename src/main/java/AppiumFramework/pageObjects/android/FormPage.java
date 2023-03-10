package AppiumFramework.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sachin Tendulkar");
AndroidDriver driver;
	public FormPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	} 
@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
private WebElement nameField;

@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
private WebElement femaleOption;

@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
private WebElement maleOption;

@AndroidFindBy(id="android:id/text1")
private WebElement countrySelection;

public void setNameField(String name)
{
	nameField.sendKeys(name);
	driver.hideKeyboard();
}
public void setGender(String gender)
{
	if (gender.contains("Female"))
		femaleOption.click();
	else
		maleOption.click();
}



}
