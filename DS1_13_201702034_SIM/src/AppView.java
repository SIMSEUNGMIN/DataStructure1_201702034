import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	//�Է�
	public String inputString(){
		String aString = this._scanner.next();
		return aString;
		
	}
	
	public int inputInt(){
		System.out.print("- ���ڸ� �Է��Ͻÿ� : ");
		return this._scanner.nextInt();
	}
	
	public char inputCharacter(){
		char element;
		System.out.print("> ���ڸ� �Է��Ͻÿ� : ");
		element = this.inputString().charAt(0);
		return element;
	}
	
	public int inputNumber(){
		System.out.print("- ���ڸ� �Է��Ͻÿ� : ");
		return this._scanner.nextInt();
	}
	
	//���
	public void outputSize(int aSize){
		System.out.println("[Length]����Ʈ���� ���� " + aSize + "���� �ֽ��ϴ�.");
	}
	
	public void outputAdd(int anElement){
		System.out.println("[Insert]���Ե� ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputRemove(int anElement){
		System.out.println("[Remove]������ ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputElement(int anElement){
		System.out.print(anElement + " ");
	}
	
	public void outputMessage(String aMessage){
		System.out.print(aMessage);
	}
	
}
