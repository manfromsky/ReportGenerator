package ru.texunatask.reportgenerator.report;

import ru.texunatask.reportgenerator.data.Report;

import java.io.*;
import java.util.List;

/**
 * Файл отчета
 */
public class ReportFile {
    private final Report report;
    private static final String ENCODING = "UTF-16";
    private static final String FILENAME = "report.txt";

    public ReportFile(Report report) {
        this.report = report;
    }

    /**
     * Запись отчета в txt файл
     */
    public void writeTxt() {
        List<String> reportData;
        reportData = this.report.data();
        File file = new File(FILENAME);
        try (PrintWriter printWriter = new PrintWriter(file, ENCODING)) {
            for (String s : reportData) {
                printWriter.println(s);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file - " + file + " not found");
        } catch (UnsupportedEncodingException e) {
            System.out.println("encoding - " + ENCODING + " unsupported");
        }
    }
}
