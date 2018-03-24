import java.util.HashMap;

import java.util.Stack;

/*
 * author:zhanghh
 * time:2018.03.18
 * function:Using the inverse Poland calculation equation
 */

public class ReversePolish 
{
	public static int reversePolish(String formula) 
	{
		Stack<Integer> sNumbers = new Stack<Integer>();//Put numbers
		Stack<String> sOperator = new Stack<String>();//Put operator
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("(", 0);
		hashMap.put("+", 1);
		hashMap.put("-", 1);
		hashMap.put("*", 2);
		hashMap.put("¡Â", 2);
		
		//Separate the number from the operator and call the function of calcInt
		
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
					sOperator.push(String.valueOf(c));
					break;
				}
				case ')': {
					String stmp = sOperator.pop();
					while (!sOperator.isEmpty() && !stmp.equals("(")) {
						int a = sNumbers .pop();
						int b = sNumbers .pop();
						int sresult = calcInt(b, a, stmp);
						sNumbers.push(sresult);
						stmp = sOperator.pop();
					}
					break;
				}
				case '=': {
					String stmp;
					while (!sOperator.isEmpty()) {
						stmp = sOperator.pop();
						int a = sNumbers .pop();
						int b = sNumbers .pop();
						int sresult = calcInt(b, a, stmp);
						if(sresult == -1){
							return -1;
						}
						sNumbers .push(sresult);
					}
					break;
				}
				default: {
					String stmp;
					while (!sOperator.isEmpty()) {
						stmp = sOperator.pop();
						if (hashMap.get(stmp) >= hashMap.get(String.valueOf(c))) {
							int a = sNumbers .pop();
							int b = sNumbers .pop();
							int sresult = calcInt(b, a, stmp);
							if(sresult == -1){
								return -1;
							}
							sNumbers .push(sresult);

						} else {
							sOperator.push(stmp);
							break;
						}

					}
					sOperator.push(String.valueOf(c));
					break;
				}
				}
			}else {
				sNumbers .push(Integer.valueOf(digit.toString()));
				continue;
			}
			i++;
		}
		return sNumbers .peek();
	}
	
	//Calculation intermediate results
	
	public static int calcInt(int a, int b, String stmp) 
	{
		int res = 0;
		char s = stmp.charAt(0);
		switch (s) {
		  case '+': {
			res = a + b;
			break;
		  }
		  case '-': {
			res = a - b;
            if(res < 0){
            	return -1;
            }
			break;
		  }
		  case '*': {
			res = a * b;
			break;
		  }
		  case '¡Â': {
			res = a / b;
			if( a % b != 0){
				return -1;
			}
			break;
		  }
		}
		return res;
	}
}
