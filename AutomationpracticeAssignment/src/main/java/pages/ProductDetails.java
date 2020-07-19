package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWomenSection() {

		driver.findElement(By.xpath("$x(\"/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a\")")).click();
	}

	/**
	 * This method will select small size in product details page
	 */
	public void selectSmallSize() {
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
	}

	/**
	 * This method will select medium size in product details page
	 */
	public void selectMediumSize() {

		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).isSelected();

	}

	/**
	 * This method will select large size in product details page
	 */
	public void selectLargeSize() {

		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();

	}
	
	/**
	 * This method will click on first product in product details page
	 */
	public void selectProduct() {
		Actions obj = new Actions(driver);
		obj.moveToElement(driver.findElements(By.xpath(".//*[@id='center_column']/ul/li")).get(0)).build().perform();
		driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
	}
}
