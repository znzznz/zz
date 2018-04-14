package jp.com.znzznz.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyManager {
	
	public static HashMap<String, String> load(String name){
		
		return new HashMap<String, String>(){{
			
			String fname = String.format("%s/resource/%s.properties", System.getProperty("user.dir"), name);
			
			new Properties(){{
				try{ this.load(new FileInputStream(fname));}
				catch(Exception e){ e.printStackTrace(); }
			}}.forEach((k, v) -> {
				
				this.put(k.toString(), v.toString());
			});
		}};
	}
}
