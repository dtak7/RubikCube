import java.util.Arrays;

import javax.swing.JOptionPane;

public class Controller {

	public Model model;
	Screen s = new Screen();
	public Frame view;

	public int[][] m;
	int[][] m2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5 } };
	int j = 0;

	public Controller() {
	}

	public Controller(Model mod, Frame v) {
		model = mod;
		view = v;
		view.registerObserver(this);
		view.setMatToScreen(model.getMat());
		m = model.getMat();
	}

	public void cw(int[] m, int[] r) {
		m[0] = r[6];
		m[1] = r[3];
		m[2] = r[0];
		m[3] = r[7];
		m[4] = r[4];
		m[5] = r[1];
		m[6] = r[8];
		m[7] = r[5];
		m[8] = r[2];
	}

	public void ccw(int[] m, int[] r) {
		m[0] = r[2];
		m[1] = r[5];
		m[2] = r[8];
		m[3] = r[1];
		m[4] = r[4];
		m[5] = r[7];
		m[6] = r[0];
		m[7] = r[3];
		m[8] = r[6];
	}

	public void start() {
		for (int i = 0; i < 10000; i++) {
			boolean check = Arrays.deepEquals(m2, model.getMat());
			if (check && i > 0) {
				System.out.println(j - 1);
				JOptionPane.showMessageDialog(null, "DOLVED");
				break;
			}
			j++;
			doR();
			pause();
			doY();
			pause();
			doU();
			pause();
			doXp();
			pause();
			System.out.println(j);
		}
	}

	public void pause() {
		try {
			view.repaint();
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

	public void keyType(char c) {
		if (c == 'x') {
			doX();
		} else if (c == 'X') {
			doXp();
		} else if (c == 'y') {
			doY();
		} else if (c == 'Y') {
			doYp();
		} else if (c == 'z') {
			doZ();
		} else if (c == 'Z') {
			doZp();
		} else if (c == 'p') {
			printMat();
		} else if (c == 'u') {
			doU();
		} else if (c == 'U') {
			doUp();
		} else if (c == 'd') {
			doD();
		} else if (c == 'D') {
			doDp();
		} else if (c == 'l') {
			doL();
		} else if (c == 'L') {
			doLp();
		} else if (c == 'r') {
			doR();
		} else if (c == 'R') {
			doRp();
		} else if (c == 'f') {
			doF();
		} else if (c == 'F') {
			doFp();
		} else if (c == 'b') {
			doB();
		} else if (c == 'B') {
			doBp();
		} else if (c == 'o') {
			resetCube();
		} else if (c == 's') {
			scramble();
		}
	}

	public void resetCube() {
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 9; c++) {
				m[r][c] = r;
			}
		}
	}

	public void scramble() {
		double d = 1.0 / 5.0;
		for (int i = 0; i < 60; i++) {
			double r = Math.random();
			if (r < d) {
				doR();
			} else if (r < 2 * d) {
				doLp();
			} else if (r < 3 * d) {
				doX();
			} else if (r < 4 * d) {
				doY();
			} else {
				doZ();
			}
		}
	}

	public void doU() {
		doZ();
		doR();
		doZp();
	}

	public void doUp() {
		doZp();
		doLp();
		doZ();
	}

	public void doD() {
		doZp();
		doR();
		doZ();
	}

	public void doDp() {
		doZ();
		doLp();
		doZp();
	}

	public void doL() {
		doZ();
		doZ();
		doR();
		doZ();
		doZ();
	}

	public void doRp() {
		doZ();
		doZ();
		doLp();
		doZ();
		doZ();
	}

	public void doF() {
		doYp();
		doR();
		doY();
	}

	public void doFp() {
		doY();
		doLp();
		doYp();
	}

	public void doB() {
		doY();
		doR();
		doYp();
	}

	public void doBp() {
		doYp();
		doLp();
		doY();
	}

	public void doLp() {

		int[] f = m[0].clone();

		m[0][8 - 2] = m[5][8 - 2];
		m[0][8 - 5] = m[5][8 - 5];
		m[0][8 - 8] = m[5][8 - 8];

		m[5][8 - 2] = m[2][2];
		m[5][8 - 5] = m[2][5];
		m[5][8 - 8] = m[2][8];

		m[2][2] = m[4][8 - 2];
		m[2][5] = m[4][8 - 5];
		m[2][8] = m[4][8 - 8];

		m[4][8 - 2] = f[8 - 2];
		m[4][8 - 5] = f[8 - 5];
		m[4][8 - 8] = f[8 - 8];

		int[] l = m[3].clone();
		ccw(m[3], l);

	}

	public void doR() {

		int[] f = m[0].clone();

		m[0][2] = m[5][2];
		m[0][5] = m[5][5];
		m[0][8] = m[5][8];

		m[5][2] = m[2][8 - 2];
		m[5][5] = m[2][8 - 5];
		m[5][8] = m[2][8 - 8];

		m[2][8 - 2] = m[4][2];
		m[2][8 - 5] = m[4][5];
		m[2][8 - 8] = m[4][8];

		m[4][2] = f[2];
		m[4][5] = f[5];
		m[4][8] = f[8];

		int[] r = m[1].clone();
		cw(m[1], r);

	}

	public void printMat() {
		int[][] cube = model.getMat();
		for (int row = 0; row < cube.length; row++) {
			for (int col = 0; col < cube[row].length; col++) {
				int value = cube[row][col];
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	public void doX() {
		int[] f = m[0].clone();

		for (int c = 0; c < 9; c++) {
			m[0][c] = m[5][c];
		}
		for (int c = 0; c < 9; c++) {
			m[5][8 - c] = m[2][c];
		}
		for (int c = 0; c < 9; c++) {
			m[2][8 - c] = m[4][c];
		}
		for (int c = 0; c < 9; c++) {
			m[4][c] = f[c];
		}

		int[] r = m[1].clone();
		cw(m[1], r);

		int[] l = m[3].clone();
		ccw(m[3], l);
	}

	public void doXp() {
		int[] f = m[0].clone();

		for (int c = 0; c < 9; c++) {
			m[0][c] = m[4][c];
		}
		for (int c = 0; c < 9; c++) {
			m[4][8 - c] = m[2][c];
		}
		for (int c = 0; c < 9; c++) {
			m[2][8 - c] = m[5][c];
		}
		for (int c = 0; c < 9; c++) {
			m[5][c] = f[c];
		}

		int[] r = m[1].clone();
		ccw(m[1], r);

		int[] l = m[3].clone();
		cw(m[3], l);
	}

	public void doY() {
		int[] f = m[0].clone();

		for (int c = 0; c < 9; c++) {
			m[0][c] = m[1][c];
		}
		for (int c = 0; c < 9; c++) {
			m[1][c] = m[2][c];
		}
		for (int c = 0; c < 9; c++) {
			m[2][c] = m[3][c];
		}
		for (int c = 0; c < 9; c++) {
			m[3][c] = f[c];
		}

		int[] d = m[5].clone();
		ccw(m[5], d);

		int[] u = m[4].clone();
		cw(m[4], u);
	}

	public void doYp() {
		int[] f = m[0].clone();

		for (int c = 0; c < 9; c++) {
			m[0][c] = m[3][c];
		}
		for (int c = 0; c < 9; c++) {
			m[3][c] = m[2][c];
		}
		for (int c = 0; c < 9; c++) {
			m[2][c] = m[1][c];
		}
		for (int c = 0; c < 9; c++) {
			m[1][c] = f[c];
		}

		int[] d = m[5].clone();
		cw(m[5], d);

		int[] u = m[4].clone();
		ccw(m[4], u);
	}

	public void doZ() {
		int[] u = m[4].clone();

		for (int c = 0; c < 9; c++) {
			m[4][c] = m[3][c];
		}
		cw(m[4], m[4].clone());
		for (int c = 0; c < 9; c++) {
			m[3][c] = m[5][c];
		}
		cw(m[3], m[3].clone());
		for (int c = 0; c < 9; c++) {
			m[5][c] = m[1][c];
		}
		cw(m[5], m[5].clone());
		for (int c = 0; c < 9; c++) {
			m[1][c] = u[c];
		}
		cw(m[1], m[1].clone());

		int[] f = m[0].clone();
		cw(m[0], f);

		int[] b = m[2].clone();
		ccw(m[2], b);
	}

	public void doZp() {
		int[] u = m[4].clone();

		for (int c = 0; c < 9; c++) {
			m[4][c] = m[1][c];
		}
		ccw(m[4], m[4].clone());
		for (int c = 0; c < 9; c++) {
			m[1][c] = m[5][c];
		}
		ccw(m[1], m[1].clone());
		for (int c = 0; c < 9; c++) {
			m[5][c] = m[3][c];
		}
		ccw(m[5], m[5].clone());
		for (int c = 0; c < 9; c++) {
			m[3][c] = u[c];
		}
		ccw(m[3], m[3].clone());

		int[] f = m[0].clone();
		ccw(m[0], f);

		int[] b = m[2].clone();
		cw(m[2], b);
	}

	// if (c=='u') {
	// doX();
	// } else if (c=='j') {
	// doXp();
	// } else if (c=='i') {
	// doY();
	// } else if (c=='k') {
	// doYp();
	// } else if (c=='o') {
	// doZ();
	// } else if (c=='l') {
	// doZp();
	// } else if (c=='p') {
	// printMat();
	// } else if (c=='q') {
	// doU();
	// } else if (c=='a') {
	// doUp();
	// } else if (c=='w') {
	// doD();
	// } else if (c=='s') {
	// doDp();
	// } else if (c=='e') {
	// doL();
	// } else if (c=='d') {
	// doLp();
	// } else if (c=='r') {
	// doR();
	// } else if (c=='f') {
	// doRp();
	// } else if (c=='t') {
	// doF();
	// } else if (c=='g') {
	// doFp();
	// } else if (c=='y') {
	// doB();
	// } else if (c=='h') {
	// doBp();
	// } else if (c=='z') {
	// resetCube();
	// }
}
