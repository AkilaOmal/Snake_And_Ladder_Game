import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class DisplayWindow {
    public int po = 0;
    public int step = 50;
    public int startX = 120;
    public int startY =338;
    public boolean LR = true;

    public void FirstWindow() {

        JFrame frame = new JFrame();

        JButton b1=new JButton();
        b1.setText("START");
        b1.setBorderPainted(false);
        b1.setBounds(945,250,150,50);
        b1.setBackground(Color.black);
        b1.setForeground(new  Color(216, 74, 232) );
        b1.setFont(new Font("Jokerman",Font.BOLD,30));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    frame.dispose();
                    StartWindow();
                }
            }
        });



        JButton b3 = new JButton();
        b3.setText("EXIT");
        b3.setBorderPainted(false);
        b3.setBounds(945,350,150,50);
        b3.setBackground(Color.black);
        b3.setForeground(new Color(146, 237, 104));
        b3.setFont(new Font("Jokerman",Font.BOLD,30));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    frame.dispose();
                }
            }
        });


        JPanel p1 = new JPanel();
        p1.setBackground(Color.black);
        p1.setBounds(0, 700, 110, 768);
        JLabel l2 =new JLabel();
        l2.setText("AK®");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 15));




        ImageIcon i1 = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\sw.png");
        JLabel l1 = new JLabel();
        l1.setText("         Snake & Ladder");
        l1.setForeground(Color.RED);
        //Chiller,Showcard Gothic
        l1.setFont(new Font("Jokerman", Font.BOLD, 50));
        l1.setVerticalTextPosition(SwingConstants.TOP);
        l1.setHorizontalTextPosition(SwingConstants.RIGHT);
        l1.setVerticalAlignment(SwingConstants.CENTER);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setIcon(i1);
        l1.setIconTextGap(-25);




        frame.setExtendedState(JFrame. MAXIMIZED_BOTH);
        //frame.setSize(1360,768);
        frame.setTitle("S&L");
        frame.setUndecorated(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        ImageIcon i = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\snake.png");
        frame.setIconImage(i.getImage());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(p1);
        p1.add(l2);
        frame.add(b1);
        frame.add(b3);
        frame.add(l1);
        frame.setVisible(true);



    }

    public void StartWindow() {

        HashMap<Integer,Integer> ladder = new HashMap<>(){{
            put(9, 27);
            put(18,37);
            put(25,54);
            put(28,51);
            put(56,64);
            put(68,88);
            put(76,97);
            put(79,100);
        }};
        HashMap<Integer,Integer> snake = new HashMap<>(){{

            put(16,7);
            put(59,17);
            put(63,19);
            put(67,30);
            put(87,24);
            put(93,69);
            put(95,75);
            put(99,77);

        }};
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            list.add(new ArrayList<>(2));
        }

        for (int i = 0; i <10; ++i) {
            for (int j = 0; j < 10; ++j) {
                int ind= i*10 +((LR)?j:(9-j));
                int x=startX+j*step;
                int y=startY-i*step;
                list.get(ind).add(x);
                list.get(ind).add(y);
            }
            LR = !LR;
        }



        JFrame frame1 = new JFrame();
        frame1.setLayout(null);
        JLabel l5 = new JLabel();
        JButton b4 = new JButton();
        b4.setText("RESET");
        b4.setBorderPainted(false);
        b4.setBounds(1075,600,150,50);
        b4.setBackground(Color.black);
        b4.setForeground(new Color(240, 223, 77));
        b4.setFont(new Font("Jokerman",Font.BOLD,30));
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b4) {
                    //frame1.dispose();
                    po=0;
                    l5.setBounds( list.get(0).get(0),list.get(0).get(1), 523, 523);
                    //FirstWindow();
                }
            }
        });

        JButton b3 = new JButton();
        b3.setText("EXIT");
        b3.setBorderPainted(false);
        b3.setBounds(1075,660,150,50);
        b3.setBackground(Color.black);
        b3.setForeground(new Color(146, 237, 104));
        b3.setFont(new Font("Jokerman",Font.BOLD,30));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    frame1.dispose();
                }
            }
        });

        ImageIcon player = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\Picture4.png");
        //JLabel l5 = new JLabel();
        l5.setIcon(player);
        l5.setBackground(Color.black);
        l5.setBounds( list.get(0).get(0),list.get(0).get(1), 523, 523);
        JButton br = new  JButton();
        br.setText("ROLL");
        br.setBackground(Color.black);
        br.setBorderPainted(false);
        //br.setFocusPainted(false);
        //br.setContentAreaFilled(false);
        br.setOpaque(false);
        br.setBounds(1075,200,150,50);
        br.setForeground(new Color(240, 223, 77));
        br.setFont(new Font("Jokerman",Font.BOLD,30));
        br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int l=0;
                if (e.getSource() == br) {
                    RandomeNumber r = new RandomeNumber();
                    l=r.R();  //j+=r.R();
                    po+=l;
                    System.out.println(l+" --> "+ (po));
                    int x=0;
                    int y=0;
                    if(ladder.containsKey(po))  {
                        x=ladder.get(po);
                        po=ladder.get(po);
                        l5.setBounds(list.get(x-1).get(0),  list.get(x-1).get(1), 523, 523);
                    }
                    if (snake.containsKey(po)) {
                        x=snake.get(po);
                        po=snake.get(po);
                        l5.setBounds(list.get(x-1).get(0),  list.get(x-1).get(1), 523, 523);
                    }
                    if (po>=100) {
                        l5.setBounds(list.get(99).get(0),  list.get(99).get(1), 523, 523);
                        JOptionPane.showMessageDialog(null,"YOU WIN !!!","WINNER",JOptionPane.INFORMATION_MESSAGE);
                    }

                    l5.setBounds(list.get(po-1).get(0),  list.get(po-1).get(1), 523, 523);




                }
            }
        });

        ImageIcon board = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\board.jpeg");
        JLabel l3 = new JLabel();
        l3.setIcon(board);
        l3.setBounds(100, 10, 900, 700);

        ImageIcon win = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\Winner.gif");
        JLabel l4 = new JLabel();
        l4.setIcon(win);
        l4.setBackground(Color.black);
        l4.setBounds(0, 70, 100, 80);


        ImageIcon b = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\Untitled file5 (1).gif");
        JLabel l2 = new JLabel();
        l2.setIcon(b);
        l2.setBounds(970, 90, 900, 700);

//        JOptionPane pane = new JOptionPane();
//        pane.createDialog("WINNER");
//        pane.setMessage("YOU WIN");
//        pane.setBackground(Color.black);
//        pane.setForeground(new Color(240, 223, 77));
//        pane.setFont(new Font("Jokerman",Font.BOLD,30));
//       pane.setSize(new Dimension(100, 100));
//        pane.setBounds(0, 0, 900, 700);
//        pane.setVisible(true);

        frame1.setExtendedState(JFrame. MAXIMIZED_BOTH);
        frame1.setTitle("S&L");
        frame1.setUndecorated(true);
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        ImageIcon i = new ImageIcon("C:\\Users\\akila\\Documents\\myJava\\src\\snake.png");
        frame1.setIconImage(i.getImage());
        frame1.getContentPane().setBackground(Color.BLACK);
        frame1.add(b4);
        frame1.add(b3);
        frame1.add(l5);
        frame1.add(l4);
        frame1.add(l5);
        frame1.add(l3);
        frame1.add(l2);
        frame1.add(br);
        frame1.setVisible(true);

    }


}
