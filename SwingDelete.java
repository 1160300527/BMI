package edu.hit1160300527.experiment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class SwingDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingDelete frame = new SwingDelete();
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
	public SwingDelete() {
		setTitle("Delete the student");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B64\u5B66\u751F\u6240\u6709\u4FE1\u606F");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		label.setBounds(10, 33, 114, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(74, 10, 226, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u59D3\u540D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(331, 10, 93, 24);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5B66\u53F7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(331, 35, 93, 24);
		contentPane.add(btnNewButton_1);
		
		JScrollPane sp=new JScrollPane();
		sp.setBounds(21, 79, 392, 109);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(sp);
		JTextArea textArea = new JTextArea();
		sp.setViewportView(textArea);
		textArea.setEditable(false);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(111, 233, 204, 28);
		contentPane.add(splitPane);
		
		JButton btnNewButton_2 = new JButton("\u53D6\u6D88\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		splitPane.setLeftComponent(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u786E\u8BA4\u5220\u9664");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		splitPane.setRightComponent(btnNewButton_3);
		
	}
}
