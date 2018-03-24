import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import java.util.HashMap;

import java.util.Random;

import java.util.Scanner;

import java.util.Stack;

/*
 * author:zhanghh
 * time:2018.03.18
 * function:Call function 
 */

public class Main {

	public static void main(String args[]) throws IOException {
		
		ReversePolish reversePolish = new ReversePolish();
		RandomEquation randomEqual = new RandomEquation();
		ContentToTxt contentToTxt = new ContentToTxt();
		int questionAmount = -1;
		int result = -1;
		
		//Number of output titles
		
		Scanner num = new Scanner(System.in);
		System.out.println("请输入想要产生的题目个数(1~1000以内的数字):");
		while(questionAmount < 1||questionAmount > 1000){
		        
		    try{
		    	questionAmount = num.nextInt();
		     }catch(Exception e){
		         System.out.println("对不起，请输入1~1000以内的数字");
		         num.next();
		         questionAmount = -1;
		     }
		    
		    if((questionAmount < 1 || questionAmount > 1000) && questionAmount != -1){
		    	 System.out.println("对不起，请输入1~1000以内的数字");
		    }
		} 
		
		//The scope of the output equation result
		
		System.out.println("请输入运算结果的范围(数字)：");
		while(result < 1)
		{
		        
		    try{
		    	result = num.nextInt();
		     }catch(Exception e){
		         System.out.println("对不起，请输入数字(大于1):");
		         num.next();
		         result = -1;
		     }
		    
		    if(result != -1&&result < 1){
		    	System.out.println("对不起，请输入数字(大于1):");
		    }   
		}  
		
		//Define a file and write a school number to a file
		
		String strFilePath = "result.txt";
		String strStuentId = "201571030135";
		System.out.println("正在生成题目，请稍后......");
		BufferedWriter bw = new BufferedWriter(new FileWriter(strFilePath));
		contentToTxt.contentToTxt(strFilePath,strStuentId);
		contentToTxt.contentToTxt(strFilePath,String.valueOf("\n"));
		
		//Output equations and results, and write files
		
		for(int i = 0;i < questionAmount;i++){
			
			String randoms = randomEqual.randomEquation();
			final boolean existed = reversePolish.reversePolish(randoms) != -1 && reversePolish.reversePolish(randoms) < 500;
			if(existed){
				
				contentToTxt.contentToTxt(strFilePath,String.valueOf(randoms+reversePolish.reversePolish(randoms)));
				contentToTxt.contentToTxt(strFilePath,String.valueOf("\n"));
			}else{
				i--;
			}
		}
		num.close();
		
	}
	
}





