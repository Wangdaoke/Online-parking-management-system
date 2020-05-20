/*
 * ��ui��������ʾ��Ϣ��ѯ�˵��µ��û���ʷ��¼�˵������ʾ
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;																										
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import whsdu.se.DAL.Dal;
import whsdu.se.DAO.park;
import whsdu.se.DAO.users;
import whsdu.se.UI.ComUsersInfoFrame.queryActionListener;

public class HistoryFrame extends JInternalFrame {
	private  JLabel  queryjcombobox;
	private  JTextField queryjtextfield;
	private  JButton queryjbutton;
	private  JLabel  cardidjtextfield;
	private  JLabel  namejtextfield;
	private  JLabel  passwordjtextfield;
	private  JLabel  cardtypejtextfield;
	private  JLabel  overagejtextfield;
	private  JLabel  teljtextfield;
	private  users user;
	private  JLabel caridjtextfield;
	private  JPanel panel2;
	private  JPanel mainPanel;	

	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			park park = (park) list.get(i);
			s[i][0] = park.getCardid();
			s[i][1] = park.getStationid();
			s[i][2] = park.getStartpark();
			s[i][3] = park.getEndpark();
			s[i][4] = park.getSumpark();
			s[i][5] = park.getFee();
		}
		return s;
	}

	//���췽��
	public HistoryFrame() {
		super("�û���ʷ��Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(49,99,639,367));
		setBackground(java.awt.Color.gray);
		mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));

		JPanel Panel1 = new JPanel();			//�����������
		Panel1.setLayout(new FlowLayout());		//���ò���
		Panel1.setBorder(new EmptyBorder(10,10,10,10));		//���ñ߿�Ϊ0
		mainPanel.add(Panel1,BorderLayout.NORTH);		//�����������뵽����
		queryjcombobox = new JLabel("����");
		Panel1.add(queryjcombobox);//��ӵ��������			//��ӵ��������
		queryjtextfield = new JTextField();//���������ı���
		queryjtextfield.setColumns(10);//�����ı��򳤶�
		Panel1.add(queryjtextfield);
		queryjbutton = new JButton();//�������水ť
		queryjbutton.addActionListener(new queryActionListener());//ע�������
		queryjbutton.setText("��ѯ");//���ð�ť�ı�
		Panel1.add(queryjbutton);//��ӵ��������
		
		setVisible(true);
	}

	class queryActionListener implements ActionListener {//��Ӳ�ѯ�˵�������

		public void actionPerformed(ActionEvent arg0) {
			String [] history = { "����",  "��λ", "��ʼʱ��", "����ʱ��","��ʱ��(h)",  "����(Ԫ)"};
			if(queryjtextfield.getText().equals(""))
				queryjtextfield.setText("");
			else {
				Object[][] results=getselect(Dal.selectcardid(Integer.parseInt(queryjtextfield.getText())));
				JTable table = new JTable(results,history);
				JScrollPane scroll = new JScrollPane(table);
				mainPanel.add(scroll,BorderLayout.CENTER);		//�����������뵽����
			}
		}
	}
}















