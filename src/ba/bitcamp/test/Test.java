package ba.bitcamp.test;

import java.io.FileNotFoundException;
import java.util.HashMap;

import ba.bitcamp.logger.Logger;

public class Test {

	public static void main(String[] args) throws FileNotFoundException 
	{
		HashMap<String, String> logs = new HashMap<String, String>();
		logs.put("application", "application");
		logs.put("error", "error");
		logs.put("warning", "warning");
		new Logger(logs);
		Logger.log("application", "application");
		Logger.log("error", "error");
		Logger.log("warning", "warning");
	}

}
