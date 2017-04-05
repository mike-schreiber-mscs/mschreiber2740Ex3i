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

public class DriverExamForm extends JFrame {

	private JPanel contentPane;
	private JList responseList;
	private JTextField inputAnswerTextField;
	private JLabel questNumLabel;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblResult;
	private DefaultListModel responsesListModel;

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
		setBounds(100, 100, 311, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOne = new JLabel("Result:");
		lblOne.setBounds(149, 32, 46, 14);
		contentPane.add(lblOne);
		
		lblResult = new JLabel("");
		lblResult.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblResult.setBounds(149, 49, 124, 22);
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
		
		responseList = new JList();
		responseList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		responseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		responseList.setBounds(69, 59, 36, 185);
		contentPane.add(responseList);
		
		questNumLabel = new JLabel("#0:");
		questNumLabel.setBounds(26, 255, 27, 14);
		contentPane.add(questNumLabel);
		
		inputAnswerTextField = new JTextField();
		inputAnswerTextField.setBounds(69, 252, 36, 20);
		contentPane.add(inputAnswerTextField);
		inputAnswerTextField.setColumns(10);
		
		btnPrev = new JButton("Prev");
		btnPrev.setEnabled(false);
		btnPrev.setBounds(147, 251, 89, 23);
		contentPane.add(btnPrev);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(147, 285, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnPass = new JButton("Pass");
		btnPass.setBounds(147, 82, 114, 23);
		contentPane.add(btnPass);
		
		JButton btnCorrect = new JButton("Correct");
		btnCorrect.setBounds(147, 113, 114, 23);
		contentPane.add(btnCorrect);
		
		JButton btnIncorrect = new JButton("Incorrect");
		btnIncorrect.setBounds(147, 147, 114, 23);
		contentPane.add(btnIncorrect);
		
		JButton btnListIncorrect = new JButton("List Incorrect");
		btnListIncorrect.setBounds(147, 183, 114, 23);
		contentPane.add(btnListIncorrect);
	}
}
