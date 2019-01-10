
public class AppController { //��ü���� �帧.
	
	private AppView _appView; //AppView�� �����Ŵ.
	private MagicSquare _magicSquare;
	
	
	public AppController(){
		
		_appView = new AppView(); //�����ڿ��� Ŭ���� AppController�� ������ �� AppViewŬ������ ���� ����, AppView �ʱ�ȭ.
		_magicSquare = new MagicSquare(); // MagicSquareŬ������ ���� ����, MagicSquare �ʱ�ȭ.
	}
	
	public void run(){ //������ ��ü�� ����ϱ� ���� �Լ�. ��ü���� �帧�� �����Ѵ�.
		this._appView.outputLine("<<< ������ ����� �����ϰڽ��ϴ�. >>>"); //AppView�� ���ؼ� ���.
		
		int order = this._appView.inputOrder(); //AppView�� ���ؼ� ������ �Է¹޾� order�� ����.
		
		while(order >= 0){ //������ Ÿ�缺 �Ǵ�. ������ ���α׷� ����.
			OrderValidity currentOrderValidity = this._magicSquare.checkOrderValidity(order); //���� ������ ���¸� �˷���.
			
			if(currentOrderValidity == OrderValidity.Vaild){ //���� ������ Ÿ���ϸ� ������ ����.
				this._appView.outputTitleWithOrder(order); //title ����ϴ� �Լ� ȣ��.
				Board solvedBoard = this._magicSquare.solve(order); //MagicSquare��ü���� �������� Ǯ���ؼ� ������ ���.
				this.showBoard(solvedBoard); //�������� ȭ�鿡 ���.
			}
			else { 
				this.showOrderValidityErrorMessage(currentOrderValidity); //Ÿ������ ���� ��� ���������� ���� ������ ���.
			}
			
			order = this._appView.inputOrder(); // �ٽ� ������ �Է� ����. (�ݺ�)
			
		}
		
		this._appView.outputLine("\n<<< ������ Ǯ�̸� �����մϴ�. >>>");

		
	}
	
	
	private void showOrderValidityErrorMessage (OrderValidity anOrderValidity){ //�޾Ƶ��� anOrderValidity�� Ÿ������ ���� ���.
		switch(anOrderValidity){
			case TooSmall:
				this._appView.outputLine("���� : ������ �ʹ� �۽��ϴ�. 3���� ũ�ų� ���ƾ� �մϴ�.");
				break;
			case TooLarge:
				this._appView.outputLine("���� : ������ �ʹ� Ů�ϴ�. 99���� �۰ų� ���ƾ� �մϴ�.");
				break;
			case NotOddNumber:
				this._appView.outputLine("���� : ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.");
				break;
			default:
				break;
				
		}
	}
	
	private void showBoard (Board aBoard){ // BoardŬ������ �̿��Ͽ� order�� �°� cellLocation�� row,col�� �ش��ϴ� ���� ���忡 ���.
		CellLocation currentLoc = new CellLocation();
		this.showTitleOfrColumnIndexes(aBoard.order());
		
		for(int row = 0; row < aBoard.order(); row++){
			this._appView.outputRowNumber(row);
			
			for(int col = 0; col < aBoard.order(); col++){
				currentLoc.setRow(row); //row�� ���� currentLoc�� setRow�� �ִ´�.
				currentLoc.setCol(col);	//col�� ���� currentLoc�� setCol�� �ִ´�.
				this._appView.outputCell(aBoard.cell(currentLoc)); // currentLoc�� cell�ȿ� ����ִ� ���� ����Ѵ�.
			}
			
			this._appView.outputLine("");
		}
		
		
	}
	
	private void showTitleOfrColumnIndexes(int anOrder){ //���� [] ǥ��.
		this._appView.outputLine("      "); //��ĭ 6��.
		
		for(int col = 0; col < anOrder; col++){
			if(col == 0){
				this._appView.output(String.format("     [%3d]", col));
			}
			else this._appView.output(String.format("[%3d]", col));
		}
		this._appView.outputLine("");
	}
	
	
	
	}
