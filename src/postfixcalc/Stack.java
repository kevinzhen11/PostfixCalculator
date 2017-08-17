package postfixcalc;

import java.util.ArrayList;

public class Stack {
	private ArrayList<Double> vals;
	private int top;
	
	public Stack(){
		this.vals = new ArrayList<Double>();
		this.top = -1;
	}
	
	public boolean isEmpty() { return this.top == -1; }
	
	public void push(double num){
		this.vals.add(num);
		this.top += 1;
	}
	
	public double pop(){
		double num = this.vals.get(this.top);
		this.vals.remove(num);
		this.top -= 1;
		return num;
	}
	
	public double peek(){
		return this.vals.get(this.top);
	}
	
	public double operation(String operand){
		double num1 = pop();
		double total = -1;
		// lnx, logx, x^2, x^y, sinx, cosx, tanx, root, e^x
		
		if(operand.equals("+") || operand.equals("-") || operand.equals("*") || operand.equals("/") || operand.equals("x^y")){
				double num2 = pop();
			switch(operand){
			case "+" : total = num1 + num2; break;
			case "-" : total = num1 - num2; break;
			case "*" : total = num1 * num2; break;
			case "/" : total = num1 / num2; break;
			case "x^y" : total = Math.pow(num1, num2); break;
			}
		}
		else{
			switch(operand){
			case "lnx" : total = (-Math.log(1-num1))/num1; break;
			case "logx" : total = Math.log(num1); break;
			case "x^2": total = num1 * num1;
			case "sinx" : total = Math.sin(num1); break;
			case "cosx" : total = Math.cos(num1); break;
			case "tanx" : total = Math.tan(num1); break;
			case "root" : total = Math.sqrt(num1); break;
			case "e^x" : total = Math.pow(Math.E, num1);
			}
		}
		
		push(total);
		return total;
	}
	
	public String toString(){
		if(this.top == -1) return "";
		String str = "";
		Double[] arr = this.vals.toArray(new Double[this.vals.size()]);
		for(int i = arr.length - 1; i >= 0; i--){
			if(i == arr.length -1) str += "---> " + arr[i] + "\n";
			else str += arr[i] + "\n";
		}
		return str;
	}
}
