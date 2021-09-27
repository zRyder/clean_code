import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) throws FileNotFoundException {
        WordList test = new WordList("./src/input.txt");

        test.parse_input_stream('A');
        test.parse_input_stream('E');
        test.parse_input_stream('I');
        test.parse_input_stream('O');
        test.parse_input_stream('U');
        test.print_list();
    }
}

class WordList {
    private ArrayList<String> word_list;
    private Scanner input_file;
    private ArrayList<String> raw_list;

    public WordList(String file_path) throws FileNotFoundException {
        word_list = new ArrayList<>();
        input_file = new Scanner(new File(file_path));
        raw_list = new ArrayList<>();
        parse_into_struct();
    }

    public void print_list() {
        System.out.println(word_list);
    }

    private void parse_into_struct() {
        while (input_file.hasNextLine()) {
            raw_list.add(input_file.nextLine());
        }
    }

    public void parse_input_stream(Character token) {
        for (int i = 0; i < raw_list.size(); i++) {
            if(raw_list.get(i).charAt(0) == token) {
                word_list.add(raw_list.get(i));
            }
        }
    }
}
