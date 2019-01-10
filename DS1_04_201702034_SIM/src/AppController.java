
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
	
	private void addCoin(){ //�־��� coin�� linkedBag�� ���ϴ� �Լ�.
		int coinValue = this._appView.inputCoinValue();
		if(this._coinBag.add(new Coin(coinValue))){
			this._appView.outputLine("-�־��� ���� ������ ���濡 ���������� �־����ϴ�.");
		}
		else this._appView.outputLine("-�־��� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�.");
	}
	
	private void removeCoin(){ //�־��� coin�� linkedBag���� �����ϴ� �Լ�.
		//remove any �κе� ���⿡ ������. ������ ��.
		int coinValue = this._appView.inputCoinValue();
			if(!this._coinBag.remove(new Coin(coinValue))){
				this._appView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.");
			}
			else this._appView.outputLine("- �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�.");
	}
	
	private void searchForCoin(){ //�־��� coin�� Bag �ȿ� �����ϴ��� Ȯ���ϴ� �Լ�.
		int coinValue = this._appView.inputCoinValue();
		if(this._coinBag.doesContain(new Coin(coinValue))){
			this._appView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �����մϴ�.");
		}
		else this._appView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.");
	}
	
	private void frequencyOfCoin(){ //�־��� coin�� Bag �ȿ� � �����ϴ��� Ȯ���ϴ� �Լ�.
		int coinValue = this._appView.inputCoinValue();
		int frequency = this._coinBag.frequencyOf(new Coin(coinValue));
		this._appView.outputLine("-�־��� ���� ���� ������ ������ " + frequency + "�� �Դϴ�.");
	}
	
	private void undefineEndMenuNumber(int aMenuNumber){
		this._appView.outputLine("-���õ� �޴� ��ȣ " + aMenuNumber + "��(��) �߸��� ��ȣ�Դϴ�.");
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
		this._appView.outputLine("�� ���� ���� : " + this._coinBag.size());
		this._appView.outputLine("���� �� ���� ū �� : " + this.maxCoinValue());
		this._appView.outputLine("���� ���� �� : " + this.sumOfCoinValues());
	}
	
	public void run(){
		
		this._appView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>");
		
		this._coinBag = new LinkedBag<Coin>();
		int menuNumber = this._appView.inputMenuNumber();
		
		while(menuNumber != MENU_EXIT){ //9�� �ԷµǸ� ����.
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
		
		this._appView.outputLine("- ���濡 ���� ������ �����մϴ�.\n");
		this.showStatistics();
		this._appView.outputLine("\n<<< ���� ���� ���α׷��� �����մϴ�. >>>");
		
		
	}
}
