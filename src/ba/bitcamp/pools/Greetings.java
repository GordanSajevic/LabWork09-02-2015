package ba.bitcamp.pools;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ba.bitcamp.logger.Logger;

public class Greetings implements Runnable{

	private int id;
	
	public Greetings(int id)
	{
		this.id = id;
	}
	
	@Override
	public void run() {
		
		for (int i=0; i<5; i++)
		{
			String message = String.format("I'm " + this.id + ". thread, my count is " + (i+1));
			Logger.log("threadLog", message);
		}
		
	}
	
	public static void main(String[] args) {
		
		HashMap<String, String> logs = new HashMap<String, String>();
		logs.put("threadLog", "threadLog");
		try {
			new Logger(logs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		for (int i=0; i<5; i++)
		{
			es.submit(new Greetings(i));
//			new Thread(new Greetings(i+1)).start();
		}
		es.shutdown();
		while(!es.isTerminated())
		{
			Logger.log("threadLog", "End.");
		}
	}

}
