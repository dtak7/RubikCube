
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Controller controller;
	
	Screen s;
	
	private char c;
	
	public void registerObserver(Controller controller) {
		this.controller = controller;
	}
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setResizable(false);
		setTitle("Rubik's Cube");
		
		init();
		
		addKeyListener(this);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	
	public void init() {
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(1,1,0,0));
		
		s = new Screen();
		add(s);
		
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) {
        c = e.getKeyChar();
        System.out.println(c);
        this.controller.keyType(c);
        repaint();
    }

    public void setMatToScreen(int[][] m) {
    	s.setMat(m);
    }

}