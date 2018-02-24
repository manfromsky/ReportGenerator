package ru.texunatask.reportgenerator.data;

import ru.texunatask.reportgenerator.model.Column;
import ru.texunatask.reportgenerator.model.Settings;

import java.util.List;

/**
 * Строка отчета
 */
class ReportLine {

    private final Settings settings;

    ReportLine(Settings settings) {
        this.settings = settings;
    }

    /**
     * Генерация строки отчета из предоставленных данных
     */
    String generate(String[] data) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < settings.getColumns().size(); i++) {

            stringBuilder.append('|');
            stringBuilder.append(" ");
            stringBuilder.append(data[i].trim());
            int spaceCount = settings.getColumns().get(i).getWidth() - data[i].trim().length() + 1;
            if (spaceCount > 0) {
                for (int j = 0; j < spaceCount; j++) {
                    stringBuilder.append(" ");
                }
            }
        }
        stringBuilder.append('|');
        return stringBuilder.toString();
    }

    /**
     * Создание разделяющей строки
     */
    String delimiterLineGenerate() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < settings.getPage().getWidth(); i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

    /**
     * Создание строки заголовка
     */
    String headLineGenerate(List<Column> columnList) {
        String[] column = new String[columnList.size()];
        for (int i = 0; i < column.length; i++) {
            column[i] = columnList.get(i).getTitle();
        }
        return generate(column);
    }
}

