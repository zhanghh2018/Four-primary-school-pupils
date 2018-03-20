import java.util.HashMap;
import java.util.Stack;

import java.lang.*;
public class Polish {
	public static int polish (String formula) {
		Stack<Integer> s1 = new Stack<Integer>();//放数字
		Stack<String> s2 = new Stack<String>();//放操作符
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("(", 0);
		hashMap.put("+", 1);
		hashMap.put("-", 1);
		hashMap.put("*", 2);
		hashMap.put("/", 2);
		
		for (int i = 0; i < formula.length();) {
			StringBuffer digit = new StringBuffer();
			char c = formula.charAt(i);
			while (Character.isDigit(c) || c == '.') {
				digit.append(c);
				i++;
				c = formula.charAt(i);
			}
			if (digit.length() == 0) {
				switch (c) {
				case '(': {
					s2.push(String.valueOf(c));
					break;
				}
				case ')': {
					String stmp = s2.pop();
					while (!s2.isEmpty() && !stmp.equals("(")) {
						int a = s1.pop();
						int b = s1.pop();
						int sresult = calcInt(b, a, stmp);
						
						
						s1.push(sresult);
						stmp = s2.pop();
					}
					break;
				}
				case '=': {
					String stmp;
					while (!s2.isEmpty()) {
						stmp = s2.pop();
						int a = s1.pop();
						int b = s1.pop();
						int sresult = calcInt(b, a, stmp);
						if(sresult==-1)
						{
							return -1;
						}
						s1.push(sresult);
					}
					break;
				}
				default: {
					String stmp;
					while (!s2.isEmpty()) {
						stmp = s2.pop();
						if (hashMap.get(stmp) >= hashMap.get(String.valueOf(c))) {
							int a = s1.pop();
							int b = s1.pop();
							int sresult = calcInt(b, a, stmp);
							if(sresult==-1)
							{
								return -1;
							}
							s1.push(sresult);

						} else {
							s2.push(stmp);
							break;
						}

					}
					s2.push(String.valueOf(c));
					break;
				}
				}
			} else {
				s1.push(Integer.valueOf(digit.toString()));
				continue;
			}
			i++;
		}
		return s1.peek();
	}
	public static int calcInt(int a, int b, String stmp) {
		int res = 0;
		char s = stmp.charAt(0);
		switch (s) {
		  case '+': {
			res = a + b;
			break;
		  }
		  case '-': {
			res = a - b;
            if(res<0)
            {
            	return -1;
            }
			break;
		  }
		  case '*': {
			res = a * b;
			break;
		  }
		  case '/': {
			res = a / b;
			if(a%b!=0)
			{
				return -1;
			}
			break;
		  }
		}
		return res;
	}
}
