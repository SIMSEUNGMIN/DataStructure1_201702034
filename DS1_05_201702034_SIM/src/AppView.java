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
		System.out.print("X좌표 : " + aX + " ");
		System.out.print("Y좌표 : " + aY + " ");
		System.out.print("별의 이름 : " + aStarName + "\n");
	}
	
	public void outputStarExistence(String aStarName, int aX, int aY){
		if(aStarName != null){
			System.out.print(aStarName + "별이 존재 합니다.");
		}
		else if ((aX != 0) && (aY != 0)){
			System.out.print("(" + aX + ", " + aY + ") 위치에 별이 존재합니다.");
		}
	}
	
	public void outputNumberOfStars(int aStarCollectorSize){
		System.out.println(aStarCollectorSize + "개의 별이 존재합니다.");
	}

}
