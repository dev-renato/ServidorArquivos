package br.edu.flf.client;

import br.edu.flf.ftp.Requisicao;
import br.edu.flf.ftp.Resposta;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        Socket socket;
        Scanner teclado = new Scanner(System.in);
        
        try {
            socket = new Socket("localhost", 40000);
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream   in = new ObjectInputStream(socket.getInputStream());
            
            //criar requisicao
            System.out.println("CLIENT: Digite o nome do arquivo");
            String fileName = teclado.nextLine();
            Requisicao req = new Requisicao();
            req.setMessageType(Requisicao.FILENAME_REQUEST);
            req.setMessageContent(fileName);
            
            //envio a requisicao
            out.writeObject(req);
            
            //espera a resposta
            Resposta rep = (Resposta)in.readObject();
            if(rep.getResponseCode() == Resposta.FILE_EXISTS){
                System.out.println("SUCESSO - Arquivo existe no servidor... pronto para iniciar download");
            }else if(rep.getResponseCode() == Resposta.FILE_NOT_FOUMD){
                System.out.println("ERRO - Arquivo nao encontrado no servidor");
            }
            
            in.close();
            out.close();
            socket.close();
            
        } catch (Exception ex) {
            System.out.println("Deu ruim no cliente");
            ex.printStackTrace();
        }
    }
}
