package com.ewertonilima.webscraping.application;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class InfoMoneyWebScrapping {

	public static void main(String[] args) throws IOException, ParseException {

		// URL do site a ser acessado
		String website = "https://www.infomoney.com.br/mercados/";

		// Conectando e obtendo uma cópia do html inteiro da página
		Document doc = Jsoup.connect(website).get();

		// Obtendo a div do conteudo através do seu Id
		Element id = doc.getElementById("infiniteScroll");

		// Obtendo as urls da div através da classe e atributo
		List<String> links = id.getElementsByClass("col-12 col-lg-4 img-container").stream()
				.map(x -> x.getElementsByTag("a").attr("href").substring(29)).collect(Collectors.toList());
		
		System.out.println(links);

	}

}
