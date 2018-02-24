package ru.texunatask.reportgenerator.data;

import ru.texunatask.reportgenerator.model.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Редактирование строки с учетом настроек
 */
class ReportLineRedactor {
    private final Settings settings;

    ReportLineRedactor(Settings settings) {
        this.settings = settings;
    }

    /**
     * изменение строки с учетом настроек
     */
    List<String[]> lineRedactor(String[] dataLine) {
        List<String[]> outputLine = new ArrayList<>();
        int lineNumber = generateLineNumber(dataLine);
        for (int i = 0; i < lineNumber; i++) {
            String[] result = new String[dataLine.length];
            for (int j = 0; j < dataLine.length; j++) {
                if (dataLine[j].length() < settings.getColumns().get(j).getWidth()) {
                    if (i == 0) {
                        result[j] = dataLine[j];
                    } else {
                        result[j] = "";
                    }
                } else {
                    int cuttingLine = settings.getColumns().get(j).getWidth() * i;
                    if (cuttingLine >= dataLine[j].length()) {
                        result[j] = "";
                    } else if (cuttingLine + settings.getColumns().get(j).getWidth() - 1 >= dataLine[j].length()) {
                        if(dataLine[j].contains("/")){
                            result[j] = dataLine[j].substring(dataLine[j].lastIndexOf('/') + 1);
                        }else{
                        result[j] = dataLine[j].substring(cuttingLine);}
                    } else {
                        if(dataLine[j].contains("/")){
                            result[j] = dataLine[j].substring(0,dataLine[j].lastIndexOf('/') + 1);
                        }else{
                        result[j] = dataLine[j].substring(cuttingLine, cuttingLine + settings
                                .getColumns().get(j).getWidth());}
                    }
                }
            }
            outputLine.add(result);
        }
        return outputLine;
    }

    /**
     * Высота ячейки
     */
    private int generateLineNumber(String[] dataLine) {
        int lineNumber = 1;
        for (int j = 0; j < settings.getColumns().size(); j++) {
            if (dataLine[j].length() / settings.getColumns().get(j).getWidth() >= 1) {
                if (lineNumber < dataLine[j].length() / settings.getColumns().get(j).getWidth()) {
                    lineNumber = dataLine[j].length() / settings.getColumns().get(j).getWidth();
                }
                if (dataLine[j].length() % settings.getColumns().get(j).getWidth() > 0) {
                    lineNumber++;
                }
            }
        }
        return lineNumber;
    }
}
