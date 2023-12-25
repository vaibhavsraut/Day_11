package com.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        cards = new ArrayList<>();

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards, new Random());
    }

    public List<Card> getCards() {
        return cards;
    }
}

class Player {
    private List<Card> hand;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }
}

public class DeckOfCards {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player();
        }

        List<Card> cards = deck.getCards();
        int cardIndex = 0;

        for (int i = 0; i < 9; i++) {
            for (Player player : players) {
                player.receiveCard(cards.get(cardIndex));
                cardIndex++;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + " Hand:");
            for (Card card : players[i].getHand()) {
                System.out.println(card);
            }
            System.out.println();
        }
    }
}
