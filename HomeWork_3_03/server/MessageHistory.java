package HomeWork_3_03.server;

import java.io.*;

public class MessageHistory {
    private String locationFile;
    private File fileHistory;

    public MessageHistory(String fileName) {

        locationFile = String.format("src/HomeWork_3_03/log/%s.txt", fileName);
        fileHistory = new File(locationFile);
        try {
            fileHistory.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMessage(String message) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(
                            fileHistory, true));
            bw.newLine();
            bw.write(message);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String showHistory(int countMessage){
        StringBuilder result = new StringBuilder();
        int countLines = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile(fileHistory, "r");
            long fileLengthInByte = fileHistory.length()-1;
            if(fileLengthInByte<0) return "";
            raf.seek(fileLengthInByte);

            for (long i = fileLengthInByte; i >= 0 ; i--) {
                raf.seek(i);
                char simbol = (char)raf.read();
                if(simbol == '\n') countLines++;
                if(countLines == countMessage) break;
                result.append(simbol);
            }
            result.reverse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
