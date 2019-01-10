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
		System.out.print("\n �����Ϸ����ϴ� �޴��� �����ϼ���\n(add : 1, remove : 2, print : 3, search : 4, exit: 9) :  ");
		int number = _scanner.nextInt();
		
		return number;
	}
	
	public int inputCoinValue(){
		System.out.print("������ �׼��� �Է��ϼ��� : ");
		int coin = this._scanner.nextInt();
		
		return coin;
	}
	
	public int inputCapacityOfCoinBag(){
		System.out.print("���濡 �� �� ���� ������ �Է��Ͻÿ� : ");
		int capacity = _scanner.nextInt();
		return capacity;
	}
}
