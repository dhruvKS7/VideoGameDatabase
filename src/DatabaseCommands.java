/*
Dhruv K. Saligram
10/13/18
This class carries out 4 major database commands for all 3 tables
*/
package videogameapplication;
//Imports below:
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Creating class below:
public class DatabaseCommands {
    //Creating method for inserting into game table below:
    public static boolean insertGameTable (String gameName, String gameEdition, String publisher, String exclusiveType, int yearPublished, int copiesSold) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        String query;
        query = "INSERT INTO gameInfo VALUES (?, ?, ?, ?, ?, ?)";
        try {
            //Executing prepared statement below:
            PreparedStatement executeStatement = myDbConn.prepareStatement(query);
            executeStatement.setString(1, gameName);
            executeStatement.setString(2, gameEdition);
            executeStatement.setString(3, publisher);
            executeStatement.setString(4, exclusiveType);
            executeStatement.setInt(5, yearPublished);
            executeStatement.setInt(6, copiesSold);
            executeStatement.executeUpdate();
        }
        //Catching SQL exceptions below:
        catch (SQLException e) {
            acceptedValues = false;
        }
        return acceptedValues;
    }
    //Creating method for inserting into price table below:
    public static boolean insertPriceTable (String gameEdition, String ebayPrice, String gameStopPrice, String walmartPrice, String amazonPrice) {
        //Creating and initialzing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        String query;
        query = "INSERT INTO priceInfo VALUES (?, ?, ?, ?, ?)";
        try {
            //Executing prepared statement below:
            PreparedStatement executeStatement = myDbConn.prepareStatement(query);
            executeStatement.setString(1, gameEdition);
            executeStatement.setString(2, gameStopPrice);
            executeStatement.setString(3, ebayPrice);
            executeStatement.setString(4, amazonPrice);
            executeStatement.setString(5, walmartPrice);
            executeStatement.executeUpdate();
        }
        //Catching SQL exception below:
        catch (SQLException e) {
            acceptedValues = false;
        }
        return acceptedValues;
    }
    //Creating method for inserting into exclusivity table below:
    public static boolean insertExclusivityTable (String exclusiveType, String ps4Compatibility, String xboxOneCompatibility, String pcCompatibility) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        String query;
        query = "INSERT INTO exclusivity VALUES (?, ?, ?, ?)";
        try {
            //Executing prepared statement below:
            PreparedStatement executeStatement = myDbConn.prepareStatement(query);
            executeStatement.setString(1, exclusiveType);
            executeStatement.setString(2, ps4Compatibility);
            executeStatement.setString(3, xboxOneCompatibility);
            executeStatement.setString(4, pcCompatibility);
            executeStatement.executeUpdate();
        }
        //Catching SQL exception below:
        catch (SQLException e) {
            acceptedValues = false;
        }
        return acceptedValues;
    }
    
    //Creating method for deleting data from game table below:
    public static boolean deleteGameTable (String gameName, String gameEdition, String publisher, String exclusiveType, int yearPublished, int copiesSold) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        //Creating potential querys below:
        String gameNameQuery = "DELETE FROM gameInfo WHERE gameName = ?";
        String gameEditionQuery = "DELETE FROM gameInfo WHERE gameEdition = ?";
        String publisherQuery = "DELETE FROM gameInfo WHERE publisher = ?";
        String exclusiveTypeQuery = "DELETE FROM gameInfo WHERE exclusiveType = ?";
        String yearPublishedQuery = "DELETE FROM gameInfo WHERE yearPublished = ?";
        String copiesSoldQuery = "DELETE FROM gameInfo WHERE copiesSold = ?";
        
        //Testing for deleting exclusive type below:
        if (exclusiveType.equals("")) { 
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeExclusiveTypeStatement = myDbConn.prepareStatement(exclusiveTypeQuery);
                executeExclusiveTypeStatement.setString(1, exclusiveType);
                executeExclusiveTypeStatement.executeUpdate();
            }
            //Catching SQL exceptions below:
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting game name below:
        if (gameName.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeGameNameStatement = myDbConn.prepareStatement(gameNameQuery);
                executeGameNameStatement.setString(1, gameName);
                executeGameNameStatement.executeUpdate();
            }
            //Catching SQL exceptions below:
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting game edition below:
        if (gameEdition.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeGameEditionStatement = myDbConn.prepareStatement(gameEditionQuery);
                executeGameEditionStatement.setString(1, gameEdition);
                executeGameEditionStatement.executeUpdate();
            }
            //Catching SQL exceptions below:
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting publisher below:
        if (publisher.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executePublisherStatement = myDbConn.prepareStatement(publisherQuery);
                executePublisherStatement.setString(1, publisher);
                executePublisherStatement.executeUpdate();
            }
            //Catching SQL exceptions below:
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting year published below:
        if (yearPublished == 0) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeYearPublishedStatement = myDbConn.prepareStatement(yearPublishedQuery);
                executeYearPublishedStatement.setInt(1, yearPublished);
                executeYearPublishedStatement.executeUpdate();
            }
            //Catching SQL exceptions below:
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting copies sold below:
        if (copiesSold == 0) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeCopiesSoldStatement = myDbConn.prepareStatement(copiesSoldQuery);
                executeCopiesSoldStatement.setInt(1, copiesSold);
                executeCopiesSoldStatement.executeUpdate();
            }
            //Catching SQL exceptions below:
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Returning boolean below:
        return acceptedValues;
    }
    //Creating method for deleting data from price table below:
    public static boolean deletePriceTable (String gameEdition, String ebayPrice, String gameStopPrice, String walmartPrice, String amazonPrice) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        //Creating potential querys below:
        String gameEditionQuery = "DELETE FROM priceInfo WHERE gameEdition = ?";
        String ebayPriceQuery = "DELETE FROM priceInfo WHERE ebayPrice = ?";
        String gameStopPriceQuery = "DELETE FROM priceInfo WHERE gameStopPrice = ?";
        String amazonPriceQuery = "DELETE FROM priceInfo WHERE amazonPrice = ?";
        String walmartPriceQuery = "DELETE FROM priceInfo WHERE walmartPrice = ?";
        //Testing for deleting game edition below:
        if (gameEdition.equals("")) { 
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeGameEditionStatement = myDbConn.prepareStatement(gameEditionQuery);
                executeGameEditionStatement.setString(1, gameEdition);
                executeGameEditionStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting ebay price below:
        if (ebayPrice.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeEbayPriceStatement = myDbConn.prepareStatement(ebayPriceQuery);
                executeEbayPriceStatement.setString(1, ebayPrice);
                executeEbayPriceStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting gamestop price below:
        if (gameStopPrice.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeGameStopPriceStatement = myDbConn.prepareStatement(gameStopPriceQuery);
                executeGameStopPriceStatement.setString(1, gameStopPrice);
                executeGameStopPriceStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting amazon price below:
        if (amazonPrice.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeAmazonPriceStatement = myDbConn.prepareStatement(amazonPriceQuery);
                executeAmazonPriceStatement.setString(1, amazonPrice);
                executeAmazonPriceStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting walmart price below:
        if (walmartPrice.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeWalmartPriceStatement = myDbConn.prepareStatement(walmartPriceQuery);
                executeWalmartPriceStatement.setString(1, walmartPrice);
                executeWalmartPriceStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        return acceptedValues;
    }
    //Creating method for deleting data from exclusivity table below:
    public static boolean deleteExclusivityTable (String exclusiveType, String ps4Compatibility, String xboxOneCompatibility, String pcCompatibility) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        //Creating potential querys below:
        String ps4CompatibilityQuery = "DELETE FROM exclusivity WHERE ps4Compatibility = ?";
        String xboxOneCompatibilityQuery = "DELETE FROM exclusivity WHERE xboxOneCompatibility = ?";
        String pcCompatibilityQuery = "DELETE FROM exclusivity WHERE pcCompatibility = ?";
        String exclusiveTypeQuery = "DELETE FROM exclusivity WHERE exclusiveType = ?";
        //Testing for deleting exclusive type below:
        if (exclusiveType.equals("")) { 
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeExclusiveTypeStatement = myDbConn.prepareStatement(exclusiveTypeQuery);
                executeExclusiveTypeStatement.setString(1, exclusiveType);
                executeExclusiveTypeStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting ps4 compatibility below:
        if (ps4Compatibility.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executePs4CompatibilityStatement = myDbConn.prepareStatement(ps4CompatibilityQuery);
                executePs4CompatibilityStatement.setString(1, ps4Compatibility);
                executePs4CompatibilityStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting xboxone compatibility below:
        if (xboxOneCompatibility.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executeXboxOneCompatibilityStatement = myDbConn.prepareStatement(xboxOneCompatibilityQuery);
                executeXboxOneCompatibilityStatement.setString(1, xboxOneCompatibility);
                executeXboxOneCompatibilityStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Testing for deleting pc compatibility below:
        if (pcCompatibility.equals("")) {
        }
        else {
            try {
                //Executing prepared statement below:
                PreparedStatement executePcCompatibilityStatement = myDbConn.prepareStatement(pcCompatibilityQuery);
                executePcCompatibilityStatement.setString(1, pcCompatibility);
                executePcCompatibilityStatement.executeUpdate();
            }
            catch (SQLException e) {
                acceptedValues = false;
            }
        }
        //Returning boolean below:
        return acceptedValues;
    }
    
    //Creating method for updating game table below:
    public static boolean updateGameTable (String setGameName, String setGameEdition, String setPublisher, String setExclusiveType, int setYearPublished, int setCopiesSold, String whereGameName, String whereGameEdition, String wherePublisher, String whereExclusiveType, int whereYearPublished, int whereCopiesSold) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        //Creating potential querys below:
        String setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE ? = ?";
        String setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE ? = ?";
        String setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE ? = ?";
        String setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE ? = ?";
        String setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE ? = ?";
        String setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE ? = ?";
        //Testing to set exclusive type below:
        if (setExclusiveType.equals("")){
        }
        else {
            //Testing to check game name below:
            if (whereGameName.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE gameName = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, whereGameName);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check game edition below:
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, whereGameEdition);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check exclusive type below:
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, whereExclusiveType);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check publisher below:
            if (wherePublisher.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE publisher = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, wherePublisher);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check year published below:
            if (whereYearPublished == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE yearPublished = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setInt(2, whereYearPublished);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check copies sold below:
            if (whereCopiesSold == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE gameInfo SET exclusiveType = ? WHERE copiesSold = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setInt(2, whereCopiesSold);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set game edition below:
        if (setGameEdition.equals("")){
        }
        else {
            //Testing to check game name below:
            if (whereGameName.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE gameName = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereGameName);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check game edition below:
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereGameEdition);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check exclusive type below:
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereExclusiveType);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check publisher below:
            if (wherePublisher.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE publisher = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, wherePublisher);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check year published below:
            if (whereYearPublished == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE yearPublished = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setInt(2, whereYearPublished);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check copies sold below:
            if (whereCopiesSold == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE gameInfo SET gameEdition = ? WHERE copiesSold = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setInt(2, whereCopiesSold);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set game name below:
        if (setGameName.equals("")){
        }
        else {
            //Testing to check game name below:
            if (whereGameName.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE gameName = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameNameQuery);
                    executeSetGameNameStatement.setString(1, setGameName);
                    executeSetGameNameStatement.setString(2, whereGameName);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check game edition below:
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameNameQuery);
                    executeSetGameNameStatement.setString(1, setGameName);
                    executeSetGameNameStatement.setString(2, whereGameEdition);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check exclusive type below:
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameNameQuery);
                    executeSetGameNameStatement.setString(1, setGameName);
                    executeSetGameNameStatement.setString(2, whereExclusiveType);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check publisher below:
            if (wherePublisher.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE publisher = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameNameQuery);
                    executeSetGameNameStatement.setString(1, setGameName);
                    executeSetGameNameStatement.setString(2, wherePublisher);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check year published below:
            if (whereYearPublished == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE yearPublished = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameNameQuery);
                    executeSetGameNameStatement.setString(1, setGameName);
                    executeSetGameNameStatement.setInt(2, whereYearPublished);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check copies sold below:
            if (whereCopiesSold == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameNameQuery = "UPDATE gameInfo SET gameName = ? WHERE copiesSold = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameNameQuery);
                    executeSetGameNameStatement.setString(1, setGameName);
                    executeSetGameNameStatement.setInt(2, whereCopiesSold);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set publisher below:
        if (setPublisher.equals("")){
        }
        else {
            //Testing to check game name below:
            if (whereGameName.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE gameName = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPublisherQuery);
                    executeSetPublisherStatement.setString(1, setPublisher);
                    executeSetPublisherStatement.setString(2, whereGameName);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check game edition below:
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPublisherQuery);
                    executeSetPublisherStatement.setString(1, setPublisher);
                    executeSetPublisherStatement.setString(2, whereGameEdition);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check exclusive type below:
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPublisherQuery);
                    executeSetPublisherStatement.setString(1, setPublisher);
                    executeSetPublisherStatement.setString(2, whereExclusiveType);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check publisher below:
            if (wherePublisher.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE publisher = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPublisherQuery);
                    executeSetPublisherStatement.setString(1, setPublisher);
                    executeSetPublisherStatement.setString(2, wherePublisher);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check year published below:
            if (whereYearPublished == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE yearPublished = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPublisherQuery);
                    executeSetPublisherStatement.setString(1, setPublisher);
                    executeSetPublisherStatement.setInt(2, whereYearPublished);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check copies sold below:
            if (whereCopiesSold == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPublisherQuery = "UPDATE gameInfo SET publisher = ? WHERE copiesSold = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPublisherQuery);
                    executeSetPublisherStatement.setString(1, setPublisher);
                    executeSetPublisherStatement.setInt(2, whereCopiesSold);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set year published below:
        if (setYearPublished == 0){
        }
        else {
            //Testing to check game name below:
            if (whereGameName.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE gameName = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setYearPublishedQuery);
                    executeSetYearPublishedStatement.setInt(1, setYearPublished);
                    executeSetYearPublishedStatement.setString(2, whereGameName);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check game edition below:
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setYearPublishedQuery);
                    executeSetYearPublishedStatement.setInt(1, setYearPublished);
                    executeSetYearPublishedStatement.setString(2, whereGameEdition);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check exclusive type below:
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setYearPublishedQuery);
                    executeSetYearPublishedStatement.setInt(1, setYearPublished);
                    executeSetYearPublishedStatement.setString(2, whereExclusiveType);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check publisher below:
            if (wherePublisher.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE publisher = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setYearPublishedQuery);
                    executeSetYearPublishedStatement.setInt(1, setYearPublished);
                    executeSetYearPublishedStatement.setString(2, wherePublisher);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check year published below:
            if (whereYearPublished == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE yearPublished = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setYearPublishedQuery);
                    executeSetYearPublishedStatement.setInt(1, setYearPublished);
                    executeSetYearPublishedStatement.setInt(2, whereYearPublished);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check copies sold below:
            if (whereCopiesSold == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setYearPublishedQuery = "UPDATE gameInfo SET yearPublished = ? WHERE copiesSold = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setYearPublishedQuery);
                    executeSetYearPublishedStatement.setInt(1, setYearPublished);
                    executeSetYearPublishedStatement.setInt(2, whereCopiesSold);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set copies sold below:
        if (setCopiesSold == 0){
        }
        else {
            //Testing to check game name below:
            if (whereGameName.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE gameName = ?";
                    PreparedStatement executeSetCopiesSoldStatement = myDbConn.prepareStatement(setCopiesSoldQuery);
                    executeSetCopiesSoldStatement.setInt(1, setCopiesSold);
                    executeSetCopiesSoldStatement.setString(2, whereGameName);
                    executeSetCopiesSoldStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check game edition below:
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetCopiesSoldStatement = myDbConn.prepareStatement(setCopiesSoldQuery);
                    executeSetCopiesSoldStatement.setInt(1, setCopiesSold);
                    executeSetCopiesSoldStatement.setString(2, whereGameEdition);
                    executeSetCopiesSoldStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check exclusive type below:
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetCopiesSoldStatement = myDbConn.prepareStatement(setCopiesSoldQuery);
                    executeSetCopiesSoldStatement.setInt(1, setCopiesSold);
                    executeSetCopiesSoldStatement.setString(2, whereExclusiveType);
                    executeSetCopiesSoldStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check publisher below:
            if (wherePublisher.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE publisher = ?";
                    PreparedStatement executeSetCopiesSoldStatement = myDbConn.prepareStatement(setCopiesSoldQuery);
                    executeSetCopiesSoldStatement.setInt(1, setCopiesSold);
                    executeSetCopiesSoldStatement.setString(2, wherePublisher);
                    executeSetCopiesSoldStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check year published below:
            if (whereYearPublished == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE yearPublished = ?";
                    PreparedStatement executeSetCopiesSoldStatement = myDbConn.prepareStatement(setCopiesSoldQuery);
                    executeSetCopiesSoldStatement.setInt(1, setCopiesSold);
                    executeSetCopiesSoldStatement.setInt(2, whereYearPublished);
                    executeSetCopiesSoldStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            //Testing to check copies sold below:
            if (whereCopiesSold == 0) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setCopiesSoldQuery = "UPDATE gameInfo SET copiesSold = ? WHERE copiesSold = ?";
                    PreparedStatement executeSetCopiesSoldStatement = myDbConn.prepareStatement(setCopiesSoldQuery);
                    executeSetCopiesSoldStatement.setInt(1, setCopiesSold);
                    executeSetCopiesSoldStatement.setInt(2, whereCopiesSold);
                    executeSetCopiesSoldStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Returning boolean below:
        return acceptedValues;
    }
    //Creating method for updating price table below:
    public static boolean updatePriceTable (String setGameEdition, String setEbayPrice, String setGameStopPrice, String setWalmartPrice, String setAmazonPrice, String whereGameEdition, String whereEbayPrice, String whereGameStopPrice, String whereWalmartPrice, String whereAmazonPrice) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        //Creating potential querys below:
        String setGameEditionQuery = "UPDATE priceInfo SET gameEdition = ? WHERE ? = ?";
        String setEbayPriceQuery = "UPDATE priceInfo SET ebayPrice = ? WHERE ? = ?";
        String setGameStopPriceQuery = "UPDATE priceInfo SET gameStopPrice = ? WHERE ? = ?";
        String setWalmartPriceQuery = "UPDATE priceInfo SET walmartPrice = ? WHERE ? = ?";
        String setAmazonPriceQuery = "UPDATE priceInfo SET amazonPrice = ? WHERE ? = ?";
        //Testing to set ebay price below:
        if (setEbayPrice.equals("")){
        }
        else {
            if (whereEbayPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setEbayPriceQuery = "UPDATE priceInfo SET ebayPrice = ? WHERE ebayPrice = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setEbayPriceQuery);
                    executeSetExclusiveTypeStatement.setString(1, setEbayPrice);
                    executeSetExclusiveTypeStatement.setString(2, whereEbayPrice);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setEbayPriceQuery = "UPDATE priceInfo SET ebayPrice = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setEbayPriceQuery);
                    executeSetExclusiveTypeStatement.setString(1, setEbayPrice);
                    executeSetExclusiveTypeStatement.setString(2, whereGameEdition);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereAmazonPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setEbayPriceQuery = "UPDATE priceInfo SET ebayPrice = ? WHERE amazonPrice = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setEbayPriceQuery);
                    executeSetExclusiveTypeStatement.setString(1, setEbayPrice);
                    executeSetExclusiveTypeStatement.setString(2, whereAmazonPrice);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameStopPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setEbayPriceQuery = "UPDATE priceInfo SET ebayPrice = ? WHERE gameStopPrice = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setEbayPriceQuery);
                    executeSetExclusiveTypeStatement.setString(1, setEbayPrice);
                    executeSetExclusiveTypeStatement.setString(2, whereGameStopPrice);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereWalmartPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setEbayPriceQuery = "UPDATE priceInfo SET ebayPrice = ? WHERE walmartPrice = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setEbayPriceQuery);
                    executeSetExclusiveTypeStatement.setString(1, setEbayPrice);
                    executeSetExclusiveTypeStatement.setString(2, whereWalmartPrice);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set game edition below:
        if (setGameEdition.equals("")){
        }
        else {
            if (whereEbayPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE priceInfo SET gameEdition = ? WHERE ebayPrice = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereEbayPrice);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE priceInfo SET gameEdition = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereGameEdition);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereAmazonPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE priceInfo SET gameEdition = ? WHERE amazonPrice = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereAmazonPrice);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameStopPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE priceInfo SET gameEdition = ? WHERE gameStopPrice = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereGameStopPrice);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereWalmartPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameEditionQuery = "UPDATE priceInfo SET gameEdition = ? WHERE walmartPrice = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setGameEditionQuery);
                    executeSetGameEditionStatement.setString(1, setGameEdition);
                    executeSetGameEditionStatement.setString(2, whereWalmartPrice);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set gamestop price below:
        if (setGameStopPrice.equals("")){
        }
        else {
            if (whereEbayPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameStopPriceQuery = "UPDATE priceInfo SET gameStopPrice = ? WHERE ebayPrice = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameStopPriceQuery);
                    executeSetGameNameStatement.setString(1, setGameStopPrice);
                    executeSetGameNameStatement.setString(2, whereEbayPrice);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameStopPriceQuery = "UPDATE priceInfo SET gameStopPrice = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameStopPriceQuery);
                    executeSetGameNameStatement.setString(1, setGameStopPrice);
                    executeSetGameNameStatement.setString(2, whereGameEdition);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereAmazonPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameStopPriceQuery = "UPDATE priceInfo SET gameStopPrice = ? WHERE amazonPrice = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameStopPriceQuery);
                    executeSetGameNameStatement.setString(1, setGameStopPrice);
                    executeSetGameNameStatement.setString(2, whereAmazonPrice);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameStopPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameStopPriceQuery = "UPDATE priceInfo SET gameStopPrice = ? WHERE gameStopPrice = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameStopPriceQuery);
                    executeSetGameNameStatement.setString(1, setGameStopPrice);
                    executeSetGameNameStatement.setString(2, whereGameStopPrice);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereWalmartPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setGameStopPriceQuery = "UPDATE priceInfo SET gameStopPrice = ? WHERE walmartPrice = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setGameStopPriceQuery);
                    executeSetGameNameStatement.setString(1, setGameStopPrice);
                    executeSetGameNameStatement.setString(2, whereWalmartPrice);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set walmart price below:
        if (setWalmartPrice.equals("")){
        }
        else {
            if (whereEbayPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setWalmartPriceQuery = "UPDATE priceInfo SET walmartPrice = ? WHERE ebayPrice = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setWalmartPriceQuery);
                    executeSetPublisherStatement.setString(1, setWalmartPrice);
                    executeSetPublisherStatement.setString(2, whereEbayPrice);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setWalmartPriceQuery = "UPDATE priceInfo SET walmartPrice = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setWalmartPriceQuery);
                    executeSetPublisherStatement.setString(1, setWalmartPrice);
                    executeSetPublisherStatement.setString(2, whereGameEdition);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereAmazonPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setWalmartPriceQuery = "UPDATE priceInfo SET walmartPrice = ? WHERE amazonPrice = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setWalmartPriceQuery);
                    executeSetPublisherStatement.setString(1, setWalmartPrice);
                    executeSetPublisherStatement.setString(2, whereAmazonPrice);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameStopPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setWalmartPriceQuery = "UPDATE priceInfo SET walmartPrice = ? WHERE gameStopPrice = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setWalmartPriceQuery);
                    executeSetPublisherStatement.setString(1, setWalmartPrice);
                    executeSetPublisherStatement.setString(2, whereGameStopPrice);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereWalmartPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setWalmartPriceQuery = "UPDATE priceInfo SET walmartPrice = ? WHERE walmartPrice = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setWalmartPriceQuery);
                    executeSetPublisherStatement.setString(1, setWalmartPrice);
                    executeSetPublisherStatement.setString(2, whereWalmartPrice);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to set amazon price below:
        if (setAmazonPrice.equals("")){
        }
        else {
            if (whereEbayPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setAmazonPriceQuery = "UPDATE priceInfo SET amazonPrice = ? WHERE ebayPrice = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setAmazonPriceQuery);
                    executeSetYearPublishedStatement.setString(1, setAmazonPrice);
                    executeSetYearPublishedStatement.setString(2, whereEbayPrice);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameEdition.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setAmazonPriceQuery = "UPDATE priceInfo SET amazonPrice = ? WHERE gameEdition = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setAmazonPriceQuery);
                    executeSetYearPublishedStatement.setString(1, setAmazonPrice);
                    executeSetYearPublishedStatement.setString(2, whereGameEdition);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereAmazonPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setAmazonPriceQuery = "UPDATE priceInfo SET amazonPrice = ? WHERE amazonPrice = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setAmazonPriceQuery);
                    executeSetYearPublishedStatement.setString(1, setAmazonPrice);
                    executeSetYearPublishedStatement.setString(2, whereAmazonPrice);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereGameStopPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setAmazonPriceQuery = "UPDATE priceInfo SET amazonPrice = ? WHERE gameStopPrice = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setAmazonPriceQuery);
                    executeSetYearPublishedStatement.setString(1, setAmazonPrice);
                    executeSetYearPublishedStatement.setString(2, whereGameStopPrice);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereWalmartPrice.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setAmazonPriceQuery = "UPDATE priceInfo SET amazonPrice = ? WHERE walmartPrice = ?";
                    PreparedStatement executeSetYearPublishedStatement = myDbConn.prepareStatement(setAmazonPriceQuery);
                    executeSetYearPublishedStatement.setString(1, setAmazonPrice);
                    executeSetYearPublishedStatement.setString(2, whereWalmartPrice);
                    executeSetYearPublishedStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Returning boolean below:
        return acceptedValues;
    }
    //Creating method for updating exclusivity table below:
    public static boolean updateExclusivityTable (String setExclusiveType, String setPs4Compatibility, String setXboxOneCompatibility, String setPcCompatibility, String whereExclusiveType, String wherePs4Compatibility, String whereXboxOneCompatibility, String wherePcCompatibility) {
        //Creating and initializing variables below:
        Connection myDbConn;
        DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
        boolean acceptedValues = true;
        myDbConn = dbObj.getDbConn();
        //Creating potential querys below:
        String setExclusiveTypeQuery = "UPDATE exclusivity SET exclusiveType = ? WHERE ? = ?";
        String setPs4CompatibilityQuery = "UPDATE exclusivity SET ps4Compatibility = ? WHERE ? = ?";
        String setXboxOneCompatibilityQuery = "UPDATE exclusivity SET xboxOneCompatibility = ? WHERE ? = ?";
        String setPcCompatibilityQuery = "UPDATE exclusivity SET pcCompatibility = ? WHERE ? = ?";
        
        //Testing to set exclusive type below:
        if (setExclusiveType.equals("")){
        }
        else {
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE exclusivity SET exclusiveType = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, whereExclusiveType);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePs4Compatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE exclusivity SET exclusiveType = ? WHERE ps4Compatibility = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, wherePs4Compatibility);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereXboxOneCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE exclusivity SET exclusiveType = ? WHERE xboxOneCompatibility = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, whereXboxOneCompatibility);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePcCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setExclusiveTypeQuery = "UPDATE exclusivity SET exclusiveType = ? WHERE pcCompatibility = ?";
                    PreparedStatement executeSetExclusiveTypeStatement = myDbConn.prepareStatement(setExclusiveTypeQuery);
                    executeSetExclusiveTypeStatement.setString(1, setExclusiveType);
                    executeSetExclusiveTypeStatement.setString(2, wherePcCompatibility);
                    executeSetExclusiveTypeStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to ps4 compatibility type below:
        if (setPs4Compatibility.equals("")){
        }
        else {
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPs4CompatibilityQuery = "UPDATE exclusivity SET ps4Compatibility = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setPs4CompatibilityQuery);
                    executeSetGameEditionStatement.setString(1, setPs4Compatibility);
                    executeSetGameEditionStatement.setString(2, whereExclusiveType);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePs4Compatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPs4CompatibilityQuery = "UPDATE exclusivity SET ps4Compatibility = ? WHERE ps4Compatibility = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setPs4CompatibilityQuery);
                    executeSetGameEditionStatement.setString(1, setPs4Compatibility);
                    executeSetGameEditionStatement.setString(2, wherePs4Compatibility);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereXboxOneCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPs4CompatibilityQuery = "UPDATE exclusivity SET ps4Compatibility = ? WHERE xboxOneCompatibility = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setPs4CompatibilityQuery);
                    executeSetGameEditionStatement.setString(1, setPs4Compatibility);
                    executeSetGameEditionStatement.setString(2, whereXboxOneCompatibility);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePcCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPs4CompatibilityQuery = "UPDATE exclusivity SET ps4Compatibility = ? WHERE pcCompatibility = ?";
                    PreparedStatement executeSetGameEditionStatement = myDbConn.prepareStatement(setPs4CompatibilityQuery);
                    executeSetGameEditionStatement.setString(1, setPs4Compatibility);
                    executeSetGameEditionStatement.setString(2, wherePcCompatibility);
                    executeSetGameEditionStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to xboxone compatibility type below:
        if (setXboxOneCompatibility.equals("")){
        }
        else {
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setXboxOneCompatibilityQuery = "UPDATE exclusivity SET xboxOneCompatibility = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setXboxOneCompatibilityQuery);
                    executeSetGameNameStatement.setString(1, setXboxOneCompatibility);
                    executeSetGameNameStatement.setString(2, whereExclusiveType);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePs4Compatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setXboxOneCompatibilityQuery = "UPDATE exclusivity SET xboxOneCompatibility = ? WHERE ps4Compatibility = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setXboxOneCompatibilityQuery);
                    executeSetGameNameStatement.setString(1, setXboxOneCompatibility);
                    executeSetGameNameStatement.setString(2, wherePs4Compatibility);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereXboxOneCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setXboxOneCompatibilityQuery = "UPDATE exclusivity SET xboxOneCompatibility = ? WHERE xboxOneCompatibility = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setXboxOneCompatibilityQuery);
                    executeSetGameNameStatement.setString(1, setXboxOneCompatibility);
                    executeSetGameNameStatement.setString(2, whereXboxOneCompatibility);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePcCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setXboxOneCompatibilityQuery = "UPDATE exclusivity SET xboxOneCompatibility = ? WHERE pcCompatibility = ?";
                    PreparedStatement executeSetGameNameStatement = myDbConn.prepareStatement(setXboxOneCompatibilityQuery);
                    executeSetGameNameStatement.setString(1, setXboxOneCompatibility);
                    executeSetGameNameStatement.setString(2, wherePcCompatibility);
                    executeSetGameNameStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Testing to pc compatibility type below:
        if (setPcCompatibility.equals("")){
        }
        else {
            if (whereExclusiveType.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPcCompatibilityQuery = "UPDATE exclusivity SET pcCompatibility = ? WHERE exclusiveType = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPcCompatibilityQuery);
                    executeSetPublisherStatement.setString(1, setPcCompatibility);
                    executeSetPublisherStatement.setString(2, whereExclusiveType);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePs4Compatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPcCompatibilityQuery = "UPDATE exclusivity SET pcCompatibility = ? WHERE ps4Compatibility = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPcCompatibilityQuery);
                    executeSetPublisherStatement.setString(1, setPcCompatibility);
                    executeSetPublisherStatement.setString(2, wherePs4Compatibility);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (whereXboxOneCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPcCompatibilityQuery = "UPDATE exclusivity SET pcCompatibility = ? WHERE xboxOneCompatibility = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPcCompatibilityQuery);
                    executeSetPublisherStatement.setString(1, setPcCompatibility);
                    executeSetPublisherStatement.setString(2, whereXboxOneCompatibility);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
            if (wherePcCompatibility.equals("")) {
            }
            else {
                try {
                    //Executing prepared statement below:
                    setPcCompatibilityQuery = "UPDATE exclusivity SET pcCompatibility = ? WHERE pcCompatibility = ?";
                    PreparedStatement executeSetPublisherStatement = myDbConn.prepareStatement(setPcCompatibilityQuery);
                    executeSetPublisherStatement.setString(1, setPcCompatibility);
                    executeSetPublisherStatement.setString(2, wherePcCompatibility);
                    executeSetPublisherStatement.executeUpdate();
                }
                catch (SQLException e) {
                    acceptedValues = false;
                }
            }
        }
        //Returning boolean below:
        return acceptedValues;
    }
}