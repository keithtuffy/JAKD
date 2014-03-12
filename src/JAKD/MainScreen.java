package JAKD;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class MainScreen extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardLayout cards;
	
	private JFrame frame;
	private static final int FRAME_WIDTH = 1148;
	private static final int FRAME_HEIGHT = 827;
	private JButton genReportBtn, editUserBtn, editProdBtn, financialManagBtn;
	private JLabel logo, spacer;
	private JPanel  cardPanel, genReportPanel, editUserPanel, editProdPanel, financialPanel;
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	private Color cl;
	
	
	public MainScreen()
	{
		frame = new JFrame();
		frame.setLayout(layout);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("Admin Screen");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cl = new Color(240, 240, 240);
		
		//Border declaration for use on east and west panels on main frame
		Border space = (Border) BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border line = (Border) BorderFactory.createLineBorder(Color.black);
		Border border = BorderFactory.createCompoundBorder(space, line);
		
		
		//Left side buttons panel
		JPanel sideButtons = new JPanel();
		sideButtons.setBackground(cl);
		sideButtons.setLayout(new GridBagLayout());
		sideButtons.setBorder(border);
		frame.add(sideButtons, BorderLayout.WEST);
		
		//Logo and buttons added to left side panel
		logo = new JLabel("");
		logo.setIcon(new ImageIcon("src/resources/logo.jpeg"));
		logo.setPreferredSize(new Dimension(295, 120));
		gc.gridx = 0; // col
		gc.gridy = 0; // row
		gc.gridwidth = 1; // set gridwidth
		gc.gridheight = 1; // set gridheight
		gc.weighty = 0.0;// amount of space to allocate vertically
		gc.weightx = 0.0;// amount of space to allocate horizontally
		sideButtons.add(logo, gc); 
		
		//space between logo and buttons, would rather use a "spacer" here, more research needed
		spacer = new JLabel("");
		
		gc.gridx = 0; 
		gc.gridy = 1; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 10.0; 
		gc.weightx = 0.0;
		sideButtons.add(spacer, gc); 
		
		genReportBtn = new JButton("Genarate Report");
		genReportBtn.setIcon(new ImageIcon("src/resources/blueButton.png"));
		genReportBtn.setFont(new Font("sansserif",Font.BOLD,22));
		genReportBtn.setPreferredSize(new Dimension(280, 100));
		genReportBtn.setHorizontalTextPosition(JButton.CENTER);
		genReportBtn.setVerticalTextPosition(JButton.CENTER);
		genReportBtn.addActionListener(this);
		gc.gridx = 0; 
		gc.gridy = 2; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(genReportBtn, gc); 
		
		editUserBtn = new JButton("Edit User");
		editUserBtn.setIcon(new ImageIcon("src/resources/blueButton.png"));
		editUserBtn.setFont(new Font("sansserif",Font.BOLD,22));
		editUserBtn.setPreferredSize(new Dimension(280, 100));
		editUserBtn.setHorizontalTextPosition(JButton.CENTER);
		editUserBtn.setVerticalTextPosition(JButton.CENTER);
		editUserBtn.addActionListener(this);
		gc.gridx = 0; 
		gc.gridy = 3; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(editUserBtn, gc); 
		
		editProdBtn = new JButton("Edit Product");
		editProdBtn.setIcon(new ImageIcon("src/resources/blueButton.png"));
		editProdBtn.setFont(new Font("sansserif",Font.BOLD,22));
		editProdBtn.setPreferredSize(new Dimension(280, 100));
		editProdBtn.setHorizontalTextPosition(JButton.CENTER);
		editProdBtn.setVerticalTextPosition(JButton.CENTER);
		editProdBtn.addActionListener(this);
		gc.gridx = 0; 
		gc.gridy = 4; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(editProdBtn, gc); 
		
		financialManagBtn = new JButton("Financial Managment");
		financialManagBtn.setIcon(new ImageIcon("src/resources/blueButton.png"));
		financialManagBtn.setFont(new Font("sansserif",Font.BOLD,22));
		financialManagBtn.setPreferredSize(new Dimension(280, 100));
		financialManagBtn.setHorizontalTextPosition(JButton.CENTER);
		financialManagBtn.setVerticalTextPosition(JButton.CENTER);
		financialManagBtn.addActionListener(this);
		gc.gridx = 0; 
		gc.gridy = 5; 
		gc.gridwidth = 1; 
		gc.gridheight = 1; 
		gc.weighty = 0.2; 
		gc.weightx = 0.0;
		sideButtons.add(financialManagBtn, gc); 
		
		//Different panels for action performed events on the side menu
        cardPanel = new JPanel();
        
        genReportPanel = new JPanel();
        genReportPanel.setBackground(Color.WHITE);
        JButton test = new JButton("Test");
        test.addActionListener(this);
        genReportPanel.add(test);
        
        
        editUserPanel = new JPanel();
        editUserPanel.setBackground(Color.BLACK);
        JButton test2 = new JButton("Test2");
        test2.addActionListener(this);
        editUserPanel.add(test2);
        
        
        editProdPanel =  new JPanel();
        editProdPanel.setBackground(Color.RED);
        JButton test3 = new JButton("Test3");
        test3.addActionListener(this);
        editProdPanel.add(test3);
        
        
        financialPanel =  new JPanel();
        financialPanel.setBackground(Color.BLUE);
        JButton test4 = new JButton("Test4");
        test4.addActionListener(this);
        financialPanel.add(test4);
        
        
		//Main panel for displaying all the above panels on action performed 
		cards = new CardLayout();
		
		cardPanel.setLayout(cards);
        cardPanel.add(genReportPanel, "first");
        cardPanel.add(editUserPanel, "second");
        cardPanel.add(editProdPanel , "third");
        cardPanel.add(financialPanel, "forth");
		cardPanel.setBorder(border);
		cardPanel.setPreferredSize(new Dimension(820, 10));
		frame.add(cardPanel, BorderLayout.EAST);
		
		
		
		frame.setVisible(true);
	}
	
	

	
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if(e.getSource() == genReportBtn)
        {
			cards.show(cardPanel, "first"); 
        }
		else if(e.getSource() == editUserBtn)
        {
			cards.show(cardPanel, "second"); 
        }
		else if(e.getSource() == editProdBtn)
        {
			cards.show(cardPanel, "third"); 
        }
		else if(e.getSource() == financialManagBtn)
        {
			cards.show(cardPanel, "forth"); 
        }
	}

	
	
	
	
}
