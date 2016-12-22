package com.efinix.datapublisher;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.SystemDefaultHttpClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by dilip on 6/23/16.
 */
public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Stock> stocks = readStockPrices();
        ArrayList<PortfolioFile> portfolios = readPortfolios();
        Thread t1 = new StockStreamClient(stocks);
        Thread t2 = new PortfolioStreamClient(portfolios);
        t1.start();
        t2.start();

    }

    public static ArrayList<Stock> readStockPrices() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("A50E13000.csv"));
        ArrayList<Stock> stocks = new ArrayList();
        String[] split;
        Stock stock;
        while(scan.hasNext()){
           split = scan.nextLine().split(",");
           stock = new Stock(split[0],Double.parseDouble(split[1]));
           stocks.add(stock);
        }
        return stocks;
    }

    public static ArrayList<PortfolioFile> readPortfolios() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("A50Portfolio.csv"));
        ArrayList<PortfolioFile> portfolios = new ArrayList();
        String[] split;
        PortfolioFile portfolio;
        while(scan.hasNext()){
            split = scan.nextLine().split(",");
            portfolio = new PortfolioFile(Integer.parseInt(split[0]),split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]));
            portfolios.add(portfolio);
        }
        return portfolios;
    }
}

