package ru.texunatask.reportgenerator.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Настройки страницы
 */
@XmlRootElement(name = "page")
public class Page {
    @XmlElement(name = "width")
    private int width;
    @XmlElement(name = "height")
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}