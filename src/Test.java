import java.io.File;

public class Test {

    static int maxDepth = 0;
    static String name;

    public static void main(String[] args) {
        File dir = new File("C:\\j\\basedir");

        getDepth(dir, 0);

        System.out.println(name);
        System.out.println(maxDepth);
    }

    private static void getDepth(File file, int depth) {

        depth++;

        if (file.isFile()) {
            if (depth > maxDepth) {
                maxDepth = depth;
                name = file.getName();
            }
        } else {
            File[] files = file.listFiles();
            if (files.length == 0) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                    name = file.getName();
                }
            } else {
                for (File file1 : files) {
                    getDepth(file1, depth);
                }
            }


        }



    }


}
