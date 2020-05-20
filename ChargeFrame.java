/*
 * ��ui��������ʾ��ѯ�˵���ļƷѱ�׼�˵���
 * 
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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

import whsdu.se.DAO.*;
import whsdu.se.DAL.*;

public class ChargeFrame extends JInternalFrame {


	private  JLabel cardidjlabel;
	private  JTextField cardidjtextfield;
	private  JLabel namejlabel;
	private  JTextField namejtextfield;
	private  JLabel passwordjlabel;
	private  JTextField passwordjtextfield;
	private  JLabel cardtypejlabel;
	private  JComboBox cardtypejcombobox;
	private  JLabel overagejlabel;
	private  JTextField overagejtextfield;
	private  JLabel teljlabel;
	private  JTextField teljtextfield;


	private  JLabel zhanwei;
	private static charger charger;

	private static JLabel bigjtextfield1;
	private static JLabel bigjtextfield2;
	private static JLabel smalljtextfield1;
	private static JLabel smalljtextfield2;


	//���췽��
	public  ChargeFrame() {
		super("�Ʒѱ�׼");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(206,76,331,300));

		JPanel Panel1 = new JPanel();//�����������
		Panel1.setLayout(new GridLayout(6,2));//���ò���
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));//���ñ߿�
		getContentPane().add(Panel1);

		Panel1.add(new JLabel("�Żݿ���"));//��ӵ��������
		Panel1.add(new JLabel());//��ӵ��������

		JLabel bigjlabel1 = new JLabel();//�������ͳ�λ��Ԫ/h����ǩ
		bigjlabel1.setText("���ͳ�λ��Ԫ/h����");//���ñ�ǩ�ı�
		Panel1.add(bigjlabel1);	//��ӵ��������
		bigjtextfield1 = new JLabel();//������ǩ
		Panel1.add(bigjtextfield1);//��ӵ��������

		JLabel smalljlabel1 = new JLabel();//����С�ͳ�λ��Ԫ/h����ǩ
		smalljlabel1.setText("С�ͳ�λ��Ԫ/h����");//���ñ�ǩ�ı�
		Panel1.add(smalljlabel1);//��ӵ��������
		smalljtextfield1 = new JLabel();//������ǩ
		Panel1.add(smalljtextfield1);//��ӵ��������

		Panel1.add(new JLabel("��ͨ����"));//��ӵ��������
		Panel1.add(new JLabel());//��ӵ��������

		JLabel bigjlabel2 = new JLabel();
		bigjlabel2.setText("���ͳ�λ��Ԫ/h����");			
		Panel1.add(bigjlabel2);				
		bigjtextfield2 = new JLabel();
		Panel1.add(bigjtextfield2);

		JLabel smalljlabel2 = new JLabel();
		smalljlabel2.setText("С�ͳ�λ��Ԫ/h����");	
		Panel1.add(smalljlabel2);			
		smalljtextfield2 = new JLabel();
		Panel1.add(smalljtextfield2);

		//��ѯ�Żݿ������ͳ�λ�ĵ��ۣ�����ʾ����Ӧ�ı�ǩ��
		charger = Dal.searchcharge("select * from charger where cardtype = '�Żݿ�'and stationtype = '���ͳ�λ'");
		String a1 = String.valueOf(charger.getCharge());
		bigjtextfield1.setText(a1);
		//��ѯ�Żݿ���С�ͳ�λ�ĵ��ۣ�����ʾ����Ӧ�ı�ǩ��
		charger = Dal.searchcharge("select * from charger where cardtype = '�Żݿ�'and stationtype = 'С�ͳ�λ'");	
		String a2 = String.valueOf(charger.getCharge());
		smalljtextfield1.setText(a2);
		//��ѯ��ͨ�������ͳ�λ�ĵ��ۣ�����ʾ����Ӧ�ı�ǩ��
		charger = Dal.searchcharge("select * from charger where cardtype = '��ͨ��'and stationtype = '���ͳ�λ'");	
		String a3 = String.valueOf(charger.getCharge());
		bigjtextfield2.setText(a3);
		//��ѯ��ͨ����С�ͳ�λ�ĵ��ۣ�����ʾ����Ӧ�ı�ǩ��
		charger = Dal.searchcharge("select * from charger where cardtype = '��ͨ��'and stationtype = 'С�ͳ�λ'");
		String a4 = String.valueOf(charger.getCharge());
		smalljtextfield2.setText(a4);

		setVisible(true);// ��ʾ����ɼ�	
	}		
}
