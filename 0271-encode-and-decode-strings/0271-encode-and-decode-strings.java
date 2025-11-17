public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs){
            encoded.append(s.length()).append("/:").append(s);
        }
        return encoded.toString();
    }

    //Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();  
        int i = 0;
        while(i < s.length()){
            //find delimeter index
            int delim = s.indexOf("/:", i);

            //find length
            int len = Integer.parseInt(s.substring(i, delim));
            String str = s.substring(delim + 2, delim + 2 + len);
            decoded.add(str);

            i = delim + 2 + len;
        }
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));