
public class Testcase {

	public static void main(String[] args) {


		Rectangle s = new Rectangle(2,4);
		System.out.println(s);
		System.out.println("Area is " + s.getArea());
		Diamond d = new Diamond(3);
		System.out.println(d);
		System.out.println("Area is " + d.getArea());
		Shape union = s.union(d);
		System.out.println(union);
		System.out.println("Area is " + union.getArea()); 
		Shape intersect = s.intersect(d); 
		System.out.println(intersect); 
		System.out.println("Area is " + intersect.getArea());

		
	}
		
}
