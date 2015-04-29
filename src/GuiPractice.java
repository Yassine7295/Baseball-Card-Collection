import java.awt.*;
import java.awt.event.*;
//import java.awt.Button;
 
import javax.swing.*;
 
public class GuiPractice extends JFrame{
	private TextField nameTF;
	private TextField manuTF;
	private TextField yearTF;
	private TextField priceTF;
	private TextField sizeTF;
    GuiPractice(){
        //Panel a = new Panel();
        nameTF = new TextField(20);
        manuTF = new TextField(20);
        yearTF = new TextField(20);
        priceTF = new TextField(20);
        sizeTF = new TextField(20);
        Label nameL = new Label("Enter name: ");
        Label manuL = new Label("Enter manufacturer: ");
        Label yearL = new Label("Enter year: ");
        Label priceL = new Label("Enter price: ");
        Label sizeL = new Label("Enter size: ");
        Button submit = new Button("Submit");
        add(nameL);
        add(nameTF);
        add(manuL);
        add(manuTF);
        add(yearL);
        add(yearTF);
        add(priceL);
        add(priceTF);
        add(sizeL);
        add(sizeTF);
        add(submit);
        
        //BtnListener listener = new BtnListener();
        
        //submit.addActionListener(listener);
//        submit.addActionListener(new ActionListener(){
//        	public void actionPerformed(ActionEvent ex){
//            	String name = nameTF.getText();
//            	String manu = manuTF.getText();
//            	String year = yearTF.getText();
//            	String price = priceTF.getText();
//            	String size = sizeTF.getText();
//            	System.out.println(name);
//            	System.out.println(manu);
//            	System.out.println(year);
//            	System.out.println(price);
//            	System.out.println(size);
//            }
//        });
    }
    public static void main(String[] args){
        GuiPractice frame = new GuiPractice();
        frame.setSize(400, 300);
        frame.setTitle("Baseball Card Collection");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6,2,10,10));
        //System.out.println(input);
    }
    
}