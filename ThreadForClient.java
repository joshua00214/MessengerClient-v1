package joshua;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadForClient extends Thread{
	DataInputStream input;
	String data;
	WorkingMesseger WM = new WorkingMesseger();
	public ThreadForClient(DataInputStream input) throws IOException{
		this.input = input;
		
	}
	public void run(){
		getData();
		WM.setPanel(data);
	}
	public void getData(){
		try {
			data = input.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
