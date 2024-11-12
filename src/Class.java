import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Class {

	WebDriver driver = new ChromeDriver();
	String AlmosaferWebsite ="https://www.almosafer.com/en";
	Random rand = new Random();
	String ExpectedLang = "العربية";
	String ExpectedCurancy = "SAR";
	String EXpectedNumb="+966554400000";
	boolean ExpectedLogo = true;
	String Expectedflight = "false";
	int ExpectedDate = LocalDate.now().plusDays(1).getDayOfMonth();
	String expectedDateFormatted = String.format("%02d", ExpectedDate);
	
	int DayAfterTomorrow =LocalDate.now().plusDays(2).getDayOfMonth();
	String expectedDateFormat = String.format("%02d", DayAfterTomorrow);
	boolean ExpectedDownload =true;
	
	
	
	
	
	
	
	
	public void BeforTesting () {
		
		driver.get(AlmosaferWebsite);
		driver.manage().window().maximize();
		WebElement Suadikindom = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		Suadikindom.click();
		
		
	}
	
	
	
	
	public void randomlanguages() {
		String [] Lang ={"https://www.almosafer.com/ar?ncr=1","https://www.almosafer.com/en?ncr=1"};
		Random rand = new Random();
		int URl = rand.nextInt(Lang.length);
		
		driver.get(Lang[URl]);
		
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar?ncr=1")) {
			 String langs = driver .findElement(By.xpath("//a[normalize-space()='English']")).getText();
			 String ExpectedLang = "English";
			 Assert.assertEquals(langs, ExpectedLang);
		}else {
			
			
			 String langs = driver .findElement(By.xpath("//a[contains(text(),'العربية')]")).getText();
			 String ExpectedLang = "العربية";
			 Assert.assertEquals(langs, ExpectedLang);
		}
		
	}
	
	
	public void sotOptions() {
		
		
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
	
	
	
	
	public void Locatins() {
		
		
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar?ncr=1")) {
			String langs = driver .findElement(By.xpath("//a[normalize-space()='English']")).getText();
			 String ExpectedLang = "English";
			 Assert.assertEquals(langs, ExpectedLang);
			Random rand = new Random();
	     	String[] Ar ={"دبي","جدة"};
			
		String	 AraElement=Ar[rand.nextInt(Ar.length)];
			WebElement Input = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
			Input.sendKeys(AraElement);
		}else {
			String langs = driver .findElement(By.xpath("//a[contains(text(),'العربية')]")).getText();
			 String ExpectedLang = "العربية";
			 Assert.assertEquals(langs, ExpectedLang);
			Random rand = new Random();
			String[] En ={"Dubai","Jaddah","Riyadh"};
			String ENG = En[rand.nextInt(En.length)];
			WebElement Input= driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
			Input.sendKeys(ENG);
		
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	public void guest() {
		
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar?ncr=1")) {
			WebElement Search1 = driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk"));
			Search1.click();
		}else {
			WebElement Search = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.sc-1vkdpp9-6.iKBWgG.js-HotelSearchBox__SearchButton.btn.btn-primary.btn-block"));
			Search.click();
			
			 
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
