import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    public static String username;
    public static String host;

    public Client(){

    }

    public static void sendMessage(String messageToSend) {

        try{


                bufferedWriter.write(username + ": " + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

        } catch (IOException e){

            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    public static void sendUserName(){

        try{


            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e){

            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    public static void listenForMessage() throws IOException {

        SimpleAudioPlayer.filePath = "sound.wav";


        Socket socket = new Socket(host,3333);
        try{

            Client.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e){

            closeEverything(socket, bufferedReader, bufferedWriter);
        }

        if(socket.isConnected()){

            sendUserName();

        }
        new Thread(new Runnable() {
            @Override
            public void run() {


            String msgFromGroupChat;
            while (socket.isConnected()){

                try {
                    msgFromGroupChat = bufferedReader.readLine();
                    ChatUI.jTextArea1.append(msgFromGroupChat+"\n");

                    if(!ChatUI.isWindowActive) {
                        SimpleAudioPlayer audioPlayer =
                                new SimpleAudioPlayer();
                        audioPlayer.play();

                    }



                } catch (IOException e){

                    closeEverything(socket, bufferedReader, bufferedWriter);
                } catch (UnsupportedAudioFileException | LineUnavailableException e) {
                    e.printStackTrace();
                }


            }
            }

        }).start();


    }

    public static void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){

        try{

            if(bufferedReader !=null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){

                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        } catch (IOException e){

            e.printStackTrace();

        }

    }



}
