import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public void outMessge(String aMessageString){
		System.out.println(aMessageString);
	}
	
	public void outputResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime){
		System.out.println("ũ�� : " + aTestSize + "\t�����ϱ� : " + aTestInsertTime + " �ִ밪ã�� : " + aTestFindMaxTime);
	}
}
