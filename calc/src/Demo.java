import zpy.calc.Calc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 4个数字，3、4、7、8
 * 3个符号，×、÷、－
 * 要求各用一次（括号随意），结果 = 10
 * 
 * 实现比较渣，不会加括号
 */
public class Demo {

	public static void main(String[] args) throws Exception {
		String[] num = new String[]{"3", "4", "7", "8"};
		String[] opt = new String[]{"/", "-", "*"};
		Calc calc = new Calc();
		fun(num, list -> fun(opt, list1 -> {
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				s.append(list.get(i));
				s.append(list1.get(i));
			}
			s.append(list.get(3));
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					s.insert(i, '(');
					for (int j = i + 1; j <= s.length(); j++) {
						if (s.charAt(j - 1) >= '0' && s.charAt(j - 1) <= '9') {
							s.insert(j, ')');
							try {
								double d = Double.valueOf(calc.calculator(s.toString()));
								if (d == 10d) {
								System.out.println(s);
								}
							} catch (Exception e) {
							}
							s.deleteCharAt(j);
						}
					}
					s.deleteCharAt(i);
				}
			}
		}));
	}

	public static void fun(String[] strings, Consumer<List<String>> consumer) {
		fun(strings, 0, new ArrayList<>(), consumer);
	}

	public static void fun(String[] strings, int n, List<String> stringList, Consumer<List<String>> consumer) {
		if (n == strings.length) {
			consumer.accept(stringList);
			return;
		}
		List<String> list = new ArrayList<>(stringList);
		for (int i = 0; i <= stringList.size(); i++) {
			list.add(i, strings[n]);
			fun(strings, n + 1, list, consumer);
			list.remove(i);
		}
	}
}
