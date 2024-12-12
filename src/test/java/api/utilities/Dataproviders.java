package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	
	@DataProvider(name="data")
	public static String[][] data() throws IOException {
		
		
		String path =System.getProperty("user.dir")+"//testData//UserTestData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowCount = xl.getRowCount("Sheet1");
		
		int cellCount = xl.getCellCount("Sheet1", 1);
		
		String xldata[][]=new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				xldata[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		
		return xldata;
		
	}
	
	@DataProvider(name="username")
	public static String[] getCellName() throws IOException {
		String path =System.getProperty("user.dir")+"//testData//UserTestData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowCount = xl.getRowCount("Sheet1");
		
		String apidata[] = new String[rowCount];
		
		for(int i=1; i<=rowCount; i++) {
			 apidata [i-1]= xl.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
		
	}

}
