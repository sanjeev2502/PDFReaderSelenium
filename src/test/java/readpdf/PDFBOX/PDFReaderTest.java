package readpdf.PDFBOX;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PDFReaderTest {
	
	
	@Test
	public void readPDFTest() throws IOException {


		System.setProperty("webdriver.chrome.driver", "C:\\Sanjeev_Software\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		//download pdf and keep it in local folder

		driver.get("file:///C:/Users/703235924/Downloads/employee-information-form-download-20170810.pdf");

		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);

		URL url=new URL(currentURL);

		InputStream is=url.openStream();

		BufferedInputStream fileParse=new BufferedInputStream(is);

		PDDocument document=null;
		document=PDDocument.load(fileParse);
		String pdfContent	=new PDFTextStripper().getText(document);

		System.out.println(pdfContent);
	}
}
