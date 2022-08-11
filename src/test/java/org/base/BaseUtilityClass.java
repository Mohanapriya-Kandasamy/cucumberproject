package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtilityClass {
	

	public static  WebDriver driver;
	static Actions a;
	static Robot r;
	static Select s;
	static JavascriptExecutor js;
	static Alert alert;

//1
	public static void launchBrowser(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		}
		
		
		
		
	}

//2
	public static void launchUrl(String url) {

		driver.get(url);
	}

//3
	public static void printUrl() {
		driver.getCurrentUrl();

	}

//4
	public static void printTitle() {
		driver.getTitle();

	}

//5
	public static void windowMax() {
		driver.manage().window().maximize();
	}

//6

	public static void fillValue(WebElement e, String value) {
		e.sendKeys(value);
	}

//7
	public static void clickElement(WebElement e) {
		e.click();

	}

//8
	public static void printText(WebElement e) {

		String text = e.getText();
		System.out.println(text);
	}

//9
	public static String printAttributevalue(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}

//10
	public static void doubleClkBtn(WebElement e) {
		a = new Actions(driver);
		a.doubleClick(e).perform();

	}

//11
	public static void clickUsingAction(WebElement e) {
		a = new Actions(driver);
		a.click(e).perform();
	}

//12	
	public static void contextClkBtn(WebElement e) {
		a = new Actions(driver);
		a.contextClick(e).perform();
	}

//13
	public static void moveTOElementBtn(WebElement e) {
		a=new Actions(driver);
		a.moveToElement(e).perform();
	}

//14
	public static void dragAndDropBtn(WebElement src, WebElement dest) {
		a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();

	}

//15
	public static void downBtn() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

//16
	public static void enterBtn() {
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

//17
	public static void copyBtn(WebElement e) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

	}

//18
	public static void tabBtn() {
		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

	}

//19
	public static void pasteBtn() {

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

//20	
	public static void scrollDown(WebElement e) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);

	}

// 21
	public static void scrollUp(WebElement e) {
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}

// 22
	public static void clickExeScript(WebElement e) {

		js.executeScript("arguments[0].click", e);
	}

// 23
	public static void frameSwitchToIndex(int i) {
		driver.switchTo().frame(i);

	}
// 24

	public static void frameSwitchToId(String id) {
		driver.switchTo().frame(id);

	}

// 25
	public static void frameSwitchToElement(WebElement e) {
		driver.switchTo().frame(e);

	}

// 26
	public static void frameSwitchToName(String name) {
		driver.switchTo().frame(name);

	}

// 27
	public static void getSingleWindowId() {
		driver.getWindowHandle();
	}

// 28
	public static void getMultiWindowId() {
		driver.getWindowHandles();
	}

//29
	public static void defaultContentSwitch() {
		driver.switchTo().defaultContent();

	}

//30
	public static void windowSwitchTO(int index) {
		List li = new ArrayList();
		driver.switchTo().window((String) li.get(index));

	}

//31
	public static void screenshot(String path) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f1 = tk.getScreenshotAs(OutputType.FILE);
		File f2 = new File(path);
		FileUtils.copyFile(f1, f2);
	}

//32
	public static void switchAlert() {
		alert = driver.switchTo().alert();
	}

//33	
	public static void alertAccept() {

		alert.accept();
	}

//34	
	public static void alertDismiss() {
		alert.dismiss();

	}

//35	
	public static void alertSendKeys(String value) {
		alert.sendKeys(value);
	}

//36	
	public static void selectIndexbtn(WebElement e, int i) {
		s = new Select(e);
		s.selectByIndex(i);

	}

//37
	public static void selectValuebtn( WebElement e, String value) {
        s= new Select(e);
		s.selectByValue(value);

	}

//38
	public static void selectTextBtn(WebElement e,String text) {
		s=new Select(e);
		s.selectByVisibleText(text);
	}

//39
	public static void deselectIndexBtn(WebElement e,int i) {
		s= new Select(e);
		s.deselectByIndex(i);

	}

//40
	public static void deselectValueBtn(WebElement e,String value) {
		s=new Select(e);
		s.deselectByValue(value);

	}

//41
	public static void deselectTextBtn(WebElement e,String text) {
		s= new Select(e);
		s.deselectByVisibleText(text);
	}

//42
	public static void deselectAllOptions(WebElement e) {
		s=new Select(e);
		s.deselectAll();

	}
//43

	public static void windowQuit() {
		driver.quit();

	}

//44
	public static void windowClose() {
		driver.close();

	}
//45	
	public static void implicityWait() {// default polling time:250 milliseconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
//46
	public static void explicitWebDriverWait() {   //default polling frequency:500ms
	WebDriverWait w=new WebDriverWait(driver, 10);  //can't handle timeout exception
	}
//47
	public static void explicitFluentWait() {
		FluentWait<WebDriver> f= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).
				pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);
	}


//48
	public static void excelReadSingle(int rownum, int cellnum) throws IOException {
		File file = new File("C:\\Users\\siddh\\eclipse-workspace\\MavenProject\\ExcelSheet\\hotellogin.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		System.out.println(cell);
	}
	
// 49
	public static String excelReadWhole(int rowno, int cellno) throws IOException {
		File f = new File("C:\\Users\\siddh\\eclipse-workspace\\MavenProject\\ExcelSheet\\facebook.xlsx");

		FileInputStream file = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(file);

		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);

		int cellType = cell.getCellType();

		String value = "";

		if (cellType == 1) {

			value = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date dateCellValue = cell.getDateCellValue();

			SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

			value = s.format(dateCellValue);

		} else {
			double numericCellValue = cell.getNumericCellValue();

			long l = (long) numericCellValue;
			value = String.valueOf(l);

		}

		return value;
	}

//50
	public static void excelWrite(String filename, String name, int rowno, int cellno, String value)
			throws IOException {
		File f = new File("C:\\Users\\siddh\\eclipse-workspace\\MavenProject\\ExcelSheet\\" + filename + ".xlxs ");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet(name);
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(value);
		FileOutputStream setdata = new FileOutputStream(f);
		book.write(setdata);
		System.out.println("data created");

	}

//51
	
	
	
	public static void toGetExcelValue() throws IOException {
		File f = new File("C:\\Users\\siddh\\eclipse-workspace\\MavenProject\\ExcelSheet\\MavenExcelSheet.xlsx");

		FileInputStream file = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(file);

		Sheet sheet = book.getSheet("Sheet1");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);

				int cellType = cell.getCellType();

				String value = "";

				if (cellType == 1) {

					value = cell.getStringCellValue();

				} else if (DateUtil.isCellDateFormatted(cell)) {

					Date dateCellValue = cell.getDateCellValue();

					SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

					value = s.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();

					long l = (long) numericCellValue;
					value = String.valueOf(l);

				}
			

				System.out.println( value);

			}//inner for loop
			}//outer for loop
		}//method closing
	//52
	public static void excelUpdate(String sheetName,int rownum,int cellnum,String newvalue) throws IOException {
		File file = new File("C:\\Users\\siddh\\eclipse-workspace\\MavenProject\\ExcelSheet\\marksheet.xlxs");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String Value = cell.getStringCellValue();
		if (Value == Value) {
			cell.setCellValue(newvalue);
			
		}else {
			cell.setCellValue("notchange");
		}
		
			FileOutputStream setdata = new FileOutputStream(file);
			book.write(setdata);
		System.out.println("change done");
		
	}
	
	
	//53
	public static void excelInsertData(String name, int rowno, int cellno, String value)
			throws IOException {
		File f = new File("C:\\Users\\siddh\\eclipse-workspace\\MavenProject\\ExcelSheet\\EmployeeDetails.xlxs");
		FileInputStream FIS= new FileInputStream(f);
		Workbook book = new XSSFWorkbook(FIS);
		Sheet sheet = book.getSheet(name);
		
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		
		cell.setCellValue(value);
		FileOutputStream setdata = new FileOutputStream(f);
		book.write(setdata);
		System.out.println("cell created");
		

	}
	//54
	
	public static void refresh() {
	 driver.navigate().refresh();

	}
	
	
	
}
