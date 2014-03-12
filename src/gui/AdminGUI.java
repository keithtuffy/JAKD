package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AdminGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardLayout cards;
	
	private JFrame frame;
	private static final int FRAME_WIDTH = 1148;
	private static final int FRAME_HEIGHT = 827;
	private JButton genReportBtn, editUserBtn, editProdBtn, financialManagBtn, addUser, editUser, removeUser;
	private JLabel logo, spacer, userDetails;
	private JTextField forenameBx, surenamebx, line1Bx, line2Bx, Line3Bx, staffIDBx, pinBx, PPSBx;
	private JPanel  cardPanel, editUserBtnsPanel, genReportPanel, editUserPanel, editProdPanel, financialPanel, userDetailsPanel;
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	private Color cl;
	private Font font = new Font("Verdana", Font.PLAIN, 20);
	
	public AdminGUI()
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
		
		//side button array
		JButton [] sideButtonsArray = {
				genReportBtn = new JButton("Genarate Report"),
				editUserBtn = new JButton("Edit User"),
				editProdBtn = new JButton("Edit Product"),
				financialManagBtn = new JButton("Financial Managment")
		        };
		
		for(int i = 0; i < sideButtonsArray.length; i++)
        {
			gc.gridx = 0; 
			gc.gridy = i + 2; 
			gc.gridwidth = 1; 
			gc.gridheight = 1; 
			gc.weighty = 0.2; 
			gc.weightx = 0.0;
			sideButtonsArray[i].setIcon(new ImageIcon("src/resources/blueButton.png"));
			sideButtonsArray[i].setFont(new Font("sansserif",Font.BOLD,22));
			sideButtonsArray[i].setPreferredSize(new Dimension(280, 100));
			sideButtonsArray[i].setHorizontalTextPosition(JButton.CENTER);
			sideButtonsArray[i].setVerticalTextPosition(JButton.CENTER);
			sideButtonsArray[i].addActionListener(this);
			sideButtons.add(sideButtonsArray[i],gc);
        }
		

		
		//Different panels for action performed events on the side buttons
        cardPanel = new JPanel();
        
        genReportPanel = new JPanel();
        genReportPanel.setBackground(Color.WHITE);
        JButton test = new JButton("Test");
        test.addActionListener(this);
        genReportPanel.add(test);
        
        
        editUserPanel = new JPanel();
        editUserPanel.setLayout(new BorderLayout());
        userDetails = new JLabel("User Details");
        userDetails.setBorder(new EmptyBorder(10,500,0,0));
        userDetails.setFont(font);
        
        
        editUserPanel.add(userDetails, BorderLayout.NORTH);
        
        
        userDetailsPanel = new JPanel();
        userDetailsPanel.setLayout(new GridBagLayout());
        userDetailsPanel.setPreferredSize(new Dimension(550, 600));
        userDetailsPanel.setBorder(border);
       
        //Adding labels and textbox to the user details panel
        JTextField [] userDetailBx = {
        		forenameBx = new JTextField(),
        		surenamebx = new JTextField(),
        		line1Bx = new JTextField(),
        		line2Bx = new JTextField(),
        		Line3Bx = new JTextField(),
        		staffIDBx = new JTextField(),
        		pinBx = new JTextField(),
        		PPSBx = new JTextField(),
        }; 
        
        JLabel [] userDetailLb = {
        new JLabel(" Forename"),
        new JLabel(" Surename"),
        new JLabel(" Line 1"),
        new JLabel(" Line 2"),
        new JLabel(" Line 3"),
        new JLabel(" Staff ID"),
        new JLabel(" Pin"),
        new JLabel(" PPS")
        };
        for(int i = 0; i < userDetailLb.length; i++)
        {
        	gc.gridx = 0; 
    		gc.gridy = i; 
    		gc.gridwidth = 1; 
    		gc.gridheight = 1; 
    		gc.weighty = 0.1; 
    		gc.weightx = 10.0;
    		gc.anchor = GridBagConstraints.WEST;
    		userDetailLb[i].setFont(font);
        	userDetailsPanel.add(userDetailLb[i], gc);
        	
        	gc.gridx = 1; 
    		gc.gridy = i  ; 
    		gc.gridwidth = 1; 
    		gc.gridheight = 1; 
    		gc.weighty = 0.2; 
    		gc.weightx = 10.0;
//    		userDetailBx[i] = new JTextField();
    		userDetailBx[i].setPreferredSize(new Dimension(350, 30));
        	userDetailsPanel.add(userDetailBx[i], gc);
        }
        
        editUserPanel.add(userDetailsPanel, BorderLayout.EAST);
        
        editUserBtnsPanel = new JPanel();
        editUserBtnsPanel.setLayout(new GridBagLayout());
        editUserBtnsPanel.setPreferredSize(new Dimension(250, 100));
        
        
        JButton [] editUserBtnsArray = {
				addUser = new JButton("Add User"),
				removeUser = new JButton("Remove User"),
				editUser = new JButton("Edit User"),
				
		        };
		
		for(int i = 0; i < editUserBtnsArray.length; i++)
        {
			gc.gridx = 0; 
			gc.gridy = i; 
			gc.gridwidth = 1; 
			gc.gridheight = 1; 
			gc.weighty = 0.2; 
			gc.weightx = 0.0;
			editUserBtnsArray[i].setIcon(new ImageIcon("src/resources/blueButton.png"));
			editUserBtnsArray[i].setFont(new Font("sansserif",Font.BOLD,12));
			editUserBtnsArray[i].setPreferredSize(new Dimension(180, 50));
			editUserBtnsArray[i].setHorizontalTextPosition(JButton.CENTER);
			editUserBtnsArray[i].setVerticalTextPosition(JButton.CENTER);
			editUserBtnsArray[i].addActionListener(this);
			editUserBtnsPanel.add(editUserBtnsArray[i],gc);
        }
        editUserPanel.add(editUserBtnsPanel, BorderLayout.WEST);
        
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
			String nameSearch = JOptionPane.showInputDialog(null,"Enter the name of person you wish to edit");

			/*if (findContact(nameSearch) != -1) {
				
			} 
			else {
				JOptionPane.showMessageDialog(null, "Contact not found");
			}*/
			
			cards.show(cardPanel, "second"); 
			forenameBx.setText("cool");
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
