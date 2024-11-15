package day47_assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import day47.ExcelUtilities;

public class WebScrapping {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		
		// Define file path and sheet name for Excel utility to save scraped data
		String filePath=System.getProperty("user.dir")+"//testdata//webscrapper.xlsx";
		String sheetName="ProductInfo";
		
		ExcelUtilities excelUtil=new ExcelUtilities(filePath,sheetName);
	
		//Creating header
		excelUtil.setCellData(0, 0, "Product Name");
		excelUtil.setCellData(0, 1, "Product Price");
		 
		int rowindex=1;
		
		List<WebElement>categories=driver.findElements(By.xpath("//div[@class='list-group']/a[@id='itemc']"));
		for (WebElement cat:categories)
		{
			cat.click();
			Thread.sleep(3000);
			
			List<WebElement>productnames=driver.findElements(By.xpath("//div[@id='tbodyid']//h4"));
			List<WebElement>productprice=driver.findElements(By.xpath("//div[@id='tbodyid']//h5"));
		 
			for (int i=1;i<productnames.size();i++)
			{
				excelUtil.setCellData(rowindex, 0, productnames.get(i).getText());
				excelUtil.setCellData(rowindex, 1, productprice.get(i).getText());
				rowindex++;
			}
		
		
		
		}
		
		driver.quit();
		System.out.println("webscrapper assignment done");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
