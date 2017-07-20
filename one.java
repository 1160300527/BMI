package edu.hit1160300527.experiment4;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class one extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					one frame = new one();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public one() {
		setBounds(100, 100, 450, 300);

	}

}
