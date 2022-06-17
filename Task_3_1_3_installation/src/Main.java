import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

                String gamesPath = "C:\\Users\\alex\\Desktop\\Games\\";

                String[] gamesDirectories = {"src", "res", "savegames", "temp" };
                String[] scrDirectories = {"main", "test" };
                String[] mainFiles = {"Main.java", "Utils.java" };
                String[] resDirectories = {"drawables", "vectors", "icons" };
                String[] tempFiles = {"temp.txt" };

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < gamesDirectories.length; i++) {
                    String path = gamesPath + gamesDirectories[i];
                    File dir = new File(path);
                    String msg = "";
                    if (dir.mkdir()) {
                        msg = "Каталог \"" + path + "\" успешно создан";
                    } else {
                        msg = "Ошибка создания каталога \"" + path + "\"";
                    }
                    System.out.println(msg);
                    sb.append(msg + "\n");
                }

                File src = new File(gamesPath + gamesDirectories[0]);
                if (src.isDirectory()) {
                    for (int i = 0; i < scrDirectories.length; i++) {
                        String path = gamesPath + gamesDirectories[0] + "\\" + scrDirectories[i];
                        File dir = new File(path);
                        String msg = "";
                        if (dir.mkdir()) {
                            msg = "Каталог \"" + path + "\" успешно создан";
                        } else {
                            msg = "Ошибка создания каталога \"" + path + "\"";
                        }
                        System.out.println(msg);
                        sb.append(msg + "\n");
                    }
                }

                File res = new File(gamesPath + gamesDirectories[1]);
                if (res.isDirectory()) {
                    for (int i = 0; i < resDirectories.length; i++) {
                        String path = gamesPath + gamesDirectories[1] + "\\" + resDirectories[i];
                        File dir = new File(path);
                        String msg = "";
                        if (dir.mkdir()) {
                            msg = "Каталог \"" + path + "\" успешно создан";
                        } else {
                            msg = "Ошибка создания каталога \"" + path + "\"";
                        }
                        System.out.println(msg);
                        sb.append(msg + "\n");
                    }
                }

                String mainPath = gamesPath + gamesDirectories[0] + "\\" + scrDirectories[0] + "\\";
                for (int i = 0; i < mainFiles.length; i++) {
                    String msg = "";
                    String nameForMainFile = mainPath + mainFiles[i];
                    File newFile = new File(nameForMainFile);
                    try {
                        if (newFile.createNewFile())
                            msg = "Файл \"" + nameForMainFile + "\" успешно создан";
                    } catch (IOException e) {
                        msg = e.getMessage();
                    } finally {
                        System.out.println(msg);
                        sb.append(msg + "\n");
                    }
                }

                String tempPath = gamesPath + gamesDirectories[3] + "\\";
                for (int i = 0; i < tempFiles.length; i++) {
                    String msg = "";
                    String nameForTempFile = tempPath+ tempFiles[i];
                    File newFile = new File(nameForTempFile);
                    try {
                        if (newFile.createNewFile())
                            msg = "Файл \"" + nameForTempFile + "\" создан успешно";
                    } catch (IOException e) {
                        msg = e.getMessage();
                    } finally {
                        System.out.println(msg);
                        sb.append(msg + "\n");
                    }
                }

                String logFile = gamesPath + gamesDirectories[3] + "\\" + tempFiles[0];

                try (BufferedWriter b = new BufferedWriter(new FileWriter(logFile))) {
                    String log = sb.toString();
                    String text = log;
                    b.write(text);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


