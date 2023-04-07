import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// <applet code="Calc" height=400 width=400></applet>

public class Calc extends Applet implements ActionListener
{ 
    int num1,num2,result;
	char Operation;
	TextField txt = new TextField(40);
    Button btn[] = new Button[10];
	Button Add = new Button("+");
	Button Sub = new Button("-");
	Button Mul = new Button("*");
	Button Div = new Button("/");
	Button clear = new Button("Clear");
	Button EQ = new Button("=");
    Panel nn = new Panel();
    Panel cc = new Panel();
    Panel ss = new Panel();
    
    public void init() 
	{
		nn.setLayout(new GridLayout(1,1,3,3));
        nn.add(txt);
		cc.setLayout(new GridLayout(5,5,3,3));
		for(int i=0; i<10; i++)
		{
			btn[i]=new Button(i+"");
			cc.add(btn[i]);
			btn[i].addActionListener(this);
		}
        txt.addActionListener(this);
        cc.add(Add);
        cc.add(Sub);
        cc.add(Mul);
        cc.add(Div);
        cc.add(EQ);
        
		ss.setBackground(Color.yellow);
		ss.add(clear);
		
		Add.addActionListener(this);
		Sub.addActionListener(this);
		Mul.addActionListener(this);
		Div.addActionListener(this);
		clear.addActionListener(this);
		EQ.addActionListener(this);
		this.setLayout(new BorderLayout());
		
		add(nn,BorderLayout.NORTH);
		add(cc,BorderLayout.CENTER);
		add(ss,BorderLayout.SOUTH);
    }
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		char ch=str.charAt(0);
		
		if(Character.isDigit(ch))
			txt.setText(txt.getText()+str);
		else
		{
			if(str.equals("+")){
				num1=Integer.parseInt(txt.getText());
				Operation='+';
				txt.setText("");
			}
			if(str.equals("-")){
				num1=Integer.parseInt(txt.getText());
				Operation='-';
				txt.setText("");
			}
			if(str.equals("*")){
				num1=Integer.parseInt(txt.getText());
				Operation='*';
				txt.setText("");
			}
			if(str.equals("/")){
				num1=Integer.parseInt(txt.getText());
				Operation='/';
				txt.setText("");
			}
			if(str.equals("=")){
				num2=Integer.parseInt(txt.getText());
				switch(Operation)
				{
					case '+':result=num1+num2;
							break;
					case '-':result=num1-num2;
							break;
					case '*':result=num1*num2;
							break;
					case '/':try{result=num1/num2;}
							catch(ArithmeticException ae)
							{
								System.out.println("Divided by zero...");
							}
							break;
				}
				txt.setText(""+result);
			}
			if(str.equals("Clear")){
				txt.setText("");
			}
		}
	}
}