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
		System.out.print("- 점수를 입력하시오 : ");
		score = this.inputInt();
		return score;
	}
	
	public void outputAverageScore(float anAverageScore){
		System.out.println("평균 점수는 " + anAverageScore + "점 입니다.");
	}
	
	public void outputNumberOfStudentsAboveAverage(int aNumber){
		System.out.println("평균 이상인 학생은 모두 " + aNumber + "명 입니다.");
	}
	
	public void outputMaxScore(int aMaxScore){
		System.out.println("최고점은 " + aMaxScore + "점 입니다.");
	}
	
	public void outputMinScore(int aMinScore){
		System.out.println("최저점은 " + aMinScore + "점 입니다.");
	}
	
	public void outputGradeCountFor(char aGrade, int aCount){
		System.out.println(aGrade + "학점은 모두 " + aCount + "명 입니다.");
	}
	
	public void outputStudentInfo(int aScore){
		System.out.println("점수 : " + aScore);
	}
	
	public void outputMessage(String aMessageString){
		System.out.print(aMessageString);
	} 
		
}
