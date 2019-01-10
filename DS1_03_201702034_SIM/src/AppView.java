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
		System.out.println("크기 : " + aTestSize + "\t삽입하기 : " + aTestInsertTime + " 최대값찾기 : " + aTestFindMaxTime);
	}
}
