package ru.mirea.inbo_05_19.Kuznetsov.Task3;
import java.util.*;

public class CardGameArrayDequeue {
    private ArrayDeque<Integer> cards1;
    private ArrayDeque<Integer> cards2;
    private int gameLength;

    public CardGameArrayDequeue() {
        cards1 = new ArrayDeque<>();
        cards2 = new ArrayDeque<>();
        gameLength = 0;
    }

    public void InputCards() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            cards1.add(in.nextInt());
        }
        for (int i = 5; i < 10; i++) {
            cards2.add(in.nextInt());
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

    public void TakeCards(int winner, int loser, ArrayDeque<Integer> cards) {
        cards.add(winner);
        cards.add(loser);
    }

    public void CompareCards() {
        int pl1 = cards1.poll();
        int pl2 = cards2.poll();
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
        CardGameArrayDequeue g = new CardGameArrayDequeue();
        g.Game();
    }
}
