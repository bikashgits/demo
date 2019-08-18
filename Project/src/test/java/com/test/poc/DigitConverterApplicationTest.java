package com.test.poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class DigitConverterApplicationTest {
	
	@Autowired
	private WebTestClient webClient;

	@Test
	public void digitToWordConverterCase() throws Exception {

		// 1
		this.webClient.get().uri("/converter/digittoword?value=1").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("one");
		// 9
		this.webClient.get().uri("/converter/digittoword?value=9").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("nine");

		// 101
		this.webClient.get().uri("/converter/digittoword?value=101").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("one hundred and one");
		// 999
		this.webClient.get().uri("/converter/digittoword?value=999").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("nine hundred and ninety nine");
		
		// 1001
		this.webClient.get().uri("/converter/digittoword?value=1001").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("one thousand and one");
		
		// 9999
		this.webClient.get().uri("/converter/digittoword?value=9999").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("nine thousand nine hundred and ninety nine");

		//999999999
		this.webClient.get().uri("/converter/digittoword?value=999999999").exchange().expectStatus().isOk().expectBody(String.class)
		.isEqualTo("ninety nine crore ninety nine lakh ninety nine thousand nine hundred and ninety nine");
		
	}

	
}
