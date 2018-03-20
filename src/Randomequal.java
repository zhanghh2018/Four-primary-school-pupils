import java.util.Random;

import java.lang.*;
public class Randomequal {
	public static String randomequal()
	{
		String s=new String();//之前的表达式
		String s1=new String();//之后的表达式
		char equal[];
		int i,j,m,n,k=6;
		
		int number[];
		char symbol[];
		number=new int[k];
		symbol=new char[k];
		equal=new char[2*k];
		
		char[] c ={'+','-','*','/'};
		Random random=new Random();
		//生成符号
		for(i=0;i<(int)(Math.random()*3)+3;i++)//3~5个运算符
		{
			int index=random.nextInt(c.length); //得到一个随机下标
			char resultChar=c[index];
			symbol[i]=resultChar;
			//System.out.println(symbol[i]);
		}
		//System.out.println(i);
		for(m=0;m<i;m++)
		{
			if(symbol[i-1]!=symbol[m])
			{
				break;
			}
		}
		//System.out.println(m);
		//去除只有一种运算符的情况
		if(m==i)//最后一个与前几个相同，最后一个随机生成一个符号
		{
			do
			{
				int index=random.nextInt(c.length); //得到一个随机下标
				char resultChar=c[index];
				symbol[i-1]=resultChar;
			}
			while(symbol[i-1]==symbol[i-2]);
		}
		/*for(n=0;n<i;n++)
		{
			System.out.println(symbol[n]);
		}
		**/
		//生成数字
		for(j=0;j<i+1;j++)//4~6个数字
		{
				
			int num=(int)(Math.random()*100);//生成数字0~100
			number[j]=num;
			//System.out.println(number[j]);
		}
		
		
		//产生等式
		for(n=0;n<i;n++)
		{
			s+=String.valueOf(number[n])+String.valueOf(symbol[n]);
			
			//System.out.println(s);
		}
		s+=String.valueOf(number[i]);
		//System.out.println("之前的等式：");
	    //System.out.println(s);
	    
	    //将符号与数字存入char equal数组中
	    for(n=1;n<2*i;n=n+2)
        {
			
			equal[n]=symbol[(n-1)/2];
			//System.out.println(equal[n]);
		}
	    for(n=0;n<2*j-1;n=n+2)
		{
			
	    	equal[n]=(char)number[(n+1)/2];
			//System.out.println((int)equal[n]);
			
		}
	    
	  //去掉/分母为0的情况以及分子分母除不尽的情况
	    for(n=1;n<i+j&&n+1<i+j;n=n+2)
	    {
	    	if(equal[n]=='/')
	    	{
	    		if(equal[n+1]==0)
	    		{
	    			do{
	    				int num2=(int)(Math.random()*100);
		    			equal[n+1]=(char)num2;
	    			}
	    			while(equal[n+1]==0);
	    		}
	    		else if((int)equal[n-1]%(int)equal[n+1]!=0||(int)equal[n-1]<(int)equal[n+1])
	    		{
	    			do{
	    				//int num1=(int)(Math.random()*100)+1;//生成数字0~100
	    				int num2=(int)(Math.random()*100)+1;
	    				//equal[n-1]=(char)num1;
	    				equal[n+1]=(char)num2;
	    				if(equal[n+1]==0)
	    	    		{
	    	    			do{
	    	    				int num3=(int)(Math.random()*100);
	    		    			equal[n+1]=(char)num3;
	    	    			}
	    	    			while(equal[n+1]==0);
	    	    		}
	    				
	    			}while((int)equal[n-1]%(int)equal[n+1]!=0||(int)equal[n-1]<(int)equal[n+1]);
	    		}
	    		
	    	}
	    	
	    	
	    }
	    //之后的等式
	    for(n=0;n<i+j&&n+1<i+j;n=n+2)
		{
			
	    	s1+=String.valueOf((int)equal[n]);
	    	//System.out.println(s1);
	    	s1+=String.valueOf(equal[n+1]);
			//System.out.println(s1);
		}
	    s1+=String.valueOf((int)equal[i+j-1]);
	    //System.out.println(s1);
	    /*for(n=0;n<2*j-1;n=n+2)
		{
			
	    	s1+=String.valueOf((int)equal[(n+1)/2]);
			System.out.println(s1);
		
		}*/
	    //System.out.println("之后的等式：");
	    s1+=String.valueOf('=');
	    //System.out.print(s1);
	    return s1;
	}
	
}
