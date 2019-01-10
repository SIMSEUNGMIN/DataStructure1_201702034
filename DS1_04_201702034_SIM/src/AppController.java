
public class AppController {
	private static final int MENU_ADD = 1;
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_EXIT = 9;
	
	private AppView _appView;
	private LinkedBag<Coin> _coinBag;

	public AppController(){
		this._appView = new AppView();
	}
	
	private void addCoin(){ //주어진 coin을 linkedBag에 더하는 함수.
		int coinValue = this._appView.inputCoinValue();
		if(this._coinBag.add(new Coin(coinValue))){
			this._appView.outputLine("-주어진 값의 동전을 가방에 성공적으로 넣었습니다.");
		}
		else this._appView.outputLine("-주어진 값의 동전을 가방에 넣는데 실패하였습니다.");
	}
	
	private void removeCoin(){ //주어진 coin을 linkedBag에서 삭제하는 함수.
		//remove any 부분도 여기에 들어가야함. 음수일 때.
		int coinValue = this._appView.inputCoinValue();
			if(!this._coinBag.remove(new Coin(coinValue))){
				this._appView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.");
			}
			else this._appView.outputLine("- 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.");
	}
	
	private void searchForCoin(){ //주어진 coin이 Bag 안에 존재하는지 확인하는 함수.
		int coinValue = this._appView.inputCoinValue();
		if(this._coinBag.doesContain(new Coin(coinValue))){
			this._appView.outputLine("- 주어진 값을 갖는 동전이 가방 안에 존재합니다.");
		}
		else this._appView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.");
	}
	
	private void frequencyOfCoin(){ //주어진 coin이 Bag 안에 몇개 존재하는지 확인하는 함수.
		int coinValue = this._appView.inputCoinValue();
		int frequency = this._coinBag.frequencyOf(new Coin(coinValue));
		this._appView.outputLine("-주어진 값을 갖는 동전의 개수는 " + frequency + "개 입니다.");
	}
	
	private void undefineEndMenuNumber(int aMenuNumber){
		this._appView.outputLine("-선택된 메뉴 번호 " + aMenuNumber + "은(는) 잘못된 번호입니다.");
	}
	
	private int sumOfCoinValues(){
		int sum = 0;
		for(int i = 0; i < this._coinBag.size(); i++){
			sum += this._coinBag.elementAt(i).value();
		}
		return sum;
	}
	
	private int maxCoinValue(){
		int maxValue = 0;
		for(int i = 0; i < this._coinBag.size(); i++){
			if(maxValue < this._coinBag.elementAt(i).value()){
				maxValue = this._coinBag.elementAt(i).value();
			}
		}
		return maxValue;
	}
	
	private void showStatistics(){
		this._appView.outputLine("총 동전 개수 : " + this._coinBag.size());
		this._appView.outputLine("동전 중 가장 큰 값 : " + this.maxCoinValue());
		this._appView.outputLine("동전 값의 합 : " + this.sumOfCoinValues());
	}
	
	public void run(){
		
		this._appView.outputLine("<<< 동전 가방 프로그램을 시작합니다. >>>");
		
		this._coinBag = new LinkedBag<Coin>();
		int menuNumber = this._appView.inputMenuNumber();
		
		while(menuNumber != MENU_EXIT){ //9가 입력되면 종료.
			switch (menuNumber){
			case MENU_ADD:
				this.addCoin();
				break;
			case MENU_REMOVE:
				this.removeCoin();
				break;
			case MENU_SEARCH:
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:
				this.frequencyOfCoin();
				break;
			default:
				this.undefineEndMenuNumber(menuNumber);
			
			}
			menuNumber = this._appView.inputMenuNumber();
		}
		
		this._appView.outputLine("- 가방에 대한 수행을 종료합니다.\n");
		this.showStatistics();
		this._appView.outputLine("\n<<< 동전 가방 프로그램을 종료합니다. >>>");
		
		
	}
}
