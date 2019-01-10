import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public int inputInt(){
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString(){
		return this._scanner.nextLine();
	}
	
	public Boolean inputDoesContinueToInputNextStudent(){
		char answer;
		answer = this.inputString().charAt(0);
		
		if((answer == 'Y') || (answer == 'y')){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int inputScore(){
		int score; 
		System.out.print("- ������ �Է��Ͻÿ� : ");
		score = this.inputInt();
		return score;
	}
	
	public void outputAverageScore(float anAverageScore){
		System.out.println("��� ������ " + anAverageScore + "�� �Դϴ�.");
	}
	
	public void outputNumberOfStudentsAboveAverage(int aNumber){
		System.out.println("��� �̻��� �л��� ��� " + aNumber + "�� �Դϴ�.");
	}
	
	public void outputMaxScore(int aMaxScore){
		System.out.println("�ְ����� " + aMaxScore + "�� �Դϴ�.");
	}
	
	public void outputMinScore(int aMinScore){
		System.out.println("�������� " + aMinScore + "�� �Դϴ�.");
	}
	
	public void outputGradeCountFor(char aGrade, int aCount){
		System.out.println(aGrade + "������ ��� " + aCount + "�� �Դϴ�.");
	}
	
	public void outputStudentInfo(int aScore){
		System.out.println("���� : " + aScore);
	}
	
	public void outputMessage(String aMessageString){
		System.out.print(aMessageString);
	} 
		
}
