
public class AppController {
	private AppView _appView;
	private ArrayList<Character> _arrayStack;
	private int _inputChars; //입력된 문자의 개수
	private int _ignoredChars; //무시된 문자의 개수
	private int _addedChars; //삽입된 문자의 개수
	
	public AppController(){
		this._appView = new AppView();
		this._inputChars = 0;
		this._ignoredChars = 0;
		this._addedChars = 0;
	}
	
	private void showAllFromBottom(){
		this.showMessage(MessageID.Notice_ShowStack);
		this.showMessage(MessageID.Show_StartBottom);
		for(int index = 0; index < this._arrayStack.size(); index++){
			this._appView.outputStackElement((char)this._arrayStack.elementAt(index));
		}
		this.showMessage(MessageID.Show_EndTop);
	}
	
	private void showAllFromTop(){
		this.showMessage(MessageID.Notice_ShowStack);
		this.showMessage(MessageID.Show_StartTop);
		for(int index = 0; index < this._arrayStack.size(); index++){
			this._appView.outputStackElement((char)this._arrayStack.elementAt(index));
		}
		this.showMessage(MessageID.Show_EndBottom);
	}
	
	private void showTopElement(){
		this._appView.outputTopElement(this._arrayStack.peek());
	}
	
	private void showStackSize(){
		this._appView.outputStackSize(this._arrayStack.size());
	}
	
	private void countAdded(){
		this._addedChars++;
	}
	
	private void countIgnored(){
		this._ignoredChars++;
	}
	
	private void countInputChar(){
		this._inputChars++;
	}
	
	private void addToSTack(char inputChar){
		if(this._arrayStack.push(inputChar)){
			this._appView.outputAddedElement(inputChar);
			this.countAdded();
		}
		else{
			this.showMessage(MessageID.Error_InputFull);
		}
	}
	
	private void removeOne(){
		if(this._arrayStack.isEmpty()){
			this.showMessage(MessageID.Error_RemoveEmpty);
		}
		else{
			this._appView.outputRemove((char)this._arrayStack.pop());
		}
	}
	
	private void removeN(int numberOrCharsToBeRemoved){
		for(int i = 0; i < numberOrCharsToBeRemoved; i++){
			this.removeOne();
		}
	}
	
	private void conclusion(){
		this.removeOne();
		this._appView.outputResult(this._inputChars, this._ignoredChars, this._addedChars);
	}
	
	public void run(){
		this._arrayStack = new ArrayList<Character>();
		char input;
		
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		input = this._appView.inputCharacter();
		while(input != '!'){
			this.countInputChar();
			if((input >= 'A') && (input <= 'Z') || (input >= 'a') && (input <= 'z')){
				this.addToSTack(input);
			}
			else if(input >= '0' && input <= '9'){
				this.removeN(input - '0');
			}
			else if(input == '-'){
				this.removeOne();
			}
			else if(input == '#'){
				this.showStackSize();
			}
			else if(input == '/'){
				this.showTopElement();
			}
			else{
				this.showMessage(MessageID.Error_WrongMenu);
				this.countIgnored();
			}		
			input = this._appView.inputCharacter();
		}
		this.showMessage(MessageID.Notice_EndMenu);
		this.conclusion();
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
		case Notice_StartProgram:
			this._appView.outputMessage("> 프로그램을 시작합니다.\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("> 프로그램을 종료합니다.");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage("[스택 사용을 시작합니다.]\n");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("[스택 입력을 종료합니다.]");
			break;
		case Notice_InputStack:
			this._appView.outputMessage("[Push]");
			break;
		case Notice_DelStack:
			this._appView.outputMessage("[Pop]");
			break;
		case Notice_ShowStack:
			this._appView.outputMessage("[Stack]");
			break;
		case Show_StartBottom:
			this._appView.outputMessage("<Bottom>");
			break;
		case Show_StartTop:
			this._appView.outputMessage("<Top>");
			break;
		case Show_EndBottom:
			this._appView.outputMessage("<Bottom>");
			break;
		case Show_EndTop:
			this._appView.outputMessage("<Top>");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("잘못된 입력입니다.\n");
			break;
		case Error_InputFull:
			this._appView.outputMessage("[Full]스택이 꽉 차서 삽입이 불가능합니다.\n");
			break;
		}
	}

}
