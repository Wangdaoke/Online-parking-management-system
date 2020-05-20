/*
 * ��ui��������ʾ��¼����
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;
import whsdu.se.UI.*;

public class LoginFrame extends JFrame {
	private JPasswordField password;
	private JTextField username;
	private JButton login;
	private JButton reset;
	private static users user;

	//����д��Ŀ����Ϊ�˲������ݿ⣬��ʦд����Ȼ�ã����Ƕ��ڲ������ݿⲢ������
	public LoginFrame() {
		super();
		final BorderLayout borderLayout = new BorderLayout();	//�������ֹ�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//���ùرհ�ť�����¼�
		borderLayout.setVgap(10);								//�������֮�䴹ֱ����			
		getContentPane().setLayout(borderLayout);				//ʹ�ò��ֹ�����
		setTitle("ͣ��������ϵͳ");							//���ô������

		setSize(289, 167);//���ô����С
		setLocation(550, 350);

		final JPanel mainPanel = new JPanel();					//���������
		mainPanel.setLayout(new BorderLayout());				//���ñ߿򲼾�
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));		//���ñ߿�Ϊ0
		getContentPane().add(mainPanel);						//�ڴ����м��������

		final JPanel centerPanel = new JPanel();				//���һ���������	
		final GridLayout gridLayout = new GridLayout(3, 2);		//�������񲼾ֹ�����
		centerPanel.setLayout(gridLayout);						//ʹ�ò��ֹ�����
		mainPanel.add(centerPanel);//��ӵ������

		JLabel zhanwei1 = new JLabel();	//�������ű�ǩ
		centerPanel.add(zhanwei1);				//��ӵ��������
		JLabel zhanwei2 = new JLabel();	//�������ű�ǩ
		centerPanel.add(zhanwei2);				//��ӵ��������

		final JLabel userNamelabel = new JLabel();				//����һ����ǩ
		userNamelabel.setHorizontalAlignment(SwingConstants.CENTER);//���ö��뷽ʽ
		userNamelabel.setPreferredSize(new Dimension(0, 0));	//���������С
		userNamelabel.setMinimumSize(new Dimension(0, 0));		//���������С�Ĵ�С
		centerPanel.add(userNamelabel);							//��ӵ��������
		userNamelabel.setText("��  ��  ����");						//���ñ�ǩ�ı�
		username = new JTextField(20);							//�����ı���
		//username.setColumns(20);
		username.setPreferredSize(new Dimension(0, 0));			//���������С
		centerPanel.add(username);								//��ӵ��������

		final JLabel passwordLabel = new JLabel();					//����һ����ǩ
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);//���ö��뷽ʽ
		centerPanel.add(passwordLabel);								//��ӵ��������
		passwordLabel.setText("��      �룺");							//���ñ�ǩ�ı�
		password = new JPasswordField(20);							//���������	
		//password.setDocument(new MyDocument(6));					//�������볤��Ϊ6
		password.setEchoChar('*');									//���������Ļ����ַ�
		centerPanel.add(password);									//��ӵ��������

		final JPanel southPanel = new JPanel();//����һ���ײ����
		southPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.add(southPanel, BorderLayout.SOUTH);				//��ӵ��������
		login = new JButton();
		login.addActionListener(new LoginAction());				//��Ӽ�����
		login.setText("��¼");										//���ð�ť�ı�
		southPanel.add(login);										//�Ѱ�ť��ӵ��ײ����
		reset = new JButton();
		reset.addActionListener(new ResetAction());				//��Ӽ�����
		reset.setText("����");										//���ð�ť�ı�
		southPanel.add(reset);										//�Ѱ�ť��ӵ��ײ����
		setVisible(true);											//���ô����ɼ�
		setResizable(false);										//���ô��岻�ɸı��С
	}

	class ResetAction implements ActionListener {//ʵ�����ð�ť�ļ���
		public void actionPerformed(final ActionEvent e){

			password.setText("");//�������������Ϊ��
			username.setText("");//�����û��������Ϊ��

		}
	}

	class LoginAction implements ActionListener {//ʵ�ֵ�½��ť�ļ���
		public void actionPerformed(final ActionEvent e) {
			user = Dal.check(username.getText(),new String(password.getText()));
			if(user.getName()!=null) {
				if(user.getUserstype().equals("����Ա")) {
					MdiFrame frame1 = new MdiFrame();//����һ��������
					//frame1.setEnabled(true);//������ɼ�
					LoginFrame.this.setVisible(false);//���õ�¼����Ϊ����ʾ
				}
				else {//�ж��û����Ƿ�Ϊnull
					MdiFrame frame = new MdiFrame();//����һ��������
					frame.disMenu();
					//frame.setEnabled(true);//������ɼ�
					LoginFrame.this.setVisible(false);//���õ�¼����Ϊ����ʾ
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"��������ȷ���û��������룡");//������ʾ��
				username.setText("");//�����û��������Ϊ��
				password.setText("");//�������������Ϊ��
			}
		}
	}
	//�������������Ϊ�ڸ��Ŀ���ʱ��Ҫ��½ʱ���û���
	public static users getUser() {
		return user;
	}
	public static void setUser(users user) {
		LoginFrame.user = user;
	}
	
	public static void main(String[] args) {
		new LoginFrame();	
	}
}







