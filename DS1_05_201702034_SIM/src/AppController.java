
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
			this._appView.outputMessage(reachStar.starName() + "이 존재합니다.");
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
			this._appView.outputMessage("(" + searchStar.xCoordinate() + ", " + searchStar.yCoordinate() + ") 위치에 별이 존재합니다." );
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
				this._appView.outputMessage("<별의 집합을 시작합니다.>\n");
				break;
			case Notice_EndProgram:
				this._appView.outputMessage("<별의 집합을 종료합니다.>");
				break;
			case Notice_Menu:
				this._appView.outputMessage("\n1: 입력 \t 2: 주어진 별 삭제 \t 3: 임의의 별 삭제\n");
				this._appView.outputMessage("4. 출력 \t 5.이름으로 검색 \t 6. 좌료표로 검색 \t 9: 종료\n");
				this._appView.outputMessage("원하는 메뉴를 입력하세요 : ");
				break;
			case Notice_EndMenu:
				break;
			case Notice_InputStar:
				this._appView.outputMessage("-[입력]-\n");
				break;
			case Notice_InputStarName:
				this._appView.outputMessage("-별의 이름을 입력하시오 : ");
				break;
			case Notice_InputStarXCoordinate:
				this._appView.outputMessage("- x좌표를 입력하시오 : ");
				break;
			case Notice_InputStarYCoordinate:
				this._appView.outputMessage("- y좌표를 입력하시오 : ");
				break;
			case Notice_RemoveStar:
				this._appView.outputMessage("-[주어진 별 삭제]-\n");
				break;
			case Notice_RemoveRandomStar:
				this._appView.outputMessage("-[임의의 별 삭제]-\n");
				break;
			case Notice_Show:
				this._appView.outputMessage("-[출력]-\n");
				break;
			case Notice_SearchByName:
				this._appView.outputMessage("-[이름으로 검색]-\n");
				break;
			case Notice_SearchByCoordinate:
				this._appView.outputMessage("-[좌표로 검색]-\n");
				break;
			case Error_WrongMenu:
				this._appView.outputMessage("ERROR : 올바른 메뉴를 입력하십시오.\n");
				break;
			case Error_Input:
				this._appView.outputMessage("ERROR : 잘못된 입력입니다.\n");
				break;
			case Error_Remove:
				this._appView.outputMessage("ERROR : 삭제될 별이 존재하지 않습니다.\n");
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
