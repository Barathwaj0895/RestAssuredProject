package restapipackage;
import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {
//		Object[][] data = new Object[2][3];
//		data[0][0] = "Nikola";
//		data[0][1] = "Tesla";
//		data[0][2] = 2;
//		
//		data[1][0] = "Albert";
//		data[1][1] = "Einstein";
//		data[1][2] = 1;
//		
//		return data;
		
		return new Object[][] {
			{"Graham","Bell",3},
			{"Issac","Newton",1},
		};
	}
	
	@DataProvider(name= "DeleteData")
	public Object[] dataForDelete() {
		return new Object[] {
				5,6
		};
	}
}
