package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MyForm {

	private JFrame frmMyFirstWindow;
	private JTextField textField_X;
	private JTextField textField_Y;
	private JTextField textField_result;
	private JTextField textField_oper;
	private JButton btnNewButton1;
	private JButton btnNewButton_2;
	private JButton btnNewButtonOper;
	float operand1=0;
	private JLabel lblNewLabelPrev;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyForm window = new MyForm();
					window.frmMyFirstWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyFirstWindow = new JFrame();
		frmMyFirstWindow.setTitle("My Window");
		frmMyFirstWindow.setBounds(100, 100, 450, 300);
		frmMyFirstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmMyFirstWindow.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnButtonCalc = new JButton("=");
		btnButtonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double x=Double.parseDouble(textField_X.getText());
				double y=Double.parseDouble(textField_Y.getText());
				char oper=textField_oper.getText().charAt(0);
				double res=0;
						if(oper=='+'){res=x+y;}
				textField_result.setText(Double.toString(res));		
			}
		});
		btnButtonCalc.setBounds(186, 159, 89, 23);
		panel.add(btnButtonCalc);
		
		textField_X = new JTextField();
		textField_X.setBounds(63, 54, 86, 20);
		panel.add(textField_X);
		textField_X.setColumns(10);
		
		textField_Y = new JTextField();
		textField_Y.setBounds(63, 116, 86, 20);
		panel.add(textField_Y);
		textField_Y.setColumns(10);
		
		textField_result = new JTextField();
		textField_result.setBounds(63, 160, 86, 20);
		panel.add(textField_result);
		textField_result.setColumns(10);
		
		textField_oper = new JTextField();
		textField_oper.setBounds(63, 85, 86, 20);
		panel.add(textField_oper);
		textField_oper.setColumns(10);
		
		btnNewButton1 = new JButton("1");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_X.setText(textField_X.getText()+"1");
			}
		});
		btnNewButton1.setBounds(186, 53, 89, 23);
		panel.add(btnNewButton1);
		
		btnNewButton_2 = new JButton("2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_X.setText(textField_X.getText()+"2");
			}
		});
		btnNewButton_2.setBounds(186, 84, 89, 23);
		panel.add(btnNewButton_2);
		
		btnNewButtonOper = new JButton("+");
		btnNewButtonOper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operand1=Float.parseFloat(textField_X.getText());
				lblNewLabelPrev.setText(Float.toString(operand1));
				textField_X.setText("+");
			}
		});
		btnNewButtonOper.setBounds(186, 115, 89, 23);
		panel.add(btnNewButtonOper);
		
		lblNewLabelPrev = new JLabel("New label");
		lblNewLabelPrev.setBounds(63, 29, 46, 14);
		panel.add(lblNewLabelPrev);
	}
}
