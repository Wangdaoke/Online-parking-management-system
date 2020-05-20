/*
 * 
 * ��ui��������ʾ��Ϣά���˵���ĳ�ֵ�˵���
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

public class chongzhiFrame extends JInternalFrame {

	private JTextField cardidjtextfield;
	private JLabel namejtextfield;
	private JTextField passwordjtextfield;
	private JButton savejbutton;
	private int a4;
	private int a1;
	private users user;
	private JButton yuejbutton;
	//���췽��
	public chongzhiFrame() {
		super("�û���ֵ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(178,44,365,376));

		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());	//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(30, 10, 30, 10));//�����������Ĵ�С��λ��

		JPanel Panel1 = new JPanel();			//�������1
		Panel1.setLayout(new GridLayout(3,2));	//���ò���
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));	//���ñ߿�
		mainPanel.add(Panel1,BorderLayout.CENTER);	//�����1���뵽���������

		JLabel cardidjlabel = new JLabel();	//�������ű�ǩ
		cardidjlabel.setText("���ţ�");			//���ñ�ǩ�ı�
		Panel1.add(cardidjlabel);				//��ӵ����1
		cardidjtextfield = new JTextField();//���������ı���
		cardidjtextfield.setColumns(6);//�����ı��򳤶�
		Panel1.add(cardidjtextfield);//��ӵ����1

		JLabel namejlabel = new JLabel();	//��������ǩ
		namejlabel.setText("��");			//���ñ�ǩ�ı�
		Panel1.add(namejlabel);				//��ӵ����1
		namejtextfield = new JLabel();//������Ӧ�ı�ǩ
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); //��ʾ��Ӧ��ǩ�ı߿�
		Panel1.add(namejtextfield);//��ӵ����1

		JLabel passwordjlabel = new JLabel();	//������ֵ��ǩ
		passwordjlabel.setText("��ֵ��");			//���ñ�ǩ�ı�
		Panel1.add(passwordjlabel);				//��ӵ����1
		passwordjtextfield = new JTextField();//���������ı���
		passwordjtextfield.setColumns(10);//�����ı��򳤶�
		Panel1.add(passwordjtextfield);//��ӵ����1

		JPanel Panel2 = new JPanel();			//�������2
		Panel2.setLayout(new FlowLayout());		//���ò���
		Panel2.setBorder(new EmptyBorder(30, 10, 50, 10));	//���ñ߿�
		mainPanel.add(Panel2,BorderLayout.SOUTH);		//�����2���뵽���������

		yuejbutton = new JButton();//������ť
		yuejbutton.addActionListener(new yueActionListener());//ע�������
		yuejbutton.setText("���");//���ð�ť�ı�
		Panel2.add(yuejbutton);//��ӵ����2

		savejbutton = new JButton();//�������水ť
		savejbutton.addActionListener(new addmanActionListener());//ע�������
		savejbutton.setText("��ֵ");//���ð�ť�ı�
		Panel2.add(savejbutton);//��ӵ����2

		JButton backjbutton = new JButton();//�������ذ�ť
		backjbutton.addActionListener(new CloseActionListener());//ע�������
		backjbutton.setText("����");//���ð�ť�ı�
		Panel2.add(backjbutton);//������2

		setVisible(true);											// ��ʾ����ɼ�
	}
	class CloseActionListener implements ActionListener {			// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class addmanActionListener implements ActionListener {			// ��ӳ�ֵ��ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			int a2 = Integer.parseInt(passwordjtextfield.getText());
			int a3 = a4 +a2;
			Dal.chongzhi("update users set overage ="+ a3+" where cardid = " + a1 );
			JOptionPane.showMessageDialog(null, "��ֵ�ɹ���");
		}
	}

	class yueActionListener implements ActionListener {			// �����ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			if(cardidjtextfield.getText().equals(""))
				namejtextfield.setText("");
			else {
				a1 = Integer.parseInt(cardidjtextfield.getText());
				user = Dal.searchcominfo("select * from users where cardid = "+a1 );
				a4 = user.getOverage();
				namejtextfield.setText(String.valueOf(a4));
			}
		}
	}
}