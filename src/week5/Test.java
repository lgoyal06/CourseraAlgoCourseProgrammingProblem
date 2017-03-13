package week5;

public class Test {
	public static void main(String... s) {
		Object[] arrObj = { 1, 2, "SD", 2.3, new PrimitiveCalculator() };
		String[] arrString = new String[arrObj.length];
		for (int i = 0; i < arrObj.length; ++i) {
			arrString[i] = arrObj[i].toString();
		}
		for (int j = 0; j < arrObj.length; ++j)
			System.out.println(arrString[j]);
	}
}