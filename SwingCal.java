package edu.hit1160300527.experiment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import edu.hit1160300527.experiment4.SwingBMI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SwingCal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingCal frame = new SwingCal();
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
	public SwingCal() {
		setTitle("Calculate");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 226, 349, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 10, 373, 25);
		panel.add(menuBar);
		
		JButton btnNewButton = new JButton("\u8EAB\u9AD8\u67F1\u5F62\u56FE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4F53\u91CD\u67F1\u5F62\u56FE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		menuBar.add(btnNewButton_1);
		
		JButton btnBmi = new JButton("BMI\u67F1\u5F62\u56FE");
		btnBmi.setFont(new Font("宋体", Font.PLAIN, 16));
		menuBar.add(btnBmi);
		
		textField = new JTextField();
		textField.setBounds(236, 12, 145, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 59, 145, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(236, 106, 145, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 172, 343, 30);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		btnBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFreeChart chart = ChartFactory.createXYBarChart("BMI Statistics",
				"Intervals", false, "Number of Students", 
				TestXYBarChart.createDataset(), PlotOrientation.VERTICAL,
				true, false, false);
				ChartFrame frame = new ChartFrame("BMI Statistics", chart);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	public static class TestXYBarChart {
		public static IntervalXYDataset createDataset() {
			XYSeriesCollection seriesCollection = new XYSeriesCollection();
			XYSeries series1 = new XYSeries("BMI Statistics");
			SwingBMI one=new SwingBMI();
			series1.add(1, 1);
			series1.add(2, 2);
			series1.add(3, 2);
			series1.add(4, 7);
			series1.add(5, 12);
			series1.add(6, 16);
			series1.add(7, 7);
			series1.add(8, 3);
			series1.add(9, 2);
			series1.add(10, 1);
			seriesCollection.addSeries(series1);
			return new XYBarDataset(seriesCollection, 0.9);
		}
	}
}
