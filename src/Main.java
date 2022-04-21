import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String path = "D:" + File.separator + "Games(netology)" + File.separator;
        List<File> folders = Arrays.asList(
                new File(path),
                new File(path + "src"),
                new File(path + "res"),
                new File(path + "savegames"),
                new File(path + "temp"),
                new File(path + "src" + File.separator + "main"),
                new File(path + "src" + File.separator + "test"),
                new File(path + "res" + File.separator + "drawables"),
                new File(path + "res" + File.separator + "vectors"),
                new File(path + "res" + File.separator + "icons")
        );

        List<File> files = Arrays.asList(
                new File(path + "src" + File.separator + "main" + File.separator + "Main.java"),
                new File(path + "src" + File.separator + "main" + File.separator + "Utils.java"),
                new File(path + "temp" + File.separator + "temp.txt")
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
        try (FileWriter log = new FileWriter(path + "temp" + File.separator + "temp.txt")) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            sb.append(e.getMessage()).append('\n');
        }
    }

}
