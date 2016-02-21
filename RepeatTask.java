import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class RepeatTask  {
	

	
	
	
	private Timer t;
	private Integer[] base; //super important de gérer des Integer et pas des int
	public RepeatTask(int periode, int[] base) {
		this.base = new Integer[base.length];
		int compt = 0;
		for (int i : base){
			this.base[compt]= new Integer(i);
			compt++;
		}
		
		t=new Timer();
		t.schedule(new Task(),0,periode*1000);
	}

class Task extends TimerTask{
	public void run() {
		Json json=new Json();
		Station[] tab = json.getResult();
		Date date = new Date();
		int[] data=new int[tab.length];

		for (Station x : tab){
			Integer j=new Integer(x.getNumber());
			int k = Arrays.asList(base).indexOf(j);
			data[k]=x.getNbVelos();
		}
		

		Acquisition.writeLign(Acquisition.toS(data)+";"+date.toString());
		
	}
	
	
}
public void stop(){
	t.cancel();
}
}
