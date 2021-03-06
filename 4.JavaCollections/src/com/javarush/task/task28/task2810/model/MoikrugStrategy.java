package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    String siteName = "https://moikrug.ru";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> listVacancy = new ArrayList<>();
        String siteName = "https://moikrug.ru";
        int pageNumber = 0;

        String url = String.format(URL_FORMAT, searchString, pageNumber);

        try {

            Document doc;

            while (true) {
                doc = getDocument(searchString, pageNumber++);

                Elements elements = doc.getElementsByAttributeValue("class", "job");
                elements.addAll( doc.getElementsByAttributeValue("class", "job marked"));

                if (elements.size() != 0) {
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(element.select("div[class=title]").text().trim());

                        vacancy.setSalary(element.select("div[class=salary]").text().trim());
                        vacancy.setCity(element.select("span[class=location]").text().trim());
                        vacancy.setCompanyName(element.getElementsByClass("company_name").text().trim());

                        vacancy.setSiteName(siteName);
                        vacancy.setUrl(siteName + element.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());

                        listVacancy.add(vacancy);

                    }

                }
                else break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return listVacancy;
    }


    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
                .referrer("none")
                .timeout(5 * 1000)
                .get();

        return doc;
    }
}
