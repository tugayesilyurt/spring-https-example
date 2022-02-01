package com.spring.https.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;


@SpringBootApplication
@RequiredArgsConstructor
public class SpringHttpsClientApplication {

	private String keystorepassword = "tugayesilyurt";
	private String keystore = "classpath:tugayesilyurt.p12";
	private final ResourceLoader resourceLoader;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringHttpsClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() throws Exception {
		
        Resource resource = resourceLoader.getResource(keystore);
        InputStream stream = resource.getInputStream();
        File tempFile = File.createTempFile("temp", "temp");
        IOUtils.copy(stream, new FileOutputStream(tempFile));
        
		SSLContext sslContext = SSLContextBuilder.create()
				.loadTrustMaterial(tempFile, keystorepassword.toCharArray()).build();
		CloseableHttpClient client = HttpClients.custom().setSSLContext(sslContext).build();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(client);

		RestTemplate restTemplate = new RestTemplate(requestFactory);

		return restTemplate;
		
	}


}
