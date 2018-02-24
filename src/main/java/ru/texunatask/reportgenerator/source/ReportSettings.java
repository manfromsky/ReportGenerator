package ru.texunatask.reportgenerator.source;

import ru.texunatask.reportgenerator.model.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Настройки
 */
public class ReportSettings {
    private final String fileName;

    public ReportSettings(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Считывание настроек с xml файла
     */
    public Settings parsing() {

        Settings settings = new Settings();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
            XMLStreamReader xmlStreamReader = XMLInputFactory.newFactory()
                    .createXMLStreamReader(new FileInputStream(fileName));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            xmlStreamReader.nextTag();
            settings = (Settings) unmarshaller.unmarshal(xmlStreamReader);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("file - " + fileName + " not found");
        }
        return settings;
    }
}
