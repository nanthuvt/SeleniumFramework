import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class day3 {
	
	@Test(dependsOnMethods={"irin"})
	public static void abhijith()
	{
		System.out.println("Abhijith display");
	}
	
	@Test(dataProvider="getData")
	public static void irin(String uname,String pwd)
	{
		System.out.println(uname+"  "+pwd);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="firstUname";
		data[0][1]="firstPwd";
		
		data[1][0]="SecongUname";
		data[1][1]="secondPwd";
		
		return data;
	}
	

}
