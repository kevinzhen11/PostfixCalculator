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
	
	public double operation(char operand){
		double num1 = pop();
		double num2 = pop();
		double total = -1;
		switch(operand){
		case '+' : total = num1 + num2; break;
		case '-' : total = num1 - num2; break;
		case '*' : total = num1 * num2; break;
		case '/': total = num1 / num2; break;
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
