import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;

public  class lesson2{
    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\JAVA\\семинары");

        var a = getFileDirs(dir);

        Logger logger = Logger.getLogger(lesson2.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.txt");

        logger.addHandler(ch);
        logger.addHandler(fh);

        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        ch.setFormatter(sf);

        try {
            WriteInFile(a, "содержимое папки.txt");
            logger.log(Level.INFO, "Код успешно выполнился");
            logger.info("Код успешно выполнился");
        } catch (IOException e) {
            logger.log(Level.WARNING, e.toString());
            logger.info(e.toString());
        }

        PrintExtensions(dir);

        var params = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(formWHERE(params));

    }

    public  static String[] getFileDirs(File dir){
        File[] files = dir.listFiles();
        String[] filesArr = new String[files.length];

        for(int i = 0; i < files.length; i++){
            if (files[i].isFile())
                filesArr[i] = "File: " + files[i].getName();
            else{
                filesArr[i] = "Directory: " + files[i].getName();
                getFileDirs(files[i]);
            }
        }
        return filesArr;
    }

    public static void WriteInFile(String[] files, String name) throws IOException {
        File file = new File(name);
        FileWriter writer = new FileWriter(file);

        for (String s : files){
            writer.write(s + "\n");
        }
        writer.close();
    }

    public static String getFileExtension(String nameFile){
        int index = nameFile.indexOf('.');
        if (index == - 1)
            return null;
        else
            return nameFile.substring(index);
    }

    public  static void PrintExtensions(File dir){
        File[] files = dir.listFiles();

        for(File item : files){
            if(item.isFile()){
                System.out.println("Расширение файла: " + getFileExtension(item.getName()));
            }
        }
    }

    public static String formWHERE(String params){
        var SB = new StringBuilder(15);

        var newstr = params.replace("\"", "");
        newstr = newstr.replace("{", "");
        newstr = newstr.replace("}", "");
        var arrStr = newstr.split(", ");
        var count = 0;
        for (String item : arrStr){
            var temp = item.split(":");
            if(!temp[1].equals("null")){
                if (count > 0)
                    SB.append(" and ");
                SB.append(temp[0]);
                SB.append("='");
                SB.append(temp[1]);
                SB.append("'");
                count++;
            }
        }
        return SB.toString();
    }
}