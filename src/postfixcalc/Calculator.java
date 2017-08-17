package postfixcalc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{

	public Calculator(){
		JFrame frame = new JFrame("Postfix Calculator");
		JPanel main_p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		JTextField num = new JTextField("Answer");
		num.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 6;
		main_p.add(num, c);
		
		JTextField stack_view = new JTextField("Stack Contents:");
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
		c.gridx += 1;
		main_p.add(ce, c);
		JButton pop = new JButton("POP");
		c.gridx += 1;
		main_p.add(pop, c);
		JButton back = new JButton("<--");
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
		c.gridx += 1;
		main_p.add(one, c);
		JButton two = new JButton("2");
		c.gridx += 1;
		main_p.add(two, c);
		JButton three = new JButton("3");
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
		c.gridx += 1;
		main_p.add(four, c);
		JButton five = new JButton("5");
		c.gridx += 1;
		main_p.add(five, c);
		JButton six = new JButton("6");
		c.gridx += 1;
		main_p.add(six, c);
		JButton minus = new JButton("-");
		c.gridx += 1;
		main_p.add(minus, c);
		
		JButton e = new JButton("e");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		main_p.add(e, c);
		JButton seven = new JButton("7");
		c.gridx += 1;
		main_p.add(seven, c);
		JButton eight = new JButton("8");
		c.gridx += 1;
		main_p.add(eight, c);
		JButton nine = new JButton("9");
		c.gridx += 1;
		main_p.add(nine, c);
		JButton mult = new JButton("*");
		c.gridx += 1;
		main_p.add(mult, c);
		
		JButton pi = new JButton("pi");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		main_p.add(pi, c);
		JButton dot = new JButton(".");
		c.gridx += 1;
		main_p.add(dot, c);
		JButton zero = new JButton("0");
		c.gridx += 1;
		main_p.add(zero, c);
		JButton push = new JButton("PUSH");
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
		
		Stack s = new Stack();
		s.push(100);
		s.push(7);
		s.push(.22);
		s.operation("lnx");
		//s.pop();
		
		
		System.out.println(s.toString());
		
		System.out.println(s.peek());
	}

}
