import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Acquisition {
	private static String nomOutput="output.txt";
	private int periode;
	private int iteration;

	
	
	
	public Acquisition(int per, int iter) {
			periode=per;
			iteration=iter;
			Json json=new Json();
			Station[] tab = json.getResult();
			int[] data=new int[tab.length];
			int j=0;
			for (Station x : tab){
				data[j]=x.getNumber();
				j++;
			}
			init();
			writeLign(toS(data));
			int k = Arrays.asList(data).indexOf(tab[5].getNumber());
			RepeatTask repeatTask = new RepeatTask(periode, data);
			try {
				Thread.sleep(1000*periode*iteration);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repeatTask.stop();
	}

	public static void main(String[] args) { //premier param la periode en seconde, deuxième param nombre d'itération
		if (args==null){
			args[0]="10";
			args[1]="10";
		}
		new Acquisition(Integer.parseInt(args[0]),Integer.parseInt(args[1]));;

	}
	private static void init(){
		try{
		FileWriter writer = new FileWriter(new File(nomOutput));
		writer.close();
		}
		catch (Exception e){
			System.err.println(e);
			System.out.println("init fichier");
		}
	}
	public static void writeLign(String s) {
		 FileWriter writer;
		try {
			writer = new FileWriter(nomOutput, true);
			writer.write(s,0,s.length());
			String x="\r\n";
			writer.write(x,0,x.length());
	         writer.close();
		} catch (IOException e) {
			System.err.println(e);
			System.out.println("probleme ecriture" );
		}
		 
	}
	
	public static String toS(int[] tab){
		String s="";
		for (int i :tab){
			s=s+i+",";
		}
		return s;
	}
	
	
	
	

}

