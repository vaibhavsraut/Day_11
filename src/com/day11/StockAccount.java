package com.day11;

import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String stockName;
    int numberOfShares;
    double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    double stockValue(){
        return numberOfShares * sharePrice;
    }
}

class StockPortfolio{
    ArrayList<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    void addStock(String stockName, int numberOfShares, double sharePrice){
        Stock stock = new Stock(stockName, numberOfShares, sharePrice);
        stocks.add(stock);
    }

    double portfolioValue(){
        double totalValue=0;
        for(Stock stock: stocks) {
            totalValue += stock.stockValue();
        }
        return totalValue;
    }

    void stockReport(){
        System.out.println("Stock Report:");
        System.out.println("******************");
        for(Stock stock : stocks){
            System.out.println("Stock name: " + stock.stockName);
            System.out.println("Number of Shares: " + stock.numberOfShares);
            System.out.println("Each ShareEN price $" + stock.sharePrice);
            System.out.println("Stock Price: $"+ stock.stockValue());
            System.out.println();
        }
        System.out.println("*******************************************************");
        System.out.println("Portfolio Value: $"+ portfolioValue());
    }
}


public class StockAccount {
    static StockPortfolio stockPortfolio = new StockPortfolio();
    void debit(double debitAmount){
        double accountBalance = stockPortfolio.portfolioValue();

        if(accountBalance>=debitAmount){
            accountBalance -= debitAmount;
            System.out.println("You have successfully withdrawn $"+ debitAmount +".");
            System.out.println("Your remaining Account Balance: $"+ accountBalance);
        }else {
            System.out.println("Your Account does not have enough balance to withdrawn $" + debitAmount);
            System.out.println("Your Account Balance: $"+ accountBalance);
        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of stocks:");
        int numberOfStocks = scanner.nextInt();

        for (int i=1;i<=numberOfStocks;i++){
            System.out.println("Enter details of stock number "+ i + ":");
            System.out.print("Enter Stock Name: ");
            String stockName = scanner.next();
            System.out.print("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Enter Share Price: ");
            double sharePrice = scanner.nextDouble();
            System.out.println();

            stockPortfolio.addStock(stockName, numberOfShares, sharePrice);
        }

        stockPortfolio.stockReport();

        System.out.println();

        System.out.println("Account Balance: $" + stockPortfolio.portfolioValue());

        StockAccount stockAccount = new StockAccount();
        System.out.println("Enter the amount you want to withdrawn: ");
        double debitAmount = scanner.nextDouble();
        System.out.println();
        stockAccount.debit(debitAmount);


    }
}


