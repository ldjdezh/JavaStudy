package com.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.panel.GamePanel;

public class Bullet {
	Image[] bulletPic;
	public int mPosX;
	public int mPosY;
	public int mPlayID;
	GamePanel panel;
	public boolean flag;

	public Bullet(GamePanel panel) {
		this.panel = panel;

		bulletPic = new Image[4];
		for (int i = 0; i < bulletPic.length; i++)
			bulletPic[i] = Toolkit.getDefaultToolkit().getImage("images\\bullet_" + i + ".png");

	}

	public void init(int x, int y) {
		mPosX = x;
		mPosY = y;
		mPlayID = 0;
		flag = true;
	}

	public void updateBullet() {
		if (flag) {
			mPosY -= 15;

//			mPlayID++;
//
//			if (mPlayID == 4) {
//				mPlayID = 0;
//			}
		}

	}

	public void drawBullet(Graphics g) {
		if (flag)
			g.drawImage(bulletPic[mPlayID], mPosX, mPosY, panel);
	}
}
