package testSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class DemoScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private final JLabel lblNewLabel = new JLabel("");
	
	

	/**
	 * Create the frame.
	 */
	public DemoScreen(DictionaryCommandline dataDict) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\eclipse-workspace\\testSwing\\texture\\dict2.png"));
		setTitle("MyDictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Definition");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\testSwing\\tt1.jpg"));
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(323, 57, 174, 32);
		contentPane.add(lblNewLabel_1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField1.setBounds(22, 60, 228, 32);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setRows(8);
		textArea1.setFont(new Font("Arial", Font.PLAIN, 18));
		textArea1.setEditable(false);
		textArea1.setBounds(311, 92, 471, 548);
		contentPane.add(textArea1);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(22, 92, 262, 548);
		contentPane.add(textArea2);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\testSwing\\texture\\a1.jpg"));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(311, 0, 471, 92);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\testSwing\\texture\\images1.jpg"));
		label_1.setBounds(0, 92, 311, 561);
		contentPane.add(label_1);
		
		
		JButton btnTra = new JButton("");
		btnTra.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\testSwing\\texture\\kinhlup3.png"));
		btnTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String word = textField1.getText();
				textArea1.setText(dataDict.Lookup(word));
			}
		});
		btnTra.setBounds(251, 60, 33, 32);
		contentPane.add(btnTra);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\testSwing\\texture\\a2.jpg"));
		label.setBounds(0, 0, 311, 92);
		contentPane.add(label);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, textField1, textArea1, textArea2, btnTra, lblNewLabel, label, label_1}));
	}
}
