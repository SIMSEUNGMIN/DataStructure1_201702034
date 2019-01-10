
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
		return (this._size == 0); //0이면 true 아니면 false.
	}
	
	public boolean isFull(){
		return(this._size == this._capacity); //같으면 true, 다르면 false.
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
		//객체에 저장된 학생들의 성적을 성적 순으로 정렬시킨다.
		int size = this._size;
		//정렬할 데이터는 this.elemnet[0]부터 this.element[size-1]까지.
		//퀵 정렬을 실행한다.
		if(size >= 2){ //개수가 2개 이상이면
			int minLoc = 0;
			for(int i = 1; i < size; i++){
				if(this._elements[i].score() < this._elements[minLoc].score()){
					minLoc = i;
				}
			}
			//최소값을 원소 구간의 맨끝으로 옮긴다.
			swap(minLoc, size -1);
			//정렬을 시작한다.
			quickSortRecursively(0, size - 2);
		}
	}
	
	public int minScore(){
		return minScoreRecursively(0, this._size-1); //학급의 최저점을 얻는다.
	}
	
	public int maxScore(){
		return maxScoreRecursively(0, this._size-1); //학급의 최고점을 얻는다.
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
		//학점 별 학생수를 센다.
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
		int pivot = left; // pivot 원소의 위치를 정한다.
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
		return toLeft; //pivot의 위치가 toLeft이다.
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
		//최고점을 찾아서 return 값으로 돌려준다.
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
		//최저점을 찾아서 return 값으로 돌려준다.
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
