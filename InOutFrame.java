/*
 * ��ui��������ʾ��Ϣ��ѯ�˵��µĳ��볧��Ϣ�˵���
 * */

package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
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
import whsdu.se.DAO.*;
public class InOutFrame extends JInternalFrame {
	private  JLabel bigsumjtextfield;
	private  JLabel smallsumjtextfield;
	private  JLabel bigusejtextfield;
	private  JLabel smallusejtextfield;

	//���췽��
	public InOutFrame() {
		super("���볡��Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С

		JPanel mainPanel = new JPanel();			//�����������
		GridLayout gridLayout = new GridLayout(4,2);//������񲼾ֹ�����
		gridLayout.setVgap(20);					//�������֮�䴹ֱ����
		gridLayout.setHgap(10);					//�������֮��ƽ�о���
		mainPanel.setLayout(gridLayout);		//���ò���

		mainPanel.setBorder(new EmptyBorder(30, 10, 50, 10));		//���ñ߿�Ϊ0
		getContentPane().add(mainPanel);		//�����������뵽����
		setBounds(146,81,390,303);		

		JLabel bigsumjlabel = new JLabel();	//�������ű�ǩ
		bigsumjlabel.setText("���ͳ�λ��������");			//���ñ�ǩ�ı�
		mainPanel.add(bigsumjlabel);				//��ӵ��������
		bigsumjtextfield = new JLabel();//���������ı���
		//bigsumjtextfield.setColumns(12);//�����ı��򳤶�
		mainPanel.add(bigsumjtextfield);

		JLabel smallsumjlabel = new JLabel();	//�������ű�ǩ
		smallsumjlabel.setText("С�ͳ�λ��������");			//���ñ�ǩ�ı�
		mainPanel.add(smallsumjlabel);				//��ӵ��������
		smallsumjtextfield = new JLabel();//���������ı���
		//smallsumjtextfield.setColumns(12);//�����ı��򳤶�
		mainPanel.add( smallsumjtextfield);

		JLabel bigusejlabel = new JLabel();	//�������ű�ǩ
		bigusejlabel.setText("���ô��ͳ�λ������");			//���ñ�ǩ�ı�
		mainPanel.add(bigusejlabel);				//��ӵ��������
		bigusejtextfield = new JLabel();//���������ı���
		//bigusejtextfield.setColumns(12);//�����ı��򳤶�
		mainPanel.add(bigusejtextfield);

		JLabel smallusejlabel = new JLabel();	//�������ű�ǩ
		smallusejlabel.setText("����С�ͳ�λ������");			//���ñ�ǩ�ı�
		mainPanel.add(smallusejlabel);				//��ӵ��������
		smallusejtextfield = new JLabel();//���������ı���
		//smallusejtextfield.setColumns(12);//�����ı��򳤶�
		mainPanel.add(smallusejtextfield);

		setVisible(true);											// ��ʾ����ɼ�

		int b1 = Dal.count("select count(stationid) from sit_infor where stationtype = '���ͳ�λ'");

		String a1 = String.valueOf(b1);
		bigsumjtextfield.setText(a1);

		int b2 = Dal.count("select count(stationid) from sit_infor where stationtype = 'С�ͳ�λ'");
		String a2 = String.valueOf(b2);
		smallsumjtextfield.setText(a2);

		int b3 = Dal.count("select count(distinct stationid) from park where stationtype = '���ͳ�λ' and startpark  is not null and endpark is null ");

		int b4 = b1 - b3;
		String a3 = String.valueOf(b4);
		bigusejtextfield.setText(a3);

		int b5 = Dal.count("select count(distinct stationid) from park where stationtype = 'С�ͳ�λ'and startpark is not null and endpark is null ");
		int b6 = b2 - b5;
		String a4 = String.valueOf(b6);
		smallusejtextfield.setText(a4);
	}
}