package com.game.frame;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.game.panel.GamePanel;
import com.game.panel.StatusPanel;

/**
 * 
 * @author Mark
 *	完成了主要功能
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;
	private StatusPanel statusPanel;

	public MainFrame() {
		statusPanel = new StatusPanel();
		gamePanel = new GamePanel(statusPanel);
		setTitle("������");
		setSize(850, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container container = getContentPane();
		container.setLayout(new BorderLayout(2, 2));
		container.add(gamePanel, BorderLayout.CENTER);
		container.add(statusPanel, BorderLayout.EAST);
		setVisible(true);
	}
}
