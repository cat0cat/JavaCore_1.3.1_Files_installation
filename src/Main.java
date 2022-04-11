import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folders = Arrays.asList(
                new File("D:\\Games(netology)\\"),
                new File("D:\\Games(netology)\\src"),
                new File("D:\\Games(netology)\\res"),
                new File("D:\\Games(netology)\\savegames"),
                new File("D:\\Games(netology)\\temp"),
                new File("D:\\Games(netology)\\src\\main"),
                new File("D:\\Games(netology)\\src\\test"),
                new File("D:\\Games(netology)\\res\\drawables"),
                new File("D:\\Games(netology)\\res\\vectors"),
                new File("D:\\Games(netology)\\res\\icons")
        );

        List<File> files = Arrays.asList(
                new File("D:\\Games(netology)\\src\\main\\Main.java"),
                new File("D:\\Games(netology)\\src\\main\\Utils.java"),
                new File("D:\\Games(netology)\\temp\\temp.txt")
        );

        //создание директорий
        folders.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("директория ")
                    .append(folder)
                    .append(" создана успешно\n");
            else sb.append("директория")
                    .append(folder)
                    .append(" не создана\n");
        });

        //создание файлов
        files.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("файл ")
                        .append(file)
                        .append(" создан успешно\n");
                else sb.append("файл ")
                        .append(file)
                        .append(" не создан\n");
            } catch (IOException e) {
                sb.append(e.getMessage()).append('\n');
            }
        });

        // добавление в лог информации о создании файлов и каталогов.
        try (FileWriter log = new FileWriter("D:\\Games(netology)\\temp\\temp.txt")) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            sb.append(e.getMessage()).append('\n');
        }
    }

}
