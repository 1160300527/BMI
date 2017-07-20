package edu.hit1160300527.experiment4;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import edu.hit1160300527.experiment3.OOBMI.Student;

import java.awt.Button;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SwingBMI extends JFrame {
	public static class Student{
		String id;
		String name;
		double height;
		double weight;
		double bmi;
	}
	private double aveBMI;//平均数
	ArrayList<Double> modeBMI=new ArrayList<Double>();//众数
	private double medBMI;//中位数
	private double varBMI;//方差
	private JPanel contentPane;
	
	ArrayList<Student>Students=new ArrayList<Student>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingBMI frame = new SwingBMI();
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
	public SwingBMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Button button = new Button("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		button.setForeground(Color.BLACK);
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SwingChange change = new SwingChange();
							change.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		Button button_1 = new Button("\u65B0\u589E\u5B66\u751F\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SwingInput input = new SwingInput();
					input.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(SystemColor.controlHighlight);
		menuBar.add(button_1);
		menuBar.add(button);
		
		Button button_2 = new Button("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SwingDelete delete = new SwingDelete();
					delete.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(SystemColor.controlHighlight);
		menuBar.add(button_2);
		
		Button button_3 = new Button("\u67E5\u770B\u7EDF\u8BA1\u60C5\u51B5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SwingCal cal = new SwingCal();
					cal.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setBackground(SystemColor.controlHighlight);
		menuBar.add(button_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public ArrayList<Student>  readFile(String filename){
		File file=new File(filename);
		BufferedReader reader=null;
		ArrayList<Student>Students=new ArrayList<Student>();
		try{
			reader=new BufferedReader(new FileReader(file));
			String stringLine=null;
			while((stringLine=reader.readLine())!=null){
				String str[]=stringLine.split("\t");
				Student student=new Student();
				student.id=str[0];
				student.name=str[1];
				student.height=Double.parseDouble(str[2]);
				student.weight=Double.parseDouble(str[3]);
				student.bmi=Double.parseDouble(str[4]);
				Students.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				reader.close();
			}catch(Exception e){}
		}
		return Students;
	}
	
	
	public class SwingInput extends JFrame {
		private JPanel contentPane;

		/**
		 * Launch the application.
		 */

		/**
		 * Create the frame.
		 */
	}
}
