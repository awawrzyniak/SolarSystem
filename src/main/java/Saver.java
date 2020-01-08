import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Saver {

    public Saver() {
    }

    public static void saveToTxt(ArrayList<String> trajektoria, int id){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("Trajectory_"+ id + ".txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("X \t Y");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < trajektoria.size(); i++) {
                bufferedWriter.newLine();
                bufferedWriter.write(trajektoria.get(i));
            }
        }catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        try{
                System.out.println("Your file has been saved in current folder.");
                System.out.println("File name: Trajectory_" + id + ".txt");

                bufferedWriter.close();
                fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

