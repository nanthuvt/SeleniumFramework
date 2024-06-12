import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class day4 {
	@Test(enabled=true)
	public static void anandhu()
	{
		System.out.println("anandhu display");
	}
	@Test
	public static void anvar()
	{
		System.out.println("anvar display");
	}
	@Test
	@Parameters({"URL"})
	public static void parameterExample(String URLstring)
	{
		System.out.println("para example "+URLstring);
	}

}
