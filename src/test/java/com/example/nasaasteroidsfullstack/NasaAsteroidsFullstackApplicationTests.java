package com.example.nasaasteroidsfullstack;

import com.example.nasaasteroidsfullstackback.config.ExecutorServiceConfig;
import com.example.nasaasteroidsfullstackback.config.PropertyConfig;
import com.example.nasaasteroidsfullstackback.config.RestTemplateConfig;
import com.example.nasaasteroidsfullstackback.config.WebClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
		ExecutorServiceConfig.class,
		PropertyConfig.class,
		RestTemplateConfig.class,
		WebClientConfig.class
})
class NasaAsteroidsFullstackApplicationTests {

	@Test
	void contextLoads() {
	}

}
