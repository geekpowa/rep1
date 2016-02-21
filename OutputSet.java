

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputSet {
	String[][] tab;
	String name;

	public OutputSet(String[][] t, String name) {
		tab = t;
		this.name = name;
		while (this.existingFile()) {
			this.name = "New" + this.name;
		}
	}

	public void write() throws IOException {
		FileWriter f = new FileWriter(new File(name));
		for (int i = 0; i < tab.length; i++) {
			String s = new String();
			for (int j = 0; j < tab[i].length; j++) {
				if (tab[i][j] !=null){
					s = s + tab[i][j] + " ";
				}
			}
			f.write(s);
			f.write("\r\n");
		}
		f.close();
	}

	public boolean existingFile() {
		File f = new File(name);
		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}

	}
	
}
