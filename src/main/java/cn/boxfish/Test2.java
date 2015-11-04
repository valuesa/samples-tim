package cn.boxfish;

import org.junit.Test;

import java.io.IOException;
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

    @Test
    public void testTempPath() {
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

    @Test
    public void testWalk() throws IOException {
        /*Files.walkFileTree(Paths.get("/share/svn/人教PEP五上U4"),
                Sets.newHashSet(FOLLOW_LINKS),
                Integer.MAX_VALUE,
                new SimpleFileVisitor<Path>() {
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println(file.toString());
                        return FileVisitResult.CONTINUE;
                    }
                });*/
    }


    @Test
    public void getNow() {
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void regTest1() {
        // ^([a-zA-Z]+['-\s])*[a-zA-Z]+$
        Pattern pattern = Pattern.compile("^([a-zA-Z]+[-' ])*[a-zA-Z]+$");
        Matcher matcher = pattern.matcher("smart");
        boolean b = matcher.matches();
        System.out.println(b);
    }

    @Test
    public void decode() {
        //String str = new String(Base64.decodeBase64("L3NoYXJlL3N2bi_kurrmlZlQRVDkuInkuIpVNC8wMDEuVW5pdDRXZSBsb3ZlIGFuaW1hbHMgMS54bHN4"));
        //System.out.println(str);
    }

}
