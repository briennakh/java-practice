package ch21_figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingNotes {
	public static JFrame frame;  // the main window of the app
	
	public static void main(String[] args) {
		createAndDisplayFrame();
		workWithButtons();
		demonstrateBorderLayout();
		//changeLayoutManager();
		
		
		// Make the frame visible
		// NOTE: Add all of the panels & components to frame before calling setVisible
		frame.setVisible(true);
	}
	
	// Figure 21-3, How to work with frames
	public static void createAndDisplayFrame() {
		frame = new JFrame("Site-Directed Mutagenesis Verifier");
		frame.setSize(600, 400);
		// Let the OS set the location
		frame.setLocationByPlatform(true);
		// Exit application when user selects close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set look and feel to use default platform look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
			System.err.println("Unsupported look and feel.");
		}
	}
	
	// Figure 21-4, How to work with buttons
	// NOTE: Usually the easiest way to build a GUI application is to use an invisible
	// container known as a panel to group components.
	public static void workWithButtons() {
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton button1 = new JButton("Click me!");
		JButton button2 = new JButton();
		JButton button3 = new JButton("I'm deactivated");
		
		// Disable and gray out
		button3.setEnabled(false);
		// Set text
		button2.setText("No, click me!");
		// Display tooltip on user hover
		button2.setToolTipText("Because I have more effects and am cooler.");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		// Handle click events with an anonymous inner class
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button 1 clicked!");
			}
		});
		
		// Handle click events with a lambda expression (in Java 8 or later)
		button2.addActionListener((ActionEvent e) -> {
			System.out.println("Button 2 clicked!");
		});
	}
	
	// Figure 21-6
	// NOTE: A layout manager determines how your components are placed in the container
	// and how they behave if the container is resized or if the font size changes.
	// By default, a JFrame widget uses the BorderLayout manager, and a JPanel widget
	// uses the FlowLayout manager. 
	public static void changeLayoutManager() {
		// NOTE: The constructor argument sets the horizontal alignment of the manager.
		// You can specify LEFT, RIGHT, or CENTER (default). 
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	// Figure 21-8
	// NOTE: A BorderLayout has 5 areas: NORTH, SOUTH, EAST, WEST, and CENTER (default).
	// Each area of a BorderLayout can only hold one component. If you need to add multiple
	// components to an area, add them to a panel and then add the panel to the area.
	// If you don't provide a component for an area in the BorderLayout, that area has a size
	// of zero and the components in other areas resize to fill any remaining space.
	public static void demonstrateBorderLayout() {
		frame.add(new JButton("North"), BorderLayout.NORTH);
		frame.add(new JButton("South"), BorderLayout.SOUTH);
		frame.add(new JButton("East"), BorderLayout.EAST);
		frame.add(new JButton("West"), BorderLayout.WEST);
		frame.add(new JButton("Center"), BorderLayout.CENTER);
	}
}
