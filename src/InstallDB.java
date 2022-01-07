/*
Dhruv K. Saligram
10/13/18
This class creates the database and tables
*/
package videogameapplication;
//Creating class below:
public class InstallDB {
    //Creating main class below:
    public static void main(String[] args) {
        //Creaint local variables below:
        String gameTable;
        String priceTable;
        String compatibilityTable;
        DBMySQLAccess objDb = new DBMySQLAccess();
        //Creating database below:
        objDb.createDb("videoGameDB");
        //Creating query for table creation below:
        gameTable = "CREATE TABLE gameInfo ( "
                + "gameName varchar(30), "
                + "gameEdition varchar(30), "
                + "publisher varchar(50), "
                + "exclusiveType varchar(50), "
                + "yearPublished int, "
                + "copiesSold int "
                + ")";
        //Creating query for table creation below:
        priceTable = "CREATE TABLE priceInfo ( "
                + "gameEdition varchar(30), "
                + "gameStopPrice varchar(30), "
                + "ebayPrice varchar(30), "
                + "amazonPrice varchar(30), "
                + "walmartPrice varchar(30) "
                + ")";
        //Creating query for table creation below:
        compatibilityTable = "CREATE TABLE exclusivity ( "
                + "exclusiveType varchar(30), "
                + "ps4Compatibility varchar(30), "
                + "xboxOneCompatibility varchar(30), "
                + "pcCompatibility varchar(30) "
                + ")";
        //Creating tables below:
        objDb.createTable(gameTable, "videoGameDB");
        objDb.createTable(priceTable, "videoGameDB");
        objDb.createTable(compatibilityTable, "videoGameDB");
    }
}