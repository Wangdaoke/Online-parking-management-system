/*
 * ��ui������ʵ�ֲ�ѯ�˵��µ�ǰ�ڳ���Ϣ����ʾ
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

public class NowInfoFrame extends JInternalFrame {
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

	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			park park = (park) list.get(i);
			s[i][0] = park.getCardid();
			s[i][1] = park.getStationid();
			s[i][2] = park.getStartpark();
		}
		return s;
	}

	//���췽��
	public NowInfoFrame() {
		super("��ǰ�ڳ���Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(142,106,449,279));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		String [] nowin = { "����",  "��λ", "��ʼʱ��"};
		Object[][] results=getselect(Dal.now());
		JTable table = new JTable(results,nowin);
		JScrollPane scroll = new JScrollPane(table);
		mainPanel.add(scroll,BorderLayout.CENTER);		//�����������뵽����
		setVisible(true);
	}
}

















