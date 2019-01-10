import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public String inputString(){
		return this._scanner.next();
	}
	
	public void outputMessage(String aMessageString){
		System.out.print(aMessageString);
	}
	
	public char inputCharacter(){
		char input;
		System.out.print("- ���ڸ� �Է��Ͻÿ� :");
		input = this.inputString().charAt(0);
		return input;
	}
	
	public	void outputAddedElement(char anElement){
		System.out.println("���Ե� ���Ҵ� '" + anElement + "' �Դϴ�.");
	}
	
	public void outputStackElement(char anElement){
		System.out.print(anElement);
	}
	
	public void outputTopElement(char anElement){
		System.out.println("[Top] Top ���Ҵ� '" + anElement + "' �Դϴ�.");
	}
	
	public void outputStackSize(int aStackSize){
		System.out.println("[Size] ���ÿ��� ���� " + aStackSize + "���� ���Ұ� �ֽ��ϴ�.");
	}
	
	public void outputRemove(char anElement){
		System.out.println("������ ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputResult(int numberOfInputChars, int numberOfIgnoredChars, int numberOfAddedChars){
		System.out.println("\n---�Էµ� ���ڴ� ��� " + numberOfInputChars + "�Դϴ�.");
		System.out.println("---����ó���� ���ڴ� ��� " + (numberOfInputChars-numberOfIgnoredChars) + "�Դϴ�.");
		System.out.println("---���õ� ���ڴ� ��� " + numberOfIgnoredChars + "�Դϴ�.");
		System.out.println("---���Ե� ���ڴ� ��� " + numberOfAddedChars + "�Դϴ�.");
	}
}
