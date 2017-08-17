package postfixcalc;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	String num_str = "";
	Stack my_stack = new Stack();
	boolean is_pi = false, is_e = false;
	
	JTextArea screen;
	JTextArea stack_view;
	
	public Calculator(){
		JFrame frame = new JFrame("Postfix Calculator");
		JPanel main_p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		screen = new JTextArea("");
		screen.setFont(new Font("Arial", Font.PLAIN, 28));
		screen.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1; c.gridx = 0;
		c.gridy = 0; c.gridwidth = 6;
		main_p.add(screen, c);
		stack_view = new JTextArea("Stack Contents:");
		stack_view.setFont(new Font("Arial", Font.PLAIN, 28));
		stack_view.setEditable(false);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1; c.gridx = 0;
		c.gridy = 1; c.gridheight = 6;
		main_p.add(stack_view, c);
		JButton lnx = new JButton("ln(x)");
		lnx.setFont(new Font("Arial", Font.PLAIN, 28));
		c.fill = GridBagConstraints.HORIZONTAL;
		lnx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("lnx");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridwidth = 1; c.weightx = 1;
		c.gridx = 1; c.gridy = 1;
		c.gridheight = 1;
		main_p.add(lnx, c);
		JButton logx = new JButton("log(x)");
		logx.setFont(new Font("Arial", Font.PLAIN, 28));
		logx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("logx");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(logx, c);
		JButton ce = new JButton("CE");
		ce.setFont(new Font("Arial", Font.PLAIN, 28));
		ce.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				screen.setText("");
				num_str = "";
			}			
		});
		c.gridx += 1;
		main_p.add(ce, c);
		JButton pop = new JButton("POP");
		pop.setFont(new Font("Arial", Font.PLAIN, 28));
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
		back.setFont(new Font("Arial", Font.PLAIN, 28));
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				screen.setText(screen.getText().substring(0, screen.getText().length() - 1));
				num_str = num_str.substring(0, num_str.length() - 1);
			}			
		});
		c.gridx += 1;
		main_p.add(back, c);
		
		JButton squared = new JButton("x^2");
		squared.setFont(new Font("Arial", Font.PLAIN, 28));
		setFont(new Font("Arial", Font.PLAIN, 28));
		c.fill = GridBagConstraints.HORIZONTAL;
		squared.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("x^2");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridwidth = 1; c.weightx = 1;
		c.gridx = 1; c.gridy = 2;
		c.gridheight = 1;
		main_p.add(squared, c);
		JButton pow_y = new JButton("x^y");
		pow_y.setFont(new Font("Arial", Font.PLAIN, 28));
		pow_y.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 2){
					my_stack.operation("x^y");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(pow_y, c);
		JButton sinx = new JButton("sin(x)");
		sinx.setFont(new Font("Arial", Font.PLAIN, 28));
		sinx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("sinx");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(sinx, c);
		JButton cosx = new JButton("cos(x)");
		cosx.setFont(new Font("Arial", Font.PLAIN, 28));
		cosx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("cosx");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(cosx, c);
		JButton tanx = new JButton("tan(x)");
		tanx.setFont(new Font("Arial", Font.PLAIN, 28));
		tanx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("tanx");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(tanx, c);
		JButton root = new JButton("sqrt(x)");
		root.setFont(new Font("Arial", Font.PLAIN, 28));
		c.fill = GridBagConstraints.HORIZONTAL;
		root.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 1){
					my_stack.operation("root");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		main_p.add(root, c);
		JButton one = new JButton("1");
		one.setFont(new Font("Arial", Font.PLAIN, 28));
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
		two.setFont(new Font("Arial", Font.PLAIN, 28));
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
		three.setFont(new Font("Arial", Font.PLAIN, 28));
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
		plus.setFont(new Font("Arial", Font.PLAIN, 28));
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					is_pi = false; is_e = false;
				}
				if(my_stack.count() >= 2){
					my_stack.operation("+");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(plus, c);
		
		JButton ex = new JButton("e^x");
		ex.setFont(new Font("Arial", Font.PLAIN, 28));
		c.fill = GridBagConstraints.HORIZONTAL;
		ex.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					is_pi = false; is_e = false;
				}
				if(my_stack.count() >= 1){
					my_stack.operation("e^x");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		main_p.add(ex, c);
		JButton four = new JButton("4");
		four.setFont(new Font("Arial", Font.PLAIN, 28));
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
		five.setFont(new Font("Arial", Font.PLAIN, 28));
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
		six.setFont(new Font("Arial", Font.PLAIN, 28));
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
		minus.setFont(new Font("Arial", Font.PLAIN, 28));
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					is_pi = false; is_e = false;
				}
				if(my_stack.count() >= 2){
					my_stack.operation("-");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(minus, c);
		
		JButton e = new JButton("e");
		e.setFont(new Font("Arial", Font.PLAIN, 28));
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
		seven.setFont(new Font("Arial", Font.PLAIN, 28));
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
		eight.setFont(new Font("Arial", Font.PLAIN, 28));
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
		nine.setFont(new Font("Arial", Font.PLAIN, 28));
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
		mult.setFont(new Font("Arial", Font.PLAIN, 28));
		mult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){
					is_pi = false; is_e = false;
				}
				if(my_stack.count() >= 2){
					my_stack.operation("*");
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(mult, c);
		
		JButton pi = new JButton("pi");
		pi.setFont(new Font("Arial", Font.PLAIN, 28));
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
		dot.setFont(new Font("Arial", Font.PLAIN, 28));
		dot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				num_str += ".";
				screen.append(".");
			}			
		});
		c.gridx += 1;
		main_p.add(dot, c);
		JButton zero = new JButton("0");
		zero.setFont(new Font("Arial", Font.PLAIN, 28));
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
		push.setFont(new Font("Arial", Font.PLAIN, 28));
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
		divide.setFont(new Font("Arial", Font.PLAIN, 28));
		divide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(is_pi || is_e){ is_pi = false; is_e = false; }
				if(my_stack.count() >= 2){
					if(my_stack.peek() == 0){
						JOptionPane.showMessageDialog(frame, "Cannot divide by zero.");
						my_stack.pop();
					}
					else{
						my_stack.operation("/");
					}
					screen.setText("");
					num_str = "";
					stack_view.setText("Stack Contents\n-------\n" + my_stack.toString());
				}
			}			
		});
		c.gridx += 1;
		main_p.add(divide, c);
		frame.getContentPane().add(main_p);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
