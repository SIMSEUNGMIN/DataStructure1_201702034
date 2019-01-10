import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public int inputInt(){
		int number = this._scanner.nextInt();
		return number;
	}
	
	public String inputString(){
		String aString = this._scanner.next();
		return aString;
	}
	
	public void outputMessage(String aMessage){
		System.out.print(aMessage);
	}
	
	public void outputStar(String aStarName, int aX, int aY){
		System.out.print("X��ǥ : " + aX + " ");
		System.out.print("Y��ǥ : " + aY + " ");
		System.out.print("���� �̸� : " + aStarName + "\n");
	}
	
	public void outputStarExistence(String aStarName, int aX, int aY){
		if(aStarName != null){
			System.out.print(aStarName + "���� ���� �մϴ�.");
		}
		else if ((aX != 0) && (aY != 0)){
			System.out.print("(" + aX + ", " + aY + ") ��ġ�� ���� �����մϴ�.");
		}
	}
	
	public void outputNumberOfStars(int aStarCollectorSize){
		System.out.println(aStarCollectorSize + "���� ���� �����մϴ�.");
	}

}
