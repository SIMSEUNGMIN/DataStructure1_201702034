
public class AppController {
	
	private AppView _appView;
	private Ban _ban;
	
	public AppController(){
		this._appView = new AppView();
	}
	
	private boolean inputAndStoreStudents(){
		
		this.showMessage(MessageID.Notice_StartMenu);
		int score;
		boolean storingAStudentWasSuccessful = true;
		this._ban = new Ban();
		while(storingAStudentWasSuccessful && 
				this._appView.inputDoesContinueToInputNextStudent()){
			score = this._appView.inputScore();
			if(score < 0 || score > 100){
				this.showMessage(MessageID.Error_InvaildScore );
			}
			else{
				Student aStudent = new Student(score);
				this._ban.add(aStudent);
			}
			this.showMessage(MessageID.Notice_StartMenu);
		}
		
		this.showMessage(MessageID.Notice_EndMenu);
		return storingAStudentWasSuccessful;
	}
	
	private void showStatistics(){
		this._appView.outputAverageScore(this._ban.averageScore());
		this._appView.outputNumberOfStudentsAboveAverage(this._ban.numberOfStudentsAboveAverage());
		this._appView.outputMaxScore(this._ban.maxScore());
		this._appView.outputMinScore(this._ban.minScore());
		
		//학점 별 학생수는 Ban객체로부터 GradeCounter 객체 형태로 얻는다.
		GradeCounter gradeCounter = this._ban.countGrades();
		this._appView.outputGradeCountFor('A', gradeCounter.numberOfA());
		this._appView.outputGradeCountFor('B', gradeCounter.numberOfB());
		this._appView.outputGradeCountFor('C', gradeCounter.numberOfC());
		this._appView.outputGradeCountFor('D', gradeCounter.numberOfD());
		this._appView.outputGradeCountFor('F', gradeCounter.numberOfF());
	}
	
	private void showStudentsSortedByScore(){
		this.showMessage(MessageID.Show_SortedStudentList);
		for(int position = 0; position < this._ban.size(); position++){
			this._appView.outputStudentInfo(this._ban.elementAt(position).score());
		}
	}
	
	public void run(){
		this.showMessage(MessageID.Notice_StartProgram);
		this.inputAndStoreStudents(); // 성적을 입력 받는다.
		if(this._ban.isEmpty()){
			this.showMessage(MessageID.Error_NoInputScores);
		}
		else{
			//평균과 평균이상인 학생수 최고점 최저점을 계산, 출력.
			this.showStatistics();
			//성적순으로 정렬, 그리고 입력 받는 학생 정보를 출력.
			this._ban.sortStudentsByScore();
			this.showStudentsSortedByScore();
		}
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
		case Notice_StartProgram:
			this._appView.outputMessage("<<성적 처리를 시작합니다.>>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("\n<<성적 처리를 종료합니다.>>");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage("\n성적을 입력하려면 'Y' 또는 'y'를, 종료하려면 다른 아무 키나 치시오 : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("\n[성적 입력을 종료합니다.]\n");
			break;
		case Show_SortedStudentList:
			this._appView.outputMessage("학생들의 성적순 목록입니다.\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("\n입력이 올바르지 않습니다.");
			break; //수정 필요.
		case Error_InvaildScore:
			this._appView.outputMessage("Error : 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다.\n");
			break;
		case Error_NoInputScores:
			this._appView.outputMessage("점수가 입력되지 않았습니다.\n");
		}
	}

}
