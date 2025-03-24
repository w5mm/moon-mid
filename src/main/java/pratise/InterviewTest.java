package pratise;

public class InterviewTest {
	public static void main(String[] args) {
        String a = "12345";
        String b = "12345";
        System.out.println(a==b);
        System.out.println(a.equals(b));
        String c = new String("12345");
        String d = new String("12345");
        System.out.println(c==d );
        System.out.println(c.equals(d));


	}
}
