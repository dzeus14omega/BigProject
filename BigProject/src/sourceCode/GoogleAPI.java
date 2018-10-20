package sourceCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class GoogleAPI {
     
    private final String googleTranslatorURL = "http://translate.google.com/translate_a/t?";
    private LANGUAGE srcLang = LANGUAGE.AUTO;
    private LANGUAGE destLang = LANGUAGE.VIETNAMESE;
    private String userAgent = "Mozilla/5.0 (Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";
 
    public String translate(String query) throws MalformedURLException, IOException, ParseException {
        URL url = new URL(this.buildURLRequestWith(query));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setDoOutput(true);
        conn.setRequestProperty("X-HTTP-Method-Override", "GET");
        conn.addRequestProperty("User-Agent", this.userAgent);
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(30000);
        conn.connect();
 
        InputStream inputStream = conn.getInputStream();
        BufferedReader bis = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String respContent = bis.readLine();
        inputStream.close();
        bis.close();
        conn.disconnect();
 
        StringBuilder contentBuilder = new StringBuilder();
 
        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(respContent);
        JSONArray sentences = (JSONArray) jsonData.get("sentences");
 
        for (Object sentence : sentences) {
            contentBuilder.append(((JSONObject) sentence).get("trans").toString().trim());
        }
 
        return contentBuilder.toString().trim().replace(" .", ". ");
    }
 
    private String buildURLRequestWith(String query) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(this.googleTranslatorURL);
        urlBuilder.append("client=webapp");
        urlBuilder.append("&sl=en");
        urlBuilder.append("&tl=").append(this.destLang);
        
        //
        urlBuilder.append("&format=html");
        //urlBuilder.append("&hl=").append(this.srcLang);
        //urlBuilder.append("&sc=1");
        urlBuilder.append("&v=2.0");
        String queryEncoded = "";
        try {
            queryEncoded = URLEncoder.encode(query, "UTF-8");
        } catch (Exception e) {
        }
        urlBuilder.append("&q=").append(queryEncoded);
        return urlBuilder.toString();
    }
 
    public LANGUAGE getSrcLang() {
        return srcLang;
    }
 
    public void setSrcLang(LANGUAGE srcLang) {
        this.srcLang = srcLang;
    }
 
    public LANGUAGE getDestLang() {
        return destLang;
    }
 
    public void setDestLang(LANGUAGE destLang) {
        this.destLang = destLang;
    }
 
    public String getUserAgent() {
        return userAgent;
    }
 
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
     
    public static enum LANGUAGE {
        ENGLISH("en"),
        VIETNAMESE("vi"), 
        AUTO("auto");
         
        private String lang = "";
        private LANGUAGE(String lang) {
            this.lang = lang;
        }
        @Override
        public String toString() {
            return this.lang;
        }
    }
         
}