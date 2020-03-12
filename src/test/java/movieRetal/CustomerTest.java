package movieRetal;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

class CustomerTest {

    private final Movie starWar = new Movie("Star War", 0);
    private final Movie tomJack = new Movie("Tom and Jack", 2);
    private final Movie joker = new Movie("Joker", 1);

    @Test
    void should_show_statements_when_customer_want_to_see_it() throws IOException {

        final Customer mike = new Customer("Mike");
        final Rental starWarRental = new Rental(starWar, 10);
        final Rental tomJackRental = new Rental(tomJack, 20);
        final Rental jokerRental = new Rental(joker, 30);

        ImmutableList.of(starWarRental, tomJackRental, jokerRental)
                     .forEach(mike::addRental);

        final String expectedStatement = Files.toString(new File("src/test/resources/safeNet.txt"), UTF_8);
        final String actualStatement = mike.statement();

        Assertions.assertEquals(expectedStatement, actualStatement);
    }
}