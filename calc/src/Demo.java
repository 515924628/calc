import zpy.calc.Calc;

/**
 * Created by zpy on 2014/9/17.
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		Calc calc = new Calc();
		String str = "-3+5";
		System.out.println(calc.calculator(str));
	}
}
