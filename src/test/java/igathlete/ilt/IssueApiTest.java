package igathlete.ilt;

import igathlete.ilt.model.Issue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

//@Disabled
@SpringBootTest
public class IssueApiTest {

    @Test
    public void bulkCreateIssues() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/issues";
        Random random = new Random();

        String[] namePrefixes = {"Alpha", "Beta", "Gamma", "Delta", "Omega", "Zen", "Nova", "Eco", "Lux", "Neo"};
        String[] categories = {"Books", "Electronics", "Clothing", "Games", "Furniture", "Sports", "Toys", "Tools", "Groceries", "Music"};
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Miami", "Seattle", "Boston", "Denver", "Phoenix", "San Francisco"};

        for (int i = 1; i <= 100; i++) {
            String name = namePrefixes[random.nextInt(namePrefixes.length)] + " " + categories[random.nextInt(categories.length)];
            String description = "This is a " + name.toLowerCase() + " catalog, entry #" + i;
            String city = cities[random.nextInt(cities.length)];

            Issue catalog = new Issue(null, name, description, city);
            restTemplate.postForEntity(url, catalog, Issue.class);
        }
    }
}
