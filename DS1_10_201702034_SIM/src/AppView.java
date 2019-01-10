import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public String inputString(){
		return this._scanner.next();
	}
	
	public char inputCharacter(){
		char input;
		System.out.print("- ���ڸ� �Է��Ͻÿ� : ");
		input = this.inputString().charAt(0);
		return input;
	}
	
	public void outputAdd(char anElement){
		System.out.println("[EnQueue] ���Ե� ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputElement(char anElement){
		System.out.print(anElement + " ");
	}
	
	public void outputFrontElements(char anElement){
		System.out.println("[Fornt] �� ���� ���Ҵ� " + anElement + " �Դϴ�.");
	}
	
	public void outputQueueSize(int aQueueSize){
		System.out.println("[Size] ť���� ���� " + aQueueSize + "���� ���Ұ� �ֽ��ϴ�.");
	}
	
	public void outputRemove(char anElement){
		System.out.println("[DeQueue] ������ ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputRemoveN(int numberOfCharsToBeRemoved){
		System.out.println("[RemoveN] " + numberOfCharsToBeRemoved + "���� ���Ҹ� �����Ϸ��� �մϴ�.");
	}
	
	public void outputResult(int inputChars, int ignoreChars, int addChars){
		System.out.println("\n--- �Էµ� ���ڴ� ��� " + inputChars + "�� �Դϴ�.");
		System.out.println("--- ����ó���� ���ڴ� ��� " + (inputChars - ignoreChars) + "�� �Դϴ�.");
		System.out.println("--- ���õ� ���ڴ� ��� " + ignoreChars + "�� �Դϴ�.");
		System.out.println("--- ���Ե� ���ڴ� ��� " + addChars + "�� �Դϴ�.");
	}
	
	public void outputMessage(String aString){
		System.out.print(aString);
	}
}
