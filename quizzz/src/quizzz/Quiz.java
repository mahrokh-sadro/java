package quizzz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class Quiz implements ActionListener {

	String[] m_questions = { "Who is your dream boss?",
			"Which one is true about you?", 
			"I… Declare…",
			"What is the best TV show ever?",
			"I am ..." };

	String[][] m_options = {

			{ "Michael Scott", "Chandler Bing", "Albus Dumbledore", "Miranda Bailey" },
			{ "a night owl", "an early bird", "a permanently exhausted pigeon", "none" },
			{ "cookies", "promises", "war", "bankruptcy" },
			{ "The Office", "Mind Your Language", "Seinfeld", "friends" },
			{ "superstitious", "a little stitious", "hero", "Beyonce" }

	};

	char[] m_answers = { 'A', 'C', 'D', 'C', 'B' };
	char m_guess;
	char m_userAnswer;
	int m_currentIndex;
	int m_numOfCorrectAnswers;
	int m_numOfQuestions = m_questions.length;
	int m_result;
	int m_seconds = 10;

	JFrame m_frame = new JFrame();
	JTextField m_textfield = new JTextField();
	JTextArea m_textArea = new JTextArea();

	JButton m_buttonA = new JButton();
	JButton m_buttonB = new JButton();
	JButton m_buttonC = new JButton();
	JButton m_buttonD = new JButton();

	JLabel m_answerLabelA = new JLabel();
	JLabel m_answerLabelB = new JLabel();
	JLabel m_answerLabelC = new JLabel();
	JLabel m_answerLabelD = new JLabel();

	JLabel m_timer = new JLabel();
	JLabel m_secondsLeft = new JLabel();

	JTextField m_correctAnswersField = new JTextField();
	JTextField m_percentageField = new JTextField();

	public Quiz() {
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.setSize(700, 700);
		m_frame.getContentPane().setBackground(Color.DARK_GRAY);
		m_frame.setLayout(null);
		m_frame.setResizable(true);

		m_textfield.setBounds(10, 10, 650, 50);
		m_textfield.setBackground(Color.gray);
		m_textfield.setForeground(Color.black);
		m_textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
		m_textfield.setBorder(BorderFactory.createBevelBorder(1));
		m_textfield.setHorizontalAlignment(JTextField.CENTER);
		m_textfield.setEditable(false);
		m_textfield.setText("testiiiinnggg");

		m_textArea.setBounds(10, 70, 650, 50);
		m_textArea.setLineWrap(true);
		m_textArea.setWrapStyleWord(true);
		m_textArea.setBackground(Color.gray);
		m_textArea.setForeground(Color.black);
		m_textArea.setFont(new Font("Ink Free", Font.BOLD, 25));
		m_textArea.setBorder(BorderFactory.createBevelBorder(1));
		m_textArea.setEditable(false);
		m_textArea.setText("gggg");

		m_buttonA.setBounds(10, 130, 50, 50);
		m_buttonA.setFont(new Font("MV Boli", Font.BOLD, 15));
		m_buttonA.setText("A");
		m_buttonA.setFocusable(false);
		m_buttonA.addActionListener(this);

		m_buttonB.setBounds(10, 190, 50, 50);
		m_buttonB.setFont(new Font("MV Boli", Font.BOLD, 15));
		m_buttonB.setText("B");
		m_buttonB.setFocusable(false);
		m_buttonB.addActionListener(this);

		m_buttonC.setBounds(10, 250, 50, 50);
		m_buttonC.setFont(new Font("MV Boli", Font.BOLD, 15));
		m_buttonC.setText("C");
		m_buttonC.setFocusable(false);
		m_buttonC.addActionListener(this);

		m_buttonD.setBounds(10, 310, 50, 50);
		m_buttonD.setFont(new Font("MV Boli", Font.BOLD, 15));
		m_buttonD.setText("D");
		m_buttonD.setFocusable(false);
		m_buttonD.addActionListener(this);

		m_answerLabelA.setBounds(100, 100, 500, 100);
		m_answerLabelA.setBackground(Color.red);
		m_answerLabelA.setForeground(Color.black);
		m_answerLabelA.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_answerLabelA.setText("lalalalalalalalal");

		m_answerLabelB.setBounds(100, 160, 500, 100);
		m_answerLabelB.setBackground(Color.red);
		m_answerLabelB.setForeground(Color.black);
		m_answerLabelB.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_answerLabelB.setText("lalalalalalalalal");

		m_answerLabelC.setBounds(100, 220, 500, 100);
		m_answerLabelC.setBackground(Color.red);
		m_answerLabelC.setForeground(Color.black);
		m_answerLabelC.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_answerLabelC.setText("lalalalalalalalal");

		m_answerLabelD.setBounds(100, 280, 500, 100);
		m_answerLabelD.setBackground(Color.red);
		m_answerLabelD.setForeground(Color.black);
		m_answerLabelD.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_answerLabelD.setText("lalalalalalalalal");

		m_secondsLeft.setBounds(535, 510, 100, 100);
		m_secondsLeft.setBackground(Color.black);
		m_secondsLeft.setForeground(Color.gray);
		m_secondsLeft.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		m_secondsLeft.setOpaque(true);
		m_secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		m_secondsLeft.setText(String.valueOf(m_seconds));

		m_correctAnswersField.setBounds(225, 225, 200, 100);
		m_correctAnswersField.setBackground(Color.black);
		m_correctAnswersField.setForeground(Color.white);
		m_correctAnswersField.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_correctAnswersField.setBorder(BorderFactory.createBevelBorder(1));
		m_correctAnswersField.setHorizontalAlignment(JTextField.CENTER);
		m_correctAnswersField.setEditable(false);

		m_percentageField.setBounds(225, 328, 200, 100);
		m_percentageField.setBackground(Color.black);
		m_percentageField.setForeground(Color.white);
		m_percentageField.setFont(new Font("MV Boli", Font.BOLD, 25));
		m_percentageField.setBorder(BorderFactory.createBevelBorder(1));
		m_percentageField.setHorizontalAlignment(JTextField.CENTER);
		m_percentageField.setEditable(false);

		m_frame.add(m_textfield);
		m_frame.add(m_textArea);
		m_frame.add(m_buttonA);
		m_frame.add(m_buttonB);
		m_frame.add(m_buttonC);
		m_frame.add(m_buttonD);
		m_frame.add(m_answerLabelA);
		m_frame.add(m_answerLabelB);
		m_frame.add(m_answerLabelC);
		m_frame.add(m_answerLabelD);
		m_frame.add(m_secondsLeft);
//		m_frame.add(m_correctAnswersField);
//		m_frame.add(m_percentageField);

		m_frame.setVisible(true);

		nextQuestion();
	}

	public void nextQuestion() {

		if (m_currentIndex >= m_numOfQuestions)
			result();
		else {
			m_textfield.setText("Question " + (m_currentIndex+1));
			m_textArea.setText(m_questions[m_currentIndex]);
			m_answerLabelA.setText(m_options[m_currentIndex][0]);
			m_answerLabelB.setText(m_options[m_currentIndex][1]);
			m_answerLabelC.setText(m_options[m_currentIndex][2]);
			m_answerLabelD.setText(m_options[m_currentIndex][3]);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int n=m_numOfCorrectAnswers;
		m_buttonA.setEnabled(false);
		m_buttonB.setEnabled(false);
		m_buttonC.setEnabled(false);
		m_buttonD.setEnabled(false);
		
		//getSource() Returns the object on which 
		//the event occurred
		if(e.getSource()==m_buttonA) {
			m_userAnswer='A';
			if(m_userAnswer==m_answers[m_currentIndex]) m_numOfCorrectAnswers++;
		}
		if(e.getSource()==m_buttonB) {
			m_userAnswer='B';
			if(m_userAnswer==m_answers[m_currentIndex]) m_numOfCorrectAnswers++;
		}
		if(e.getSource()==m_buttonC) {
			m_userAnswer='C';
			if(m_userAnswer==m_answers[m_currentIndex]) m_numOfCorrectAnswers++;
		}
		if(e.getSource()==m_buttonD) {
			m_userAnswer='D';
			if(m_userAnswer==m_answers[m_currentIndex]) m_numOfCorrectAnswers++;
		}
		
		
		
		if(n==m_numOfCorrectAnswers) {
			if(e.getSource()==m_buttonA) {
				m_answerLabelA.setForeground(Color.red);
			}
			
			else if(e.getSource()==m_buttonB) {
				m_answerLabelB.setForeground(Color.red);
			}
			else if(e.getSource()==m_buttonC) {
				m_answerLabelC.setForeground(Color.red);
			}
			
			else if(e.getSource()==m_buttonD) {
				m_answerLabelD.setForeground(Color.red);
			}
		}
		else {
			if(e.getSource()==m_buttonA) {
				m_answerLabelA.setForeground(Color.green);
			}
			
			else if(e.getSource()==m_buttonB) {
				m_answerLabelB.setForeground(Color.green);
			}
			else if(e.getSource()==m_buttonC) {
				m_answerLabelC.setForeground(Color.green);
			}
			
			else if(e.getSource()==m_buttonD) {
				m_answerLabelD.setForeground(Color.green);
			}
		}
		
		Timer pause=new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				m_answerLabelA.setForeground(Color.black);
				m_answerLabelB.setForeground(Color.black);
				m_answerLabelC.setForeground(Color.black);
				m_answerLabelD.setForeground(Color.black);

				m_userAnswer=' ';
				
				m_buttonA.setEnabled(true);
				m_buttonB.setEnabled(true);
				m_buttonC.setEnabled(true);
				m_buttonD.setEnabled(true);
				
				m_currentIndex++;
				nextQuestion();
			}
			
			
		});
		pause.setRepeats(false);
		pause.start();
		
		
	}

	public void displayAnswer() {
		
		m_buttonA.setEnabled(false);
		m_buttonA.setEnabled(false);
		m_buttonA.setEnabled(false);
		m_buttonA.setEnabled(false);
		
	
		//JTextField m_percentageField = new JTextField();
		
		
		
	}

	public void result() {
		
		m_buttonA.setEnabled(false);
		m_buttonB.setEnabled(false);
		m_buttonC.setEnabled(false);
		m_buttonD.setEnabled(false);
	
		m_answerLabelA.setText("");
		m_answerLabelB.setText("");
		m_answerLabelC.setText("");
		m_answerLabelD.setText("");
		
		m_correctAnswersField.setText(m_numOfCorrectAnswers+"/"+m_numOfQuestions);
		
		m_percentageField.setText((double)m_numOfCorrectAnswers/m_numOfQuestions*100+"%");
				
		m_frame.add(m_correctAnswersField);
		m_frame.add(m_percentageField);

	
	}

}
