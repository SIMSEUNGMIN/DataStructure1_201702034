import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public String inputString(){
		return this._scanner.next();
	}
	
	public String inputExpression(){
		System.out.print("> ������ �Է��Ͻÿ� : ");
		return this.inputString();
	}
	
	public void outputResult(double aValue){
		System.out.println("[������] " + aValue);
	}
	
	public void outputPostfix(String aPostfix){
		System.out.println("[Postfix] " + aPostfix);
	}
	
	public void outputMessage(String aMessage){
		System.out.print(aMessage);
	}
	
}
