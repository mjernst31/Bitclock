/**
 * @author Matthew Ernst
 */

import java.time.LocalDateTime;
public class Bitclock{

    private String merids, hours, mins;
    private String[][] clock = new String[3][6];

    public Bitclock(){
        hours = Integer.toBinaryString(LocalDateTime.now().getHour());
        mins = Integer.toBinaryString(LocalDateTime.now().getMinute());

        if(LocalDateTime.now().getHour()/12 > 0){
            hours = Integer.toBinaryString(LocalDateTime.now().getHour() %12);
            merids = "1";
        }

        //instantiates the merid column (AM(0) or PM(1))
        int count = 1;
        for (int i = 5; i >= 0; i--) {
            if (count <= merids.length())
                clock[0][i] = String.valueOf(merids.charAt(merids.length() - count));
            else clock[0][i] = "0";

            count++;
        }

        //Instantiates the hours column
        count = 1;
        for (int i = 5; i >= 0; i--) {
            if (count <= hours.length())
                clock[1][i] = String.valueOf(hours.charAt(hours.length() - count));
            else clock[1][i] = "0";

            count++;
        }

        //Instantiates the minutes column
        count = 1;
        for (int i = 5; i >= 0; i--) {
            if (count <= mins.length())
                clock[2][i] = String.valueOf(mins.charAt(mins.length() - count));

            else clock[2][i] = "0";

            count++;
        }


    }

    public String toString(){
        String complete = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++)
                complete = complete + clock[i][j];

            complete = complete + "\n";
        }

        return complete;
    }

    public String[][] getRet() {
        return clock;
    }
    public String getMerid() {
        return merids;
    }

    public String getHour() {
        return hours;
    }

    public String getMin() {
        return mins;
    }

    public static void main(String[] args){
        Bitclock btc = new Bitclock();
        System.out.println(btc);
    }
}