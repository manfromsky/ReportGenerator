package ru.texunatask.reportgenerator.data;

import ru.texunatask.reportgenerator.model.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Отчет
 */
public class Report {

    private final Settings settings;
    private final List<String[]> data;
    private final ReportLine reportLine;
    private final ReportLineRedactor reportLineRedactor;

    public Report(Settings settings, List<String[]> data) {
        this.settings = settings;
        this.data = data;
        this.reportLine = new ReportLine(settings);
        this.reportLineRedactor = new ReportLineRedactor(settings);
    }

    /**
     * Создание отчета
     */
    public List<String> data() {
        List<String> outPutData = new ArrayList<>();
        int heightBorder = settings.getPage().getHeight();
        reportLine.headLineGenerate(settings.getColumns());
        reportLine.delimiterLineGenerate();

        outPutData.add(reportLine.headLineGenerate(settings.getColumns()));
        outPutData.add(reportLine.delimiterLineGenerate());

        for (String[] dataLine : data) {
            List<String[]> lineList = reportLineRedactor.lineRedactor(dataLine);
            if (outPutData.size() + lineList.size() > heightBorder) {
                outPutData.add("~");
                outPutData.add(reportLine.headLineGenerate(settings.getColumns()));
                outPutData.add(reportLine.delimiterLineGenerate());
                heightBorder += settings.getPage().getHeight();
            }
            for (String[] strings : lineList) {
                outPutData.add(reportLine.generate(strings));
            }
            outPutData.add(reportLine.delimiterLineGenerate());
            if (outPutData.size() % settings.getPage().getHeight() == 0) {
                outPutData.add("~");
                outPutData.add(reportLine.headLineGenerate(settings.getColumns()));
                outPutData.add(reportLine.delimiterLineGenerate());
            }
        }
        return outPutData;
    }
}


