
/*
 * ��ui�����ڲ�ѯ�˵��µ��û�������Ϣ�˵������ʾ
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;

public class ComUsersInfoFrame1 extends JInternalFrame {
	private static JComboBox queryjcombobox;
	private static JTextField queryjtextfield;
	private static JButton queryjbutton;
	private static JLabel  cardidjtextfield;
	private static JLabel  namejtextfield;
	private static JLabel  passwordjtextfield;
	private static JLabel  cardtypejtextfield;
	private static JLabel  overagejtextfield;
	private static JLabel  teljtextfield;
	private static JLabel caridjtextfield;
	private users user = LoginFrame.getUser(); 
	
	
	//���췽��
	public ComUsersInfoFrame1() {
		super("�û�������Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(114,97,482,221));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		
		JPanel Panel2 = new JPanel();			//�������2
		GridLayout gridLayout = new GridLayout(4,4);
		Panel2.setLayout(gridLayout);		//���ò���
		gridLayout.setVgap(5);					//�������֮�䴹ֱ����
		gridLayout.setHgap(5);					//�������֮��ƽ�о���
		Panel2.setBorder(new EmptyBorder(10,30,30,30));		//���ñ߿�
		mainPanel.add(Panel2,BorderLayout.CENTER);		//�����2���뵽������������
		
	    JLabel cardidjlabel = new JLabel();	//�������ű�ǩ
		cardidjlabel.setText("���ţ�");			//���ñ�ǩ�ı�
		Panel2.add(cardidjlabel);				//��ӵ����2
		cardidjtextfield = new JLabel();
		cardidjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardidjtextfield);
		cardidjtextfield.setText(String.valueOf(user.getCardid()));
		
		JLabel namejlabel = new JLabel();	//����������ǩ
		namejlabel.setText("������");			//���ñ�ǩ�ı�
		Panel2.add(namejlabel);				//��ӵ����2
		namejtextfield = new JLabel();
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(namejtextfield);
		namejtextfield.setText(user.getName());
		
		JLabel passwordjlabel = new JLabel();	//���������ǩ
		passwordjlabel.setText("���룺");			//���ñ�ǩ�ı�
		Panel2.add(passwordjlabel);				//��ӵ����2
		passwordjtextfield = new JLabel();
		passwordjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(passwordjtextfield);
		passwordjtextfield.setText(user.getPassword());
		
		JLabel cardtypejlabel = new JLabel();	//�����������ͱ�ǩ
		cardtypejlabel.setText("���ͣ�");			//���ñ�ǩ�ı�
		Panel2.add(cardtypejlabel);				//��ӵ����2
		cardtypejtextfield = new JLabel();//���������ı���
		cardtypejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardtypejtextfield);
		cardtypejtextfield.setText(user.getCardtype());
		
		JLabel overagejlabel = new JLabel();	//��������ǩ
		overagejlabel.setText("��");			//���ñ�ǩ�ı�
		Panel2.add(overagejlabel);				//��ӵ����2
		overagejtextfield = new JLabel();
		overagejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(overagejtextfield);
		overagejtextfield.setText(String.valueOf(user.getOverage()));
		
		JLabel teljlabel = new JLabel();	//�����绰��ǩ
		teljlabel.setText("�绰��");			//���ñ�ǩ�ı�
		Panel2.add(teljlabel);				//��ӵ����2
		teljtextfield = new JLabel();
		teljtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(teljtextfield);
		teljtextfield.setText(String.valueOf(user.getTel()));
		
		JLabel caridjlabel = new JLabel();	//�������ƺű�ǩ
		caridjlabel.setText("���ƺţ�");			//���ñ�ǩ�ı�
		Panel2.add(caridjlabel);				//��ӵ����2
		caridjtextfield = new JLabel();
		caridjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(caridjtextfield);
		caridjtextfield.setText(String.valueOf(user.getCarid()));
		setVisible(true);		// ��ʾ����ɼ�	
  }
}











