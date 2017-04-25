package com.game.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.game.map.Map;
import com.game.map.MapFactory;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mapRow, mapCol;
	private int manX, manY;
	private int leftX, leftY;
	private Image[] pic;
	private final byte WALL = 1, BOX = 2, BOXONEND = 3, END = 4, MANDOWN = 5, MANLEFT = 6, MANRIGHT = 7, MANUP = 8,
			GRASS = 9, MANDOWNONEND = 10, MANLEFTONEND = 11, MANRIGHTONEND = 12, MANUPONEND = 13;
	private int grade;
	private byte[][] map;
	private final int PX = 30;
	private Image iBuffer;
	private Graphics gBuffer;
	private ArrayList<Map> list;
	private int step;
	private JLabel jCheckPoint, jStep;

	public GamePanel(StatusPanel sp) {
		jCheckPoint = sp.getJlCheckPoint();
		jStep = sp.getJlStep();

		list = new ArrayList<Map>();
		getPic();
		init();
		setFocusable(true);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				getLeftXAndLeftY();
				iBuffer = null;
				repaint();
			}
		});

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
					moveLeft();
				}

				if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
					moveRight();
				}

				if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
					moveUp();
				}

				if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
					moveDown();
				}

				if (keyCode == KeyEvent.VK_R) {
					undo();
				}

				repaint();
				jCheckPoint.setText(Integer.toString(grade + 1));
				jStep.setText(Integer.toString(step));

				if (isFinished()) {
					if (grade == MapFactory.getMapLength()) {
						JOptionPane.showConfirmDialog(GamePanel.this, "恭喜你通过了所有的关卡", "信息", JOptionPane.YES_NO_OPTION);
					} else {
						int choose = JOptionPane.showConfirmDialog(GamePanel.this, "通关成功", "信息",
								JOptionPane.YES_NO_OPTION);

						if (choose == JOptionPane.YES_OPTION) {
							iBuffer = null;
							grade++;
							init();
						}
					}
				}
			}
		});
	}

	private void init() {
		step = 0;
		list.clear();
		map = MapFactory.getMap(grade);
		mapRow = map.length;
		mapCol = map[0].length;
		getManPosition();
		getLeftXAndLeftY();
		repaint();
		jCheckPoint.setText(Integer.toString(grade + 1));
		jStep.setText(Integer.toString(step));
	}

	private void getLeftXAndLeftY() {
		leftX = (getWidth() - mapRow * PX) / 2;
		leftY = (getHeight() - mapCol * PX) / 2;
	}

	private void getManPosition() {
		for (int i = 0; i < mapRow; i++)
			for (int j = 0; j < mapCol; j++) {
				if (map[i][j] == MANDOWN || map[i][j] == MANLEFT || map[i][j] == MANRIGHT || map[i][j] == MANUP
						|| map[i][j] == MANDOWNONEND || map[i][j] == MANLEFTONEND || map[i][j] == MANRIGHTONEND
						|| map[i][j] == MANUPONEND) {
					manX = i;
					manY = j;
				}
			}
	}

	private boolean isFinished() {
		for (int i = 0; i < mapRow; i++)
			for (int j = 0; j < mapCol; j++) {
				if (map[i][j] == END || map[i][j] == MANDOWNONEND || map[i][j] == MANLEFTONEND
						|| map[i][j] == MANRIGHTONEND || map[i][j] == MANUPONEND) {
					return false;
				}
			}

		return true;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (iBuffer == null) {
			iBuffer = createImage(getWidth(), getHeight());
			gBuffer = iBuffer.getGraphics();
		}

		for (int i = 0; i < mapRow; i++)
			for (int j = 0; j < mapCol; j++) {
				if (map[i][j] != 0) {
					gBuffer.drawImage(pic[map[i][j]], leftX + j * PX, leftY + i * PX, this);
				}
			}

		g.drawImage(iBuffer, 0, 0, this);
	}

	private void getPic() {
		pic = new Image[14];

		for (int i = 0; i <= 13; i++) {
			pic[i] = Toolkit.getDefaultToolkit().getImage("images//pic" + i + ".JPG");
		}
	}

	private byte grassOrEnd(byte man) {
		byte result = GRASS;

		if (man == MANDOWNONEND || man == MANLEFTONEND || man == MANRIGHTONEND || man == MANUPONEND)
			result = END;

		return result;
	}

	private void save() {
		list.add(new Map(mapRow, mapCol, map));
		step++;
	}

	private void undo() {
		if (list.size() > 0) {
			map = list.remove(list.size() - 1).getMap();
			getManPosition();
			step--;
		}
	}

	private void moveDown() {
		if (map[manX + 1][manY] == WALL)
			return;

		if (map[manX + 1][manY] == BOX || map[manX + 1][manY] == BOXONEND) {
			if (map[manX + 2][manY] == END || map[manX + 2][manY] == GRASS) {
				save();
				byte tempMap = map[manX + 2][manY] == END ? BOXONEND : BOX;
				byte manMap = map[manX + 1][manY] == BOX ? MANDOWN : MANDOWNONEND;

				map[manX + 2][manY] = tempMap;
				map[manX + 1][manY] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manX++;
			}
		} else {
			if (map[manX + 1][manY] == GRASS || map[manX + 1][manY] == END) {
				save();
				byte manMap = map[manX + 1][manY] == GRASS ? MANDOWN : MANDOWNONEND;

				map[manX + 1][manY] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manX++;
			}
		}
	}

	private void moveUp() {
		if (map[manX - 1][manY] == WALL)
			return;

		if (map[manX - 1][manY] == BOX || map[manX - 1][manY] == BOXONEND) {
			if (map[manX - 2][manY] == END || map[manX - 2][manY] == GRASS) {
				save();
				byte tempMap = map[manX - 2][manY] == END ? BOXONEND : BOX;
				byte manMap = map[manX - 1][manY] == BOX ? MANUP : MANUPONEND;

				map[manX - 2][manY] = tempMap;
				map[manX - 1][manY] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manX--;
			}
		} else {
			if (map[manX - 1][manY] == GRASS || map[manX - 1][manY] == END) {
				save();
				byte manMap = map[manX - 1][manY] == GRASS ? MANUP : MANUPONEND;

				map[manX - 1][manY] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manX--;
			}
		}
	}

	private void moveLeft() {
		if (map[manX][manY - 1] == WALL)
			return;

		if (map[manX][manY - 1] == BOX || map[manX][manY - 1] == BOXONEND) {
			if (map[manX][manY - 2] == END || map[manX][manY - 2] == GRASS) {
				save();
				byte tempMap = map[manX][manY - 2] == END ? BOXONEND : BOX;
				byte manMap = map[manX][manY - 1] == BOX ? MANLEFT : MANLEFTONEND;

				map[manX][manY - 2] = tempMap;
				map[manX][manY - 1] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manY--;
			}
		} else {
			if (map[manX][manY - 1] == GRASS || map[manX][manY - 1] == END) {
				save();
				byte manMap = map[manX][manY - 1] == GRASS ? MANLEFT : MANLEFTONEND;

				map[manX][manY - 1] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manY--;
			}
		}
	}

	private void moveRight() {
		if (map[manX][manY + 1] == WALL)
			return;

		if (map[manX][manY + 1] == BOX || map[manX][manY + 1] == BOXONEND) {
			if (map[manX][manY + 2] == END || map[manX][manY + 2] == GRASS) {
				save();
				byte tempMap = map[manX][manY + 2] == END ? BOXONEND : BOX;
				byte manMap = map[manX][manY + 1] == BOX ? MANRIGHT : MANRIGHTONEND;

				map[manX][manY + 2] = tempMap;
				map[manX][manY + 1] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manY++;
			}
		} else {
			if (map[manX][manY + 1] == GRASS || map[manX][manY + 1] == END) {
				save();
				byte manMap = map[manX][manY + 1] == GRASS ? MANRIGHT : MANRIGHTONEND;

				map[manX][manY + 1] = manMap;
				map[manX][manY] = grassOrEnd(map[manX][manY]);
				manY++;
			}
		}
	}
}
