package PropertyClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

   public class Property   
      {	
	    public  static String getData(String DATA,String key) throws IOException
	    {  	
	    	Properties pro=new Properties();
	    	//FileInputStream fis=new FileInputStream("C:\\Test-OXYGEN\\RedBookTest\\Property_File\\"+DATA+".properties");
	    	FileInputStream fis=new FileInputStream("C:\\Test-OXYGEN\\RedBook\\Property_File\\"+DATA+".properties");
	    	pro.load(fis);
	    	
	    	String data=pro.getProperty(key);

	    	return data;
	     }
         }
   
