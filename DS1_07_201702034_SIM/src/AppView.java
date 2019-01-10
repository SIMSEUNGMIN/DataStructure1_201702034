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
		System.out.print("- 문자를 입력하시오 :");
		input = this.inputString().charAt(0);
		return input;
	}
	
	public	void outputAddedElement(char anElement){
		System.out.println("삽입된 원소는 '" + anElement + "' 입니다.");
	}
	
	public void outputStackElement(char anElement){
		System.out.print(anElement);
	}
	
	public void outputTopElement(char anElement){
		System.out.println("[Top] Top 원소는 '" + anElement + "' 입니다.");
	}
	
	public void outputStackSize(int aStackSize){
		System.out.println("[Size] 스택에는 현재 " + aStackSize + "개의 원소가 있습니다.");
	}
	
	public void outputRemove(char anElement){
		System.out.println("삭제된 원소는 " + anElement + "입니다.");
	}
	
	public void outputResult(int numberOfInputChars, int numberOfIgnoredChars, int numberOfAddedChars){
		System.out.println("\n---입력된 문자는 모두 " + numberOfInputChars + "입니다.");
		System.out.println("---정상처리된 문자는 모두 " + (numberOfInputChars-numberOfIgnoredChars) + "입니다.");
		System.out.println("---무시된 문자는 모두 " + numberOfIgnoredChars + "입니다.");
		System.out.println("---삽입된 문자는 모두 " + numberOfAddedChars + "입니다.");
	}
}
