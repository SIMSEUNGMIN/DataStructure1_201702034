import java.util.Random;

public class PerformanceMeasurement {
	private static final int DEFAULT_NUMBER_OF_TESTS = 5; //테스트 횟수.
	private static final int DEFAULT_FIRST_TEST_SIZE = 10000; //첫 번째 실험 데이터 크기.
	private static final int DEFAULT_SIZE_INCREMENT = 10000; //실험 데이터 크기 증가량.
	
	private int _numberOfTests;
	private int _firstTestSize;
	private int _sizeIncrement;
	private int[] _data;
	private TestResult[] _testResults;
	
	public PerformanceMeasurement(){
		this._numberOfTests = DEFAULT_NUMBER_OF_TESTS;
		this._firstTestSize = DEFAULT_FIRST_TEST_SIZE;
		this._sizeIncrement = DEFAULT_SIZE_INCREMENT;
		
		this._data = new int[this.maxDataSize()];
		this._testResults = new TestResult[DEFAULT_NUMBER_OF_TESTS];
	}
	
	public PerformanceMeasurement(int givenNumberOfTests, int givenFirstTestSize, int givenSizeIncrement){
		this._numberOfTests = givenNumberOfTests;
		this._firstTestSize = givenFirstTestSize;
		this._sizeIncrement = givenSizeIncrement;
		
		this._data = new int[this.maxDataSize()];
		this._testResults = new TestResult[DEFAULT_NUMBER_OF_TESTS];
	}

	public int numberOfTests(){
		return this._numberOfTests;
	}
	
	public int maxDataSize(){
		return this._firstTestSize + this._sizeIncrement * (this._numberOfTests - 1);
	}
	
	public void generateData(){
		int i = 0;
		Random random = new Random();
		while(i < this.maxDataSize()){
			this._data[i] = random.nextInt(this.maxDataSize());
			i++;
		}
	}
	
	public TestResult[] testResults(){
		return this._testResults;
	}
	
	public void testUnsortedArrayBag(){
		// UnsortedArray로 구현한 list의 성능을 측정.
		UnsortedArrayBag<Coin> bag;
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		
		while(testCount < this._numberOfTests){
			bag = new UnsortedArrayBag<Coin>(testSize);
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize){
				Coin coin = new Coin(this._data[testDataCount]);
				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += (stop - start);
				
				start = System.nanoTime();
				this.maxCoinValue(bag);
				stop = System.nanoTime();
				timeForMax += (stop - start);
				testDataCount++;
				
			}
			this.testResults()[testCount] = new TestResult(testSize, timeForAdd, timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
	}
	
	private int maxCoinValue(UnsortedArrayBag<Coin> aCoinBag){
		int maxValue = 0;
		
		for(int i = 0; i < aCoinBag.size(); i++){
			if(maxValue < aCoinBag.elementAt(i).value()){
				maxValue = aCoinBag.elementAt(i).value();
			}
		}
		return maxValue;
	}
}
