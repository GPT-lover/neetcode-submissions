class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(String str : strs){ //5#hello
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) { //5#hello 
        List<String> result = new ArrayList<>(); 
        if(str == null || str.isEmpty()){
            return result;
        }

        int i = 0; 

        while(i < str.length()){
            int slashIndex = str.indexOf("#", i);

            int length = Integer.parseInt(str.substring(i, slashIndex));

            String word = str.substring(slashIndex + 1, slashIndex + 1 + length);

            result.add(word);

            i = slashIndex + 1 + length;
        }
        return result;    
         
    }
}
