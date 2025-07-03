package igathlete.ilt;

import igathlete.ilt.model.Catalog;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Disabled
@SpringBootTest
public class CatalogApiTest {

    @Test
    public void bulkCreateCatalogs() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/catalogs";
        Random random = new Random();

        String[] namePrefixes = {"Alpha", "Beta", "Gamma", "Delta", "Omega", "Zen", "Nova", "Eco", "Lux", "Neo"};
        String[] categories = {"Books", "Electronics", "Clothing", "Games", "Furniture", "Sports", "Toys", "Tools", "Groceries", "Music"};

        for (int i = 1; i <= 100; i++) {
            String name = namePrefixes[random.nextInt(namePrefixes.length)] + " " + categories[random.nextInt(categories.length)];
            String description = "This is a " + name.toLowerCase() + " catalog, entry #" + i;

            Catalog catalog = new Catalog(null, name, description);
            restTemplate.postForEntity(url, catalog, Catalog.class);
        }
    }
}