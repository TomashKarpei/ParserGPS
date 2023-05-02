import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    private static void RMC(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\nOkreślane przez standard NMEA minimum danych, które musi wysyłać każdy odbiornik GPS. Interpretacja tych danych również pozwala określić pozycję GPS urządzenia.");
        System.out.println(data[nr][0].substring(3,6) + " - nagłówek");
        System.out.println(data[nr][1] + " - aktualność danych - " + data[nr][1].substring(0,2)+":"+data[nr][1].substring(2,4)+":"+data[nr][1].substring(4,6));
        System.out.println(data[nr][2] + " – status (A – aktywny, V – nieaktywny)");
        System.out.println(data[nr][3] + "," + data[nr][4] + " – szerokość geograficzna (latitude) - " + data[nr][3].substring(0, 2) + " deg " + data[nr][3].substring(2, 7) + "' " + data[nr][4]);
        System.out.println(data[nr][5] + "," + data[nr][6] + " – długość geograficzna (longitude) - " + data[nr][5].substring(0, 2) + " deg " + data[nr][5].substring(2, 7) + "' " + data[nr][6]);
        System.out.println(data[nr][7] + " – prędkość obiektu (liczona w węzłach)");
        System.out.println(data[nr][8] + " – kąt śledzenia/poruszania się obiektu (w stopniach) – przydatny w celu określenia kierunku poruszania się obiektu, jeżeli urządzenie GPS nie jest wyposażone w kompas");
        System.out.println(data[nr][9] + " – data [ Dzien: " + data[nr][9].substring(0,2) + "; Miesiac: " + data[nr][9].substring(2,4) + "; Rok: " + data[nr][9].substring(4,6) + ";]");
        System.out.println(data[nr][10]+","+data[nr][11].substring(0,1) + " – odchylenie magnetyczne ziemi");
        System.out.println(data[nr][11].substring(1,4) + " – suma kontrolna");
    }
    /*
    private static void RMB(String [][] data, int nr){
       System.out.println("\nBrak dla RMB");
    }
    */

    private static void GGA(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\nDostarcza informacji na temat aktualnego położenia:");
        System.out.println(data[nr][0].substring(3,6) + " - nagłówek");
        System.out.println(data[nr][1] + " - aktualność danych - " + data[nr][1].substring(0,2)+":"+data[nr][1].substring(2,4)+":"+data[nr][1].substring(4,6));
        System.out.println(data[nr][2] + "," + data[nr][3] + " – szerokość geograficzna (latitude) - " + data[nr][2].substring(0, 2) + " deg " + data[nr][2].substring(2, 7) + "' " + data[nr][3]);
        System.out.println(data[nr][4] + "," + data[nr][5] + " – długość geograficzna (longitude) - " + data[nr][4].substring(0, 2) + " deg " + data[nr][4].substring(2, 7) + "' " + data[nr][5]);
        System.out.println(data[nr][6] + " – jakosc pomiaru");
        System.out.println(data[nr][7] + " – liczba sledzonych satelitow");
        System.out.println(data[nr][8] + " – horyzontalna dokładność pozycji (HDOP)");
        System.out.println(data[nr][9] + "," + data[nr][10] + " – wysokość w metrach nad poziom morza");
        System.out.println(data[nr][11] + "," + data[nr][12] + " – wysokość geoid (powyżej elipsoidy WGS84)");
        System.out.println(data[nr][13] + " – czas od czasu ostatniego uaktualnienia DGPS (uaktualnienia różnicowe wysyłane przez stacje naziemne - zwiększają dokładność wykonywanych pomiarów)");
        System.out.println(data[nr][13] + " – numer ID stacji DGPS");
        System.out.println(data[nr][14] + " – suma kontrolna");
    }

    private static void GSA(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\nDostarcza informacji o satelitach.");
        System.out.println(data[nr][0].substring(3,6) + " - nagłówek");
        System.out.println(data[nr][1] + "," + data[nr][2] + " – automatyczny wybór pozycji (2D lub 3D) (M – manualny), pozycja 3D; możliwe wartości:\n" +
                "* 1 – brak ustalonej pozycji z tego satelity\n" +
                "* 2 – pozycja 2D\n" +
                "* 3 – pozycja 3D");
        System.out.println(data[nr][3] + "," + data[nr][4] + "," + data[nr][5] + "," + data[nr][6] + "," +
                data[nr][7] + "," + data[nr][8] + "," + data[nr][9] + "," + data[nr][10] + "," +
                data[nr][11] + "," + data[nr][12] + "," + data[nr][13] + "," + data[nr][14] + " - numery satelitów wykorzystane do wyznaczenia pozycji (miejsce dla 12 satelitów)");
        System.out.println(data[nr][15] + " – DOP (dilution of precision) – precyzja wyznaczonej pozycji");
        System.out.println(data[nr][16] + " – HDOP (horizontal dilution of precision) – horyzontalna precyzja wyznaczonej pozycji");
        System.out.println(data[nr][17].substring(0,3) + " – VDOP (vertical dilution of precision) – wertykalna precyzja wyznaczonej pozycji");
        System.out.println(data[nr][17].substring(3,5) + " – suma kontrolna.");
    }

    private static void GSV(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\nDostarcza dokładnych informacji o każdym widocznym satelicie (osobno). ");
        System.out.println(data[nr][0].substring(3,6) + " - nagłówek");
        System.out.println(data[nr][1] + " – liczba linii, które powinna aplikacja odczytać w celu posiadania pełnych danych o wszystkich satelitach (wynika z ograniczenia do 80 znaków na linie NMEA)");
        System.out.println(data[nr][2] + " – aktualny numer linii (odnosi się do powyższego punktu)");
        System.out.println(data[nr][3] + " – liczba aktualnie widocznych satelitów");
        System.out.println(data[nr][4] + " – identyfikator PRN satelity");
        System.out.println(data[nr][5] + " – wyniesienie satelity nad poziom równika (stopnie)");
        System.out.println(data[nr][6] + " – azymut satelity (stopnie)");
        System.out.println(data[nr][7] + " – SNR (signal to noise ratio) – poziom odbieranego sygnału");
        System.out.println(data[nr][8] + ", " + data[nr][9] + ", " + data[nr][10] + ", " + data[nr][11] + ", ");
        System.out.println(data[nr][12] + ", " + data[nr][13] + ", " + data[nr][14] + ", " + data[nr][15] + ", ");
        System.out.println(data[nr][16] + ", " + data[nr][17] + ", " + data[nr][18] + ", " + data[nr][19].substring(0,2) + " - kolejne wartości określają 4 w/w informacje o kolejnych satelitach");
        System.out.println(data[nr][19].substring(2,5) + " - suma kontrolna");
    }
    /*
    private static void RME(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\n" + data[nr][0].substring(3,6) + " - brak");

    }
    */

    private static void GLL(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\nOkreśla aktualną pozycję (długość i szerokość geograficzną).");
        System.out.println(data[nr][0].substring(3,6) + " - naglowek");
        System.out.println(data[nr][1] + "," + data[nr][2] + " - szerokość geograficzna (latitude) –" + data[nr][1].substring(0,2) + " deg "+ data[nr][1].substring(2,6) + "' "+data[nr][2]);
        System.out.println(data[nr][3] + "," + data[nr][4] + " – długość geograficzna (longitude) –" + data[nr][3].substring(0,2) + " deg "+ data[nr][1].substring(2,6) + "' "+data[nr][4]);
        System.out.println(data[nr][5] + " – godzina ustalenia pozycji (" + data[nr][5].substring(0,2) + ":" + data[nr][5].substring(2,4) + ":" + data[nr][5].substring(4,6));
        System.out.println(data[nr][6].substring(0,1) + " – status (A – aktywny, V – nieaktywny)");
        System.out.println(data[nr][6].substring(1,4) + " – suma kontrolna");
    }

    private static void VTG(String [][] data, int nr){
        String sekw = new String();
        for (int jj = 0; jj < data[nr].length; jj++) {
            sekw += data[nr][jj];
        }
        System.out.println("\nOkreśla aktualną szybkość i wektor poruszania się.");
        System.out.println(data[nr][0].substring(3,6) + " - naglowek");
        System.out.println(data[nr][1] + "," + data[nr][2] + " - ścieżka poruszania się (w stopniach)");
        System.out.println(data[nr][3] + "," + data[nr][4] + " – ścieżka poruszania się na podstawie współrzędnych magnetycznych – w stopniach");
        System.out.println(data[nr][5] + "," + data[nr][6] + " – prędkość w węzłach");
        System.out.println(data[nr][7] + "," + data[nr][8].substring(0,1) + " – prędkość w km/h");
        System.out.println(data[nr][8].substring(1,4) + " – suma kontrolna");
    }

    public static int Check(String[][] data, int size){
        //String[][] Dataset = data;
        for (int i = 0; i<size; i++){
            if (data[i][0].substring(0,1).equals("$")){
                //System.out.println("NieOk");
            }
            else{
                System.out.println(data[i][0].substring(0,1));
                return 0;
            }
        }

        for (int i = 0; i<data.length; i++){
            int len = 0;
            for (int j = 0; j<data[i].length; j++) {
                len = data[i].length;
            }
            if (len > 82) {
                System.out.println("OK-82");
                return 0;
            }
            else{
                //System.out.println("NieOK-82");
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String data[][] = new String[215][82];
        int size = 0;
        try {
            File plik = new File("dane2.txt");
            Scanner dane = new Scanner(plik);
            dane.useDelimiter("");
            int i = 0;
            while (dane.hasNextLine()) {
                int k = 0;
                String line = dane.nextLine();

                if (line.equals("")) {
                } else {
                    size++;
                    //String line = text.replaceAll("(?m)^[ \t]*\r?\n", "123");
                    if (line.substring(0,1).equals("$")){
                        Scanner lineScanner = new Scanner(line);
                        lineScanner.useDelimiter(",");
                        while (lineScanner.hasNext()) {
                            String character = lineScanner.next();
                            data[i][k] = character;
                            System.out.print(data[i][k]);
                            k++;
                            System.out.print(" ");
                        }
                        System.out.println();
                        i++;
                    }
                }
            }
            Check(data, size);
            for (int ii = 0; ii < data.length; ii++){
                //System.out.println(data[ii][0].substring(3,6));
                //System.out.println(data.length);
                if (data[ii][0] != null){
                    if (data[ii][0].substring(3,6).equals("RMC") && data[ii][11] != null && data[ii][12] == null){
                        RMC(data, ii);
                    }
                    else if (data[ii][0].substring(3,6).equals("RMC") && (data[ii][11] == null || data[ii][12] != null)){
                        System.out.println("\n" + data[ii][0].substring(3,6) + " - nieprawidlowo podane dane");
                    }

                    else if(data[ii][0].substring(3,6).equals("GGA") && data[ii][14] != null && data[ii][15] == null){
                        GGA(data, ii);
                    }
                    else if (data[ii][0].substring(3,6).equals("GGA") && (data[ii][14] == null || data[ii][15] != null)){
                        System.out.println("\n" + data[ii][0].substring(3,6) + " - nieprawidlowo podane dane");
                    }

                    else if(data[ii][0].substring(3,6).equals("GSA") && data[ii][17] != null && data[ii][18] == null){
                        GSA(data, ii);
                    }
                    else if (data[ii][0].substring(3,6).equals("GSA") && (data[ii][17] == null || data[ii][18] != null)){
                        System.out.println("\n" + data[ii][0].substring(3,6) + " - nieprawidlowo podane dane");
                    }

                    else if(data[ii][0].substring(3,6).equals("GSV") && data[ii][19] != null && data[ii][20] == null){
                        GSV(data, ii);
                    }
                    else if (data[ii][0].substring(3,6).equals("GSV") && (data[ii][19] == null || data[ii][20] != null)){
                        System.out.println("\n" + data[ii][0].substring(3,6) + " - nieprawidlowo podane dane");
                    }

                    else if(data[ii][0].substring(3,6).equals("GLL") && data[ii][6] != null && data[ii][7] == null){
                        GLL(data, ii);
                    }
                    else if (data[ii][0].substring(3,6).equals("GLL") && (data[ii][6] == null || data[ii][7] != null)){
                        System.out.println("\n" + data[ii][0].substring(3,6) + " - nieprawidlowo podane dane");
                    }

                    else if(data[ii][0].substring(3,6).equals("VTG") && data[ii][8] != null && data[ii][9] == null){
                        VTG(data, ii);
                    }
                    else if (data[ii][0].substring(3,6).equals("VTG") && (data[ii][8] == null || data[ii][9] != null)){
                        System.out.println("\n" + data[ii][0].substring(3,6) + " - nieprawidlowo podane dane");
                    }

                    else{
                        System.out.println("\nBrak obsługiwania " + data[ii][0].substring(3,6));
                    }
                }
            }
            dane.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}