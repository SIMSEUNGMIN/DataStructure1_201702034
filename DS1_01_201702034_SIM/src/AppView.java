import java.util.Scanner;

public class AppView { // ��� ���.
	private Scanner aScanner = new Scanner(System.in); // ��ĳ�ʰ�ü �ʱ�ȭ.(���⼭�� ���, private)
	
	public void outputLine(String aString){ //�Է¹��� �Ű������� ȭ�鿡 ����ϴ� �Լ�.
		
		System.out.println(aString);
	}
	
	public int inputOrder (){ //�������� ������ �Է¹޴� �Լ�.
		System.out.print("\n�������� ������ �Է��Ͻÿ�.(������ �Է��ϸ� �����մϴ�.) : ");
		int aOrder = aScanner.nextInt();
		
		return aOrder;
	}
	
	public void outputTitleWithOrder(int anOrder){ //������ ������ �´� title ���.
		System.out.print("Magic Square Board : Order " + anOrder);
	} 
	
	public void output(String aString){
		System.out.printf(aString);
	}

	public void outputRowNumber(int aRowNumber){ // ������ �� �� ���.
		System.out.printf("[%3d]", aRowNumber);
	}
	
	public void outputCell(int aCellValue){ //cell���� ���ڸ� ��翡 �°� ���.
		System.out.printf(" %3d ", aCellValue);
	}
}
