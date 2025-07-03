package igathlete.ilt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("igathlete.ilt.mapper") // <-- добавь это
@SpringBootApplication
public class IssueLightTrackerApp {

	public static void main(String[] args) {
		SpringApplication.run(IssueLightTrackerApp.class, args);
	}
}
