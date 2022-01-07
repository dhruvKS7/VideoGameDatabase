/*
Dhruv K. Saligram
10/13/18
This class looks for all of the prices based on a user given condition
*/
package videogameapplication;
//Imports below:
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
//Creating class below:
public class BestPriceFinder {
    //Declaring instance variables below:
    private Object[][] gameInfoData;
    private Object[][] priceInfoData;
    //Creating method to receive booleans and user input and return an int - booleans represent which condition user gave to calculate price below:
    public int calculateBestPrice(boolean gameName, boolean gameEdition, boolean publisher, boolean exclusiveType, boolean yearPublished, String input) {
        //Creating and initializing local variables below:
        int finalLowestPrice = 0;
        String[] answers = new String[2];
        Connection myDbConn;
        //Creating string arrays to pass variables to receive from database tables below:
        String[] gameInfoHeaders = {"gameName", "gameEdition", "publisher", "exclusiveType", "yearPublished"};
        String[] priceInfoHeaders = {"gameEdition", "gameStopPrice", "ebayPrice", "amazonPrice", "walmartPrice"};
        //Creating connection to database below:
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        myDbConn = dbObj.getDbConn();
        //Creating variables to execute a select statement below:
        int columnCount = gameInfoHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM gameInfo";
        ArrayList<ArrayList<String>> gameDataList = new ArrayList<>();
        try {
            //Getting data from tables below:
            s = myDbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 0; i < columnCount; i++) {
                    row.add(rs.getString(gameInfoHeaders[i]));
                }
                gameDataList.add(row);
            }
            this.gameInfoData = new Object[gameDataList.size()][columnCount];
            for (int i = 0; i < gameDataList.size(); i++) {
                ArrayList<String> row;
                row = gameDataList.get(i);
                for (int j = 0; j < columnCount; j++) {
                    this.gameInfoData[i][j] = row.get(j);
                }
            }
        }
        //Catching SQL exceptions below:
        catch (SQLException e) {
            answers[0] = "ERROR";
        }
        //Creating array list below:
        ArrayList<Object> gameEditionObject = new ArrayList<Object>();
        //Setting array list values to game editions below:
        for (int i = 0; i < gameInfoData.length; i++) {
            gameEditionObject.add(gameInfoData[i][1]);
        }
        //Creating array list below:
        ArrayList<String> gameInfoStrings = new ArrayList<String>(gameEditionObject.size());
        //Converting object array list to string array list below:
        for (Object object : gameEditionObject) {
            gameInfoStrings.add(Objects.toString(object, null));
        }
        //Creating variables to execute a select statement below:
        columnCount = priceInfoHeaders.length;
        dbQuery = "SELECT * FROM priceInfo";
        ArrayList<ArrayList<String>> priceDataList = new ArrayList<>();
        try {
            //Getting data from tables below:
            s = myDbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 0; i < columnCount; i++) {
                    row.add(rs.getString(priceInfoHeaders[i]));
                }
                priceDataList.add(row);
            }
            this.priceInfoData = new Object[priceDataList.size()][columnCount];
            for (int i = 0; i < priceDataList.size(); i++) {
                ArrayList<String> row;
                row = priceDataList.get(i);
                for (int j = 0; j < columnCount; j++) {
                    this.priceInfoData[i][j] = row.get(j);
                }
            }
        }
        //Catching SQL exceptions below:
        catch (SQLException e) {
            answers[0] = "ERROR";
        }
        //Testing if user given condition was based on game name below:
        if (gameName == true) {
            ArrayList<Object> editionPriceCalculationObject = new ArrayList<Object>();
            ArrayList<Integer> bestPrices = new ArrayList<Integer>();
            //Testing if user input matches game name below:
            for (int w = 0; w < gameInfoData.length; w++) {
                if (gameInfoData[w][0].equals(input)) {
                    //Adding game edition to array list below:
                    editionPriceCalculationObject.add(gameInfoData[w][1]);
                }
            }
            //Converting object array list to string array list below:
            String[] editionPriceCalculation = editionPriceCalculationObject.toArray(new String[editionPriceCalculationObject.size()]);
            //Setting objects to 2D array values below:
            for (int h=0; h<priceInfoData.length; h++) {
                for (int t=0; t<editionPriceCalculation.length; t++) {
                    if (editionPriceCalculation[t].equals(priceInfoData[h][0])) {
                        Object gameStopPriceObject = priceInfoData[h][1];
                        Object ebayPriceObject = priceInfoData[h][2];
                        Object amazonPriceObject = priceInfoData[h][3];
                        Object walmartPriceObject = priceInfoData[h][4];
                        //Converting object to string below:
                        String gameStopPriceString = gameStopPriceObject.toString();
                        String ebayPriceString = ebayPriceObject.toString();
                        String amazonPriceString = amazonPriceObject.toString();
                        String walmartPriceString = walmartPriceObject.toString();
                        //Setting string to int below:
                        int gameStopPrice = Integer.parseInt(gameStopPriceString);
                        int ebayPrice = Integer.parseInt(ebayPriceString);
                        int amazonPrice = Integer.parseInt(amazonPriceString);
                        int walmartPrice = Integer.parseInt(walmartPriceString);
                        //Adding ints to int array list below:
                        int[] prices = {gameStopPrice, ebayPrice, amazonPrice, walmartPrice};
                        LowestPriceCalculation calculate = new LowestPriceCalculation();
                        //Calculating best price below:
                        int bestPrice = calculate.lowestPrice(prices);
                        //Adding price to array list below:
                        bestPrices.add(bestPrice);
                    }
                }
            }
            LowestPriceCalculation calculate = new LowestPriceCalculation();
            //Calculating final lowest price below:
            finalLowestPrice = calculate.finalLowestCalculation(bestPrices);
        }
        //Testing if user given condition was based on game edition below:
        else if (gameEdition == true) {
            ArrayList<Object> editionPriceCalculationObject = new ArrayList<Object>();
            ArrayList<Integer> bestPrices = new ArrayList<Integer>();
            //Testing if user input matches game edition below:
            for (int w = 0; w < gameInfoData.length; w++) {
                if (gameInfoData[w][1].equals(input)) {
                    editionPriceCalculationObject.add(gameInfoData[w][1]);
                }
            }
            //Converting object array list to string array list below:
            String[] editionPriceCalculation = editionPriceCalculationObject.toArray(new String[editionPriceCalculationObject.size()]);
            //Setting objects to 2D array values below:
            for (int h=0; h<priceInfoData.length; h++) {
                for (int t=0; t<editionPriceCalculation.length; t++) {
                    if (editionPriceCalculation[t].equals(priceInfoData[h][0])) {
                        Object gameStopPriceObject = priceInfoData[h][1];
                        Object ebayPriceObject = priceInfoData[h][2];
                        Object amazonPriceObject = priceInfoData[h][3];
                        Object walmartPriceObject = priceInfoData[h][4];
                        //Converting object to string below:
                        String gameStopPriceString = gameStopPriceObject.toString();
                        String ebayPriceString = ebayPriceObject.toString();
                        String amazonPriceString = amazonPriceObject.toString();
                        String walmartPriceString = walmartPriceObject.toString();
                        //Setting string to int below:
                        int gameStopPrice = Integer.parseInt(gameStopPriceString);
                        int ebayPrice = Integer.parseInt(ebayPriceString);
                        int amazonPrice = Integer.parseInt(amazonPriceString);
                        int walmartPrice = Integer.parseInt(walmartPriceString);
                        //Adding ints to int array list below:
                        int[] prices = {gameStopPrice, ebayPrice, amazonPrice, walmartPrice};
                        LowestPriceCalculation calculate = new LowestPriceCalculation();
                        //Calculating best price below:
                        int bestPrice = calculate.lowestPrice(prices);
                        //Adding price to array list below:
                        bestPrices.add(bestPrice);
                    }
                }
            }
            LowestPriceCalculation calculate = new LowestPriceCalculation();
            //Calculating final lowest price below:
            finalLowestPrice = calculate.finalLowestCalculation(bestPrices);
        }
        //Testing if user given condition was based on publisher below:
        else if (publisher == true) {
            ArrayList<Object> editionPriceCalculationObject = new ArrayList<Object>();
            ArrayList<Integer> bestPrices = new ArrayList<Integer>();
            //Testing if user input matches game edition below:
            for (int w = 0; w < gameInfoData.length; w++) {
                if (gameInfoData[w][2].equals(input)) {
                    editionPriceCalculationObject.add(gameInfoData[w][1]);
                }
            }
            //Converting object array list to string array list below:
            String[] editionPriceCalculation = editionPriceCalculationObject.toArray(new String[editionPriceCalculationObject.size()]);
            //Setting objects to 2D array values below:
            for (int h=0; h<priceInfoData.length; h++) {
                for (int t=0; t<editionPriceCalculation.length; t++) {
                    if (editionPriceCalculation[t].equals(priceInfoData[h][0])) {
                        Object gameStopPriceObject = priceInfoData[h][1];
                        Object ebayPriceObject = priceInfoData[h][2];
                        Object amazonPriceObject = priceInfoData[h][3];
                        Object walmartPriceObject = priceInfoData[h][4];
                        //Converting object to string below:
                        String gameStopPriceString = gameStopPriceObject.toString();
                        String ebayPriceString = ebayPriceObject.toString();
                        String amazonPriceString = amazonPriceObject.toString();
                        String walmartPriceString = walmartPriceObject.toString();
                        //Setting string to int below:
                        int gameStopPrice = Integer.parseInt(gameStopPriceString);
                        int ebayPrice = Integer.parseInt(ebayPriceString);
                        int amazonPrice = Integer.parseInt(amazonPriceString);
                        int walmartPrice = Integer.parseInt(walmartPriceString);
                        //Adding ints to int array list below:
                        int[] prices = {gameStopPrice, ebayPrice, amazonPrice, walmartPrice};
                        LowestPriceCalculation calculate = new LowestPriceCalculation();
                        //Calculating best price below:
                        int bestPrice = calculate.lowestPrice(prices);
                        //Adding price to array list below:
                        bestPrices.add(bestPrice);
                    }
                }
            }
            LowestPriceCalculation calculate = new LowestPriceCalculation();
            //Calculating final lowest price below:
            finalLowestPrice = calculate.finalLowestCalculation(bestPrices);
        }
        //Testing if user given condition was based on exclusive type below:
        else if (exclusiveType == true) {
            ArrayList<Object> editionPriceCalculationObject = new ArrayList<Object>();
            ArrayList<Integer> bestPrices = new ArrayList<Integer>();
            //Testing if user input matches exclusive type below:
            for (int w = 0; w < gameInfoData.length; w++) {
                if (gameInfoData[w][3].equals(input)) {
                    editionPriceCalculationObject.add(gameInfoData[w][1]);
                }
            }
            //Converting object array to string array below:
            String[] editionPriceCalculation = editionPriceCalculationObject.toArray(new String[editionPriceCalculationObject.size()]);
            //Assigning objects to 2D array values below:
            for (int h = 0; h < priceInfoData.length; h++) {
                for (int t = 0; t < editionPriceCalculation.length; t++) {
                    if (editionPriceCalculation[t].equals(priceInfoData[h][0])) {
                        Object gameStopPriceObject = priceInfoData[h][1];
                        Object ebayPriceObject = priceInfoData[h][2];
                        Object amazonPriceObject = priceInfoData[h][3];
                        Object walmartPriceObject = priceInfoData[h][4];
                        //Converting object to string below:
                        String gameStopPriceString = gameStopPriceObject.toString();
                        String ebayPriceString = ebayPriceObject.toString();
                        String amazonPriceString = amazonPriceObject.toString();
                        String walmartPriceString = walmartPriceObject.toString();
                        //Converting string to int below:
                        int gameStopPrice = Integer.parseInt(gameStopPriceString);
                        int ebayPrice = Integer.parseInt(ebayPriceString);
                        int amazonPrice = Integer.parseInt(amazonPriceString);
                        int walmartPrice = Integer.parseInt(walmartPriceString);
                        //Adding int to int array below:
                        int[] prices = {gameStopPrice, ebayPrice, amazonPrice, walmartPrice};
                        //Calulating lowest price below:
                        LowestPriceCalculation calculate = new LowestPriceCalculation();
                        int bestPrice = calculate.lowestPrice(prices);
                        //Adding price to array list below:
                        bestPrices.add(bestPrice);
                    }
                }
            }
            //Calculating actual lowest price based on all prices below:
            LowestPriceCalculation calculate = new LowestPriceCalculation();
            finalLowestPrice = calculate.finalLowestCalculation(bestPrices);
        }
        //Testing if user given condition was based on year published below:
        else if (yearPublished == true) {
            ArrayList<Object> editionPriceCalculationObject = new ArrayList<Object>();
            ArrayList<Integer> bestPrices = new ArrayList<Integer>();
            //Testing if user input matches year published below:
            for (int w = 0; w < gameInfoData.length; w++) {
                if (gameInfoData[w][4].equals(input)) {
                    editionPriceCalculationObject.add(gameInfoData[w][1]);
                }
            }
            //Converting object array to string array below:
            String[] editionPriceCalculation = editionPriceCalculationObject.toArray(new String[editionPriceCalculationObject.size()]);
            //Assigning objects to 2D array values below:
            for (int h = 0; h < priceInfoData.length; h++) {
                for (int t = 0; t < editionPriceCalculation.length; t++) {
                    if (editionPriceCalculation[t].equals(priceInfoData[h][0])) {
                        Object gameStopPriceObject = priceInfoData[h][1];
                        Object ebayPriceObject = priceInfoData[h][2];
                        Object amazonPriceObject = priceInfoData[h][3];
                        Object walmartPriceObject = priceInfoData[h][4];
                        //Converting object to string below:
                        String gameStopPriceString = gameStopPriceObject.toString();
                        String ebayPriceString = ebayPriceObject.toString();
                        String amazonPriceString = amazonPriceObject.toString();
                        String walmartPriceString = walmartPriceObject.toString();
                        //Converting string to int below:
                        int gameStopPrice = Integer.parseInt(gameStopPriceString);
                        int ebayPrice = Integer.parseInt(ebayPriceString);
                        int amazonPrice = Integer.parseInt(amazonPriceString);
                        int walmartPrice = Integer.parseInt(walmartPriceString);
                        //Adding int to int array below:
                        int[] prices = {gameStopPrice, ebayPrice, amazonPrice, walmartPrice};
                        //Calculating best price below:
                        LowestPriceCalculation calculate = new LowestPriceCalculation();
                        int bestPrice = calculate.lowestPrice(prices);
                        //Adding best price to array list below:
                        bestPrices.add(bestPrice);
                    }
                }
            }
            //Calculating actual lowest price below:
            LowestPriceCalculation calculate = new LowestPriceCalculation();
            finalLowestPrice = calculate.finalLowestCalculation(bestPrices);
        }
        //Returning lowest price to class below:
        return finalLowestPrice;
    }
}