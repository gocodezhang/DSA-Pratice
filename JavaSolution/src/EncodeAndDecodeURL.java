import java.util.HashMap;

public class EncodeAndDecodeURL {
    HashMap<String, String> map = new HashMap<>();
    // encode only path
    public String encode(String longUrl) {
        int index = longUrl.indexOf("://");
        String[] parseUrl = longUrl.substring(index + 3).split("/");

        if (parseUrl.length == 1) {
            map.put(longUrl, longUrl);
            return longUrl;
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < parseUrl.length; i++) {
                builder.append(parseUrl[i]);
            }
            int hash = builder.toString().hashCode();
            String encoded = longUrl.substring(0, index + 3) + parseUrl[0] + "/" + hash;
            map.put(encoded, longUrl);
            return encoded;
        }

    }
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
