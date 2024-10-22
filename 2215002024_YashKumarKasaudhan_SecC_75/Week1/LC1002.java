class Solution {
    public List<String> commonChars(String[] words) {
        int n=words.length;
        int j;
        int[][] freq=new int[n-1][26];
        for(int x=1;x<n;x++)
        {
            for(char c: words[x].toCharArray())
            {
                freq[x-1][c-'a']++;
            }
        }
        List<String> res=new ArrayList<>();
        for(char c: words[0].toCharArray())
        {
            for(j=1;j<n;j++)
            {
                if(freq[j-1][c-'a'] > 0) freq[j-1][c-'a']--;
                else break;
            }
            if(j==n)
                res.add(c+"");
        }
        return res;
    }
}