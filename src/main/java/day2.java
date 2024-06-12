import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class day2 {

	@BeforeTest
	public static void akhil()
	{
	System.out.println("Akhil display");
	}
	
	@Test(groups={"group1"})
	public static void JelsyFirst()
	{
		System.out.println("Jelsy display");
	}
	@Test
	public static void JelsySecond()
	{
		System.out.println("Jelsy display");
	}
}
