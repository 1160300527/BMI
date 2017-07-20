package edu.hit1160300527.experiment4;

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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingCal extends JFrame {

	private JPanel contentPane;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u67F1\u5F62\u56FE\u663E\u793A");
		button.addActionListener(new ActionListener() {
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
		contentPane.add(button, BorderLayout.SOUTH);
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
