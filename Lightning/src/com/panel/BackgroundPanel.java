package com.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackgroundPanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image bg0;
	Image bg1;
	int posY0;
	int posY1;

	public BackgroundPanel() {
		bg0 = Toolkit.getDefaultToolkit().getImage("images\\map_0.png");
		bg1 = Toolkit.getDefaultToolkit().getImage("images\\map_1.png");

		posY0 = 0;
		posY1 = -MainFrame.mScreenHeight;

		new Thread(this).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg0, 0, posY0, this);
		g.drawImage(bg1, 0, posY1, this);
	}

	@Override
	public void run() {
		while (true) {
			posY0 += 10;
			posY1 += 10;

			if (posY0 == MainFrame.mScreenHeight) {
				posY0 = -MainFrame.mScreenHeight;
			}

			if (posY1 == MainFrame.mScreenHeight) {
				posY1 = -MainFrame.mScreenHeight;
			}

			repaint();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
