package com.challenge.springboot_backend;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.challenge.springboot_backend.entity.News;
import com.challenge.springboot_backend.repository.NewsRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public void run(String... args) throws Exception {
		Random random = new Random();
		// Caminho para o arquivo CSV
		String csvFile = "E:/Projetos/spring_boot_project/springboot_backend/src/noticias.csv";

		// Configuração do separador no arquivo CSV

		try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
			List<String[]> rows = reader.readAll();
		
			// Ignora o cabeçalho (primeira linha) do arquivo CSV
			int limit = Math.min(rows.size(), 11);  // Limita o loop para no máximo 10 linhas
			for (int i = 1; i < limit; i++) {
				String[] row = rows.get(i);
						LocalDate randomDate = LocalDate.of(
			random.nextInt(10) + 2010,  // Ano aleatório entre 2010 e 2019
			random.nextInt(12) + 1,     // Mês aleatório entre 1 e 12
			random.nextInt(28) + 1      // Dia aleatório entre 1 e 28 (para simplificar)
		);


				// Extrai os dados de cada coluna do arquivo CSV
				String title = row[0];
				String content = row[1];
				String author = row[2];

				// Cria uma instância de News com os dados do CSV
				News news = News.builder()
						.title(title)
						.content(content)
						.author(author)
						.date(randomDate.toString()) // Converte a data aleatória para uma String no formato ISO
						.build();

				// Salva a notícia no banco de dados
				newsRepository.save(news);
			}
			System.out.println("Dados do CSV foram inseridos no banco de dados.");
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
}