package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AdminGUI extends JFrame implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cards;
	private JFrame frame;
	private static final int FRAME_WIDTH = 1148;
	private static final int FRAME_HEIGHT = 827;
	private JButton genReportBtn, editUserBtn,  editProdBtn, financialManagBtn, addUser, addProd, editUser, editProd, removeUser, removeProd;
	private JLabel logo, spacer, userDetails, prodDetails;
	private JTextField forenameBx, other, supplierID, currentStock, sellPrice, costPrice, prodTitle, type, prodId, surenamebx, line1Bx, line2Bx, Line3Bx, staffIDBx, pinBx, PPSBx;
	
	private JPanel  cardPanel, prodDetailsPanel, editProdBtnsPanel, editUserBtnsPanel, genReportPanel, editUserPanel, editProdPanel, financialPanel, userDetailsPanel;
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	private Color cl;
	private Font font = new Font("Verdana", Font.PLAIN, 20);
	
	public AdminGUI()
	{
		//Main frame declaration
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
		
		//Adding side buttons to side panel
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
        
        //Generate report panel
        genReportPanel = new JPanel();
        genReportPanel.setBackground(Color.WHITE);
        JButton test = new JButton("Test");
        test.addActionListener(this);
        genReportPanel.add(test);
        
        //Edit user  panel
        editUserPanel = new JPanel();
        editUserPanel.setLayout(new BorderLayout());
        userDetails = new JLabel("User Details");
        userDetails.setBorder(new EmptyBorder(10,500,0,0));
        userDetails.setFont(font);
        editUserPanel.add(userDetails, BorderLayout.NORTH);
        
        //user detail panel, inside the Edit user  panel
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
    		userDetailBx[i].setPreferredSize(new Dimension(350, 30));
        	userDetailsPanel.add(userDetailBx[i], gc);
        }
        
        editUserPanel.add(userDetailsPanel, BorderLayout.EAST);
        
        //button panel inside edit user panel
        editUserBtnsPanel = new JPanel();
        editUserBtnsPanel.setLayout(new GridBagLayout());
        editUserBtnsPanel.setPreferredSize(new Dimension(250, 50));
        
        
        //Adding buttons to the button panel inside the edit user panel
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
			gc.weighty = 0.0; 
			gc.weightx = 0.0;
			gc.insets = new Insets(10,0,0,0);
			editUserBtnsArray[i].setIcon(new ImageIcon("src/resources/blueButton.png"));
			editUserBtnsArray[i].setFont(new Font("sansserif",Font.BOLD,16));
			editUserBtnsArray[i].setPreferredSize(new Dimension(180, 50));
			editUserBtnsArray[i].setHorizontalTextPosition(JButton.CENTER);
			editUserBtnsArray[i].setVerticalTextPosition(JButton.CENTER);
			
			editUserBtnsArray[i].addActionListener(this);
			editUserBtnsPanel.add(editUserBtnsArray[i],gc);
        }
        editUserPanel.add(editUserBtnsPanel, BorderLayout.WEST);
        
        
        
        
        
        
        //edit product panel
        editProdPanel =  new JPanel();
        editProdPanel.setLayout(new BorderLayout());
        prodDetails = new JLabel("Electronic Product");
        prodDetails.setBorder(new EmptyBorder(10,500,0,0));
        prodDetails.setFont(font);
        editProdPanel.add(prodDetails, BorderLayout.NORTH);
        
        //product detail panel, inside the Edit product  panel
        prodDetailsPanel = new JPanel();
        prodDetailsPanel.setLayout(new GridBagLayout());
        prodDetailsPanel.setPreferredSize(new Dimension(550, 600));
        prodDetailsPanel.setBorder(border);
       
        //Adding labels and textbox to the product details panel
        JTextField [] prodDetailBx = {
        		prodTitle = new JTextField(),
        		type = new JTextField(),
        		prodId = new JTextField(),
        		costPrice = new JTextField(),
        		sellPrice = new JTextField(),
        		currentStock = new JTextField(),
        		supplierID = new JTextField(),
        		other = new JTextField(),
        }; 
        
        JLabel [] prodDetailLb = {
        new JLabel(" Product title"),
        new JLabel(" Type"),
        new JLabel(" Product ID"),
        new JLabel(" Cost price"),
        new JLabel(" Selling price"),
        new JLabel(" Current stock"),
        new JLabel(" Supplier ID"),
        new JLabel(" Other")
        };
        
        
        JRadioButton[] radioBtnsArray ={
        new JRadioButton("CD"),
		new JRadioButton("DVD"),
        new JRadioButton("Game")
        };
        
        
        for(int i = 0; i < prodDetailLb.length; i++)
        {
        	gc.gridx = 0; 
    		gc.gridy = i; 
    		gc.gridwidth = 1; 
    		gc.gridheight = 1; 
    		gc.weighty = 0.1; 
    		gc.weightx = 10.0;
    		gc.anchor = GridBagConstraints.WEST;
    		prodDetailLb[i].setFont(font);
    		prodDetailsPanel.add(prodDetailLb[i], gc);
        	
    		//Adds the radio buttons
    		if(i == 1)
    		{
    		int count =0;
    		while(count < 3)
    		{
    			
    			for(int j = 0; j < radioBtnsArray.length; j++)
    			{
    				gc.gridx = j + 1; 
    	    		gc.gridy = 1 ; 
    	    		gc.gridwidth = 1; 
    	    		gc.gridheight = 1; 
    	    		gc.weighty = 0.1; 
    	    		gc.weightx = 10.0;
    	    		radioBtnsArray[j].setFont(font);
    	    		prodDetailsPanel.add(radioBtnsArray[j], gc);
    	    		count++;
    			}
    		}
    		}
    		if(i == 1)
    		{
    			
    		}
    		else
    		{
        	gc.gridx = 1; 
    		gc.gridy = i  ; 
    		gc.gridwidth = 1; 
    		gc.gridheight = 1; 
    		gc.weighty = 0.2; 
    		gc.weightx = 10.0;
    		gc.gridwidth = 3;
    		prodDetailBx[i].setPreferredSize(new Dimension(300, 30));
    		prodDetailsPanel.add(prodDetailBx[i], gc);
    		}
        }
        
        editProdPanel.add(prodDetailsPanel, BorderLayout.EAST);
        
        //button panel inside edit product panel
        editProdBtnsPanel = new JPanel();
        editProdBtnsPanel.setLayout(new GridBagLayout());
        editProdBtnsPanel.setPreferredSize(new Dimension(250, 50));
        
        
        //Adding buttons to the button panel inside the edit product panel
        JButton [] editProdBtnsArray = {
				addProd = new JButton("Add Product"),
				removeProd = new JButton("Remove Product"),
				editProd= new JButton("Edit Product"),
				
		        };
        
		for(int i = 0; i < editUserBtnsArray.length; i++)
        {
			gc.gridx = 0; 
			gc.gridy = i; 
			gc.gridwidth = 1; 
			gc.gridheight = 1; 
			gc.weighty = 0.0; 
			gc.weightx = 0.0;
			gc.insets = new Insets(10,0,0,0);
			editProdBtnsArray[i].setIcon(new ImageIcon("src/resources/blueButton.png"));
			editProdBtnsArray[i].setFont(new Font("sansserif",Font.BOLD,16));
			editProdBtnsArray[i].setPreferredSize(new Dimension(180, 50));
			editProdBtnsArray[i].setHorizontalTextPosition(JButton.CENTER);
			editProdBtnsArray[i].setVerticalTextPosition(JButton.CENTER);
			
			editProdBtnsArray[i].addActionListener(this);
			editProdBtnsPanel.add(editProdBtnsArray[i], gc);
        }
		editProdPanel.add(editProdBtnsPanel, BorderLayout.WEST);
        
        //Financial panel
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
			String nameSearch = JOptionPane.showInputDialog(null,"Enter the name of person you wish to edit");

			/*if (findContact(nameSearch) != -1) {
				
			} 
			else {
				JOptionPane.showMessageDialog(null, "Contact not found");
			}*/
			
			
			
        }
		else if(e.getSource() == editProdBtn)
        {
			JPanel prodSelect = new JPanel();
			JRadioButton elcProdRB = new JRadioButton("Electronic product");
			JRadioButton digiProdRB = new JRadioButton("Digital Product");
			prodSelect.add(elcProdRB);
			prodSelect.add(digiProdRB);
			JOptionPane.showOptionDialog(null, prodSelect,  
			    "Select Product Type", JOptionPane.DEFAULT_OPTION,  
			    JOptionPane.QUESTION_MESSAGE, null, null, null); 
			if(elcProdRB.isSelected())
			{
			cards.show(cardPanel, "third"); 
			String prodSearch = JOptionPane.showInputDialog(null,"Enter the name of product you wish to edit");
			}
			else
			{
				cards.show(cardPanel, "second");
			}
        }
		else if(e.getSource() == financialManagBtn)
        {
			cards.show(cardPanel, "forth"); 
        }
	}


	
	public void itemStateChanged(ItemEvent it) {
		
		JPanel prodSelect = new JPanel();  
		prodSelect.add(new JRadioButton("Electronic product"));
		prodSelect.add(new JRadioButton("Digital Product"));
		JOptionPane.showOptionDialog(null, prodSelect,  
		    "Radio Test", JOptionPane.YES_NO_CANCEL_OPTION,  
		    JOptionPane.QUESTION_MESSAGE, null, null, null); 
		
	}
}
