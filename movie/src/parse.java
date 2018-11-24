import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;

class parse{
    private static String url = null;
    private static String[] m_name = new String[16];
    private static String[] m_link = new String[16];

    public static void set_url(String theme){
        if(theme.equals("crime")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=%EB%B2%94%EC%A3%84&s_tag=%EB%B2%94%EC%A3%84&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("adventure")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=%EB%AA%A8%ED%97%98&s_tag=%EB%AA%A8%ED%97%98&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("sf")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=SF&s_tag=SF&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("sf")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=SF&s_tag=SF&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("scare")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=%EA%B3%B5%ED%8F%AC&s_tag=%EA%B3%B5%ED%8F%AC&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("thril")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=%EC%8A%A4%EB%A6%B4%EB%9F%AC&s_tag=%EC%8A%A4%EB%A6%B4%EB%9F%AC&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("action")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=%EC%95%A1%EC%85%98&s_tag=%EC%95%A1%EC%85%98&sop=and&sst=wr_3&sod=desc&sca=";
        }
        if(theme.equals("anime")){
            parse.url = "http://moviejoa.net/bbs/board.php?bo_table=movie&sfl=wr_1&stx=%EC%95%A0%EB%8B%88%EB%A9%94%EC%9D%B4%EC%85%98&s_tag=%EC%95%A0%EB%8B%88%EB%A9%94%EC%9D%B4%EC%85%98&sop=and&sst=wr_3&sod=desc&sca=";
        }
    }
    public static String movie_rank(){
        WebDriver driver;
        String html;
        int ct=1;

        System.setProperty("webdriver.chrome.driver","C:\\Users\\oonja\\Downloads\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS); // 시간
        driver.get("https://movie.naver.com/movie/sdb/rank/rmovie.nhn#");

        html = driver.getPageSource();
        driver.quit();

        Document doc = Jsoup.parse(html);
        Elements contents = doc.select("#content .article table tbody tr .title .tit3");

        StringBuilder movie_rank = new StringBuilder();
        for (Element content : contents) {
            movie_rank.append(ct + " " + content.text() + "\n");
            ct += 1;
        }
        return movie_rank.toString();

    }
    public static String[] theme_movie(){
        WebDriver driver;
        String html;
        int ct=1;

        System.setProperty("webdriver.chrome.driver","C:\\Users\\oonja\\Downloads\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS); // 시간
        driver.get(parse.url);

        html = driver.getPageSource();
        driver.quit();

        Document doc = Jsoup.parse(html);

        Elements contents = doc.select(".fz_list li .fz_subject .list_title");

        ct = 1;
        for (Element content : contents) {
            parse.m_name[ct] = content.text();
            ct++;
        }

        Elements links = doc.select(".fz_list li .fz_subject a");

        ct = 1;
        for (Element link : links) {
            parse.m_link[ct] = link.attr("href");
            ct++;
        }

        return parse.m_name;

    }
    public static void movie_view(int idx){
        //Movie Link
        WebDriver driver;
        int ct=1;

        System.setProperty("webdriver.chrome.driver","C:\\Users\\oonja\\Downloads\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(parse.m_link[idx]);
    }
}
