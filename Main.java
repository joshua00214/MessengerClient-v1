package joshua;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		WorkingMesseger w = new WorkingMesseger();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(300, 400);
		w.setVisible(true);
	}
}
