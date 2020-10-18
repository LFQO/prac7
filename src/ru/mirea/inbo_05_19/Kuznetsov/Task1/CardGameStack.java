package ru.mirea.inbo_05_19.Kuznetsov.Task1;
import java.util.*;

public class CardGameStack {
    private Stack<Integer> cards1;
    private Stack<Integer> cards2;
    private int gameLength;

    public CardGameStack() {
        cards1 = new Stack<>();
        cards2 = new Stack<>();
        gameLength = 0;
    }

    public void InputCards() {
        Scanner in = new Scanner(System.in);
        int[] n = new int[10];
        for (int i = 0; i < 10; i++) {
            n[i] = in.nextInt();
        }
        for (int i = 4; i >= 0; i--) {
            cards1.push(n[i]);
        }
        for (int i = 9; i >= 5; i--) {
            cards2.push(n[i]);
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
            System.out.println("second " + gameLength);
            System.exit(0);
        } else if (cards2.size() == 0) {
            System.out.println("first " + gameLength);
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
        CardGameStack g = new CardGameStack();
        g.Game();
    }
}