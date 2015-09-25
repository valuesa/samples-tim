package cn.boxfish;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LuoLiBing on 15/8/3.
 */
public class Test2 {

    int i;

    @Test
    public void test() {
        String[] arr = "/share/视频/图片//".split("/");
        System.out.println(arr[arr.length-1]);
        System.out.println(i);
        System.out.println(arr.hashCode());
    }

    @Test
    public void testPath() {
        Path path = Paths.get("/share");
        System.out.println(path);
    }

    @Test
    public void testMatch() {
        String match = "\"aaaa\"\"aaaa\"\"aaaa\"\"aaaa\"\"aaaa\"\"aaaa\"";
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(match);
        while(matcher.find())
            System.out.println(matcher.group());
    }

}
