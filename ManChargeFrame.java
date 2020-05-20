/*
 * ��ui������ʵ��ϵͳά���е��û���׼�޸���
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

public class ManChargeFrame extends JInternalFrame {
	private JTextField bigjtextfield1;
	private JTextField smalljtextfield1;
	private JTextField bigjtextfield2;
	private JTextField smalljtextfield2;

	//���췽��
	public  ManChargeFrame() {
		super("�Ʒѱ�׼����");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(167,30,383,450));

		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(30, 10, 30, 10));

		JPanel Panel1 = new JPanel();			//�������1
		Panel1.setLayout(new GridLayout(6,2));		//���ò���
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//���ñ߿�
		mainPanel.add(Panel1,BorderLayout.CENTER);	

		Panel1.add(new JLabel("�Żݿ���"));				//��ӵ����1
		Panel1.add(new JLabel());//������1

		JLabel bigjlabel1 = new JLabel();	
		bigjlabel1.setText("���ͳ�λ��Ԫ/h����");		
		Panel1.add(bigjlabel1);				
		bigjtextfield1 = new JTextField();
		bigjtextfield1.setColumns(6);
		Panel1.add(bigjtextfield1);

		JLabel smalljlabel1 = new JLabel();	
		smalljlabel1.setText("С�ͳ�λ��Ԫ/h����");		
		Panel1.add(smalljlabel1);			
		smalljtextfield1 = new JTextField();
		smalljtextfield1.setColumns(6);
		Panel1.add(smalljtextfield1);


		Panel1.add(new JLabel("��ͨ����"));				
		Panel1.add(new JLabel());


		JLabel bigjlabel2 = new JLabel();	
		bigjlabel2.setText("���ͳ�λ��Ԫ/h����");			
		Panel1.add(bigjlabel2);		
		bigjtextfield2 = new JTextField();
		bigjtextfield2.setColumns(6);
		Panel1.add(bigjtextfield2);

		JLabel smalljlabel2 = new JLabel();	
		smalljlabel2.setText("С�ͳ�λ��Ԫ/h����");		
		Panel1.add(smalljlabel2);				
		smalljtextfield2 = new JTextField();
		smalljtextfield2.setColumns(6);
		Panel1.add(smalljtextfield2);

		JPanel Panel2 = new JPanel();			
		Panel2.setLayout(new FlowLayout());		
		Panel2.setBorder(new EmptyBorder(30, 10, 50, 10));		
		mainPanel.add(Panel2,BorderLayout.SOUTH);		

		JButton savejbutton = new JButton();//�������水ť
		savejbutton.addActionListener(new gaiActionListener());//ע�������
		savejbutton.setText("�޸�");//���ð�ť�ı�
		Panel2.add(savejbutton);

		JButton backjbutton = new JButton();//�������ذ�ť
		backjbutton.addActionListener(new CloseActionListener());//ע�������
		backjbutton.setText("����");//���ð�ť�ı�
		Panel2.add(backjbutton);

		setVisible(true);											// ��ʾ����ɼ�

	}
	class CloseActionListener implements ActionListener {			// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class  gaiActionListener implements ActionListener {			// ����޸İ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {


			int a1 = Integer.parseInt( bigjtextfield1.getText());
			int a2 = Integer.parseInt(smalljtextfield1.getText());
			int a3 = Integer.parseInt(bigjtextfield2.getText());
			int a4 = Integer.parseInt(smalljtextfield2.getText());

			Dal.gaicharge("update charger set charge ="+ a1+" where cardtype = '�Żݿ�'and stationtype = '���ͳ�λ'");
			Dal.gaicharge("update charger set charge ="+ a2+" where cardtype = '�Żݿ�'and stationtype = 'С�ͳ�λ'");
			Dal.gaicharge("update charger set charge ="+ a3+" where cardtype = '��ͨ��'and stationtype = '���ͳ�λ'");
			Dal.gaicharge("update charger set charge ="+ a4+" where cardtype = '��ͨ��'and stationtype = 'С�ͳ�λ'");

			JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
		}

	}
}


