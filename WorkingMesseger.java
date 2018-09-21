package joshua;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class WorkingMesseger extends JFrame{
Socket s = new Socket();
JButton connect;
DataInputStream input;
DataOutputStream output;
InetAddress inet;
private String helper;
private int one = 1;
JTextField textfield = new JTextField();
JButton send = new JButton();
JTextArea panel = new JTextArea();
	public WorkingMesseger(){
		super("Messeger");
		if(one == 1){
		connect = new JButton("Connect");
		textfield = new JTextField(30);
		panel = new JTextArea();
		send = new JButton("Send");
		setLayout(null);
		panel.setBounds(60,60,200,100);
		connect.setBounds(50,10, 200, 40);
		textfield.setBounds(60,260, 200, 40);
		send.setBounds(60, 180, 200, 40);
		add(send);
		add(connect);
		add(textfield);
		setLayout(null);
		add(panel);
		connect.addActionListener( 
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
							remove(connect);
							add(panel);
							add(send);
							try {
								make();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							Thread thread2 = new Thread(){
								public void run(){
									while(true){
									try {
										setPanel(input.readUTF());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									}
								}
							};
							
							
							thread2.start();
							
							
					
						
					
						}
				}
				);
		send.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							helper = textfield.getText();
							output.writeUTF(helper);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				);
		one = 2;
		}
		else{
			
		}
	}
	public void setPanel(String y){
		String x;
		x = panel.getText();
		panel.setText(x + "\n" + y);
	}
	public void make() throws IOException{
		inet = InetAddress.getByName("127.0.0.1");
		s = new Socket(inet, 25543);
		input = new DataInputStream(s.getInputStream());
		
		output = new DataOutputStream(s.getOutputStream());
	}
}
