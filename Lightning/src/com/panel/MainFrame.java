package com.panel;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * 
 * @author Mark
 * @time 2017年5月1日 下午3:17:20
 * @version 1.0
 * @description 当子弹与敌机碰撞时还有一点问题
 */

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int mScreenWidth = 320;
	public static final int mScreenHeight = 480;

	public MainFrame() {
		setTitle("雷电");
		setContentPane(new BackgroundPanel());
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(new GamePanel(), BorderLayout.CENTER);
		setSize(mScreenWidth, mScreenHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
