import java.io.*;
import java.util.*;

public class Solution {

    static String numberToString(int a) {
        String result = "";
        int mLen, mDigit;
        String num = ((Integer) a).toString();
        mLen = num.length() - 1;
        String[] mNumText = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};
        for (int i = 0; i <= mLen; i++) {
            mDigit = Integer.parseInt(num.substring(i, i+1));
            result = result + " " + mNumText[mDigit];
            if (mLen == i) break;
            switch ((mLen - i) % 9) {
                case 0:
                    result = result + " ty";
                    if (num.substring(i + 1, 3) == "000") i = i + 3;
                    if (num.substring(i + 1, 3) == "000") i = i + 3;
                    if (num.substring(i + 1, 3) == "000") i = i + 3;
                    break;
                case 6:
                    result = result + " trieu";
                    if (num.substring(i + 1, 3) == "000") i = i + 3;
                    if (num.substring(i + 1, 3) == "000") i = i + 3;
                    break;
                case 3:
                    result = result + " nghin";
                    if (i + 3 < mLen) {
                        if (num.substring(i + 1, 3) == "000") i = i + 3;
                    }
                    break;
                default:
                    switch ((mLen - i) % 3) {
                        case 2:
                            result = result + " tram";
                            break;
                        case 1:
                            result = result + " muoi";
                            break;
                    }
                    break;
            }
        }
        result = result.replace("khong muoi ", "linh ");
        result = result.replace("muoi khong", "mươi");
        result = result.replace("mot muoi", "muoi");
        result = result.replace("muoi bon", "muoi bon");
        result = result.replace("linh bon", "linh tu");
        result = result.replace("muoi nam", "muoi lam");
        result = result.replace("muoi mot", "muoi mot");
        result = result.replace("muoi nam", "muoi lam");
        result = result.replace("tram khong muoi khong", "tram");
        result = result.replace("tram linh khong", "tram");
        return result;
    }

    // Below is template code used to interact with stdin and stdout to run tests.
    // Please study it carefully if you need to edit. Then, temporarily show all code.
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // Edit input format here
        // Currently, we take two newline separated strings from stdin
        int a = Integer.parseInt(scanner.nextLine());

        // Edit output processing here
        // Currently, we print the output to stdout
        bufferedWriter.write(numberToString(a));

        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
