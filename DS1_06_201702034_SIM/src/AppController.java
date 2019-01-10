
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
		
		//���� �� �л����� Ban��ü�κ��� GradeCounter ��ü ���·� ��´�.
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
		this.inputAndStoreStudents(); // ������ �Է� �޴´�.
		if(this._ban.isEmpty()){
			this.showMessage(MessageID.Error_NoInputScores);
		}
		else{
			//��հ� ����̻��� �л��� �ְ��� �������� ���, ���.
			this.showStatistics();
			//���������� ����, �׸��� �Է� �޴� �л� ������ ���.
			this._ban.sortStudentsByScore();
			this.showStudentsSortedByScore();
		}
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
		case Notice_StartProgram:
			this._appView.outputMessage("<<���� ó���� �����մϴ�.>>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("\n<<���� ó���� �����մϴ�.>>");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage("\n������ �Է��Ϸ��� 'Y' �Ǵ� 'y'��, �����Ϸ��� �ٸ� �ƹ� Ű�� ġ�ÿ� : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("\n[���� �Է��� �����մϴ�.]\n");
			break;
		case Show_SortedStudentList:
			this._appView.outputMessage("�л����� ������ ����Դϴ�.\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("\n�Է��� �ùٸ��� �ʽ��ϴ�.");
			break; //���� �ʿ�.
		case Error_InvaildScore:
			this._appView.outputMessage("Error : 0���� �۰ų� 100���� Ŀ��, �������� ������ �ƴմϴ�.\n");
			break;
		case Error_NoInputScores:
			this._appView.outputMessage("������ �Էµ��� �ʾҽ��ϴ�.\n");
		}
	}

}
