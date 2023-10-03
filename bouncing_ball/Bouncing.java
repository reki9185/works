import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.event.MouseListener;

public class Bouncing extends JPanel implements MouseListener{
	JFrame board;
	JPanel panel;
	public ArrayList<ball>balls=new ArrayList<ball>();
	public Bouncing(){
		JFrame board=new JFrame("Bouncing Ball");
		board.setSize(600,600);
		board.setVisible(true);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new draw();
		panel.addMouseListener(this);
		panel.setVisible(true);
		//panel.setBackground(Color.BLACK);
		board.add(panel);
		while(true) {
			for(ball b:balls) {
				b.moving();
			}
			board.repaint();
			try
			{
				Thread.sleep(5);
			}
			catch(Exception e)
			{
				
			}
		}
		//board.repaint();
	}
	
	class draw extends JPanel{
		@Override
		public void paintComponent(Graphics graphics)
		{
			super.paintComponent(graphics);
			//System.out.println("here");
			for(ball b:balls) {
				b.paint(graphics);
			}
		}
		
	}
	
	@Override 
	public void mousePressed(MouseEvent event) {
		ball b=new ball(event.getPoint().x,event.getPoint().y);
		//System.out.println(event.getPoint().x);
		//System.out.println(event.getPoint().y);
		balls.add(b);
		panel.repaint();
		//System.out.println(balls.size());
	}
	@Override 
	public void mouseClicked(MouseEvent event) {
		
	}
	@Override 
	public void mouseReleased(MouseEvent event) {
		
	}
	@Override 
	public void mouseEntered(MouseEvent event) {
		
	}
	@Override 
	public void mouseExited(MouseEvent event) {
		
	}

	class ball{
		private int x;
		private int y;
		private int PosX;
		private int PosY;
		private Color color;
		public ball(int PosX,int PosY){
			this.PosX=PosX;
			this.PosY=PosY;
			SecureRandom random=new SecureRandom();
			this.x=random.nextInt(10)-5;
			this.y=random.nextInt(10)-5;
			if(this.x==0 && this.y==0) this.x=2;
			color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
		}
		public void paint(Graphics graphics) {
			graphics.setColor(color);
			graphics.fillOval(PosX,PosY,30,30);
		}
		public void moving() {
			if(PosX>540) {
				x*=(-1);
				PosX=540;
			}
			if(PosX<0) {
				x*=(-1);
				PosX=0;
			}
			if(PosY>540) {
				y*=(-1);
				PosY=540;
			}
			if(PosY<0) {
				y*=(-1);
				PosY=0;
			}
			this.PosX+=x;
			this.PosY+=y;
		}
	}

}

