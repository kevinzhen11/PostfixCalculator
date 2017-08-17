package postfixcalc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	String num_str = "";
	double num_double;
	Stack my_stack = new Stack();
	boolean is_pi = false, is_e = false;
	
	JTextArea screen;
	JTextArea stack_view;
	
	public Calculator(){
		JFrame frame = new JFrame("Postfix Calculator");
		JPanel main_p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		screen = new JTextArea("");
		screen.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 6;
		main_p.add(screen, c);
		
		stack_view = new JTextArea("Stack Contents:");
		stack_view.setEditable(false);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 6;
		main_p.add(stack_view, c);
		
		JButton lnx = new JButton("ln(x)");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		main_p.add(lnx, c);
		JButton logx = new JButton("log(x)");
		c.gridx += 1;
		main_p.add(logx, c);
		JButton ce = new JButton("CE");
		ce.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					is_pi = false; is_e = false;
				}
				screen.setText("");
				num_str = "";
			}			
		});
		c.gridx += 1;
		main_p.add(ce, c);
		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				my_stack.pop();
				System.out.println(my_stack.toString());
				num_str = "";
				screen.setText("");
				stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				
			}			
		});
		c.gridx += 1;
		main_p.add(pop, c);
		JButton back = new JButton("<--");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					is_pi = false; is_e = false;
				}
				screen.setText(screen.getText().substring(0, screen.getText().length() - 1));
				num_str = num_str.substring(0, num_str.length() - 1);
			}			
		});
		c.gridx += 1;
		main_p.add(back, c);
		
		JButton squared = new JButton("x^2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		main_p.add(squared, c);
		JButton pow_y = new JButton("x^y");
		c.gridx += 1;
		main_p.add(pow_y, c);
		JButton sinx = new JButton("sin(x)");
		c.gridx += 1;
		main_p.add(sinx, c);
		JButton cosx = new JButton("cos(x)");
		c.gridx += 1;
		main_p.add(cosx, c);
		JButton tanx = new JButton("tan(x)");
		c.gridx += 1;
		main_p.add(tanx, c);
		
		JButton root = new JButton("sqrt(x)");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		main_p.add(root, c);
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("1");
					num_str = "1";
					is_pi = false; is_e = false;
				}
				else{
				num_str += "1";
				screen.append("1");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(one, c);
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("2");
					num_str = "2";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "2";
					screen.append("2");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(two, c);
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("3");
					num_str = "3";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "3";
					screen.append("3");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(three, c);
		JButton plus = new JButton("+");
		c.gridx += 1;
		main_p.add(plus, c);
		
		
		JButton ex = new JButton("e^x");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		main_p.add(ex, c);
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("4");
					num_str = "4";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "4";
					screen.append("4");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(four, c);
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("5");
					num_str = "5";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "5";
					screen.append("5");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(five, c);
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("6");
					num_str = "6";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "6";
					screen.append("6");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(six, c);
		JButton minus = new JButton("-");
		c.gridx += 1;
		main_p.add(minus, c);
		
		JButton e = new JButton("e");
		c.fill = GridBagConstraints.HORIZONTAL;
		e.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				is_e = true;
				num_str = "2.718";
				screen.setText("2.718");
				
			}			
		});
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		main_p.add(e, c);
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("7");
					num_str = "7";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "7";
					screen.append("7");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(seven, c);
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("8");
					num_str = "8";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "8";
					screen.append("8");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(eight, c);
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("9");
					num_str = "9";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "9";
					screen.append("9");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(nine, c);
		JButton mult = new JButton("*");
		c.gridx += 1;
		main_p.add(mult, c);
		
		JButton pi = new JButton("pi");
		c.fill = GridBagConstraints.HORIZONTAL;
		pi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				is_pi = true;
				num_str = "3.1415";
				screen.setText("3.1415");
				
			}			
		});
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		main_p.add(pi, c);
		JButton dot = new JButton(".");
		dot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				num_str += ".";
				screen.append(".");
			}			
		});
		c.gridx += 1;
		main_p.add(dot, c);
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					screen.setText("0");
					num_str = "0";
					is_pi = false; is_e = false;
				}
				else{
					num_str += "0";
					screen.append("0");
				}
			}			
		});
		c.gridx += 1;
		main_p.add(zero, c);
		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				my_stack.push(Double.parseDouble(num_str));
				System.out.println(my_stack.toString());
				num_str = "";
				screen.setText("");
				stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				
			}			
		});
		c.gridx += 1;
		main_p.add(push, c);
		JButton divide = new JButton("/");
		c.gridx += 1;
		main_p.add(divide, c);
		
		frame.getContentPane().add(main_p);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
