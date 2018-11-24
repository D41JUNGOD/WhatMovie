import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int idx;

        parse.set_url("crime");
        String[] m_name = parse.theme_movie();
        for(int i=1; i<=15; i++)
            System.out.println(i+ " " + m_name[i]+"\n");

        idx = sc.nextInt();
        parse.movie_view(idx);
        }
}

