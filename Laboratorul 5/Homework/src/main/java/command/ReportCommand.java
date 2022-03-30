package command;

import base.Catalog;
import base.Item;
import base.Main;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.EmptyParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command {

    public ReportCommand(Catalog catalog) {
        super(catalog);
    }

    /**
     * creates and opens a html report
     */
    public void run()  {
        printCommandName();
        Configuration cfg = new Configuration(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(Main.class, "/");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("catalog", catalog.toString());
        templateData.put("title", "html report");

        //BasicConfigurator.configure();
        Template template = null;
        try {
            template = cfg.getTemplate("test.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringWriter out = new StringWriter();
        try {
            template.process(templateData, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File outFile = new File("catalog.html");

        try (FileWriter f = new FileWriter("catalog.html");
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {
            p.println(out.getBuffer().toString());
        } catch (IOException i) {
            i.printStackTrace();
        }
        Desktop desktop = null;
        desktop = Desktop.getDesktop();
        try {
            desktop.open(new File("catalog.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
    }
    @Override
    public void printCommandName() {
        System.out.println("ReportCommand");
    }


}
