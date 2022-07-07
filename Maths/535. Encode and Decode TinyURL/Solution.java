public class Codec {
    private static final int size = 6;
    private static final String chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
    private static final String HOST = "http://tinyurl.com/";
    private Map<String,String> url2Code, code2Url;
    private Random rand;
    
    public Codec() {
        url2Code = new HashMap();
        code2Url = new HashMap();
        rand = new Random();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if( url2Code.containsKey(longUrl) )
            return HOST + url2Code.get(longUrl);
        
        String code = generateCode();
        
        while( code2Url.containsKey(code) )
            code = generateCode();
        
        url2Code.put(longUrl, code);
        code2Url.put(code, longUrl);
        
        return HOST + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return code2Url.get(shortUrl.substring(HOST.length()));
    }
    
    private String generateCode() {
        char[] code = new char[6];
        for(int i=0; i<6; i++)
            code[i] = chars.charAt(rand.nextInt(chars.length()));
        return new String(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
