/*
 * ��ui��������ʾ��Ϣά���˵��µ��û�ע��˵���
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

public class ComZhuCeFrame extends JInternalFrame {
	private  JTextField cardidjtextfield;
	private  JTextField namejtextfield;
	private JTextField passwordjtextfield;
	private  JComboBox cardtypejcombobox;
	private  JTextField overagejtextfield;
	private JTextField teljtextfield;
	private JButton savejbutton;
	private JTextField caridjtextfield;

	//���췽��
	public ComZhuCeFrame() {
		super("�û�ע��");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(99,76,514,317));
		JPanel mainPanel = new JPanel();			//�����������
		GridLayout gridLayout = new GridLayout(8,4);//������񲼾ֹ�����
		gridLayout.setVgap(5);					//�������֮�䴹ֱ����
		gridLayout.setHgap(5);					//�������֮��ƽ�о���
		mainPanel.setLayout(gridLayout);		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(10, 30, 10, 30));

		mainPanel.add(new JLabel());	
		mainPanel.add(new JLabel());	
		mainPanel.add(new JLabel());	
		mainPanel.add(new JLabel());	

		JLabel cardidjlabel = new JLabel();	//�������ű�ǩ
		cardidjlabel.setText("���ţ�");			//���ñ�ǩ�ı�
		mainPanel.add(cardidjlabel);				//��ӵ��������
		cardidjtextfield = new JTextField();//���������ı���
		cardidjtextfield.setColumns(12);//�����ı��򳤶�
		mainPanel.add(cardidjtextfield);

		JLabel namejlabel = new JLabel();	//����������ǩ
		namejlabel.setText("������");			//���ñ�ǩ�ı�
		mainPanel.add(namejlabel);				//��ӵ��������
		namejtextfield = new JTextField();//���������ı���
		cardidjtextfield.setColumns(6);//�����ı��򳤶�
		mainPanel.add(namejtextfield);

		JLabel passwordjlabel = new JLabel();	//���������ǩ
		passwordjlabel.setText("���룺");			//���ñ�ǩ�ı�
		mainPanel.add(passwordjlabel);				//��ӵ��������
		passwordjtextfield = new JTextField();//���������ı���
		passwordjtextfield.setColumns(10);//�����ı��򳤶�
		mainPanel.add(passwordjtextfield);

		JLabel cardtypejlabel = new JLabel();	//�����������ͱ�ǩ
		cardtypejlabel.setText("���ͣ�");			//���ñ�ǩ�ı�
		mainPanel.add(cardtypejlabel);				//��ӵ��������
		cardtypejcombobox = new JComboBox();//������������������
		String[] array=new String[]{"��ͨ��","�Żݿ�"};//���������б�
		cardtypejcombobox.setModel(new DefaultComboBoxModel(array));//����������ģ��
		mainPanel.add(cardtypejcombobox);//��ӵ��������

		JLabel overagejlabel = new JLabel();	//��������ǩ
		overagejlabel.setText("��");			//���ñ�ǩ�ı�
		mainPanel.add(overagejlabel);				//��ӵ��������
		overagejtextfield = new JTextField();//��������ı���
		overagejtextfield.setColumns(4);//�����ı��򳤶�
		mainPanel.add(overagejtextfield);

		JLabel teljlabel = new JLabel();	//�����绰��ǩ
		teljlabel.setText("�绰��");			//���ñ�ǩ�ı�
		mainPanel.add(teljlabel);				//��ӵ��������
		teljtextfield = new JTextField();//�����绰�ı���
		teljtextfield.setColumns(11);//�����ı��򳤶�
		mainPanel.add(teljtextfield);


		JLabel caridjlabel = new JLabel();	//�������ƺű�ǩ
		caridjlabel.setText("���ƺţ�");			//���ñ�ǩ�ı�
		mainPanel.add(caridjlabel);				//��ӵ��������
		caridjtextfield = new JTextField();//�����绰�ı���
		caridjtextfield.setColumns(11);//�����ı��򳤶�
		mainPanel.add(caridjtextfield);

		mainPanel.add(new JLabel());//Ϊ����ʾ�����۶���ӵı�ǩ
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());

		savejbutton = new JButton();//�������水ť
		savejbutton.addActionListener(new zhuceActionListener());//ע�������
		savejbutton.setText("ע��");//���ð�ť�ı�
		mainPanel.add(savejbutton);//��ӵ��������

		JButton backjbutton = new JButton();//�������ذ�ť
		backjbutton.addActionListener(new CloseActionListener());//ע�������
		backjbutton.setText("����");//���ð�ť�ı�
		mainPanel.add(backjbutton);//��ӵ��������

		setVisible(true);											// ��ʾ����ɼ�

	}
	class CloseActionListener implements ActionListener {			// ��ӷ��ذ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class zhuceActionListener implements ActionListener {			// ��ӱ��水ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			int a1 = Integer.parseInt(cardidjtextfield.getText());
			String a2 = namejtextfield.getText();
			String a3 = passwordjtextfield.getText();
			String a4 = (String)cardtypejcombobox.getSelectedItem();
			int a5 = Integer.parseInt(overagejtextfield.getText());
			int a6 = Integer.parseInt(teljtextfield.getText());
			int a7 = Integer.parseInt(caridjtextfield.getText());
			int i=Dal.comzhuce(a1,a2,a3,a4,a5,a6,a7);
			if(i==1){
				JOptionPane.showMessageDialog(null, "ע��ɹ���");
			}
		}		
	}
}

