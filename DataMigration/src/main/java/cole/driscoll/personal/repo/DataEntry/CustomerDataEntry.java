package cole.driscoll.personal.repo.DataEntry;

import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;


public class CustomerDataEntry implements IDataEntry {

  private HttpClient httpClient;

  private HttpPost httpPost;


  public CustomerDataEntry() {
    final SSLConnectionSocketFactory sslsf;
    try {
      sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault(),
          NoopHostnameVerifier.INSTANCE);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

    final Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", new PlainConnectionSocketFactory())
        .register("https", sslsf)
        .build();

    final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
    cm.setMaxTotal(100);
    httpClient = HttpClients.custom()
        .setSSLSocketFactory(sslsf)
        .setConnectionManager(cm)
        .build();
  }

  @Override
  public int enterCustomer(String JSONCustomer) {
    int statusCode;
    try {
      this.httpPost = new HttpPost("https://cole.base-data.loopie.io/v1/users");
      StringEntity params = new StringEntity(JSONCustomer);
      httpPost.setEntity(params);
      httpPost.setHeader("content-type", "application/json");
      HttpResponse response = httpClient.execute(httpPost);
      statusCode = response.getStatusLine().getStatusCode();
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
    return statusCode;
  }

}

