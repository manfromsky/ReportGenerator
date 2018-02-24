package ru.texunatask.reportgenerator.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Настройки отчета
 */
@XmlRootElement(name = "settings")
public class Settings {
    @XmlElement(name = "page")
    private Page page;

    @XmlElementWrapper(name="columns")
    @XmlElement(name = "column")
    private List<Column> columns;

    public Page getPage() {
        return page;
    }

    public List<Column> getColumns() {
        return columns;
    }
}
