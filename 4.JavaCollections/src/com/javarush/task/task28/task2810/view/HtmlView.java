package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.DataOutput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = "../4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) throws IOException {
        String updt = getUpdatedFileContent(vacancies);
        updateFile(updt);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() throws IOException {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        try {
            Document doc = getDocument();
            Elements elements = doc.getElementsByClass("vacancy");
            Element elem = doc.getElementsByClass("template").first().clone();
            for (Element element : elements) {
                element.remove();
            }
            doc.select("table").first().appendChild(elem.clone());

            elem.removeAttr("style");
            elem.removeClass("template");

            for (Vacancy vacancy : vacancies) {
                Element template = elem.clone();
                template.getElementsByClass("city").append(vacancy.getCity());
                template.getElementsByClass("companyName").append(vacancy.getCompanyName());
                template.getElementsByClass("salary").append(vacancy.getSalary());
                template.getElementsByTag("a").append(vacancy.getTitle()).attr("href", vacancy.getUrl());
                if (elem != null && template != null) {
                    doc.getElementsByClass("template").first().before(template.toString());
                }
            }
            return doc.toString();
        }catch (Exception e){
            e.printStackTrace();
            return "Some exception occurred";
        }
    }
    private void updateFile(String fileContent) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(fileContent);
        fileWriter.close();
    }

    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        Document doc = Jsoup.parse(file,"UTF-8");
        return doc;
    }


}
