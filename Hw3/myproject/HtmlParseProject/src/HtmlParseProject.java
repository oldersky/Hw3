import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by HP on 30.06.2017.
 */
public class HtmlParseProject {
    public static void main(String args[]) {

        int numberOfSlash = 0, numberOfBreckets = 0, numberOfStrings = 0;

        try (BufferedReader in = new BufferedReader(new FileReader("D:\\JavaProjects\\HtmlParseProject\\src\\HtmlText.txt"))) {

            String s, runText, kbdText = "", color, allText = "";

            while ((s = in.readLine()) != null) {
                numberOfStrings++;
                allText += s;
                if (s.toLowerCase().contains("<marquee>")){
                    runText = s.substring(((s.toLowerCase().indexOf("<marquee>")) + 9), s.toLowerCase().lastIndexOf("</marquee>"));
                    System.out.println(runText);
                }
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '<') {
                        numberOfBreckets++;
                    } else if(s.charAt(i) == '/') {
                        numberOfSlash++;
                    }
                }
                if (s.toLowerCase().contains("<kbd>")) {
                    kbdText += s.substring(((s.toLowerCase().indexOf("<kbd>")) + 5), s.toLowerCase().indexOf("</kbd>"));
                }
                if (numberOfStrings == 16) {
                    color = s.substring(((s.toLowerCase().indexOf("color=")) + 6), s.toLowerCase().indexOf(">"));
                    System.out.println(color);
                }

            }

            System.out.println("Количесвто тэгов = " + (numberOfBreckets - numberOfSlash));
            System.out.println(kbdText);
            System.out.println(allText);

            String newText = "";
            int firstPosition = 0;
            boolean openF = false, closeF = true, openQuotes = false;

            for (int i = 0; i < allText.length(); i++) {
                if (allText.charAt(i) == '<') {
                    openF = true;
                }
                if (allText.charAt(i) == '>') {
                    closeF = false;
                    if (openQuotes) {
                        newText += allText.substring(firstPosition, i) + "\">";
                        openQuotes = false;
                        firstPosition = i + 1;
                    }
                    if (openF && !closeF) {
                        openF = false;
                        closeF = true;
                    }
                }
                if ((allText.charAt(i) == '=') && openF && closeF && !(allText.charAt(i + 1) == '\"')) {
                    newText += allText.substring(firstPosition, i) + "=\"";
                    openQuotes = true;
                    firstPosition = i + 1;
                }
                if ((allText.charAt(i) == ' ') && openQuotes) {
                    newText += allText.substring(firstPosition, i) + "\" ";
                    openQuotes = false;
                    firstPosition = i + 1;
                }
            }
            System.out.println(newText);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}