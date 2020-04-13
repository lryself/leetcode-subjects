package 标准题库;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/***/
public class s455 {
    private Solution myClass;

    @Before
    public void setUp() throws Exception {
        myClass = new Solution();
    }

    @Test
    public void answer() throws Exception {
        int[] g={1,2,3},s={1,1};
        assertEquals(1,myClass.findContentChildren(g,s));
    }

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i=0;
            for(int j=0;i<g.length&&j<s.length;j++)
            {
                if(g[i]<=s[j])
                {
                    i++;
                }
            }
            return i;
        }
    }
}