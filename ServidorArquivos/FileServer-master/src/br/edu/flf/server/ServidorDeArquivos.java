package br.edu.flf.server;

import br.edu.flf.ftp.Requisicao;
import br.edu.flf.ftp.Resposta;
import java.io.*;
import java.net.*;

public class ServidorDeArquivos {
    public static void main(String args[]) {
        ServerSocket serverSocket;
        Socket       cliente;
        Resposta     rep;
        
        try {
            serverSocket = new ServerSocket(40000);
            System.out.println("DEBUG - Server Started at 40000");
            
            while (true) {                
                cliente = serverSocket.accept();
                
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                
                Requisicao req = (Requisicao)in.readObject();
                
                //processamento
                if (req.getMessageType() == Requisicao.FILENAME_REQUEST){
                    //abrir o arquivo que veio como conteudo da requisicao
                    File f = new File(req.getMessageContent());
                    rep = new Resposta();
                    if(f.exists()){
                        rep.setResponseCode(Resposta.FILE_EXISTS);
                    }else{
                        rep.setResponseCode(Resposta.FILE_NOT_FOUMD);
                    }
                    
                    out.writeObject(rep);
                }
                
                in.close();
                out.close();
                cliente.close();
            }
        } catch (Exception ex) {
            System.out.println("Deu ruim no servidor");
            ex.printStackTrace();
            
        }
    }
}
