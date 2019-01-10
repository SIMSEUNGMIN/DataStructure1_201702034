
public class Calculate {
	private static final char END_OF_TOKEN = '$';
	
	private ArrayList<Character> _oStack;
	private ArrayList<Double> _vStack;
	
	private char[] _infix;
	private char[] _postfix;
	
	public Calculate(){
		this._oStack = null;
		this._vStack = null;
		this._infix = null;
		this._postfix = null;
		
	}
	
	public void setInfix(String newInfix){
		this._infix = newInfix.toCharArray();
	}
	
	public String infix(){
		return String.valueOf(this._infix);
	}
	
	public String postfix(){
		return String.valueOf(this._postfix);
	}
	
	public boolean infixToPostfix(){
		//infix�� postfix�� ��ȯ. ��ȯ�� ������ �����Ѵ�.
		int i = 0;
		int p = 0;
		char currentToken, poppedToken, topToken;
		
		this._oStack = new ArrayList<Character>(this._infix.length);
		this._postfix = new char[this._infix.length+1];
		
		while(i < this._infix.length){
			currentToken = this._infix[i++];
			if(this.isDigit(currentToken)){
				//operand : output to postfix expression
				this._postfix[p++] = currentToken;
			}
			else{ //currentToken�� ������
				if(currentToken == ')'){
					if(!this._oStack.isEmpty()){
						poppedToken = (char)this._oStack.pop();
					}
					else return false;
					
					while(poppedToken != '('){
						this._postfix[p++] = poppedToken;
						if(!this._oStack.isEmpty()){
							poppedToken = (char)this._oStack.pop();
						}
						else return false;
					}
					this.showOStackAll();
				}
				else{ //currentToken�� �Ϲ� �������� ��
					int inComingP = this.inComingPrecedence(currentToken);
					if(!this._oStack.isEmpty()){
						topToken = (char)this._oStack.peek();
						while(this.inStackPrecedence(topToken) >= inComingP){
							poppedToken = (char)this._oStack.pop();
							this._postfix[p++] = poppedToken;
							if(!this._oStack.isEmpty())
								topToken = (char)this._oStack.peek();
							else break;
						}
					}
					this._oStack.push(currentToken);
					this.showOStackAll();
				}
			}
		}
		//��ȯ�� ������ ���� ���� ���θ� true/false�� �˷��ش�.
		while(!this._oStack.isEmpty()){
			this._postfix[p++] = this._oStack.pop();
		}
		this._postfix[p++] = '$';
		return true;
	}
	
	public double evalPostfix(){
		//���� ������ �ִ� postfix ������ ����ϰ� �Ͽ� �� ����� ��´�.
		int p = 0;
		char curToken;
		this._vStack = new ArrayList<Double>(this._infix.length);
		
		curToken = this._postfix[p++];
		while(curToken != Calculate.END_OF_TOKEN){
			if(this.isDigit(curToken)){
				this._vStack.push(Double.parseDouble(String.valueOf(curToken)));
			}
			else{
				double num1;
				double num2;
				double value = 0;
				
				num1 = this._vStack.pop();
				num2 = this._vStack.pop();
				
				switch(curToken){
					case '+':
						value = num1 + num2;
						break;
					case '-':
						value = num2 - num1;
						break;
					case '*':
						value = num1 * num2;
						break;
					case '/':
						value = num2 / num1;
						break;
					default:
						break;
				}
				this._vStack.push(value);
			}
			curToken = this._postfix[p++];
			this.showVstackAll();
		}
		return this._vStack.pop();
	}
	
	private boolean isDigit(char aToken){
		return (aToken >= '0' && aToken <= '9');
	}
	
	private int inComingPrecedence(char aToken){
		//���� ���ÿ� �����ϴ� ������ aToken�� �켱���� ���� �����ش�.
		if(aToken == '+')
			return 12;
		else if(aToken == '-')
			return 12;
		else if(aToken == '(')
			return 20;
		else if(aToken == ')')
			return 20;
		else if(aToken == '*')
			return 13;
		else if(aToken == '/')
			return 13;
		else if(aToken == '%')
			return 13;
		else if(aToken == '^')
			return 17;
		else if(aToken == '$')
			return 0;
		else
			return -1;
	}
	
	public int inStackPrecedence(char aToken){
		//���� �ȿ� �����ϴ� ������ ������ aToken�� �켱 ���� ���� �����ش�.
		if(aToken == '+')
			return 12;
		else if(aToken == '-')
			return 12;
		else if(aToken == '(')
			return 0;
		else if(aToken == ')')
			return 19;
		else if(aToken == '*')
			return 13;
		else if(aToken == '/')
			return 13;
		else if(aToken == '%')
			return 13;
		else if(aToken == '^')
			return 16;
		else if(aToken == '$')
			return 0;
		else
			return -1;
	}
	
	public void showOStackAll(){
		//�ӽ� �Լ�. operation ���� ���ο� �ִ� ��� ���� ���.
		System.out.print("Ostack: ");
		for(int index = 0; index < this._oStack.size(); index++){
			System.out.print(this._oStack.elementAt(index) + " ");
		}
		System.out.println();
	}
	
	public void showVstackAll(){
		System.out.print("Vstack: ");
		for(int index = 0; index < this._vStack.size(); index++){
			System.out.print(this._vStack.elementAt(index) + " ");
		}
		System.out.println();
	}
	
}
