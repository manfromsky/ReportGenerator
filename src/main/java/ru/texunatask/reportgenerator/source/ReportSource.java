package ru.texunatask.reportgenerator.source;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * Данные для заполнения отчета
 */
public class ReportSource {
    private final String fileName;

    public ReportSource(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Считывание данных для отчета
     */
    public List<String[]> parsing() {

        List<String[]> reportData = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), Charset.forName("UTF-16")))) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] splitLine = readLine.split("\\s+", 3);
                reportData.add(splitLine);
            }
        } catch (IOException e) {
            System.out.println("Something wrong with " + fileName);
        }
        return reportData;
    }
}
