
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int[][] m = new int[6][9];
	
	public Screen() {
		repaint();
	}
	
	private Color getColor(int i) {
		Color c = Color.cyan;
		if (i==0) {
			c = Color.blue;
		} else if (i==1) {
			c = Color.red;
		} else if (i==2) {
			c = Color.green;
		} else if (i==3) {
			c = new Color(255,150,40);
			//c =Color.orange;
		} else if (i==4) {
			c = Color.yellow;
		} else if (i==5) {
			c = Color.white;
		}
		return c;
	}
	
	/*
	 * 0 = front blue
	 * 1 = right red
	 * 2 = back  green
	 * 3 = left  orange
	 * 4 = up    yellow
	 * 5 = down  white
	 */
	
	public void paint(Graphics g) {
		//black background
		int[] x = {121, 402, 682, 653, 401, 152};
		int[] y = {217, 95,  217, 526, 702, 528};
		g.setColor(Color.black);
		g.fillPolygon(x, y, x.length);
		
		// front side
		int[] xf1 = {132, 202, 208, 140};
		int[] yf1 = {232, 270, 365, 324};
		g.setColor(getColor(m[0][0]));
		g.fillPolygon(xf1, yf1, xf1.length);
		
		int[] xf2 = {216, 294, 297, 222};
		int[] yf2 = {278, 322, 420, 374};
		g.setColor(getColor(m[0][1]));
		g.fillPolygon(xf2, yf2, xf2.length);
		
		int[] xf3 = {309, 393, 393, 312};
		int[] yf3 = {331, 378, 476, 427};
		g.setColor(getColor(m[0][2]));
		g.fillPolygon(xf3, yf3, xf3.length);
		
		int[] xf4 = {142, 210, 216, 150};
		int[] yf4 = {342, 383, 470, 427};
		g.setColor(getColor(m[0][3]));
		g.fillPolygon(xf4, yf4, xf4.length);
		
		int[] xf5 = {223, 298, 301, 228};
		int[] yf5 = {391, 436, 527, 479};
		g.setColor(getColor(m[0][4]));
		g.fillPolygon(xf5, yf5, xf5.length);
		
		int[] xf6 = {313, 394, 394, 316};
		int[] yf6 = {446, 496, 587, 535};
		g.setColor(getColor(m[0][5]));
		g.fillPolygon(xf6, yf6, xf6.length);
		
		int[] xf7 = {152, 217, 222, 159};
		int[] yf7 = {444, 487, 568, 522};
		g.setColor(getColor(m[0][6]));
		g.fillPolygon(xf7, yf7, xf7.length);
		
		int[] xf8 = {231, 302, 305, 236};
		int[] yf8 = {496, 542, 625, 576};
		g.setColor(getColor(m[0][7]));
		g.fillPolygon(xf8, yf8, xf8.length);
		
		int[] xf9 = {317, 394, 394, 319};
		int[] yf9 = {553, 604, 687, 635};
		g.setColor(getColor(m[0][8]));
		g.fillPolygon(xf9, yf9, xf9.length);
		
		// right side
				int[] xr1 = {410, 493, 491, 410};
				int[] yr1 = {377, 331, 427, 476};
				g.setColor(getColor(m[1][0]));
				g.fillPolygon(xr1, yr1, xr1.length);
				
				int[] xr2 = {509, 586, 581, 506};
				int[] yr2 = {322, 278, 373, 419};
				g.setColor(getColor(m[1][1]));
				g.fillPolygon(xr2, yr2, xr2.length);
				
				int[] xr3 = {601, 671, 663, 595};
				int[] yr3 = {271, 231, 323, 364};
				g.setColor(getColor(m[1][2]));
				g.fillPolygon(xr3, yr3, xr3.length);
				
				int[] xr4 = {409, 490, 487, 409};
				int[] yr4 = {496, 446, 535, 585};
				g.setColor(getColor(m[1][3]));
				g.fillPolygon(xr4, yr4, xr4.length);
				
				int[] xr5 = {504, 580, 574, 501};
				int[] yr5 = {436, 390, 479, 526};
				g.setColor(getColor(m[1][4]));
				g.fillPolygon(xr5, yr5, xr5.length);
				
				int[] xr6 = {593, 661, 653, 588};
				int[] yr6 = {382, 342, 426, 469};
				g.setColor(getColor(m[1][5]));
				g.fillPolygon(xr6, yr6, xr6.length);
				
				int[] xr7 = {409, 486, 484, 409};
				int[] yr7 = {604, 553, 634, 686};
				g.setColor(getColor(m[1][6]));
				g.fillPolygon(xr7, yr7, xr7.length);
				
				int[] xr8 = {501, 572, 567, 499};
				int[] yr8 = {543, 496, 577, 624};
				g.setColor(getColor(m[1][7]));
				g.fillPolygon(xr8, yr8, xr8.length);
				
				int[] xr9 = {586, 651, 644, 581};
				int[] yr9 = {487, 444, 522, 567};
				g.setColor(getColor(m[1][8]));
				g.fillPolygon(xr9, yr9, xr9.length);
				
			//top
				int[] xt1 = {331, 402, 472, 402};
				int[] yt1 = {135, 105, 135, 169};
				g.setColor(getColor(m[4][0]));
				g.fillPolygon(xt1, yt1, xt1.length);
				
				int[] xt2 = {415, 488, 565, 494};
				int[] yt2 = {175, 141, 175, 212};
				g.setColor(getColor(m[4][1]));
				g.fillPolygon(xt2, yt2, xt2.length);
				
				int[] xt3 = {511, 581, 663, 594};
				int[] yt3 = {219, 183, 218, 258};
				g.setColor(getColor(m[4][2]));
				g.fillPolygon(xt3, yt3, xt3.length);
				
				int[] xt4 = {238, 316, 388, 310};
				int[] yt4 = {175, 141, 175, 212};
				g.setColor(getColor(m[4][3]));
				g.fillPolygon(xt4, yt4, xt4.length);
				
				int[] xt5 = {323, 402, 479, 401};
				int[] yt5 = {218, 181, 218, 258};
				g.setColor(getColor(m[4][4]));
				g.fillPolygon(xt5, yt5, xt5.length);
				
				int[] xt6 = {417, 495, 580, 502};
				int[] yt6 = {265, 225, 265, 309};
				g.setColor(getColor(m[4][5]));
				g.fillPolygon(xt6, yt6, xt6.length);
				
				int[] xt7 = {141, 222, 293, 209};
				int[] yt7 = {218, 183, 218, 257};
				g.setColor(getColor(m[4][6]));
				g.fillPolygon(xt7, yt7, xt7.length);
				
				int[] xt8 = {224, 309, 386, 302};
				int[] yt8 = {266, 225, 265, 309};
				g.setColor(getColor(m[4][7]));
				g.fillPolygon(xt8, yt8, xt8.length);
				
				int[] xt9 = {318, 401, 485, 402};
				int[] yt9 = {317, 274, 317, 364};
				g.setColor(getColor(m[4][8]));
				g.fillPolygon(xt9, yt9, xt9.length);
	}

	public void setMat(int[][] mat) {
		this.m = mat;
	}
	
}
