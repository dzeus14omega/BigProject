package sourceCode;

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
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.Panel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import com.sun.speech.freetts.*;
import javax.swing.ListSelectionModel;
import javax.swing.JMenu;



public class DemoScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DictionaryCommandline dataDict;
	private JPanel contentPane;
	private JTextField textField1;
	private final JLabel lblNewLabel = new JLabel("");
//	private static final String VOICENAME="kevin16";
	
	
	
	/**
	 * Create the frame.
	 */
	
	public DemoScreen(DictionaryCommandline _dataDict) {
		this.dataDict = _dataDict;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\MyDictionary\\dict2.png"));
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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\MyDictionary\\tt1.jpg"));
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(311, 51, 174, 44);
		contentPane.add(lblNewLabel_1);
		
		textField1 = new JTextField();
		textField1.setToolTipText("Type your search word");
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField1.setBounds(22, 60, 228, 32);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(311, 92, 471, 548);
		contentPane.add(scrollPane_1);
		
		
		
		JTextArea textArea1 = new JTextArea();
		scrollPane_1.setViewportView(textArea1);
		textArea1.setRows(8);
		textArea1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textArea1.setEditable(false);
		
		
		
		
		//    /////////////////////////////////////////////////////////////////
		JList<String> list1 = new JList<String>();
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setVisibleRowCount(-1);
		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String tmp = (String)list1.getSelectedValue();
				textField1.setText(tmp);
			}
		});
		list1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list1.setBounds(22, 92, 262, 548);
		JScrollPane scrollPane = new JScrollPane(list1);
		scrollPane.setBounds(22, 92, 262, 497);
		
		contentPane.add(scrollPane);
		
		
		JButton btnTra = new JButton("");
		btnTra.setToolTipText("Search");
		btnTra.setIcon(new ImageIcon("C:\\MyDictionary\\kinhlup3.png"));
		btnTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//Kich chuot vao button Search de tra
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField1.getText().isEmpty()) {
					return;
				}
				String word = textField1.getText();
				textArea1.setText(dataDict.Lookup(word));
			}
		});
		
		
		
		///
		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String tmp = (String)list1.getSelectedValue();
				textField1.setText(tmp);
			}
		});
		///
		
		
		//Kich chuot vao danh sach va hien nghia
		////
		list1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tmp = list1.getSelectedValue();
				textArea1.setText(dataDict.Lookup(tmp));
			}
		});
		////
		
		
		//Nhap chu va in danh sach tu theo tung chu
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(textField1.getText().isEmpty()) {
					return;
				}
				String word = textField1.getText();
				int[] indexWSearch = dataDict.dictionarySeacher(word);
				String[] arrWSearch = new String[indexWSearch.length];
				for(int i=0;i<arrWSearch.length;i++) {
					arrWSearch[i] = dataDict.getMyDicData().get(indexWSearch[i]).getWord_target();
				}
				list1.setModel(new AbstractListModel<String>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					String[] values = arrWSearch;
					public int getSize() {
						return values.length;
					}
					public String getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		//Nhan enter de search tu textField1
		textField1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
            	btnTra.doClick();
            }});
		
		
		btnTra.setBounds(251, 60, 33, 32);
		contentPane.add(btnTra);
		
		
		JButton btnSpeak = new JButton("");
		btnSpeak.setToolTipText("Press to speak");
		btnSpeak.setForeground(Color.LIGHT_GRAY);
		btnSpeak.setIcon(new ImageIcon("C:\\MyDictionary\\speechIcon.png"));
		
		btnSpeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField1.getText().isEmpty()) {
					return;
				}
				
				try {
					TextToSpeech.speak(textField1.getText());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		JButton btnAdd = new JButton("Advanced Dictionary");
		btnAdd.setIcon(new ImageIcon("C:\\MyDictionary\\Icon-Advan.png"));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdvanceWindow ui1=new AdvanceWindow(dataDict);
				ui1.setVisible(true);
			}
		});
		btnAdd.setBounds(22, 602, 262, 38);
		contentPane.add(btnAdd);
		btnSpeak.setBounds(735, 48, 47, 44);
		contentPane.add(btnSpeak);
		////////////////////////////////////////
		
		
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\MyDictionary\\images1.jpg"));
		label_1.setBounds(0, 92, 311, 561);
		contentPane.add(label_1);
		
		
		
		
		lblNewLabel.setIcon(new ImageIcon("C:\\MyDictionary\\a1.jpg"));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(311, 0, 471, 92);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\MyDictionary\\a2.jpg"));
		label.setBounds(0, 0, 311, 92);
		contentPane.add(label);
	
	
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, textField1, textArea1, btnTra, lblNewLabel, label, label_1}));
		
	}
}
