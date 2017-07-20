package edu.hit1160300527.experiment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import edu.hit1160300527.experiment3.OOBMI.Student;

public class SwingInput extends JFrame {
	SwingBMI bmi=new SwingBMI();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingChange frame = new SwingChange();
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
	public SwingInput() {
		setTitle("Change the information");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("input the id");
		textArea.setBounds(61, 12, 221, 28);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setToolTipText("input the name");
		textArea_1.setBounds(340, 12, 82, 28);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(107, 63, 62, 28);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(306, 63, 62, 28);
		contentPane.add(textArea_3);
		
		JLabel label = new JLabel("\u5B66\u53F7:");
		label.setLabelFor(textArea);
		label.setBounds(12, 12, 55, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D:");
		label_1.setLabelFor(textArea_1);
		label_1.setBounds(290, 12, 55, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u9AD8:");
		label_2.setBounds(64, 63, 55, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4F53\u91CD:");
		label_3.setBounds(245, 63, 55, 18);
		contentPane.add(label_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(74, 160, 143, 28);
		contentPane.add(textArea_4);
		textArea_4.setEditable(false);
		
		JLabel lblBmi = new JLabel("BMI:");
		lblBmi.setLabelFor(textArea_4);
		lblBmi.setBounds(27, 170, 54, 15);
		contentPane.add(lblBmi);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(74, 214, 149, 28);
		contentPane.add(textArea_5);

		JButton btnNewButton = new JButton("\u70B9\u51FB\u6DFB\u52A0\u5E76\u8BA1\u7B97BMI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student oneStudent=new Student();
				if(textArea.getText()==null||textArea_1.getText()==null&&textArea_2.getText()==null&&textArea_3.getText()==null||textArea.getText().equals("")||textArea_1.getText().equals("")||textArea_2.getText().equals("")||textArea_3.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please input the all information","Alert",JOptionPane.ERROR_MESSAGE);
				}
				else{
					oneStudent.id=textArea.getText();
					oneStudent.name=textArea_1.getText();
					oneStudent.height=Double.parseDouble(textArea_2.getText());
					oneStudent.weight=Double.parseDouble(textArea_3.getText());
					double bmi=oneStudent.weight/(Math.pow(oneStudent.height/100,2));
					oneStudent.bmi   =   toSecond(bmi);
					textArea_4.setText(String.valueOf(oneStudent.bmi));
				}
			}
		});
		btnNewButton.setBounds(139, 118, 161, 28);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u8BFB\u53D6\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename=textArea_5.getText();
				bmi.Students=bmi.readFile(filename);
			}
		});
		button.setBounds(276, 207, 92, 37);
		contentPane.add(button);
		
		
		JLabel label_4 = new JLabel("\u6587\u4EF6\u5730\u5740");
		label_4.setLabelFor(textArea_5);
		label_4.setBounds(5, 5, 424, 251);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u6587\u4EF6\u5730\u5740");
		label_5.setBounds(13, 218, 54, 15);
		contentPane.add(label_5);
	}
	
	public static double toSecond(double d){
		BigDecimal   b   =   new   BigDecimal(d);  
		return  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
}
