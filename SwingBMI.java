package edu.hit1160300527.experiment4;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import java.awt.BorderLayout;

public class SwingBMI extends JFrame {
	public static class Student{
		String id;
		String name;
		double height;
		double weight;
		double bmi;
	public String toString(){
		String str="";
		str=id+"\t"+name+"\t"+height+"\t"+weight+"\t"+bmi;
		return str;
	}
	}
	private static double aveBMI;//平均数
	ArrayList<Double> modeBMI=new ArrayList<Double>();//众数
	private static double medBMI;//中位数
	private static double varBMI;//方差
	private static double aveHeight;//平均数
	ArrayList<Double> modeHeight=new ArrayList<Double>();//众数
	private static double medHeight;//中位数
	private static double varHeight;//方差
	private static double aveWeight;//平均数
	ArrayList<Double> modeWeight=new ArrayList<Double>();//众数
	private static double medWeight;//中位数
	private static double varWeight;//方差
	private static JPanel contentPane;
	private static 
	
	
	ArrayList<Student>Students=new ArrayList<Student>();
	private JTextField textField_6;
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
		setTitle("\u6309\u5B66\u53F7\u6216\u59D3\u540D\u67E5\u627E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 450);
		
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
					if(Students.size()==0)
					{
						JOptionPane.showMessageDialog(null,"The number of the students mustn't be 0,so we randomly generated 20 students!","Alert",JOptionPane.ERROR_MESSAGE);
						genStudents(20);
					}
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
		
		JScrollPane sp=new JScrollPane();
		sp.setBounds(22, 129, 430, 217);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(sp);
		JTextArea textArea_1 = new JTextArea();
		sp.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(61, 35, 201, 28);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea, BorderLayout.SOUTH);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 16));
		textArea.setBackground(SystemColor.text);
		
		JButton btnNewButton = new JButton("\u6309\u5B66\u53F7\u67E5\u627E");
		btnNewButton.setBounds(309, 17, 110, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textArea.getText()!=null&&!textArea.getText().equals(""))
				{
					String id=textArea.getText();
					if(!findId(id,textArea_1)){
						JOptionPane.showMessageDialog(null,"The id don't exit","Alert",JOptionPane.ERROR_MESSAGE);
						showStudents(new bmisComparator(),textArea_1);
						textArea.setText("");
					}
					textArea.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The id shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
					showStudents(new bmisComparator(),textArea_1);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 358, 434, 28);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton_1 = new JButton("\u8EAB\u9AD8\u6392\u540D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Students.size()==0)
					genStudents(20);
				showStudents(new heightsComparator(),textArea_1);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4F53\u91CD\u6392\u540D");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Students.size()==0)
					genStudents(20);
				showStudents(new weightsComparator(),textArea_1);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("bmi\u6392\u540D");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Students.size()==0)
					genStudents(20);
				showStudents(new bmisComparator(),textArea_1);
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5B66\u53F7\u6392\u540D");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Students.size()==0)
					genStudents(20);
				showStudents(new idsComparator(),textArea_1);
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u59D3\u540D\u6392\u540D");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Students.size()==0)
					genStudents(20);
				showStudents(new namesComparator(),textArea_1);
			}
		});
		panel.add(btnNewButton_5);
		
		JButton button_5 = new JButton("\u6309\u59D3\u540D\u67E5\u627E");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textArea.getText()!=null&&!textArea.getText().equals(""))
				{
					String id=textArea.getText();
					if(!findName(id,textArea_1)){
						JOptionPane.showMessageDialog(null,"The name don't exit","Alert",JOptionPane.ERROR_MESSAGE);
						textArea.setText("");
						showStudents(new bmisComparator(),textArea_1);
					}
					textArea.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The name shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
					showStudents(new bmisComparator(),textArea_1);
				}
			}
		});
		button_5.setBounds(309, 57, 110, 28);
		contentPane.add(button_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_6.setBounds(61, 91, 201, 33);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton button_4 = new JButton("\u4FDD\u5B58\u5230\u6B64\u6587\u4EF6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_6.getText()==null||textField_6.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"The direction of the file can't be empty","Alert",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String filename=textField_6.getText();
					saveFile(Students,filename);
				}
				textField_6.setText("");
			}
		});
		button_4.setBounds(291, 97, 128, 27);
		contentPane.add(button_4);
		
	}
	public void readFile(String filename){
		File file=new File(filename);
		BufferedReader reader=null;
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
				if(!isExists(student.id))
					Students.add(student);
			}
			JOptionPane.showMessageDialog(null,"Read the"+filename+" sucessfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The filename is wrong","Alert",JOptionPane.ERROR_MESSAGE);
		}finally{
			try{
				reader.close();
			}catch(Exception e){}
		}
	}
	public class idsComparator implements Comparator<Student>{
		public int compare(Student stu1,Student stu2){
			if(stu1.id.compareTo(stu2.id)<0)
			{
				return -1;
			}
			else if(stu1.id.compareTo(stu2.id)>0){
				return 1;
			}
			return 0;
		}
	}
	public class namesComparator implements Comparator<Student>{
		public int compare(Student stu1,Student stu2){
			if(stu1.name.compareTo(stu2.name)<0)
			{
				return -1;
			}
			else if(stu1.name.compareTo(stu2.name)>0)
			{
				return 1;
			}
			return 0;
		}
	}
	public class heightsComparator implements Comparator<Student>{
		public int compare(Student stu1,Student stu2){
			if(stu1.height<stu2.height)
			{
				return -1;
			}
			else if(stu1.height>stu2.height)
			{
				return 1;
			}
			return 0;
		}
	}
	public class weightsComparator implements Comparator<Student>{
		public int compare(Student stu1,Student stu2){
			if(stu1.weight<stu2.weight)
			{
				return -1;
			}
			else if(stu1.weight>stu2.weight)
			{
				return 1;
			}
			return 0;
		}
	}
	public class bmisComparator implements Comparator<Student>{
		public int compare(Student stu1,Student stu2){
			if(stu1.bmi<stu2.bmi)
			{
				return -1;
			}
			else if(stu1.bmi>stu2.bmi)
			{
				return 1;
			}
			return 0;
		}
	}
	public void sortStudents(Comparator<Student> c) {
		Collections.sort(Students, c);
	}	
	private void showStudents(Comparator<Student>T,JTextArea textarea){
		sortStudents(T);
		StringBuffer sb = new StringBuffer();
		int i=0;
		String str1=String.format("       学号\t\t姓名\t身高\t体重\tBMI值\n");
		sb.append(str1);
		for(Student st: Students){
			i++;
			String str=String.format("%-5d ", i);
			sb.append(str+st.toString()).append("\n");
		}
		textarea.setText(sb.toString());
	}
	
	public void genStudents(int n){
		Random random=new Random();
		String names="abcdefghijklmnopqrstuvwxyz";
		for(int i=0;i<n;){
			String id="";
			String name="";
			Student newStudent=new Student();
			for(int j=0;j<10;j++)
			{
				id=id+random.nextInt(10);
			}
			newStudent.id=id;
			for(int j=0;j<4;j++)
			{
				name=name+names.charAt(random.nextInt(26));
			}
			newStudent.name=name;
			newStudent.height=toSecond(random.nextFloat()*40+150);
			newStudent.weight=toSecond(random.nextFloat()*60+50);
			newStudent.bmi=toSecond(newStudent.weight/(float)(Math.pow(newStudent.height/100,2)));
			if(!isExists(newStudent.id))
			{
				Students.add(newStudent);
				i++;
			}
		}
	}
	public boolean isExists(String id){
		for(int i=0;i<Students.size();i++)
		{
			if(Students.get(i).id.equals(id))
				return true;
		}
		return false;
	}
	public static double toSecond(double d){
		BigDecimal   b   =   new   BigDecimal(d);  
		return  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	public class SwingInput extends JFrame {
		private JPanel contentPane;

		/**
		 * Launch the application.
		 */

		/**
		 * Create the frame.
		 */
		public SwingInput() {
			setTitle("Input the information");
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel label = new JLabel("\u5B66\u53F7:");
			label.setBounds(12, 12, 55, 18);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel("\u59D3\u540D:");
			label_1.setBounds(290, 12, 55, 18);
			contentPane.add(label_1);
			
			JLabel label_2 = new JLabel("\u8EAB\u9AD8:");
			label_2.setBounds(50, 63, 55, 18);
			contentPane.add(label_2);
			
			JLabel label_3 = new JLabel("\u4F53\u91CD:");
			label_3.setBounds(250, 63, 55, 18);
			contentPane.add(label_3);
			
			
			
			JTextField textField = new JTextField();
			textField.setBounds(64, 8, 153, 28);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JTextField textField_1 = new JTextField();
			textField_1.setBounds(326, 7, 98, 28);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			JTextField textField_2 = new JTextField();
			textField_2.setBounds(92, 59, 71, 28);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			JTextField textField_3 = new JTextField();
			textField_3.setBounds(302, 59, 66, 28);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			JTextField textField_4 = new JTextField();
			textField_4.setBackground(Color.WHITE);
			textField_4.setEditable(false);
			textField_4.setBounds(74, 167, 122, 28);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			JTextField textField_5 = new JTextField();
			textField_5.setBounds(76, 215, 122, 28);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
			JLabel lblBmi = new JLabel("BMI:");
			lblBmi.setBounds(27, 170, 54, 15);
			contentPane.add(lblBmi);

			JButton btnNewButton = new JButton("\u70B9\u51FB\u6DFB\u52A0\u5E76\u8BA1\u7B97BMI");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Student oneStudent=new Student();
					if(textField.getText()==null||textField_1.getText()==null&&textField_2.getText()==null&&textField_3.getText()==null||textField.getText().equals("")||textField_3.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Please input the all information","Alert",JOptionPane.ERROR_MESSAGE);
					}
					else{
						oneStudent.id=textField.getText();
						oneStudent.name=textField_1.getText();
						oneStudent.height=Double.parseDouble(textField_2.getText());
						oneStudent.weight=Double.parseDouble(textField_3.getText());
						double bmi=oneStudent.weight/(Math.pow(oneStudent.height/100,2));
						oneStudent.bmi   =   toSecond(bmi);
						if(!isExists(oneStudent.id))
						{
							Students.add(oneStudent);
							JOptionPane.showMessageDialog(null,"Add the student successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"The id is Exists","Alert",JOptionPane.ERROR_MESSAGE);
						}
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText(String.valueOf(oneStudent.bmi));
					}
				}
			});
			btnNewButton.setBounds(139, 118, 161, 28);
			contentPane.add(btnNewButton);
			
			JButton button = new JButton("\u8BFB\u53D6\u6587\u4EF6");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField_5.getText()==null||textField_5.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"The direction of the file can't be empty","Alert",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String filename=textField_5.getText();
						readFile(filename);
						textField_5.setText("");
					}
				}
			});
			button.setBounds(276, 207, 92, 37);
			contentPane.add(button);
			
			JLabel label_5 = new JLabel("\u6587\u4EF6\u5730\u5740");
			label_5.setBounds(12, 218, 54, 15);
			contentPane.add(label_5);
		}
	}

	public class SwingChange extends JFrame {
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;

		/**
		 * Launch the application.
		 */

		/**
		 * Create the frame.
		 */
		public SwingChange() {
			setTitle("Change the information");
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			JPanel panel = new JPanel();
			panel.setBounds(120, 10, 294, 213);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
			lblNewLabel.setBounds(62, 26, 28, 16);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label = new JLabel("\u59D3\u540D");
			label.setBounds(62, 62, 64, 30);
			panel.add(label);
			label.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label_1 = new JLabel("\u8EAB\u9AD8");
			label_1.setBounds(62, 106, 61, 29);
			panel.add(label_1);
			label_1.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label_2 = new JLabel("\u4F53\u91CD");
			label_2.setBounds(62, 150, 61, 32);
			panel.add(label_2);
			label_2.setFont(new Font("宋体", Font.PLAIN, 14));
			
			textField = new JTextField();
			textField.setBounds(120, 19, 155, 32);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(120, 61, 155, 33);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(120, 107, 155, 33);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(120, 152, 155, 33);
			panel.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblBmi = new JLabel("BMI");
			lblBmi.setFont(new Font("宋体", Font.PLAIN, 16));
			lblBmi.setBounds(10, 71, 80, 23);
			contentPane.add(lblBmi);
			
			textField_4 = new JTextField();
			textField_4.setBackground(Color.WHITE);
			textField_4.setEditable(false);
			textField_4.setBounds(10, 108, 80, 39);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			JButton button = new JButton("\u70B9\u51FB\u4FEE\u6539");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText()==null||textField_1.getText()==null&&textField_2.getText()==null&&textField_3.getText()==null||textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Please input the all information","Alert",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Student oneStudent=new Student();
						oneStudent.id=textField.getText();
						oneStudent.name=textField_1.getText();
						oneStudent.height=Double.parseDouble(textField_2.getText());
						oneStudent.weight=Double.parseDouble(textField_3.getText());
						double bmi=oneStudent.weight/(Math.pow(oneStudent.height/100,2));
						oneStudent.bmi   =   toSecond(bmi);
						textField_4.setText(String.valueOf(oneStudent.bmi));
						boolean flag=false;
						for(Student student : Students)
						{
							if(student.id.equals(oneStudent.id)){
								Students.remove(student);
								Students.add(oneStudent);
								flag=true;
								JOptionPane.showMessageDialog(null,"Change the information of "+oneStudent.id+" successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
								break;
							}
						}
						if(!flag){
							JOptionPane.showMessageDialog(null,"The id isn't Exists!","Alert",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			button.setBounds(5, 233, 424, 23);
			contentPane.add(button);
		}
	}
	public class SwingDelete extends JFrame {
		boolean flag=false;
		private JPanel contentPane;
		private JTextField textField;

		/**
		 * Launch the application.
		 */
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
			label.setFont(new Font("宋体", Font.PLAIN, 16));
			label.setBounds(10, 33, 114, 25);
			contentPane.add(label);
			
			textField = new JTextField();
			textField.setBounds(74, 10, 226, 25);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JScrollPane sp=new JScrollPane();
			sp.setBounds(21, 79, 392, 109);
			sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			getContentPane().add(sp);
			JTextArea textArea = new JTextArea();
			sp.setViewportView(textArea);
			textArea.setEditable(false);
			
			
			JButton btnNewButton = new JButton("\u59D3\u540D");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!flag){
						if(textField.getText()!=null&&!textField.getText().equals(""))
						{
							String name=textField.getText();
							if(!findName(name,textArea)){
								JOptionPane.showMessageDialog(null,"The name don't exit","Alert",JOptionPane.ERROR_MESSAGE);
								textArea.setText("");
								textField.setText("");
							}
							else{
								textField.setEditable(false);
								flag=true;
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"The name shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
							textArea.setText("");
						}	
					}
				}
			});
			btnNewButton.setBounds(331, 10, 93, 24);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u5B66\u53F7");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!flag){
						if(textField.getText()!=null&&!textField.getText().equals(""))
						{
							String id=textField.getText();
							if(!findId(id,textArea)){
								JOptionPane.showMessageDialog(null,"The id don't exit","Alert",JOptionPane.ERROR_MESSAGE);
								textArea.setText("");
								textField.setText("");
							}
							else{
								textField.setEditable(false);
								flag=true;
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"The id shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
							textArea.setText("");
						}
					}
				}	
			});	
			btnNewButton_1.setBounds(331, 35, 93, 24);
			contentPane.add(btnNewButton_1);
			

			JSplitPane splitPane = new JSplitPane();
			splitPane.setBounds(111, 233, 204, 28);
			contentPane.add(splitPane);
			
			JButton btnNewButton_2 = new JButton("\u786E\u8BA4\u5220\u9664");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(flag){
						String str=textField.getText();
						for(int i=0;i<Students.size();i++){
							if(str.equals(Students.get(i).id)||str.equals(Students.get(i).name)){
								Students.remove(Students.get(i));
							}
						}
						JOptionPane.showMessageDialog(null,"You remove the student from the students successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
						textField.setEditable(true);
						textArea.setText("");
						flag=false;
					}
					else{
						JOptionPane.showMessageDialog(null,"Please search the student first!","Alert",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
			splitPane.setLeftComponent(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("\u53D6\u6D88\u5220\u9664");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setEditable(true);
					textField.setText("");
					textArea.setText("");
					flag=false;
				}
			});
			btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 16));
			splitPane.setRightComponent(btnNewButton_3);
			
		}
	}

	public boolean findId(String id,JTextArea textArea){
		int i=0;
		for(Student student : Students){
			i++;
			if(student.id.equals(id)){
				StringBuffer string=new StringBuffer();
				String table=String.format("       学号\t\t姓名\t身高\t体重\tBMI值\n");
				string.append(table);
				String str=String.format("%-5d ", i );
				String information=student.toString();
				string.append(str).append(information);
				textArea.setText(string.toString());
				return true;
			}
		}
		return false;
	}
	public boolean findName(String name,JTextArea textArea){
		int i=0;
		for(Student student : Students){
			i++;
			if(student.name.equals(name)){
				StringBuffer string=new StringBuffer();
				String table=String.format("       学号\t\t姓名\t身高\t体重\tBMI值\n");
				string.append(table);
				String str=String.format("%-5d ", i );
				String information=student.toString();
				string.append(str).append(information);
				textArea.setText(string.toString());
				return true;
			}
		}
		return false;
	}
	public void ave(){
		double sumBMI=0;
		double sumHeight=0;
		double sumWeight=0;
		for(Student student:Students){
			sumBMI+=student.bmi;
			sumHeight+=student.height;
			sumWeight+=student.weight;
		}
		aveBMI=sumBMI/Students.size();
		aveBMI=toSecond(aveBMI);
		aveHeight=sumHeight/Students.size();
		aveHeight=toSecond(aveHeight);
		aveWeight=sumWeight/Students.size();
		aveWeight=toSecond(aveWeight);

	}
	public ArrayList<Double> mod(){
		ArrayList<Double> modeBMI=new ArrayList<Double>();
        HashMap<Double,Integer> hm = new HashMap<Double,Integer>();
        Iterator<Student> iter=Students.iterator();
        Integer max=0;
        while(iter.hasNext()){
        	Double bmi=new Double(iter.next().bmi);
        	if (!hm.containsKey(bmi)){
                hm.put(bmi, 1);	    		 
           }else{ 
                hm.put(bmi,hm.get(bmi).intValue()+1);
           }
        }
        Set<Double> keys = hm.keySet();
        for (Double bmi : keys) {
        	if(hm.get(bmi).compareTo(max)>0)
        		max=hm.get(bmi);
        }
        for(Double bmi:keys){
        	if(hm.get(bmi).equals(max)){
        		modeBMI.add(bmi);
        	}
        }
        return modeBMI;
	}
	public ArrayList<Double> modHeight(){
		ArrayList<Double> modeHeight=new ArrayList<Double>();
        HashMap<Double,Integer> hm = new HashMap<Double,Integer>();
        Iterator<Student> iter=Students.iterator();
        Integer max=0;
        while(iter.hasNext()){
        	Double height=new Double(iter.next().height);
        	if (!hm.containsKey(height)){
                hm.put(height, 1);	    		 
           }else{ 
                hm.put(height,hm.get(height).intValue()+1);
           }
        }
        Set<Double> keys = hm.keySet();
        for (Double height : keys) {
        	if(hm.get(height).compareTo(max)>0)
        		max=hm.get(height);
        }
        for(Double height:keys){
        	if(hm.get(height).equals(max)){
        		modeHeight.add(height);
        	}
        }
        return modeHeight;
	}
	public ArrayList<Double> modWeight(){
		ArrayList<Double> modeWeight=new ArrayList<Double>();
        HashMap<Double,Integer> hm = new HashMap<Double,Integer>();
        Iterator<Student> iter=Students.iterator();
        Integer max=0;
        while(iter.hasNext()){
        	Double weight=new Double(iter.next().weight);
        	if (!hm.containsKey(weight)){
                hm.put(weight, 1);	    		 
           }else{ 
                hm.put(weight,hm.get(weight).intValue()+1);
           }
        }
        Set<Double> keys = hm.keySet();
        for (Double weight : keys) {
        	if(hm.get(weight).compareTo(max)>0)
        		max=hm.get(weight);
        }
        for(Double weight:keys){
        	if(hm.get(weight).equals(max)){
        		modeWeight.add(weight);
        	}
        }
        return modeWeight;
	}
	public double med(){
		double medBMI=0;
		sortStudents(new bmisComparator());
		int size=Students.size();
		medBMI+= Students.get(size/2).bmi;
		if(size%2==0)
		{
			medBMI=(medBMI+Students.get(size/2-1).bmi)/2;
		}
		return toSecond(medBMI);
	}
	public double medHeight(){
		double medHeight=0;
		sortStudents(new heightsComparator());
		int size=Students.size();
		medHeight+= Students.get(size/2).height;
		if(size%2==0)
		{
			medHeight=(medHeight+Students.get(size/2-1).height)/2;
		}
		return toSecond(medHeight);
	}
	public double medWeight(){
		double medWeight=0;
		sortStudents(new heightsComparator());
		int size=Students.size();
		medWeight+= Students.get(size/2).weight;
		if(size%2==0)
		{
			medWeight=(medWeight+Students.get(size/2-1).weight)/2;
		}
		return toSecond(medWeight);
	}
	public void var(){
		varBMI=0;
		varHeight=0;
		varWeight=0;
		for(Student student:Students){
			varBMI+=Math.pow(student.bmi-aveBMI, 2);
			varHeight+=Math.pow(student.height-aveHeight, 2);
			varWeight+=Math.pow(student.weight-aveWeight, 2);
		}
		varBMI/=Students.size();
		varBMI=toSecond(varBMI);
		varHeight/=Students.size();
		varHeight=toSecond(varHeight);
		varWeight/=Students.size();
		varWeight=toSecond(varWeight);
	}
	public class SwingCal extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;

		/**
		 * Launch the application.
		 */
		/**
		 * Create the frame.
		 */
		public SwingCal() {
			setTitle("Calculate");
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			ave();
			modeBMI=mod();
			modeHeight=modHeight();
			modeWeight=modWeight();
		    medBMI=med();
		    medHeight=medHeight();
		    medWeight=medWeight();
			var();
			
			JPanel panel = new JPanel();
			panel.setBounds(32, 226, 349, 35);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 10, 373, 25);
			panel.add(menuBar);
			
			textField = new JTextField();
			textField.setBounds(236, 12, 145, 35);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setEditable(false);
			
			textField_1 = new JTextField();
			textField_1.setBounds(236, 59, 145, 35);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setEditable(false);
			
			textField_2 = new JTextField();
			textField_2.setBounds(236, 106, 145, 35);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			textField_2.setEditable(false);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 172, 343, 45);
			contentPane.add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
			textArea.setEditable(false);
			
			JButton btnNewButton = new JButton("\u8EAB\u9AD8\u67F1\u5F62\u56FE");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField.setText(String.valueOf(aveHeight));
					textField_1.setText(String.valueOf(medHeight));
					textField_2.setText(String.valueOf(varHeight));
					String mode="";
					Iterator<Double>iter=modeHeight.iterator();
					while(iter.hasNext()){
						mode=mode+String.valueOf(iter.next())+"\t";
					}
					textArea.setText(mode);
					sortStudents(new heightsComparator());
					int num[]=new int[10];
					double min=Students.get(0).height;
					double max=Students.get(Students.size()-1).height;
					double width=(max-min)/10.0;
					Iterator<Student> iter_1=Students.iterator();
					while(iter_1.hasNext()){
						Student student=iter_1.next();
						int n=(int)((student.height-min)/width);
						if(n==10)
						{
							num[9]+=1;
						}
						else
							num[n]+=1;
						//System.out.println(n);
					}
					showDraw(min,max,width,num,"Height");
				}
			});
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
			menuBar.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u4F53\u91CD\u67F1\u5F62\u56FE");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(String.valueOf(aveWeight));
					textField_1.setText(String.valueOf(medWeight));
					textField_2.setText(String.valueOf(varWeight));
					String mode="";
					Iterator<Double>iter=modeWeight.iterator();
					while(iter.hasNext()){
						mode=mode+String.valueOf(iter.next())+"\t";
					}
					textArea.setText(mode);
					sortStudents(new weightsComparator());
					int num[]=new int[10];
					double min=Students.get(0).weight;
					double max=Students.get(Students.size()-1).weight;
					double width=(max-min)/10.0;
					Iterator<Student> iter_1=Students.iterator();
					while(iter_1.hasNext()){
						Student student=iter_1.next();
						int n=(int)((student.weight-min)/width);
						if(n==10)
						{
							num[9]+=1;
						}
						else
							num[n]+=1;
					}
					showDraw(min,max,width,num,"Weight");
				}
			});
			btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
			menuBar.add(btnNewButton_1);
			
			JButton btnBmi = new JButton("BMI\u67F1\u5F62\u56FE");
			btnBmi.setFont(new Font("宋体", Font.PLAIN, 16));
			menuBar.add(btnBmi);
			
			JLabel label = new JLabel("\u5E73\u5747\u6570\uFF1A");
			label.setFont(new Font("宋体", Font.PLAIN, 16));
			label.setBounds(151, 12, 77, 35);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel("\u4E2D\u4F4D\u6570\uFF1A");
			label_1.setFont(new Font("宋体", Font.PLAIN, 16));
			label_1.setBounds(151, 59, 77, 35);
			contentPane.add(label_1);
			
			JLabel label_2 = new JLabel("\u65B9\u5DEE\uFF1A");
			label_2.setFont(new Font("宋体", Font.PLAIN, 16));
			label_2.setBounds(151, 103, 77, 35);
			contentPane.add(label_2);
			
			JLabel label_3 = new JLabel("\u4F17\u6570\uFF1A");
			label_3.setFont(new Font("宋体", Font.PLAIN, 16));
			label_3.setBounds(43, 139, 103, 35);
			contentPane.add(label_3);
			
			btnBmi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField.setText(String.valueOf(aveBMI));
					textField_1.setText(String.valueOf(medBMI));
					textField_2.setText(String.valueOf(varBMI));
					String mode="";
					Iterator<Double>iter=modeBMI.iterator();
					while(iter.hasNext()){
						mode=mode+String.valueOf(iter.next())+"\t";
					}
					textArea.setText(mode);
					sortStudents(new bmisComparator());
					int num[]=new int[10];
					double min=Students.get(0).bmi;
					double max=Students.get(Students.size()-1).bmi;
					double width=(max-min)/10.0;
					Iterator<Student> iter_1=Students.iterator();
					while(iter_1.hasNext()){
						Student student=iter_1.next();
						int n=(int)((student.bmi-min)/width);
						if(n==10)
						{
							num[9]+=1;
						}
						else
							num[n]+=1;
					}
					showDraw(min,max,width,num,"BMI");
				}
			});
		}
	}
	public IntervalXYDataset createBMI(double min,double width,int []num,String butt) {
		XYSeriesCollection seriesCollection = new XYSeriesCollection();
		XYSeries series1 = new XYSeries(butt+" Statistics");
		for(int i=0;i<10;i++)
		{
			series1.add(i+1,num[i]);
		}
		series1.setMaximumItemCount(10);
		seriesCollection.addSeries(series1);
		return new XYBarDataset(seriesCollection, 0.9);
	}
	public void showDraw(double min,double max,double width,int []num,String butt){
		JFreeChart chart = ChartFactory.createXYBarChart(butt+" Statistics",
				"min:"+String.valueOf(min)+"~"+"max"+String.valueOf(max)+"    Intervals="+String.valueOf(toSecond(width)), false, "Number of Students", 
				createBMI(min,width,num,butt), PlotOrientation.VERTICAL,
				true, false, false);
				ChartFrame frame = new ChartFrame("BMI Statistics", chart);
				frame.pack();
				frame.setVisible(true);
	}
	public void saveFile(ArrayList<Student> students, String filename){
		FileWriter file=null;
		try{	
			file=new FileWriter(filename,false);
			for(Student student:Students){
				file.write(String.format("%s\t%s\t%.2f\t%.2f\t%.2f\r\n",student.id,student.name,student.height,student.weight,student.bmi));
			}
			JOptionPane.showMessageDialog(null,"Save to"+filename+" sucessfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e) {
            JOptionPane.showMessageDialog(null,"The direction is wrong","Alert",JOptionPane.ERROR_MESSAGE);
		}
		finally{
            try{
                     file.close();
            	}catch(Exception e){}
		}
	}
}
