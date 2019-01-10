
public class AppController {
	private AppView _appView;
	private List<Integer> _sortedList;
	
	public AppController(){
		this._appView = new AppView();
	}
	
	private void showSize(){
		this._appView.outputSize(this._sortedList.size());
	}
	
	private void reset(){
		this._sortedList.clear();
		this.showMessage(MessageID.Notice_Reset);
	}
	
	private void showAll(){
		this.showMessage(MessageID.Notice_showStartList);
		Iterator<Integer> iterator = this._sortedList.ListIterator();
		while(iterator.hasNext()){
			this._appView.outputElement((int)iterator.next());
		}
		this.showMessage(MessageID.Notice_showEndList);
	}
	
	private void add(int inputValue){
		Integer input = new Integer(inputValue);
		this._sortedList.add(input);
		this._appView.outputAdd(inputValue);
	}
	
	private void removeMin(){
		this._appView.outputRemove(this._sortedList.removeMin());
	}
	
	private void removeMax(){
		this._appView.outputRemove(this._sortedList.removeMax());
	}
	
	private void removeFrom(int aPosition){
		this._appView.outputRemove(this._sortedList.removeFrom(aPosition));
	}
	
	public void run(){
		//this._sortedList = new SortedArrayList<Integer>();
		this._sortedList = new SortedLinkedList<Integer>();
		char command = 0;
		int input;
		
		this.showMessage(MessageID.Notice_StartProgram);
		while(command != '!'){
			command = this._appView.inputCharacter();
			if(command == '%'){
				input = this._appView.inputNumber();
				this.add(input);
			}
			else if(command == '~'){
				this.reset();
			}
			else if(command == '-'){
				this.removeMin();
			}
			else if(command == '+'){
				this.removeMax();
			}
			else if(command == '#'){
				this.showSize();
			}
			else if(command == '?'){
				input = this._appView.inputNumber();
				this.removeFrom(input);
			}
			else if(command == '/'){
				this.showAll();
			}
			else if(command == '!'){
				break;
			}
			else this.showMessage(MessageID.Error_WrongMenu);
		}
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void showMessage(MessageID aMessageID){
		switch (aMessageID){
		case Notice_StartProgram:
			this._appView.outputMessage("<����Ʈ�� �����մϴ�.>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<����Ʈ�� �������ϴ�.>");
			break;
		case Notice_Reset:
			this._appView.outputMessage("- ����Ʈ�� ������ϴ�.\n");
			break;
		case Notice_showStartList:
			this._appView.outputMessage("[List]");
			break;
		case Notice_showEndList:
			this._appView.outputMessage("\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("[Error] �ǹ̾��� ���ڰ� �ԷµǾ����ϴ�.\n");
			break;
		case Error_InputFull:
			this._appView.outputMessage("[Error] ����Ʈ�� �� ���� ������ �Ұ��� �մϴ�.\n");
			break;
		case Error_empty:
			this._appView.outputMessage("[Empty] ����Ʈ�� ���Ұ� �����ϴ�.\n");
			break;
		default:
			break;
		}
	}

}
