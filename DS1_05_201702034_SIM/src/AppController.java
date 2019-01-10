
public class AppController {
	
	private AppView _appView;
	private ArraySet<Star> _starCollector;
	
	public AppController(){
		this._appView = new AppView();
		this._starCollector = null;		
	}

	private void removeByName(){
		this.showMessage(MessageID.Notice_RemoveStar);
		
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		
		Star removeStar = this._starCollector.remove(new Star(starName));
		
		
		if(removeStar != null){
			this._appView.outputStar(removeStar.starName(), removeStar.xCoordinate(), removeStar.yCoordinate());
			
		}
		else{
			this.showMessage(MessageID.Error_Remove);
		}
	}
	
	private void removeAnyStar(){
		this.showMessage(MessageID.Notice_RemoveRandomStar);
		Star removeStar = this._starCollector.removeAny();
		if(removeStar == null){
			this.showMessage(MessageID.Error_Remove);
		}
		else{
			this._appView.outputStar(removeStar.starName(),	removeStar.xCoordinate(), removeStar.yCoordinate());
		}
	}
	
	private void searchByName(){
		this.showMessage(MessageID.Notice_SearchByName);
		
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		Star reachStar = new Star(starName);
		if(this._starCollector.doesContain(reachStar)){
			this._appView.outputMessage(reachStar.starName() + "�� �����մϴ�.");
		}
		else{
			this.showMessage(MessageID.Error_Input);
		}
		
	}
	
	private void searchByCoordinate(){
		this.showMessage(MessageID.Notice_SearchByCoordinate);
		this.showMessage(MessageID.Notice_InputStarXCoordinate);
		int inputX = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarYCoordinate);
		int inputY = this._appView.inputInt();
		Star searchStar = new Star(inputX, inputY);
		if(this._starCollector.doesContain(searchStar)){
			this._appView.outputMessage("(" + searchStar.xCoordinate() + ", " + searchStar.yCoordinate() + ") ��ġ�� ���� �����մϴ�." );
		}
		else{
			this.showMessage(MessageID.Error_Input);
		}
		
	}
	
	private void inputStar(){
		this.showMessage(MessageID.Notice_InputStar);
		
		this.showMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		
		this.showMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();
		
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		
		Star addStar;
		addStar = new Star(xCoordinate, yCoordinate, starName);
		if(!this._starCollector.add(addStar)){
			this.showMessage(MessageID.Error_Input);
		}
		
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
			case Notice_StartProgram:
				this._appView.outputMessage("<���� ������ �����մϴ�.>\n");
				break;
			case Notice_EndProgram:
				this._appView.outputMessage("<���� ������ �����մϴ�.>");
				break;
			case Notice_Menu:
				this._appView.outputMessage("\n1: �Է� \t 2: �־��� �� ���� \t 3: ������ �� ����\n");
				this._appView.outputMessage("4. ��� \t 5.�̸����� �˻� \t 6. �·�ǥ�� �˻� \t 9: ����\n");
				this._appView.outputMessage("���ϴ� �޴��� �Է��ϼ��� : ");
				break;
			case Notice_EndMenu:
				break;
			case Notice_InputStar:
				this._appView.outputMessage("-[�Է�]-\n");
				break;
			case Notice_InputStarName:
				this._appView.outputMessage("-���� �̸��� �Է��Ͻÿ� : ");
				break;
			case Notice_InputStarXCoordinate:
				this._appView.outputMessage("- x��ǥ�� �Է��Ͻÿ� : ");
				break;
			case Notice_InputStarYCoordinate:
				this._appView.outputMessage("- y��ǥ�� �Է��Ͻÿ� : ");
				break;
			case Notice_RemoveStar:
				this._appView.outputMessage("-[�־��� �� ����]-\n");
				break;
			case Notice_RemoveRandomStar:
				this._appView.outputMessage("-[������ �� ����]-\n");
				break;
			case Notice_Show:
				this._appView.outputMessage("-[���]-\n");
				break;
			case Notice_SearchByName:
				this._appView.outputMessage("-[�̸����� �˻�]-\n");
				break;
			case Notice_SearchByCoordinate:
				this._appView.outputMessage("-[��ǥ�� �˻�]-\n");
				break;
			case Error_WrongMenu:
				this._appView.outputMessage("ERROR : �ùٸ� �޴��� �Է��Ͻʽÿ�.\n");
				break;
			case Error_Input:
				this._appView.outputMessage("ERROR : �߸��� �Է��Դϴ�.\n");
				break;
			case Error_Remove:
				this._appView.outputMessage("ERROR : ������ ���� �������� �ʽ��ϴ�.\n");
				break;
			default:
				break;
		}
	}
	
	public void run(){
		this._starCollector = new ArraySet<Star>();
		
		this.showMessage(MessageID.Notice_StartProgram);
		
		int command = 0;
		
		while(command != 9){
			try{
				this.showMessage(MessageID.Notice_Menu);
				command = this._appView.inputInt();
				if(command == 1){
					this.inputStar();
				}
				else if(command == 2){
					this.removeByName();
				}
				else if(command == 3){
					this.removeAnyStar();
				}
				else if(command == 4){
					this.showMessage(MessageID.Notice_Show);
					this._appView.outputNumberOfStars(this._starCollector.size());
				}
				else if(command == 5){
					this.searchByName();
				}
				else if(command == 6){
					this.searchByCoordinate();
				}
				else{
					if(command != 9)this.showMessage(MessageID.Error_WrongMenu);
				}
			} //End of Try;
			catch (Exception ex){
				System.out.println("Error MEssage : " + ex.getMessage());
				continue;
			} //End of catch
		} // End of while
		
		this.showMessage(MessageID.Notice_EndMenu);
		this._appView.outputNumberOfStars(this._starCollector.size());
		this.showMessage(MessageID.Notice_EndProgram);
	}

}
