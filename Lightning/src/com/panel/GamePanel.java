package com.panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.model.Bullet;
import com.model.Enemy;
import com.model.Plane;

public class GamePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Enemy[] mEnemy;
	Plane plane;
	Timer timer;
	Bullet[] mBullet;
	long sendTime;

	public GamePanel() {
		setOpaque(false);
		init();
		timer = new Timer(100, this);
		timer.start();

		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT)
					plane.moveLeft();

				if (key == KeyEvent.VK_RIGHT)
					plane.moveRight();

				if (key == KeyEvent.VK_DOWN)
					plane.moveDown();

				if (key == KeyEvent.VK_UP)
					plane.moveUp();
			}
		});
	}

	private void init() {
		mEnemy = new Enemy[5];

		for (int i = 0; i < mEnemy.length; i++) {
			mEnemy[i] = new Enemy(this);
			int random = getRandom();
			mEnemy[i].init(random, random - 350);
		}

		plane = new Plane(this);

		mBullet = new Bullet[15];

		for (int i = 0; i < mBullet.length; i++) {
			mBullet[i] = new Bullet(this);
		}

		sendTime = System.currentTimeMillis();
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (int i = 0; i < mEnemy.length; i++) {
			mEnemy[i].drawEnemy(g);
		}

		plane.drawPlane(g);

		for (int i = 0; i < mBullet.length; i++) {
			mBullet[i].drawBullet(g);
		}
	}

	private int getRandom() {
		int result = (int) (Math.random() * 1000 % (MainFrame.mScreenWidth - 75));

		return result;
	}

	private void draw() {
		updateGameEnemy();
		plane.updatePlane();
		updateGameBullet();
		collision();
	}

	private void collision() {
		for (int i = 0; i < mBullet.length; i++)
			for (int j = 0; j < mEnemy.length; j++) {
				if (mBullet[i].mPosX >= mEnemy[j].mPosX && mBullet[i].mPosX <= mEnemy[j].mPosX + 20
						&& mBullet[i].mPosY >= mEnemy[j].mPosY && mBullet[i].mPosX <= mEnemy[j].mPosY + 20) {
					mBullet[i].flag = false;
					mEnemy[j].flag = false;
				}
			}
	}

	private void updateGameBullet() {
		long now = System.currentTimeMillis();

		if (now - sendTime >= 1000) {
			sendTime = now;

			for (int i = 0; i < mBullet.length; i++) {
				if (mBullet[i].flag == false) {
					mBullet[i].init(plane.mAirPosX, plane.mAirPosY - 15);
					break;
				}
			}

			for (int i = 0; i < mBullet.length; i++) {
				if (mBullet[i].flag == true) {
					if (mBullet[i].mPosY <= 0) {
						mBullet[i].flag = false;
					} else {
						mBullet[i].updateBullet();
					}
				}
			}
		}
	}

	private void updateGameEnemy() {
		for (int i = 0; i < mEnemy.length; i++) {
			mEnemy[i].updateEnemy();

			if (mEnemy[i].mPosY >= MainFrame.mScreenHeight) {
				int random = getRandom();
				mEnemy[i].init(random, random - 350);
			} else if (mEnemy[i].flag == false && mEnemy[i].mPlayID == 6) {
				int random = getRandom();
				mEnemy[i].init(random, random - 350);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		draw();
		repaint();
	}

}
