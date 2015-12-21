package cn.boxfish;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
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

    @Test
    public void encode() {
//        final String s = StringEscapeUtils.unescapeHtml("<span>The plant has plenty of&nbsp;buds&nbsp;but no flowers yet..m4a</span>");
//        System.out.println(s);
    }

    @Test
    public void socket() throws IOException {
        Socket client = new Socket("192.168.0.111", 6666);
        System.out.println(client);
    }

    @Test
    public void split() {
        String[] arr = "&luolibing&liuxiaoling&".split("&");
        System.out.println(arr.length);
        arr = Arrays.copyOfRange(arr, 1, arr.length);
        for(String name: arr) {
            System.out.println(name);
        }
    }

    @Test
    public void client() throws IOException {
        Socket client = new Socket("127.0.0.1", 9092);
        OutputStream out = client.getOutputStream();
        byte[] bytes = Files.readAllBytes(Paths.get("/Users/boxfish/further.jpg"));
        out.write(bytes);
        out.close();
    }

    @Test
    public void resolvePath() {
        final Path basePath = Paths.get("/share");
        final Path path = Paths.get("/share/json/sdfdasf.json");
        final Path resolve = basePath.resolve(path);

        final Path relativize = basePath.relativize(path);
        System.out.println(relativize.toString());
    }

    @Test
    public void testBuffer() {
        System.out.println(new Integer(1).toString());
    }

    @Test
    public void testLock() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    updateCache();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
        for(int i=0; i<1000; i++) {
            int k = new Random().nextInt(100);
            queue.add(k);
        }
    }

    Map<String, String> resultMap = new HashMap<>();

    static TransferQueue<Integer> queue = new LinkedTransferQueue<>();

    static void updateCache() throws InterruptedException {
        int i = 0;
        while(true) {
            Thread.sleep(100);
            Integer k = queue.take();
            queue.remove(k);
            System.out.println(i++);
            System.out.println(queue.size());
        }
    }

    @Test
    public void test1() throws InterruptedException {
        TransferQueue<Integer> queue = new LinkedTransferQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(1);
        queue.add(1);

        while(true) {
            Integer val = queue.take();
            queue.remove(val);
            System.out.println(val);
        }
    }

}
