package edu.hit1160300527.experiment4;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.hit1160300527.experiment3.OOBMI.Student;

import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
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
			setTitle("Change the information");
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
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"The id is Exists","Alert",JOptionPane.ERROR_MESSAGE);
						}
						textField_4.setText(String.valueOf(oneStudent.bmi));
					}
				}
			});
			btnNewButton.setBounds(139, 118, 161, 28);
			contentPane.add(btnNewButton);
			
			JButton button = new JButton("\u8BFB\u53D6\u6587\u4EF6");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String filename=textField_5.getText();
					readFile(filename);
					textField_5.setText("");
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"The name shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
						textArea.setText("");
					}	
				}
			});
			btnNewButton.setBounds(331, 10, 93, 24);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u5B66\u53F7");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"The id shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
						textArea.setText("");
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
					if(textField.getText()!=null&&!textField.getText().equals(""))
					{
						String str=textField.getText();
						for(int i=0;i<Students.size();i++){
							if(str.equals(Students.get(i).id)||str.equals(Students.get(i).name)){
								Students.remove(Students.get(i));
							}
						}
						textField.setText("");
						textField.setEditable(true);
						textArea.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"The id shouldn't be empty","Alert",JOptionPane.ERROR_MESSAGE);
						textArea.setText("");
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
}
