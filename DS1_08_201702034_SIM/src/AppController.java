
public class AppController {
	private AppView _appView;
	private Calculate _calculate;
	
	public AppController(){
		this._appView = new AppView();
		this._calculate = new Calculate();
	}
	
	public void evalExpression(){
		double finalValue;
		this.showMessage(MessageID.Notice_InfixToPostfix);
		
		if(this._calculate.infixToPostfix()){
			this._appView.outputPostfix(this._calculate.postfix());
			finalValue = this._calculate.evalPostfix();
			this._appView.outputResult(finalValue);
		}
		else{
			this.showMessage(MessageID.Error_Input);
		}
	
	}
	
	public void run(){
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		String input = this._appView.inputExpression();
		while(input.charAt(0) != '!'){
			this._calculate.setInfix(input);
			this.evalExpression();
			input = this._appView.inputExpression();
		}
		this.showMessage(MessageID.Notice_EndMenu);
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void showMessage(MessageID aMessage){
		switch(aMessage){
			case Notice_StartProgram:
				this._appView.outputMessage(" :: ���α׷��� �����մϴ�. :: \n");
				break;
			case Notice_EndProgram:
				this._appView.outputMessage(" :: ���α׷��� �����մϴ�. :: \n");
				break;
			case Notice_StartMenu:
				this._appView.outputMessage("[���� �Է��� �����մϴ�.]\n");
				break;
			case Notice_EndMenu:
				this._appView.outputMessage("[���� �Է��� �����մϴ�.]\n");
				break;
			case Notice_InfixToPostfix:
				this._appView.outputMessage("[Infix�� Postfix��]\n");
				break;
			case Error_Input:
				this._appView.outputMessage("�Է��� �߸� �Ǿ����ϴ�.\n");
				break;
			default:
				break;
		}
	}

}
