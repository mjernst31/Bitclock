/**
 * @author Matthew Ernst
 */

public class Bitclock{

    private String merid, hour, min;

    public Bitclock(int merid, int hour, int min){
        this.merid = Integer.toBinaryString(merid);
        this.hour = Integer.toBinaryString(hour);
        this.min = Integer.toBinaryString(min);
    }



    public String toString(){
        String[][] ret = new String[3][6];
        final int column = 6, row = 3;
        int count = 1;

        String hours, minutes, merids;
        hours = this.getHour();
        minutes = this.getMin();
        merids = this.getMerid();

        //instantiates the merid
        ret[0][5] = this.getMerid();

        //Instantiates the minute column
        for(int i = column - 1; i >= 0; i--){
            ret[1][i] = String.valueOf(hours.charAt(hours.length() - count));
            System.out.println(ret[1][i]);
            count++;
        }

        for(int i = 5; i >= 0; i--){
            System.out.println(ret[1][i]);
        }
        return ret.toString();
    }

    public String getMerid() {
        return merid;
    }

    public String getHour() {
        return hour;
    }

    public String getMin() {
        return min;
    }

    public static String convert(int nums){
        return Integer.toBinaryString(nums);
    }

    public static void main(String[] args){
        Bitclock btc = new Bitclock(1, 5, 30);
        System.out.println(btc);
    }
}