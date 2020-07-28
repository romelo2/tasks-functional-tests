package br.ce.wcaquino.tasks.prod;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIT {
	
	@Test
	public void healthCheck() {
		WebDriver driver = new ChromeDriver();
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		//WebDriver driver = new WebDriver(new URL("http://3.92.21.158:4444/wd/hub"), cap );
		try {
			driver.navigate().to("http://192.168.0.100:9999/tasks/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.startsWith("build_"));			
		} finally {
			driver.quit();
		}
	}
}
