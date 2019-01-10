
public class AppController {
	private AppView _appView;
	private CircularlyLinkedQueue<Character> _queue;
	private int _inputChars; //입력된 문자의 개수.
	private int _ignoreChars; //무시된 문자의 개수.
	private int _addedChars; //삽입된 문자의 개수.
	
	public AppController(){
		this._appView = new AppView();
		this.initCharCounts();
	}
	
	private void showFrontElement(){
		char front = this._queue.frontElement();
		this._appView.outputFrontElements(front);
	}
	
	private void showQueueSize(){
		int size = this._queue.size();
		this._appView.outputQueueSize(size);
	} 
	
	private void showAll(){
		int queueSize = this._queue.size();
		Character elementForOutput = null;
		
		this._appView.outputMessage("[Queue] <Front> ");
		for(int order = 0; order < queueSize; order ++){
			elementForOutput = this._queue.elementAt(order);
			this._appView.outputElement(elementForOutput);
		}
		this._appView.outputMessage("<Rear>\n");
	}
	
	private void initCharCounts(){
		this._inputChars = 0;
		this._ignoreChars = 0;
		this._addedChars = 0;
	}
	
	private void countAdded(){
		this._addedChars++;
	}
	
	private void countIgnored(){
		this._ignoreChars++;
	}
	
	private void countInputChar(){
		this._inputChars++;
	}
	
	private void add(Character anElement){
		if(this._queue.isFull()){
			this.showMessage(MessageID.Error_InputFull);
		}
		else{
			this._queue.enQueue((char)anElement);
			this._appView.outputAdd((char)anElement);
			this.countAdded();
		}
	}
	
	private void removeOne(){
		if(this._queue.isEmpty()){
			this.showMessage(MessageID.Error_Empty);
		}
		else{
			char input = this._queue.deQueue();
			this._appView.outputRemove(input);
		}
	}
	
	private void removeN(int numberOfCharsToBeRemoved){
		this._appView.outputRemoveN(numberOfCharsToBeRemoved);
		for(int i = 0; i < numberOfCharsToBeRemoved; i++){
			this.removeOne();
		}
	}
	
	private void conclusion(){
		while(this._queue.size() != 0){
			this.removeOne();
		}
		
		this._appView.outputResult(this._inputChars, this._ignoreChars, this._addedChars);
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
		case Notice_StartProgram:
			this._appView.outputMessage("> 프로그램을 시작합니다.\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("> 프로그램을 종료합니다.\n");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage(" [큐 입력을 시작합니다.]\n");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage(" [큐 입력을 종료합니다.]\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("ERROR : 의미 없는 문자가 입력 되었습니다.\n");
			break;
		case Error_InputFull:
			this._appView.outputMessage("ERROR : 큐가 꽉 차서 삽입이 불가능합니다.\n");
			break;
		case Error_Empty:
			this._appView.outputMessage("[Empty] 큐에 원소가 없습니다.\n");
		}
	}
	
	public void run(){
		this._queue = new CircularlyLinkedQueue<Character>();
		char inputChar;
		
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		inputChar = this._appView.inputCharacter();
		while(inputChar != '!'){
			this.countInputChar();
			if((inputChar >= 'A' && inputChar <= 'Z') ||
					(inputChar >= 'a' && inputChar <= 'z')){
				this.add(inputChar);
			}
			else if(inputChar >= '0' && inputChar <= '9'){
				this.removeN(Integer.parseInt(String.valueOf(inputChar)));
			}
			else if(inputChar == '-'){
				this.removeOne();
			}
			else if(inputChar == '#'){
				this.showQueueSize();
			}
			else if(inputChar == '/'){
				this.showAll();
			}
			else if(inputChar == '^'){
				this.showFrontElement();
			}
			else{
				this.showMessage(MessageID.Error_WrongMenu);
				this.countIgnored();
			}
			inputChar = this._appView.inputCharacter();
		}
		this.showMessage(MessageID.Notice_EndMenu);
		this.conclusion();
		this.showMessage(MessageID.Notice_EndProgram);
	}
}
