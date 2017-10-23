
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainFrame extends JFrame{
    private Container cp;
    private JButton btn1=new JButton("原文");
    private JButton btn2=new JButton("加密");
    private JButton btn3=new JButton("Clear");
    private JTextArea jtaL=new JTextArea();
    private JTextArea jtaR=new JTextArea();
    private JTextField jtfkey=new JTextField("csie");
    private JPanel jpnC=new JPanel(new GridLayout(7,1,3,3));
    private JScrollPane jspL=new JScrollPane(jtaL);
    private JScrollPane jspR=new JScrollPane(jtaR);
    private JLabel lb1=new JLabel("key");
    private JButton btn5=new JButton("解密");
    private JButton btn4=new JButton("Exit");

    public MainFrame(){
        init();
    }
    private void init(){
        this.setTitle("");
        this.setBounds(100,100,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        jpnC.add(btn1);
        jpnC.add(btn2);
        jpnC.add(lb1);
        jpnC.add(jtfkey);
        jpnC.add(btn3);
        jpnC.add(btn5);
        jpnC.add(btn4);
        jspL.setPreferredSize(new Dimension(200,400));
        jspR.setPreferredSize(new Dimension(200,400));
        jtaL.setLineWrap(true);
        jtaR.setLineWrap(true);
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jspL,BorderLayout.WEST);
        cp.add(jspR,BorderLayout.EAST);
        btn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jtaL.setText("The Department of Computer Science an" +
                       "d Information Engineering, formerly the Departme" +
                       "nt of Information Technology, was established in 200" +
                       "1. The department first offered a Master program only. In" +
                       " 2002, the undergraduate program was established. The Doctoral p" +
                       "rogram was established in 2006. E" +
                       "ach year the department admits about 80 undergraduat" +
                       "es, 15 graduate students and 3 Ph.D. students.");
            }
        });
        btn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int key=Integer.parseInt(jtfkey.getText());
                char data[]= jtaL.getText().toCharArray();
                char data2[]= jtfkey.getText().toCharArray();
                int length=jtfkey.getText().length();
                int buffer=0;
                for(int i=0;i<data.length;i++){
                    if(buffer==length){
                        buffer=0;
                    }
                  data[i]^=data2[buffer];
                    buffer++;
                };
                String str1=new String(data);
                jtaR.setText(str1);
            }
        });
        btn5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int key=Integer.parseInt(jtfkey.getText());
                char data[]= jtaR.getText().toCharArray();
                char data2[]= jtfkey.getText().toCharArray();
                int length=jtfkey.getText().length();
                int buffer=0;
                for(int i=0;i<data.length;i++){
                    if(buffer==length){
                        buffer=0;
                    }
                    data[i]^=data2[buffer];
                    buffer++;
                };
                String str1=new String(data);
                jtaL.setText(str1);
            }
        });
        btn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });
        btn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}
