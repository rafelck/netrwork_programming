
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafel
 */
public class Ping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        try {

            Scanner sc = new Scanner(System.in);
            
            System.out.print("Input Address : ");
            String hostAddress = sc.next();

            Process p = Runtime.getRuntime().exec("ping " + hostAddress);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String commandOutput = "";
            boolean isReachable = true;
            // reading output stream of the command
            while ((commandOutput = inputStream.readLine()) != null) {
                System.out.println(commandOutput);

                if (commandOutput.contains("Destination host unreachable")) {
                    isReachable = false;
                    break;
                }

            }

            if (isReachable) {
                System.out.println("Host is reachable!");
            } else {
                System.out.println("Host is not reachable!");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
