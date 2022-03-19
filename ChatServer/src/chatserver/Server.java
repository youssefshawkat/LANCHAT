package chatserver;


import static chatserver.ServerUI.jTextArea1;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Server{

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){

        this.serverSocket = serverSocket;

    }

    public void startServer() {
            jTextArea1.setEnabled(false);
        try {
            while (!serverSocket.isClosed()) {


                Socket socket = serverSocket.accept();
                ServerUI.jTextArea1.append("A new client has connected!"+"\n");
                ClientHandler clientHander = new ClientHandler(socket);

                Thread thread = new Thread(clientHander);
                thread.start();

            }


        } catch (IOException e) {


        }
    }


        public void closeServerSocket(){
            try{

                if(serverSocket != null){

                    serverSocket.close();
                }
            } catch (IOException e){

                e.printStackTrace();

            }

        }

        public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {
             UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
        ServerUI serverui = new ServerUI();
       
        ServerSocket serverSocket = new ServerSocket(3333);
        Server server = new Server(serverSocket);
        server.startServer();


        }


    }



