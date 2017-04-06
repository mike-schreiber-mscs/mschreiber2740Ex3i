package mschreiber2740Ex3i;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DriverExamForm extends JFrame {

	private JPanel contentPane;
	private JList responsesList;
	private JTextField inputAnswerTextField;
	private JLabel questNumLabel;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblResult;
	private DefaultListModel responsesListModel;
	private DriverExam exam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverExamForm frame = new DriverExamForm();
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
	public DriverExamForm() {
		setTitle("Ex3I Driver Exam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOne = new JLabel("Result:");
		lblOne.setBounds(130, 32, 46, 14);
		contentPane.add(lblOne);
		
		lblResult = new JLabel("");
		lblResult.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblResult.setBounds(130, 60, 191, 22);
		contentPane.add(lblResult);
		
		JLabel lblResponses = new JLabel("Responses:");
		lblResponses.setBounds(32, 32, 107, 14);
		contentPane.add(lblResponses);
		
		JList questNumList = new JList();
		questNumList.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		questNumList.setEnabled(false);
		questNumList.setBounds(32, 61, 27, 183);
		contentPane.add(questNumList);
		
		responsesList = new JList();
		responsesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_responsesList_valueChanged(arg0);
			}
		});
		responsesList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		responsesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		responsesList.setBounds(80, 57, 36, 185);
		contentPane.add(responsesList);
		
		questNumLabel = new JLabel("#0:");
		questNumLabel.setBounds(26, 255, 27, 14);
		contentPane.add(questNumLabel);
		
		inputAnswerTextField = new JTextField();
		inputAnswerTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_inputAnswerTextField_focusGained(arg0);
			}
		});
		inputAnswerTextField.setBounds(69, 252, 36, 20);
		contentPane.add(inputAnswerTextField);
		inputAnswerTextField.setColumns(10);
		
		btnPrev = new JButton("Prev");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPrev_actionPerformed(arg0);
			}
		});
		btnPrev.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrev.setEnabled(false);
		btnPrev.setBounds(147, 251, 89, 23);
		contentPane.add(btnPrev);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNext_actionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(147, 285, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnPass = new JButton("Pass");
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPass_actionPerformed(e);
			}
		});
		btnPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPass.setBounds(130, 93, 114, 23);
		contentPane.add(btnPass);
		
		JButton btnCorrect = new JButton("Correct");
		btnCorrect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCorrect_actionPerformed(e);
			}
		});
		btnCorrect.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrect.setBounds(130, 127, 114, 23);
		contentPane.add(btnCorrect);
		
		JButton btnIncorrect = new JButton("Incorrect");
		btnIncorrect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnIncorrect_actionPerformed(e);
			}
		});
		btnIncorrect.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIncorrect.setBounds(130, 161, 114, 23);
		contentPane.add(btnIncorrect);
		
		JButton btnListIncorrect = new JButton("List Incorrect");
		btnListIncorrect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnListIncorrect_actionPerformed(e);
			}
		});
		btnListIncorrect.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListIncorrect.setBounds(130, 195, 114, 23);
		contentPane.add(btnListIncorrect);
		
		DriverExamObjMapper mapper = new DriverExamObjMapper("DriverExam.txt");
		this.exam = mapper.getDriverExam();
		this.responsesListModel = exam.getAnswers();
		responsesList.setModel(this.responsesListModel);
	}
	
	
	
	protected void do_responsesList_valueChanged(ListSelectionEvent arg0) {
		questNumLabel.setText("#" + Integer.toString((responsesList.getSelectedIndex() + 1)));
        inputAnswerTextField.setText((String)responsesList.getSelectedValue());    

        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (responsesList.getSelectedIndex() == responsesListModel.getSize() - 1)
            btnNext.setEnabled(false);
        if (responsesList.getSelectedIndex() == 0) 
            btnPrev.setEnabled(false);
        inputAnswerTextField.requestFocus();        
    }
	
	
	protected void do_btnPrev_actionPerformed(ActionEvent arg0) {
		this.responsesListModel.setElementAt(
        inputAnswerTextField.getText().toUpperCase(), 
        responsesList.getSelectedIndex());
        responsesList.setSelectedIndex(responsesList.getSelectedIndex() - 1);
        questNumLabel.setText("#" + Integer.toString((responsesList.getSelectedIndex() + 1)));
        inputAnswerTextField.setText((String)responsesList.getSelectedValue());    

        btnNext.setEnabled(true);
        if (responsesList.getSelectedIndex() == 0) 
            btnPrev.setEnabled(false);
        inputAnswerTextField.requestFocus();
	}
	
	protected void do_btnNext_actionPerformed(ActionEvent e) {
		this.responsesListModel.setElementAt(
        inputAnswerTextField.getText().toUpperCase(), 
        responsesList.getSelectedIndex());
        responsesList.setSelectedIndex(responsesList.getSelectedIndex() + 1);
        questNumLabel.setText("#" + Integer.toString((responsesList.getSelectedIndex() + 1)));
        inputAnswerTextField.setText((String)responsesList.getSelectedValue());
        
        btnPrev.setEnabled(true);
        if (responsesList.getSelectedIndex() == responsesListModel.getSize() - 1)
            btnNext.setEnabled(false);
        inputAnswerTextField.requestFocus();
	}
	
	protected void do_inputAnswerTextField_focusGained(FocusEvent arg0) {
		inputAnswerTextField.selectAll();
	}
	
	//NEED TO VALIDATE ALL BUTTON ACTION PERFORMED AFTER FIXING THE GETANSWERS FUNCTION IN DRIVEREXAM CLASS
	protected void do_btnPass_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if(invalid >= 0)
		{
			lblResult.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else
		{
			if(exam.passed())
			{
				lblResult.setText("You passed");				
			}
			else
			{
				lblResult.setText("You failed");
			}
		}
	}
	
	
	protected void do_btnCorrect_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if(invalid >= 0)
		{
			lblResult.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else
		{
			lblResult.setText("Total Correct: " + exam.totalCorrect());		
		}
	}
	
	
	protected void do_btnIncorrect_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if(invalid >= 0)
		{
			lblResult.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else
		{
			lblResult.setText("Total Incorrect: " + exam.totalIncorrect());
		}
	}
	
	
	protected void do_btnListIncorrect_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if(invalid >= 0)
		{
			lblResult.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else
		{
			lblResult.setText("Question missed: " + exam.questionsMissed());
		}
	}
}

