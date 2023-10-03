package hw3;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class typing extends JFrame implements KeyListener{
	JFrame type;
	JTextArea textArea;
	//button1,2,3,4:row1,2,3,4
	//button5:+arrow key(except ^) 
	JButton[] buttons;
	String[] row1= {"~","1","2","3","4","5","6","7","8","9","0","-","+","backspace"};//14
	String[] row2= {"tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};//28
	String[] row3= {"capslock","A","S","D","F","G","H","J","K","L",":","\"","enter"};//41
	String[] row4= {"shift","Z","X","C","V","B","N","M",",",".","?","^"};//53
	String[] row5= {"ctrl","fn","alt","                                                                                                   ","<","v",">"};//60
	ArrayList<String>list=new ArrayList<String>();
	
	int number=row1.length+row2.length+row3.length+row4.length+row5.length;
	
	public typing() {
		for(int i=0;i<row1.length;i++) {
			list.add(row1[i]);
		}
		for(int i=0;i<row2.length;i++) {
			list.add(row2[i]);
		}
		for(int i=0;i<row3.length;i++) {
			list.add(row3[i]);
		}
		for(int i=0;i<row4.length;i++) {
			list.add(row4[i]);
		}
		for(int i=0;i<row5.length;i++) {
			list.add(row5[i]);
		}
		
		type=new JFrame("Tying Tutor");
		//type.setVisible(true);
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(5,5));
		//setLayout(new FlowLayout());
		
		JPanel title=new JPanel();
		title.setLayout(new BorderLayout(5,5));
		title.setSize(700,20);
		JLabel label=new JLabel("Press any key on the keyboard...");
		title.add(label,BorderLayout.NORTH);
		
		//textArea(North)
		JPanel screen=new JPanel();
		screen.setLayout(new BorderLayout(5,5));
		textArea=new JTextArea(300,200);
		//textArea.setText("Press any key on the keyboard...\n");
		textArea.setEditable(true);
		textArea.setFont(new Font("Serif",Font.PLAIN,14));
		textArea.addKeyListener(this);
		
		screen.add(textArea);
		screen.setSize(600,300);
		
		//keyboard(South)
		JPanel keyboard=new JPanel();
		buttons=new JButton[number];
		int pointer=0;
		JPanel r1=new JPanel();
		r1.setLayout(new FlowLayout());
		for(int i=0;i<row1.length;i++) {
			buttons[pointer]=new JButton(row1[i]);
			buttons[pointer].setVisible(true);
			r1.add(buttons[pointer]);
			pointer=pointer+1;
		}
		JPanel r2=new JPanel();
		r2.setLayout(new FlowLayout());
		for(int i=0;i<row2.length;i++) {
			buttons[pointer]=new JButton(row2[i]);
			buttons[pointer].setVisible(true);
			r2.add(buttons[pointer]);
			pointer=pointer+1;
		}
		JPanel r3=new JPanel();
		r3.setLayout(new FlowLayout());
		for(int i=0;i<row3.length;i++) {
			buttons[pointer]=new JButton(row3[i]);
			buttons[pointer].setVisible(true);
			r3.add(buttons[pointer]);
			pointer=pointer+1;
		}
		JPanel r4=new JPanel();
		r4.setLayout(new FlowLayout());
		for(int i=0;i<row4.length;i++) {
			buttons[pointer]=new JButton(row4[i]);
			buttons[pointer].setVisible(true);
			r4.add(buttons[pointer]);
			pointer=pointer+1;
		}
		JPanel r5=new JPanel();
		r5.setLayout(new FlowLayout());
		for(int i=0;i<row5.length;i++) {
			buttons[pointer]=new JButton(row5[i]);
			buttons[pointer].setVisible(true);
			r5.add(buttons[pointer]);
			pointer=pointer+1;
		}
		
		keyboard.setLayout(new GridLayout(5,14));
		keyboard.add(r1);
		keyboard.add(r2);
		keyboard.add(r3);
		keyboard.add(r4);
		keyboard.add(r5);
		
		panel.add(title,BorderLayout.NORTH);
		panel.add(screen,BorderLayout.CENTER);
		panel.add(keyboard,BorderLayout.SOUTH);
		
		type.setSize(800,450);
		type.add(panel);
		type.show();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//?
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//13:backspace 14:tab 28:caps 40:enter 41:shift 52:up 53:ctrl 54:fn 55:alt 56:space 57:left 58:down 59:right
		char c=e.getKeyChar();
		String key=(c+"").toUpperCase();
		if(list.contains(key)) {
			buttons[list.indexOf(key)].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
			buttons[13].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_TAB) {
			buttons[14].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_CAPS_LOCK) {
			buttons[28].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			buttons[40].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			buttons[41].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			buttons[52].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_CONTROL) {
			buttons[53].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_ALT) {
			buttons[55].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			buttons[56].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			buttons[57].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			buttons[58].setBackground(Color.BLUE);
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			buttons[59].setBackground(Color.BLUE);
		}
	}
		
	@Override
	public void keyReleased(KeyEvent e) {
		char c=e.getKeyChar();
		String key=(c+"").toUpperCase();
		if(list.contains(key)) {
			buttons[list.indexOf(key)].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
			buttons[13].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_TAB) {
			buttons[14].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_CAPS_LOCK) {
			buttons[28].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			buttons[40].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			buttons[41].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			buttons[52].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_CONTROL) {
			buttons[53].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_ALT) {
			buttons[55].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			buttons[56].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			buttons[57].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			buttons[58].setBackground(null);
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			buttons[59].setBackground(null);
		}
	}

}
