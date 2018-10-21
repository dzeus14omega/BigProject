package sourceCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.darkprograms.speech.translator.GoogleTranslate;
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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



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
		setIconImage(Toolkit.getDefaultToolkit().getImage("dict2.png"));     //"C:\\MyDictionary\\dict2.png"
		setTitle("MyDictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon("tt1.jpg"));    //C:\\MyDictionary\\tt1.jpg"
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
		scrollPane.setBounds(22, 92, 262, 510);
		
		contentPane.add(scrollPane);
		
		
		JButton btnTra = new JButton("");
		btnTra.setToolTipText("Search");
		btnTra.setIcon(new ImageIcon("kinhlup3.png"));//C:\\MyDictionary\\kinhlup3.png
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
		
		
		JButton btnSpeak = new JButton("Speak");
		btnSpeak.setToolTipText("Press to speak");
		btnSpeak.setForeground(Color.BLACK);
		btnSpeak.setIcon(new ImageIcon("speechIcon.png"));//C:\\MyDictionary\\speechIcon.png
		
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
		btnSpeak.setBounds(653, 44, 129, 48);
		contentPane.add(btnSpeak);
		
		
		btnTra.setBounds(251, 60, 33, 32);
		contentPane.add(btnTra);
		
		
		
		JButton btnAdd = new JButton("Advanced Dictionary");
		btnAdd.setIcon(new ImageIcon("Icon-Advan.png"));//C:\\MyDictionary\\Icon-Advan.png
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdvanceWindow ui1=new AdvanceWindow(dataDict);
				ui1.setVisible(true);
			}
		});
		btnAdd.setBounds(22, 602, 262, 38);
		contentPane.add(btnAdd);
		////////////////////////////////////////
		
		
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images1.jpg"));//C:\\MyDictionary\\images1.jpg
		label_1.setBounds(0, 92, 311, 561);
		contentPane.add(label_1);
		
		JLabel lblGreeting = new JLabel("-----Welcome!-----");
		lblGreeting.setForeground(Color.WHITE);
		lblGreeting.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGreeting.setBounds(91, 0, 129, 25);
		contentPane.add(lblGreeting);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("a2.jpg"));//C:\\MyDictionary\\a2.jpg
		label.setBounds(0, 0, 311, 92);
		contentPane.add(label);
		
		JLabel lblVersion = new JLabel("version 1.3.1");
		lblVersion.setForeground(Color.LIGHT_GRAY);
		lblVersion.setBounds(311, 637, 83, 16);
		contentPane.add(lblVersion);
		
		JButton btnResized = new JButton("Di\u0323ch v\u0103n ba\u0309n >>");
		btnResized.setBounds(653, 0, 129, 44);
		contentPane.add(btnResized);
		
		lblNewLabel.setIcon(new ImageIcon("a1.jpg"));//C:\\MyDictionary\\a1.jpg
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(311, 0, 471, 92);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(794, 378, 376, 262);
		contentPane.add(scrollPane_2);
		
		JTextArea meanDocument = new JTextArea();
		meanDocument.setFont(new Font("Monospaced", Font.PLAIN, 15));
		meanDocument.setEditable(false);
		scrollPane_2.setViewportView(meanDocument);
		
		JComboBox selectLanguage = new JComboBox();
		selectLanguage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		selectLanguage.setModel(new DefaultComboBoxModel(new String[] {"vi", "en","fr","ja","bg","zh","id","it","ms","ru","th"}));
		selectLanguage.setBounds(1091, 340, 79, 25);
		contentPane.add(selectLanguage);
		
		JButton btnNewButton = new JButton("---- Di\u0323ch v\u0103n ba\u0309n --->");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(891, 340, 188, 25);
		contentPane.add(btnNewButton);
		
		JTextArea txtrTransdocument = new JTextArea();
		txtrTransdocument.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrTransdocument.setBounds(794, 94, 376, 233);
		contentPane.add(txtrTransdocument);
		
		JButton btnReturn = new JButton("<< Thu la\u0323i");
		btnResized.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnReturn.setVisible(true);
				setBounds(100, 100, 1200, 700);
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 800, 700);
				btnResized.setVisible(true);
			}
		});
		btnReturn.setBounds(1053, 0, 129, 45);
		contentPane.add(btnReturn);
		
		JComboBox tranFrom = new JComboBox();
		tranFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tranFrom.setModel(new DefaultComboBoxModel(new String[] {"en", "vi","fr","ja","bg","zh","id","it","ms","ru","th"}));
		tranFrom.setBounds(794, 340, 85, 25);
		contentPane.add(tranFrom);
		
		JLabel lblGoogleicon = new JLabel("");
		lblGoogleicon.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoogleicon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGoogleicon.setIcon(new ImageIcon("google_translateIcon.gif"));//C:\\MyDictionary\\google_translateIcon.gif
		lblGoogleicon.setBounds(1053, 44, 129, 48);
		contentPane.add(lblGoogleicon);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("a2.jpg"));//C:\\MyDictionary\\a2.jpg
		lblNewLabel_2.setBounds(769, 0, 413, 92);
		contentPane.add(lblNewLabel_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GG gg = new GG();
					String tmp = gg.getMean((String)tranFrom.getSelectedItem(), (String)selectLanguage.getSelectedItem(), txtrTransdocument.getText());
					meanDocument.setText(tmp);
					//meanDocument.setText(GoogleTranslate.translate((String)tranFrom.getSelectedItem(),(String)selectLanguage.getSelectedItem(),txtrTransdocument.getText() ));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, textField1, textArea1, btnTra, lblNewLabel, label, label_1}));
		
	}
}
