package ba.bitcamp.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

/**
 * This class creates logs and saves it into files.
 * @author gordansajevic
 *
 */

public class Logger {

	private static HashMap<String, FileOutputStream> logs = new HashMap<String, FileOutputStream>();
	
	/**
	 * Constructor with HashMap as parameter, with String as key and FileOutputStream as value
	 * Constructor initializes FileOutputStreams for log types
	 * @warning You need to have logs folder
	 * @param HashMap <String, String> logType
	 * @throws FileNotFoundException
	 */
	
	public Logger(HashMap<String, String> logType) throws FileNotFoundException
	{
		String basePath = "." + File.separator + "logs" + File.separator;
		Set<String> keys = logType.keySet();
		Iterator<String> it = keys.iterator();	
		while(it.hasNext())
		{
			String key = it.next();
			String value = logType.get(key);
			File file = new File(basePath + value + ".txt");
			FileOutputStream fout = new FileOutputStream(file, true);
			logs.put(key, fout);
		}
	}
	
	/**
	 * This method saves logs with date into file
	 * @warning If log does not contain type, log is not saved
	 * @param String type (log type)
	 * @param String message (message that we want to save)
	 */
	
	public static void log(String type, String message)
	{
		if (!logs.containsKey(type))
		{
			return;
		}
		Date d = new Date();
		message = d.toString() + " " + message + "\n";
		FileOutputStream fout = logs.get(type);
		try {
			fout.write(message.getBytes());
			fout.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
