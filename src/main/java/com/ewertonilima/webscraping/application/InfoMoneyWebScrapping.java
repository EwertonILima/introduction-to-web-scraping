package com.ewertonilima.webscraping.application;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.ewertonilima.webscraping.entity.News;

public class InfoMoneyWebScrapping {

	public static void main(String[] args) {

		try {
			// URL do site a ser acessado
			String website = "https://www.infomoney.com.br/mercados/";

			// Conectando e obtendo uma cópia do html inteiro da página
			Document doc = Jsoup.connect(website).get();

			// Obtendo a div do conteudo através do seu Id
			Element id = doc.getElementById("infiniteScroll");

			// Obtendo as urls da div através da classe e atributo
			List<String> links = id.getElementsByClass("col-12 col-lg-4 img-container").stream()
					.map(x -> x.getElementsByTag("a").attr("href").substring(29)).collect(Collectors.toList());

			String baseUrl = "https://www.infomoney.com.br/";

			// Conectando as URLs capturadas e coletando os atributos
			List<News> list = new ArrayList<>();
			for (int i = 0; i < links.size(); i++) {
				Document page2 = Jsoup.connect(baseUrl + links.get(i)).get();

				String url = baseUrl + links.get(i);
				String title = page2.getElementsByClass("page-title-1").first().text();
				String subtitle = page2.getElementsByClass("article-lead").first().text();
				String author = page2.getElementsByClass("author-name").first().text();
				String date = new SimpleDateFormat("dd/MM/yyyy HH:mm")
						.format(new SimpleDateFormat("dd MMM yyyy HH'h'mm", Locale.US)
								.parse(page2.getElementsByTag("time").first().text()));
				Element div = page2.getElementsByClass("col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content")
						.first();
				String text = div.getElementsByTag("p").text();

				list.add(new News(url, title, subtitle, author, date, text));
			}
			
			System.out.println(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
