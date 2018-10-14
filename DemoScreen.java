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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class DemoScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private final JLabel lblNewLabel = new JLabel("");
	
	

	/**
	 * Create the frame.
	 */
	public DemoScreen(DictionaryCommandline dataDict) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\MyDict\\dict2.png"));
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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\MyDict\\tt1.jpg"));
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
		textArea1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textArea1.setEditable(false);
		textArea1.setBounds(311, 92, 471, 548);
		contentPane.add(textArea1);
		lblNewLabel.setIcon(new ImageIcon("C:\\MyDict\\a1.jpg"));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(311, 0, 471, 92);
		contentPane.add(lblNewLabel);
		
		JList<String> list1 = new JList();
		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String tmp = (String)list1.getSelectedValue();
				textField1.setText(tmp);
			}
		});
		list1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list1.setBounds(22, 92, 262, 548);
		contentPane.add(list1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\MyDict\\images1.jpg"));
		label_1.setBounds(0, 92, 311, 561);
		contentPane.add(label_1);
		
		
		JButton btnTra = new JButton("");
		btnTra.setIcon(new ImageIcon("C:\\MyDict\\kinhlup3.png"));
		btnTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String word = textField1.getText();
//				textField1.setText(word);
				int[] indexWSearch = dataDict.dictionarySeacher(word);
				String[] arrWSearch = new String[indexWSearch.length];
				for(int i=0;i<arrWSearch.length;i++) {
					arrWSearch[i] = dataDict.getMyDicData().get(indexWSearch[i]).getWord_target();
				}
				list1.setModel(new AbstractListModel() {
					String[] values = arrWSearch;
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				textArea1.setText(dataDict.Lookup(word));
			}
		});
		
		
		
		btnTra.setBounds(251, 60, 33, 32);
		contentPane.add(btnTra);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\MyDict\\a2.jpg"));
		label.setBounds(0, 0, 311, 92);
		contentPane.add(label);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, textField1, textArea1, btnTra, lblNewLabel, label, label_1}));
	}
}
