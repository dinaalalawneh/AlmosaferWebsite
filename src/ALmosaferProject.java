import static org.testng.Assert.assertEquals;


import java.time.LocalDate;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ALmosaferProject extends Class{
	
	
			
	@BeforeTest
	
	public void BeforeTests () {
		
		BeforTesting ();
		
	}
	
	
	
	@Test(priority=1)
	public void Languages(){
		
		 String langs = driver .findElement(By.xpath("//a[contains(text(),'العربية')]")).getText();
		 
		 Assert.assertEquals(langs, ExpectedLang);
		
		
	}
	
	@Test(priority=2)
	public void Curancy(){
		
		String SarCurancy = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		
		Assert.assertEquals(SarCurancy, ExpectedCurancy);
		
		
	}
	@Test(priority=3)
	public void Number(){
		String Number = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		
		Assert.assertEquals(Number, EXpectedNumb);
		
	}
	
	
	@Test(priority=4)
	public void Logo(){
		boolean qitafLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		
		Assert.assertEquals(qitafLogo,ExpectedLogo);
		
		
		
	}
	@Test(priority=5)
	public void HotelSearchTab ()
	{
		WebElement Stays = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String Actualflight =  Stays.getAttribute("aria-selected");
		
		Assert.assertEquals(Actualflight, Expectedflight);
		
		
		
		
	}
	@Test (priority=6)
		public void Tomorrow () {
		
		
		String ActualDate = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
	
		
		Assert.assertEquals(ActualDate,expectedDateFormatted);
		
		
		
	}
	@Test (priority=7)
	public void DayAfterTomorrow() {
		
		String ActualDate1 = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
	//	String DATomorrow =Integer.toString(DayAfterTomorrow);

		Assert.assertEquals(ActualDate1, expectedDateFormat);
		
	}
		
		@Test (priority=8)
	public void Randomlanguages() {
			
			
			randomlanguages();
		}
			
			@Test (priority=9 )
			public void Locatin () throws InterruptedException {
				WebElement Hotels = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
				Hotels.click();
				Locatins();
				Thread.sleep(2000);
				
				WebElement List = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
				List.findElements(By.tagName("li")).get(1).click();
				
				
			}
			@Test (priority=10)
			public void Guests() throws InterruptedException {
				Random rand = new Random();
				WebElement guests=driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
				guests.click();
				Select select = new Select(guests);
					int numOfGuests = rand.nextInt(2);
					select.selectByIndex(numOfGuests);
					Thread.sleep(9000);
					
					guest();
					
			}
			
	@Test(priority=11)
	public void Download() throws InterruptedException {
		Thread.sleep(90000);
		WebElement download = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		
		boolean ActualResult =download.getText().contains("found") ||   download.getText().contains("إقامة");
		
		 Assert.assertEquals(ActualResult, ExpectedDownload);
		
	}
	
	
	@Test(priority=12,enabled= false)
	public void SortOption() throws InterruptedException {
		
		Thread.sleep(34000);
		WebElement LowestSort = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		LowestSort.click();
		
		Thread.sleep(2000);
		WebElement ClassSotr = driver.findElement(By.cssSelector(".__ds__comp undefined.MuiBox-root.muiltr-1smo8f0"));
WebElement ClassSotr = driver.findElement(By.cssSelector(".__ds__comp undefined.MuiBox-root.muiltr-1smo8f0"));

		
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar?ncr=1")) {
			List <WebElement> Sortlist = ClassSotr.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld __ds__comp.undefined.muiltr-18vmb2l"));
			int lowestPrice=Integer.parseInt(Sortlist.get(0).getText().replace("SAR",""));
			int highestPrice =Integer.parseInt(Sortlist.get(Sortlist.size()-1).getText().replace("SAR",""));
			
		boolean AcualSort =  lowestPrice<highestPrice ;
		boolean ExpectedSort = true;
			
			Assert.assertEquals(AcualSort, ExpectedSort);
			
		}else {
			
			List <WebElement> Sortlist = ClassSotr.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld __ds__comp.undefined.muiltr-18vmb2l"));
			
			int lowestPrice=Integer.parseInt(Sortlist.get(0).getText().replace("ر.س.‏ ",""));
			int highestPrice =Integer.parseInt(Sortlist.get(Sortlist.size()-1).getText().replace("ر.س.‏ ",""));
			
		boolean AcualSort1 =  lowestPrice<highestPrice ;
		boolean ExpectedSort1 = true;
			
			Assert.assertEquals(AcualSort1, ExpectedSort1);
		}
		
	}
	

}
