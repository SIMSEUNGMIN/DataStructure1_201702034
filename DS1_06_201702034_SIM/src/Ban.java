
public class Ban {
	private static final int DEFAULT_CAPACITY = 100;
	
	private int _capacity;
	private int _size;
	private Student[] _elements;
	
	public Ban(){
		this._capacity = DEFAULT_CAPACITY;
		this._size = 0;
		this._elements = new Student[DEFAULT_CAPACITY];
	}
	
	public Ban(int givenCapacity){
		this._capacity = givenCapacity;
		this._size = 0;
		this._elements = new Student[givenCapacity];
	}
	
	public int capacity(){
		return this._capacity;
	}
	
	public int size(){
		return this._size;
	}
	
	public boolean isEmpty(){
		return (this._size == 0); //0�̸� true �ƴϸ� false.
	}
	
	public boolean isFull(){
		return(this._size == this._capacity); //������ true, �ٸ��� false.
	}
	
	public boolean add(Student aStudent){
		if(this.isFull()){
			return false;
		}
		else{
			this._elements[this._size] = aStudent;
			this._size++;
			return true;
		}
	}
	
	public Student elementAt(int anOrder){
		if(this.isEmpty()){
			return null;
		}
		else{
			if((0 <= anOrder) && (anOrder <= this._size)){
				return this._elements[anOrder];
			}
		}
		return null;
	}
	
	public void sortStudentsByScore(){
		//��ü�� ����� �л����� ������ ���� ������ ���Ľ�Ų��.
		int size = this._size;
		//������ �����ʹ� this.elemnet[0]���� this.element[size-1]����.
		//�� ������ �����Ѵ�.
		if(size >= 2){ //������ 2�� �̻��̸�
			int minLoc = 0;
			for(int i = 1; i < size; i++){
				if(this._elements[i].score() < this._elements[minLoc].score()){
					minLoc = i;
				}
			}
			//�ּҰ��� ���� ������ �ǳ����� �ű��.
			swap(minLoc, size -1);
			//������ �����Ѵ�.
			quickSortRecursively(0, size - 2);
		}
	}
	
	public int minScore(){
		return minScoreRecursively(0, this._size-1); //�б��� �������� ��´�.
	}
	
	public int maxScore(){
		return maxScoreRecursively(0, this._size-1); //�б��� �ְ����� ��´�.
	}
	
	public float averageScore(){
		float sumOfScores = (float) sumOfScoresRecursively(0, this._size -1);
		float average = sumOfScores / (float) this._size;
		return average;
	}
	
	public int numberOfStudentsAboveAverage(){
		float average = averageScore();
		float score;
		int numberOfStudentAboveAverage = 0;
		for(int i = 0; i < this._size; i++){
			score = (float) this._elements[i].score();
			if(score >= average){
				numberOfStudentAboveAverage ++;
			}
		}
		return numberOfStudentAboveAverage;
	}
	
	public GradeCounter countGrades(){
		//���� �� �л����� ����.
		char currentGrade;
		GradeCounter gradeCounter = new GradeCounter();
		for(int i = 0; i < this._size; i ++){
			currentGrade = this.scoreToGrade(this._elements[i].score());
			gradeCounter.count(currentGrade);
		}
		return gradeCounter;
	}
	
	private void swap(int positionA, int positionB){
		Student temp = this._elements[positionA];
		this._elements[positionA] = this._elements[positionB];
		this._elements[positionB] = temp;
	}
	
	private int partition(int left, int right){
		int pivot = left; // pivot ������ ��ġ�� ���Ѵ�.
		int toRight = left;
		int toLeft = right + 1;
		do{
			do{
				toRight++;
			}while(this._elements[toRight].score() > this._elements[pivot].score());
			
			do{
				toLeft--;
			}while(this._elements[toLeft].score() < this._elements[pivot].score());
			
			if(toRight < toLeft){
				swap(toRight, toLeft);
			}
		}while(toRight < toLeft);
		swap(left, toLeft);
		return toLeft; //pivot�� ��ġ�� toLeft�̴�.
	}
	
	private void quickSortRecursively(int left, int right){
		if(left < right){
			int mid = partition(left, right);
			quickSortRecursively(left, mid-1);
			quickSortRecursively(mid + 1, right);
		}
	}
	
	public void  quickSort (int size) {
		if ( size > 1 ) {
			int maxLoc = 0;
			for ( int i = 1; i < size; i++ ) {
				if ( this._elements[i].score() > this._elements[i].score() ) {
					maxLoc = i;
					}
				}
			swap (maxLoc, size-1);
			quickSortRecursively (0, size-2);
			}
		}

	
	private float sumOfScoresRecursively(int left, int right){
		if(left > right){
			return 0;
		}
		else{
			return (this._elements[left].score() + this.sumOfScoresRecursively(left+1, right));
		}
	}
	
	private int maxScoreRecursively(int left, int right){
		//�ְ����� ã�Ƽ� return ������ �����ش�.
		if(left == right){
			return this._elements[left].score();
		}
		else{	
			int mid = (left + right) / 2;
			int maxOfLeft;
			int maxOfRight;
			
			maxOfLeft = maxScoreRecursively(left, mid);
			maxOfRight = maxScoreRecursively(mid + 1, right);
			
			if(maxOfLeft >= maxOfRight){
				return maxOfLeft;
			}
			else{
				return maxOfRight;
			}
			
		}
	}
	
	private int minScoreRecursively(int left, int right){
		//�������� ã�Ƽ� return ������ �����ش�.
		if(left == right){
			return this._elements[left].score();
		}
		else{
			int minScore = minScoreRecursively(left + 1, right);
			if(this._elements[left].score() <= minScore){
				return this._elements[left].score();
			}
			else{
				return minScore;
			}
		}
	}
	
	private char scoreToGrade(int aScore){
		if(aScore >= 90){
			return 'A';
		}
		else if(aScore >= 80){
			return 'B';
		}
		else if(aScore >= 70){
			return 'C';
		}
		else if(aScore >= 60){
			return 'D';
		}
		else return 'F';
	}
}
