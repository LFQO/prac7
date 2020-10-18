package ru.mirea.inbo_05_19.Kuznetsov.Task5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CardGameStackGUI extends JFrame {
    private Stack<Integer> cards1;
    private Stack<Integer> cards2;
    private int gameLength;
    private JTextField tf1;
    private JTextField tf2;
    private JLabel l1;
    private JLabel l2;
    private JButton b;
    private Font f;

    public CardGameStackGUI() {
        super("CardGameStackGUI");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        l1 = new JLabel("1st player cards");
        l2 = new JLabel("2st player cards");
        b = new JButton("Who is the winner?");
        f = new Font("abc", Font.PLAIN, 20);
        setLayout(new FlowLayout());
        setSize(375, 200);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b);
        l1.setFont(f);
        l2.setFont(f);
        tf1.setFont(f);
        tf2.setFont(f);
        b.setFont(f);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game();
            }
        });
        setVisible(true);
        cards1 = new Stack<>();
        cards2 = new Stack<>();
        gameLength = 0;
    }

    public void InputCards() {
        String[] z;
        z = tf1.getText().split(" ");
        for (int i = 4; i >= 0; i--) {
            cards1.push(Integer.parseInt(z[i]));
        }
        z = tf2.getText().split(" ");
        for (int i = 4; i >= 0; i--) {
            cards2.push(Integer.parseInt(z[i]));
        }
    }

    public void Game() {
        InputCards();
        while (gameLength != 106) {
            CardsCounter();
            CompareCards();
            gameLength += 1;
        }
        System.out.println("botva");
    }

    public void CardsCounter() {
        if (cards1.size() == 0) {
            JOptionPane.showMessageDialog(null, "second " + gameLength, "MatchResult", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else if (cards2.size() == 0) {
            JOptionPane.showMessageDialog(null, "first " + gameLength, "MatchResult", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void TakeCards(int winner, int loser, Stack<Integer> cards) {
        int c = cards.size();
        int[] n = new int[c + 2];
        for (int i = 0; i < c; i++) {
            n[i] = cards.pop();
        }
        n[c] = winner;
        n[c] = loser;
        cards.clear();
        for (int i = n.length - 1; i >= 0; i--) {
            cards.push(n[i]);
        }
    }

    public void CompareCards() {
        int pl1 = cards1.pop();
        int pl2 = cards2.pop();
        if (pl1 > pl2) {
            if (pl1 == 9 & pl2 == 0) {
                TakeCards(pl2, pl1, cards2);
            } else {
                TakeCards(pl1, pl2, cards1);
            }
        } else if (pl1 < pl2) {
            if (pl1 == 0 & pl2 == 9) {
                TakeCards(pl1, pl2, cards1);
            } else {
                TakeCards(pl2, pl1, cards2);
            }
        }
    }


    public static void main(String[] args) {
        new CardGameStackGUI();
    }
}