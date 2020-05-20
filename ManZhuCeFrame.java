/*
 * ��ui������ʵ��ϵͳ�����µĹ���Աע��˵���
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

public class ManZhuCeFrame extends JInternalFrame {
	private JTextField cardidjtextfield;
	private JTextField namejtextfield;
	private JTextField passwordjtextfield;
	private JButton savejbutton;

	//���췽��
	public ManZhuCeFrame() {
		super("����Աע��");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(178,44,365,376));

		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(30, 10, 30, 10));

		JPanel Panel1 = new JPanel();			
		Panel1.setLayout(new GridLayout(3,2));		
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		
		mainPanel.add(Panel1,BorderLayout.CENTER);		

		JLabel cardidjlabel = new JLabel();	
		cardidjlabel.setText("���ţ�");			
		Panel1.add(cardidjlabel);			
		cardidjtextfield = new JTextField();
		cardidjtextfield.setColumns(6);
		Panel1.add(cardidjtextfield);

		JLabel namejlabel = new JLabel();	
		namejlabel.setText("������");			
		Panel1.add(namejlabel);				
		namejtextfield = new JTextField();
		namejtextfield.setColumns(6);
		Panel1.add(namejtextfield);

		JLabel passwordjlabel = new JLabel();
		passwordjlabel.setText("���룺");
		Panel1.add(passwordjlabel);				
		passwordjtextfield = new JTextField();
		
		passwordjtextfield.setColumns(10);
		Panel1.add(passwordjtextfield);

		JPanel Panel2 = new JPanel();			
		Panel2.setLayout(new FlowLayout());		
		Panel2.setBorder(new EmptyBorder(30, 10, 50, 10));		
		mainPanel.add(Panel2,BorderLayout.SOUTH);		

		savejbutton = new JButton();//�������水ť
		savejbutton.addActionListener(new addmanActionListener());//ע�������
		savejbutton.setText("ע��");//���ð�ť�ı�
		Panel2.add(savejbutton);

		JButton backjbutton = new JButton();//�������ذ�ť
		backjbutton.addActionListener(new CloseActionListener());//ע�������
		backjbutton.setText("����");//���ð�ť�ı�
		Panel2.add(backjbutton);

		setVisible(true);											// ��ʾ����ɼ�

	}
	class CloseActionListener implements ActionListener {		// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class addmanActionListener implements ActionListener {		// ���ע�ᰴť���¼�������
		public void actionPerformed(final ActionEvent e) {
			int a1 = Integer.parseInt(cardidjtextfield.getText());
			String a2 = namejtextfield.getText();
			String a3 = passwordjtextfield.getText();
			int i=Dal.manzhuce(a1,a2,a3);
			if(i==1){
				JOptionPane.showMessageDialog(null, "ע��ɹ���");
			}
		}
	}
}