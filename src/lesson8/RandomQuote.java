package lesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RandomQuote {

    public static void main(String[] args) throws IOException {
        String page = downloadWebPage("https://api.breakingbadquotes.xyz/v1/quotes");
        int startQuote = page.lastIndexOf("quote");
        int endQuote = page.lastIndexOf(",");
        String quote = page.substring(startQuote + 8, endQuote - 1);
        int startAuthor = page.lastIndexOf("author");
        int endAuthor = page.lastIndexOf("}");
        String author = page.substring(startAuthor + 9, endAuthor - 1);
        String op = (!author.equals("Walter White")) ? "Error" :  quote + "\n" + author;
        System.out.println(op);

    }

    private static String downloadWebPage(String url) throws IOException {

        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }
}
