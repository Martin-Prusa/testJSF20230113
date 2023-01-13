package cz.martin.repositories;

import cz.martin.models.Hero;
import cz.martin.models.Publisher;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SuperheroRepository {
    private final String databaseURL = "jdbc:mariadb://localhost/superhero?user=root&password=password";

    public List<Publisher> getPublishers() {
        List<Publisher> publishers = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(databaseURL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("""
                SELECT P.publisher_name, COUNT(S.id), P.id
                FROM publisher AS P JOIN superhero AS S on P.id = S.publisher_id
                GROUP BY P.id
                """)
                ) {
            while (resultSet.next()) {
                publishers.add(new Publisher(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publishers;
    }

    public List<Hero> getHeroes(int publisher) {
        List<Hero> heroes = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(databaseURL);
                PreparedStatement statement = connection.prepareStatement("""
                SELECT S.superhero_name, S.full_name, G.gender, R.race, A.alignment
                FROM superhero AS S JOIN gender AS G ON S.gender_id = G.id
                                    JOIN race AS R ON S.race_id = R.id
                                    JOIN alignment AS A ON S.alignment_id = A.id
                                    
""" + (publisher != -1 ? "WHERE S.publisher_id = ? " : " "))
                ) {
            if(publisher != -1) statement.setInt(1, publisher);

            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    heroes.add(new Hero(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return heroes;
    }
}
