import java.util.Arrays;

public class M2410 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int res=0;
        for (int i = 0,j=0; i < players.length && j<trainers.length; ) {
            if(players[i]<= trainers[j]){
                res++;
                i++;j++;
            }else{
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]players ={4,7,9};
        int[]trainers ={8,2,5,8};
        M2410 s = new M2410();
        int res = s.matchPlayersAndTrainers(players, trainers);
        System.out.println(res);
    }
}
