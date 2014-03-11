package JAKD;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class MainScreen extends JFrame implements ActionListener {

	private JFrame frame;
	private static final int FRAME_WIDTH = 390;
	private static final int FRAME_HEIGHT = 150;
	private JButton genReport, editUser, editProd, financialManag;
	private JLabel logo, spacer;
	private JSeparator separator;
	private JPanel panel;
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	private Color cl;
	
	
	public MainScreen()
	{
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("Admin Screen");
		frame.setSize(1148, 827);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cl = new Color(240, 240, 240);
		
		JPanel sideButtons = new JPanel();
		sideButtons.setBackground(cl);
		sideButtons.setLayout(new GridBagLayout());
		sideButtons.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.add(sideButtons, BorderLayout.WEST);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon("src/resources/logo.jpeg"));
		logo.setPreferredSize(new Dimension(295, 120));
		gc.gridx = 0; // col
		gc.gridy = 0; // row
		gc.gridwidth = 1; // set gridwidth
		gc.gridheight = 1; // set gridheight
		// amount of space to allocate vertically
		gc.weighty = 0.0; 
		// amount of space to allocate horizontally
		gc.weightx = 0.0;
		sideButtons.add(logo, gc); 
		
		spacer = new JLabel("");
		
		gc.gridx = 0; 
		gc.gridy = 1; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 10.0; 
		gc.weightx = 0.0;
		sideButtons.add(spacer, gc); 
		
		genReport = new JButton("Genarate Report");
		genReport.setIcon(new ImageIcon("src/resources/blueButton.png"));
		genReport.setFont(new Font("sansserif",Font.BOLD,22));
		genReport.setPreferredSize(new Dimension(280, 100));
		genReport.setHorizontalTextPosition(JButton.CENTER);
		genReport.setVerticalTextPosition(JButton.CENTER);
		gc.gridx = 0; 
		gc.gridy = 2; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(genReport, gc); 
		
		editUser = new JButton("Edit User");
		editUser.setIcon(new ImageIcon("src/resources/blueButton.png"));
		editUser.setFont(new Font("sansserif",Font.BOLD,22));
		editUser.setPreferredSize(new Dimension(280, 100));
		editUser.setHorizontalTextPosition(JButton.CENTER);
		editUser.setVerticalTextPosition(JButton.CENTER);
		gc.gridx = 0; 
		gc.gridy = 3; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(editUser, gc); 
		
		editProd = new JButton("Edit Product");
		editProd.setIcon(new ImageIcon("src/resources/blueButton.png"));
		editProd.setFont(new Font("sansserif",Font.BOLD,22));
		editProd.setPreferredSize(new Dimension(280, 100));
		editProd.setHorizontalTextPosition(JButton.CENTER);
		editProd.setVerticalTextPosition(JButton.CENTER);
		gc.gridx = 0; 
		gc.gridy = 4; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(editProd, gc); 
		
		financialManag = new JButton("Financial Managment");
		financialManag.setIcon(new ImageIcon("src/resources/blueButton.png"));
		financialManag.setFont(new Font("sansserif",Font.BOLD,22));
		financialManag.setPreferredSize(new Dimension(280, 100));
		financialManag.setHorizontalTextPosition(JButton.CENTER);
		financialManag.setVerticalTextPosition(JButton.CENTER);
		gc.gridx = 0; 
		gc.gridy = 5; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(financialManag, gc); 
		
		
		
		frame.setVisible(true);
	}
	
	

	
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	
	
	
	
}
