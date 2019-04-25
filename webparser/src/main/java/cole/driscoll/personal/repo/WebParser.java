package cole.driscoll.personal.repo;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebParser {

  public static void main(String[] args) {
    final String url =
        "https://www.loopie.us/admin/orders.php?location=&status=&zip_code=&date_start=07%2F01%2F2018&date_end=04%2F24%2F2019&tag=&search=#";

    try {
      final Document doc = Jsoup.connect(url)
          //.header("Accept-Encoding", "gzip, deflate")
          //.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
          //.maxBodySize(0)
          //.timeout(600000)
          .get();
      System.out.println(doc.outerHtml());
      //for (Element row : document.select("table.tablesorter.full tr")) {
      //}
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
