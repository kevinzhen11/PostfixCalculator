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
		GridBagConstraints gbc = new GridBagConstraints();
		
		JTextField txt = new JTextField();
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 6;
		main_p.add(txt, gbc);
		
		
		JButton lnx = new JButton("ln(x)");
		JButton logx = new JButton("log(x)");
		JButton ce = new JButton("CE");
		JButton pop = new JButton("POP");
		JButton back = new JButton("<--");
		JButton squared = new JButton("x^2");
		JButton pow_y = new JButton("x^y");
		JButton sinx = new JButton("sin(x)");
		JButton cosx = new JButton("cos(x)");
		JButton tanx = new JButton("tan(x)");
		JButton root = new JButton("sqrt(x)");
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton plus = new JButton("+");
		JButton ex = new JButton("e^x");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton minus = new JButton("-");
		JButton e = new JButton("e");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton mult = new JButton("*");
		JButton pi = new JButton("pi");
		JButton dot = new JButton(".");
		JButton zero = new JButton("0");
		JButton push = new JButton("PUSH");
		JButton divide = new JButton("/");

		main_p.add(lnx); main_p.add(logx);
		main_p.add(ce); main_p.add(pop);
		main_p.add(back); main_p.add(squared);
		main_p.add(pow_y); main_p.add(sinx);
		main_p.add(cosx); main_p.add(tanx);
		main_p.add(root); main_p.add(one);
		main_p.add(two); main_p.add(three);
		main_p.add(plus); main_p.add(ex);
		main_p.add(four); main_p.add(five);
		main_p.add(six); main_p.add(minus);
		main_p.add(e); main_p.add(seven);
		main_p.add(eight); main_p.add(nine);
		main_p.add(mult); main_p.add(pi);
		main_p.add(dot); main_p.add(zero);
		main_p.add(push); main_p.add(divide);
		
		frame.getContentPane().add(main_p);
		frame.setLocationRelativeTo(null);
		frame.pack();
		//frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		
		Stack s = new Stack();
		s.push(100);
		s.push(70);
		s.push(80);
		s.operation('-');
		//s.pop();
		
		
		System.out.println(s.toString());
		
		System.out.println(s.peek());
	}

}
