package ru.texunatask.reportgenerator;

import ru.texunatask.reportgenerator.data.Report;
import ru.texunatask.reportgenerator.source.ReportSource;
import ru.texunatask.reportgenerator.source.ReportSettings;
import ru.texunatask.reportgenerator.report.ReportFile;

public class Generator {

    public static void main(String[] args) {
        ReportSettings reportSettings = new ReportSettings("settings.xml");
        ReportSource reportSource = new ReportSource("source-data.tsv");

        Report report = new Report(reportSettings.parsing(), reportSource.parsing());
        ReportFile reportFile = new ReportFile(report);
        reportFile.writeTxt();
    }
}
