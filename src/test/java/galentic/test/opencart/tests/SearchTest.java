package galentic.test.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import galentic.test.opencart.base.BaseTest;

public class SearchTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void searchProductTest(){
		resultsPage = accPage.doSearch("Macbook");
		Assert.assertTrue(resultsPage.getProductResultsCount()>0);
	}
		
	@Test
	public void searchPageTitleTest(){
		resultsPage = accPage.doSearch("Macbook");
		String actSearchTitle = resultsPage.getResultsPageTitle("Macbook");
		System.out.println("Search Page Title : " + actSearchTitle);
		Assert.assertEquals(actSearchTitle, "Search - " + "Macbook");
			}
	
	@Test
	public void selectProductTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("Macbook Pro");
		String actProductHeaderName = productInfoPage.getProductHeaderName();
		System.out.println("Actual Product Name : " + actProductHeaderName);
		Assert.assertEquals(actProductHeaderName, "Macbook Pro");
	}
	
	@Test
	public void selectProductImagesTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("Macbook Pro");
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		System.out.println("Actual Product Images Count : " + actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, 4);
	}
	
	
}
