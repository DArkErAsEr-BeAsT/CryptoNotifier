import java.util.*;

import java.io.*;

import org.jsoup.Jsoup;

public class HtmlSource {
	public static void main(String[] args) throws IOException {
		/**
		 * Get source from URL in String
		 */
        String webPage = "https://courscryptomonnaies.com";
        String html = Jsoup.connect(webPage).get().html();
        /**
         * Create a text-file containing source
         */
        File file = new File("HTMLSource.txt");
        PrintStream fileOutput = new PrintStream(file);
        Scanner scanHTML = new Scanner(html);
        while(scanHTML.hasNextLine()) {
        	fileOutput.println(scanHTML.nextLine());
        }
        scanHTML.close();
        //fileOutput.print(html);
        /**
         * List the top 5 crytpo currencies
         * #1 initiate I/O streams
         */
        Scanner input = new Scanner(file);
        String liste = null;
        File topCurrencies = new File("topCurrencies.txt");
        PrintStream currencyOutput = new PrintStream(topCurrencies);
        /*
         * Look for the 5 first currencies
         */
        int counterCours = 0;
        int counterName = 0;
        while(input.hasNext() && counterCours < 5) {
        	String line = input.nextLine();
        	if(line.contains("<td data-title=\"Cours\" class=\"jsx-1338272632\"><span class=\"\">")) {
        		line = line.replaceAll("               <td data-title=\"Cours\" class=\"jsx-1338272632\"><span class=\"\">", "");
        		line = line.replaceAll(" �</span></td>", "");
        		currencyOutput.println(line);
        		counterCours++;
        	} else if (line.contains("<td data-title=\"Crypto-monnaie\" class=\"jsx-1338272632\"><span class=\"jsx-1338272632\"><img style=\"width:20px;margin-right:12px\"")) {
        		line = line.replaceAll("<span class=\"hidden-md hidden-lg\" style=\"color:#1DCC8C;font-weight:bold\">", "");
        		line = line.replaceAll("</span></span></td>", "");
        		line = line.replaceAll("               <td data-title=\"Crypto-monnaie\" class=\"jsx-1338272632\">", "");
        		line = line.substring(line.length()-12, line.length()-2);
        		currencyOutput.println(line);
        	}
        }
        fileOutput.close();
        currencyOutput.close();
        input.close();
    }
}
