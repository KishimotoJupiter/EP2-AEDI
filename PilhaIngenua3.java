import java.util.Scanner;
import java.io.*;
class PilhaIngenua3{


  static void gerador(File arq, int entradas, boolean pilhaingenua){
    try{
      PilhaIngenua2 PI = new PilhaIngenua2();
      PilhaDobrada PD = new PilhaDobrada();
      Scanner ler = new Scanner(arq);
      String saida = "";
      if(pilhaingenua == true){
        while(ler.hasNextLine()){
          String linha = ler.nextLine();
          if(linha.equals("")){
            saida = saida + PI.remove() + "\n";
          }
          else{
            PI.add(Integer.parseInt(linha));
          }
        }
      }
      else{
        while(ler.hasNextLine()){
          String linha = ler.nextLine();
          if(linha.equals("")){
            saida = saida + PD.remove() + "\n";
          }
          else{
            PD.add(Integer.parseInt(linha));
          }
        }
      }
      String arqSaida = "saida" + Integer.toString(entradas) + ".txt";
      FileWriter escrever = new FileWriter(arqSaida);
      escrever.write(saida);
      ler.close();
      escrever.close();
    }
    catch(FileNotFoundException ex){}
    catch(IOException e){}
  }


  public static void main(String[] args){
    Scanner ler = new Scanner(System.in);
    boolean metodoaceito = false;
    boolean pilhaingenua = false;
    while(metodoaceito == false){
      System.out.println("Digite (1) para usar o PilhaIngenua2.java e (2) para usar o PilhaDobrada.java");
      String metodo = ler.nextLine();
      if(metodo.equals("1")){
        pilhaingenua = true;
        metodoaceito = true;
      }
      else if(metodo.equals("2")){
        metodoaceito = true;
      }
      else{
        System.out.println("Metodo invalido");
      }
    }
    long inicio = System.currentTimeMillis();
    String nome = args[0];
    if(!nome.contains(".txt")){
      nome = nome + ".txt";
    }
    char[] nome2 = nome.toCharArray();
    char[] tamanhoEmChar = new char[nome2.length - 11];
    int i;
    for(i = 0; i < (nome2.length - 11); i++){
      tamanhoEmChar[i] = nome2[i + 7];
    }
    String tamanhoEmString = new String(tamanhoEmChar);
    int entradas = Integer.parseInt(tamanhoEmString);
    File arq = new File(nome);
    for(i = 0; i < 10; i++){
      gerador(arq, entradas, pilhaingenua);
    }
    System.out.print("O tempo medio de execucao do programa, neste arquivo, foi de: " + (System.currentTimeMillis() - inicio) / 10 + "ms");
  }
}
