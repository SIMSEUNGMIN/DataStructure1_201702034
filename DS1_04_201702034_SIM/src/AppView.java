import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public void outputLine(String aString){
		System.out.println(aString);
	}
	
	public void output(String aString){
		System.out.print(aString);
	}
	
	public int inputMenuNumber(){
		System.out.print("\n 수행하려고 하는 메뉴를 선택하세요\n(add : 1, remove : 2, print : 3, search : 4, exit : 9) : ");
		int number = _scanner.nextInt();
		return number;
	}

	public int inputCoinValue(){
		System.out.print("코인의 액수를 입력하시오 : ");
		int coin = _scanner.nextInt();
		return coin;
	}
}
