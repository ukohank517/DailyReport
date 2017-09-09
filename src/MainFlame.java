
import javax.swing.*;

import java.io.File;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.jar.Attributes.Name;
import java.util.jar.JarFile;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;

class MainFlame extends JFrame implements ActionListener{

	//JTextField datetext;
	JLabel pathlabel;
	JButton selectbutton;
	JButton renewbutton;
	
	String path;
	/*
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String date = sdf.format(cal.getTime());
	*/
	public static void main(String args[]){
		MainFlame frame = new MainFlame("日報更新");
		frame.setVisible(true);
	}

	MainFlame(String title){
	  
		setTitle(title);
		setBounds(100, 100, 450, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel n = new JPanel();
		JPanel c = new JPanel();
		JPanel s = new JPanel();


		//datetext = new JTextField(date, 10);

		selectbutton = new JButton("選択");
		selectbutton.addActionListener(this);
		selectbutton.setActionCommand("select");

		renewbutton = new JButton("更新");
		renewbutton.addActionListener(this);
		renewbutton.setActionCommand("renew");
		renewbutton.setEnabled(false);//フォルダ選ばないと更新できない
		
		pathlabel = new JLabel();
		pathlabel.setText("フォルダ場所:");
		
		
		n.add(pathlabel);
		//n.add(datetext);
		c.add(selectbutton);
		s.add(renewbutton);
		Container contentPane = getContentPane();
		contentPane.add(n, BorderLayout.NORTH);
		contentPane.add(c, BorderLayout.CENTER);
		contentPane.add(s, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if(cmd.equals("select")){//フォルダを選択する。
			JFileChooser filechooser = new JFileChooser("c://");
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int selected = filechooser.showSaveDialog(this);
			if(selected == JFileChooser.APPROVE_OPTION){
				File file = filechooser.getSelectedFile();
				pathlabel.setText(file.getAbsolutePath());
			}
			renewbutton.setEnabled(true);
		}

		if(cmd.equals("renew")){
			//label.setText(datetext.getText());
			//ボタン押下時
			System.out.println("pressed!");
			//FileRead a  = new FileRead();

			//System.out.println("file print");
		}
	}
}