/*
 * ��ui����������
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import whsdu.se.Common.*;
import whsdu.se.UI.*;
import whsdu.se.DAO.*;

public class MdiFrame extends JFrame implements ActionListener {
	//�ؼ���MDIDesktopPane(����ʵ�ʼ̳��� JDesktopPane) ���������Ӵ���
	//��ʹ�Ӵ������Ҳ���������ڸ������ķ�Χ֮��
	private MDIDesktopPane desktop = new MDIDesktopPane();
	//�˵���
	private JMenuBar menuBar = new JMenuBar();
	//�˵�
	private JMenu mnuPark = new JMenu("��������");
	private JMenu mnuQuery = new JMenu("��Ϣ��ѯ");
	private JMenu mnuSever = new JMenu("��Ϣά��");
	private JMenu mnuManSes = new JMenu("ϵͳ����");
	//�˵���
	private JMenuItem munParkIn = new JMenuItem("�����볡");
	private JMenuItem mnuParkOut = new JMenuItem("��������");
	private JMenuItem munCharge = new JMenuItem("�Ʒѱ�׼");
	private JMenuItem mnuNowInfo = new JMenuItem("��ǰ�ڳ���Ϣ");
	private JMenuItem mnuHistory = new JMenuItem("�û���ʷ��Ϣ");
	private JMenuItem mnuComUsersInfo = new JMenuItem("�û�������Ϣ");
	private JMenuItem mnuInOut = new JMenuItem("���볡��Ϣ");
	private JMenuItem mnuComZhuCe = new JMenuItem("�û�ע��");
	private JMenuItem mnuComIdentity = new JMenuItem("�û��޸�");
	private JMenuItem mnuManZhuCe = new JMenuItem("����Աע��");
	private JMenuItem mnuManIdentity = new JMenuItem("�����޸�");
	private JMenuItem mnuManCharge = new JMenuItem("�Ʒѱ�׼����");
	private JMenuItem mnumancharge = new JMenuItem("�û���ֵ");
	private JMenuItem mnunowstation = new JMenuItem("��ǰ���ó�λ��Ϣ");
	private JMenuItem mnuabout = new JMenuItem("����");
	private JMenuItem mnuduichu = new JMenuItem("�˳�");
	private JScrollPane scrollPane = new JScrollPane();
	private users user = LoginFrame.getUser(); 
	
	//�����幹�췽��
	public MdiFrame() {
		desktop.setOpaque(false);  //JPanel ͸��ģʽ
		ImageIcon img = new ImageIcon("E:/java��ϰ/carsituation_man/res/main.jpg");  //����һ��ͼƬ·��
		JLabel background = new JLabel(img);  //������������ͼƬ��JLabel
		background.setIcon(img);
		this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		desktop.add(background);
		setMenu();
		setTitle("ͣ��������ϵͳ");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(280,119,800, 600);
		this.setVisible(true);
	}

	/**
	 * Ϊ������Ӳ˵���ע�������
	 * ֻд�˲��ֲ˵�
	 */
	private void setMenu(){
		//��������˵�
		mnuPark.add(munParkIn);
		munParkIn.addActionListener(this);
		mnuPark.add(mnuParkOut);
		mnuParkOut.addActionListener(this);
		//��Ϣ��ѯ�˵�
		mnuQuery.add(munCharge);
		munCharge.addActionListener(this);
		mnuQuery.add(mnuNowInfo);
		mnuNowInfo.addActionListener(this);
		mnuQuery.add(mnuHistory);
		mnuHistory.addActionListener(this);
		mnuQuery.add(mnuComUsersInfo);
		mnuComUsersInfo.addActionListener(this);
		mnuQuery.add(mnuInOut);
		mnuInOut.addActionListener(this);
		mnuQuery.add(mnunowstation);
		mnunowstation.addActionListener(this);
		//��Ϣά���˵�
		mnuSever.add(mnuComZhuCe);
		mnuComZhuCe.addActionListener(this);
		mnuSever.add(mnuComIdentity);
		mnuComIdentity.addActionListener(this);
		mnuSever.add(mnumancharge);
		mnumancharge.addActionListener(this);
		//ϵͳ����˵�
		mnuManSes.add(mnuManZhuCe);
		mnuManZhuCe.addActionListener(this);
		mnuManSes.add(mnuManIdentity);
		mnuManIdentity.addActionListener(this);
		mnuManSes.add(mnuManCharge);
		mnuManCharge.addActionListener(this);
		mnuManSes.add(mnuabout);
		mnuabout.addActionListener(this);
		mnuManSes.add(mnuduichu);
		mnuduichu.addActionListener(this);
		
		//��ӵ��˵���
		menuBar.add(mnuPark);
		menuBar.add(mnuQuery);
		menuBar.add(mnuSever);
		menuBar.add(mnuManSes);
		//�˵�����ӵ�������
		setJMenuBar(menuBar);
	}

	//�������ͨ�û�����������ʹ�õĲ˵����ֹʹ��
	public void disMenu() {
		//������������Ϣά����ϵͳ�������ͨ�û���������
		mnuPark.setEnabled(false);
		mnuSever.setEnabled(false);
		mnuManZhuCe.setEnabled(false);
		mnuManCharge.setEnabled(false);
	}

	//����˵��������Ӧ���Ӵ���
	public void actionPerformed(ActionEvent ae) {

		//�������ͬʱ�򿪶���Ӵ��ڣ������ø÷�����������Ӵ��ڶ�������
		JInternalFrame[] jiFrame = desktop.getAllFrames();  

		//���ֻ����ͬʱ��һ���������ø÷����Ƴ����д���
		//desktop.removeAll();  

		//��õ���Ĳ˵�����
		String mnuName = ae.getActionCommand();

		//���ݲ˵����ƾ�����ʾ���Ӵ��ڣ����԰�����ĸ�ʽΪÿһ���Ӳ˵�ָ����ʾ���Ӵ���
		if(mnuName.equals("�����볡")) {
			//MdiFrame.addIFrame(new ParkInFrame(),BorderLayout.CENTER);
			desktop.add(new ParkInFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("��������")) {
			desktop.add(new ParkOutFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("�Ʒѱ�׼")) {
			desktop.add(new ChargeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("��ǰ�ڳ���Ϣ")) {
			desktop.add(new NowInfoFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("�û�������Ϣ")) {
			if(user.getUserstype().equals("����Ա"))
			desktop.add(new ComUsersInfoFrame(),BorderLayout.CENTER);
			else
				desktop.add(new ComUsersInfoFrame1(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("�û���ʷ��Ϣ")) {
			desktop.add(new HistoryFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("���볡��Ϣ")) {
			desktop.add(new InOutFrame(),BorderLayout.CENTER);
		}
		//		
		else if(mnuName.equals("�û�ע��")) {
			desktop.add(new ComZhuCeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("�û��޸�")) {
			desktop.add(new ComIdentityFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("�û���ֵ")) {
			desktop.add(new chongzhiFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("����Աע��")) {
			desktop.add(new ManZhuCeFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("�����޸�")) {
			desktop.add(new GengGaiMiMa(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("��ǰ���ó�λ��Ϣ")) {
			desktop.add(new nowstationFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("����")) {
			desktop.add(new aboutFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("�˳�")) {
			System.exit(0);
		}
		else 
			desktop.add(new ManChargeFrame(),BorderLayout.CENTER);
	}		
	
}
