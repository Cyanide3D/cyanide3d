package cyanide3d.msg;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SendMessage {

    List<?> array = new ArrayList<>();
    Socket socket;
    BufferedWriter bufferedWriter;


    public SendMessage() throws IOException {
        socket = new Socket("188.134.66.216", 1099);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    }

    public List<?> send(String message) throws IOException, ClassNotFoundException {
        bufferedWriter.write(message + "\r");
        bufferedWriter.flush();
        if (message.length() < 12){
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            if (message.equals("channels")) {
                return (List<ChannelModel>) objectInputStream.readObject();
            } else if (message.equals("leaderboard")) {
                return (List<UserStats>) objectInputStream.readObject();
            }
            objectInputStream.close();
        }
        bufferedWriter.close();
        return array;
    }
}
