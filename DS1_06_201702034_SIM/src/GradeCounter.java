
public class GradeCounter { 
	
	private int numberOfA;
	private int numberOfB;
	private int numberOfC;
	private int numberOfD;
	private int numberOfF;
	
	public GradeCounter(){ // √ ±‚»≠.
		
		this.numberOfA = 0;
		this.numberOfB = 0;
		this.numberOfC = 0;
		this.numberOfD = 0;
		this.numberOfF = 0;
	}
	
	public void count(char aGrade){
		switch(aGrade){
		case 'A':
			this.numberOfA++;
			break;
		case 'B':
			this.numberOfB++;
			break;
		case 'C':
			this.numberOfC++;
			break;
		case 'D':
			this.numberOfD++;
			break;
		default:
			this.numberOfF++;
		}
	}
	
	public int numberOfA(){ //getter.
		return this.numberOfA;
	}
	
	public int numberOfB(){ //getter.
		return this.numberOfB;
	}
	
	public int numberOfC(){ //getter.
		return this.numberOfC;
	}
	
	public int numberOfD(){ //getter.
		return this.numberOfD;
	}
	
	public int numberOfF(){ //getter.
		return this.numberOfF;
	}

}
