import DAO.ContinentDAO;
import DAO.CountryDAO;
import database.Database;

import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Mareci Ioana Amalia A2
 * Main class of the project
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String args[]) throws SQLException {
        try {
            var continents = new ContinentDAO();
            try {
                continents.create("Europe");
                continents.create("Asia");

            } catch (SQLException e) {
                LOGGER.warning("SQLException");
                e.printStackTrace();
            }
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            int asiaId = continents.findByName("Asia");

            try {
                countries.create("Romania", 1, europeId);
                countries.create("Ukraine", 1, europeId);
                countries.create("Japan", 3, asiaId);
            } catch (SQLException e) {
                LOGGER.warning("SQLException");
                e.printStackTrace();
            }

            //prints all the continents
            continents.printContinents();

            //prints all the countries
            countries.printCountries();

            //prints the countries from Europe
            countries.printCountriesFromContinent(europeId);

            Database.closeConnection();
        } catch (SQLException e) {
            LOGGER.warning("SQLException : " + e.getSQLState());
            Database.rollback();

        }
    }
}

