import org.testng.annotations.Test;

public class TestNGSample {

    @Test(groups={"group1"})
    public static void TestNG1()
    {
        System.out.println("TestNG method 1");
    }

    @Test
    public static void TestNG2()
    {
        System.out.println("TestNG method 1");
    }
}
