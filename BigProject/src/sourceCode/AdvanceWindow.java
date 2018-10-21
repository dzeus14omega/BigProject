package sourceCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Container;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AdvanceWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	public AdvanceWindow(DictionaryCommandline dataDict){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\MyDictionary\\Icon-Advan.png"));
		setTitle("Dictionary Advance");
		doAddSomeControl(dataDict);
	}

	
	
	public void doAddSomeControl(DictionaryCommandline dataDict){
		JPanel pn=new JPanel();
		JButton btnMain=new JButton("Search");
		
		btnMain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMain.setBounds(342, 34, 106, 31);
		JTextField mainTxt=new JTextField(15);
		
		
		mainTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mainTxt.setBackground(new Color(255, 255, 255));
		mainTxt.setForeground(Color.BLACK);
		mainTxt.setBounds(31, 35, 302, 30);
		pn.setLayout(null);
		pn.add(btnMain);
		pn.add(mainTxt);
		Container con=getContentPane();
		con.add(pn);
		
		JComboBox listAction = new JComboBox();
		listAction.setBackground(new Color(153, 204, 204));
		listAction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listAction.setModel(new DefaultComboBoxModel(new String[] {"Th\u00EAm t\u01B0\u0300", "S\u01B0\u0309a t\u01B0\u0300", "Xo\u0301a t\u01B0\u0300"}));
		listAction.setSelectedIndex(0);
		listAction.setBounds(31, 13, 302, 22);
		pn.add(listAction);
		
		JEditorPane editMean = new JEditorPane();
		editMean.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		editMean.setBackground(new Color(255, 255, 255));
		editMean.setBounds(31, 128, 302, 202);
		pn.add(editMean);
		
		JLabel lblDeletemes = new JLabel("Nh\u00E2\u0301n save \u0111\u00EA\u0309 xa\u0301c nh\u00E2\u0323n");
		lblDeletemes.setVisible(false);
		lblDeletemes.setForeground(Color.WHITE);
		lblDeletemes.setBounds(319, 99, 150, 16);
		pn.add(lblDeletemes);
		
		JLabel lblScriptTutorial = new JLabel("Nh\u00E2\u0323p nghi\u0303a c\u00E2\u0300n th\u00EAm");
		lblScriptTutorial.setForeground(Color.WHITE);
		lblScriptTutorial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScriptTutorial.setBounds(31, 96, 251, 31);
		pn.add(lblScriptTutorial);
		
		JLabel lblCheckScript = new JLabel("T\u01B0\u0300 \u0111a\u0303 co\u0301 trong t\u01B0\u0300 \u0111i\u00EA\u0309n!");
		lblCheckScript.setForeground(new Color(255, 51, 0));
		lblCheckScript.setVisible(false);
		lblCheckScript.setBounds(156, 67, 177, 16);
		pn.add(lblCheckScript);
		
		JLabel lblRemindedScript = new JLabel("Nh\u00E2\u0323p nghi\u0303a r\u00F4\u0300i nh\u00E2\u0301n Save !");
		lblRemindedScript.setVisible(false);
		lblRemindedScript.setForeground(new Color(255, 51, 0));
		lblRemindedScript.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblRemindedScript.setBounds(31, 336, 191, 16);
		pn.add(lblRemindedScript);
		JLabel lblMesout = new JLabel("Th\u00EAm t\u01B0\u0300 tha\u0300nh c\u00F4ng!");
		lblMesout.setForeground(Color.WHITE);
		lblMesout.setVisible(false);
		lblMesout.setBounds(342, 160, 127, 31);
		pn.add(lblMesout);
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setVisible(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(342, 128, 106, 31);
		pn.add(btnSave);
		
		JLabel lblMesFix = new JLabel("S\u01B0\u0309a tha\u0300nh c\u00F4ng!");
		lblMesFix.setForeground(Color.WHITE);
		lblMesFix.setVisible(false);
		lblMesFix.setBounds(342, 160, 127, 31);
		pn.add(lblMesFix);
		
		JLabel lblcheckScript2 = new JLabel("T\u01B0\u0300 ch\u01B0a co\u0301 trong t\u01B0\u0300 \u0111i\u00EA\u0309n!");
		lblcheckScript2.setVisible(false);
		lblcheckScript2.setForeground(Color.RED);
		lblcheckScript2.setBounds(156, 67, 191, 16);
		pn.add(lblcheckScript2);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\MyDictionary\\nen_xanhAdvan.jpg"));
		lblBackground.setBounds(0, 88, 469, 277);
		pn.add(lblBackground);
		setSize(487, 412);
		setLocationRelativeTo(null);
		
		
		
		//do Action
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Default settup------------------------------//
				lblCheckScript.setVisible(false);//-----------|
				lblRemindedScript.setVisible(false);//--------|
				/*btnSave.setVisible(false);//---------------*/
				lblDeletemes.setVisible(false);//-------------|
				lblcheckScript2.setVisible(false);//----------|
				lblMesout.setVisible(false);//----------------|
				lblMesFix.setVisible(false);//----------------|
				//--------------------------------------------//
				if(mainTxt.getText()=="" || editMean.getText()=="") {
					return;
				}
				
				if(listAction.getSelectedIndex()==0) {
					String word = mainTxt.getText();
					String mean = editMean.getText();
					dataDict.dictionaryAdd(word, mean);
					lblMesout.setVisible(true);
					btnSave.setVisible(false);
					try {
						dataDict.dictionaryExportToFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				if(listAction.getSelectedIndex()==1) {
					dataDict.rePlaceVWord(mainTxt.getText(), editMean.getText());
					lblMesFix.setVisible(true);
					btnSave.setVisible(false);
					try {
						dataDict.dictionaryExportToFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(listAction.getSelectedIndex()==2) {
					dataDict.DeleteWord(mainTxt.getText());
					lblDeletemes.setVisible(false);
					btnSave.setVisible(false);
					try {
						dataDict.dictionaryExportToFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainTxt.getText()=="") {
					return;
				}
				
				String tmp = mainTxt.getText();
				
				//Default settup------------------------------//
				lblCheckScript.setVisible(false);//-----------|
				btnSave.setVisible(false);//------------------|
				lblcheckScript2.setVisible(false);//----------|
				lblDeletemes.setVisible(false);//-------------|
				lblRemindedScript.setVisible(false);//--------|
				lblMesFix.setVisible(false);//----------------|
				lblMesout.setVisible(false);//----------------|
				//--------------------------------------------//
				
				if(listAction.getSelectedIndex()==0) {
					int n = dataDict.dictionaryLookup(tmp);
					if(n!=-1) {
						lblCheckScript.setVisible(true);
						return;
					}
					lblCheckScript.setVisible(false);
					lblRemindedScript.setVisible(true);
					btnSave.setVisible(true);
					return;
				}
				if(listAction.getSelectedIndex()==1) {
					int n = dataDict.dictionaryLookup(tmp);
					if(n!=-1) {
						lblRemindedScript.setVisible(true);
						btnSave.setVisible(true);
						return;
					} else {
						lblcheckScript2.setVisible(true);
						return;
					}
				}
				if(listAction.getSelectedIndex()==2) {
					int n= dataDict.dictionaryLookup(tmp);
					if(n==-1) {
						lblcheckScript2.setVisible(true);
						return;
					} else {
						btnSave.setVisible(true);
						lblDeletemes.setVisible(true);
					}
				}
			}
		});
		mainTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//Default settup------------------------------//
				lblCheckScript.setVisible(false);//-----------|
				lblcheckScript2.setVisible(false);//----------|
				lblDeletemes.setVisible(false);//-------------|
				lblMesFix.setVisible(false);//----------------|
				lblRemindedScript.setVisible(false);//--------|
				lblMesout.setVisible(false);//----------------|
				//--------------------------------------------//
				
			}
		});
		editMean.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//Default settup------------------------------//
				lblCheckScript.setVisible(false);//-----------|
				lblDeletemes.setVisible(false);//-------------|
				lblcheckScript2.setVisible(false);//----------|
				lblMesFix.setVisible(false);//----------------|
				lblRemindedScript.setVisible(false);//--------|
				lblMesout.setVisible(false);//----------------|
				//--------------------------------------------//
			}
		});
		mainTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMain.doClick();
			}
		});
	}
}