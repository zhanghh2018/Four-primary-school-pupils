import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/*
 * author:zhanghh
 * time:2018.03.18
 * function:Write the content to the file
 */

public class ContentToTxt 
{
	public static void contentToTxt(String filePath, String content) 
	{

        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath),true));

            writer.write(content);

            writer.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }
}

