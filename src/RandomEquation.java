import java.util.Random;

/*
 * author:zhanghh
 * time:2018.03.18
 * function:Generating Equation
 */

public class RandomEquation {
	public static String randomEquation (){
		
		// Previous expressions
		
		String sBefore = new String();
		
		// The later expression
		
		String sLater = new String();
		char[] equation;
		int k = 6;
		int n;
		int m;
		int j;
		int i;
		int[] number;
		char[] symbol;
		number = new int[k];
		symbol = new char[k];
		equation = new char[2 * k];
		char[] cSymbol = {'+','-','*','¡Â'};
		Random random = new Random();
		
		// Generating operator
		
		for(i = 0;i<(int)(Math.random()*3)+3;i++){
			int index = random.nextInt(cSymbol .length); 
			char resultChar = cSymbol[index];
			symbol[i] = resultChar;
			
		}
		for(m = 0;m < i;m++){
			if(symbol[i - 1] != symbol[m]){
				break;
			}
		}
		
		/*
		 * Removal of only one operator
		 * If the last symbol is the same as the previous one, the last one generates a symbol at random.
		 */
		
		if(m == i){
			do{
				int index = random.nextInt(cSymbol.length); 
				char resultChar = cSymbol[index];
				symbol[i - 1] = resultChar;
			}while(symbol[i - 1] == symbol[i - 2]);
		}
		
		// Generating number
		
		for(j = 0;j < i + 1;j++){
				
			int num = (int)(Math.random()*100);
			number[j] = num;
			
		}
		
		// Generating equation
		
		for(n = 0;n < i;n++){
			sBefore += String.valueOf(number[n])+String.valueOf(symbol[n]);
		}
		sBefore += String.valueOf(number[i]);
	
	    // Save symbols and numbers into a equation array 
		
	    for(n = 1;n < 2 * i;n = n+2){
			
	    	equation[n] = symbol[(n - 1) / 2];
		}
	    for(n = 0;n < 2 * j - 1;n = n+2){
			
	    	equation[n] = (char)number[(n + 1) / 2];
			
		}
	   
	  // The removal ¡Â denominator is 0 and the molecular denominator is incompatible
	    
	    for(n = 1;n < i + j && n + 1 < i + j;n = n + 2){
	    	if(equation[n] == '¡Â'){
	    		if(equation[n + 1]==0){
	    			do{
	    				int num2 = (int)(Math.random()*100);
	    				equation[n + 1] = (char)num2;
	    			}while(equation[n + 1] == 0);
	    		}
	    		else if((int)equation[n - 1] % (int)equation[n + 1]!=0 || (int)equation[n - 1]<(int)equation[n + 1]){
	    			do{
	    				
	    				int num2 = (int)(Math.random()*100) + 1;
	    				equation[n + 1] = (char)num2;
	    				if(equation[n + 1] == 0){
	    	    			do{
	    	    				int num3 = (int)(Math.random()*100);
	    	    				equation[n + 1] = (char)num3;
	    	    			}while(equation[n + 1] == 0);
	    	    		}
	    				
	    			}while((int)equation[n - 1] % (int)equation[n + 1]!= 0 || (int)equation[n - 1]<(int)equation[n + 1]);
	    		}
	    		
	    	}
	    	
	    	
	    }
	    // The equation after excluding special circumstances
	    
	    for(n = 0;n < i+j && n + 1 < i + j;n = n + 2){
			
	    	sLater += String.valueOf((int)equation[n]);
	    	sLater += String.valueOf(equation[n + 1]);
			
		}
	    sLater += String.valueOf((int)equation[i + j - 1]);
	    sLater += String.valueOf('=');
	   
	    return sLater;
	}
	
}
