import java.util.Scanner;

public class AppView { // 출력 담당.
	private Scanner aScanner = new Scanner(System.in); // 스캐너객체 초기화.(여기서만 사용, private)
	
	public void outputLine(String aString){ //입력받은 매개변수를 화면에 출력하는 함수.
		
		System.out.println(aString);
	}
	
	public int inputOrder (){ //마방진의 차수를 입력받는 함수.
		System.out.print("\n마방진의 차수를 입력하시오.(음수를 입력하면 종료합니다.) : ");
		int aOrder = aScanner.nextInt();
		
		return aOrder;
	}
	
	public void outputTitleWithOrder(int anOrder){ //마방진 차수에 맞는 title 출력.
		System.out.print("Magic Square Board : Order " + anOrder);
	} 
	
	public void output(String aString){
		System.out.printf(aString);
	}

	public void outputRowNumber(int aRowNumber){ // 마방진 안 행 출력.
		System.out.printf("[%3d]", aRowNumber);
	}
	
	public void outputCell(int aCellValue){ //cell안의 숫자를 모양에 맞게 출력.
		System.out.printf(" %3d ", aCellValue);
	}
}
