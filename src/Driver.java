import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Driver {

    public static void main(String[] args) {
        Driver.run();
    }

    static void run(){
        //open a reader and a writer for input.txt and output.txt
        BufferedReader reader;
        FileWriter writer;

        var fileName = "input.txt";

        try {
            reader = new BufferedReader(new FileReader(fileName));
            writer = new FileWriter("output.txt");

            //temp strings for easier time with compression ratio
            String temp1, temp2;
            //operation variable :: 1 = encoding, 2 = decoding, 3 = equality
            int operation = 0;
            //line to be re ad
            String line = reader.readLine();
            //regex string to detect when to split when testing for equality
            String regex = "\\s+";
            String[] splitArr;

            while (line != null){


                if (line.contains("Encoding")) {
                    writer.write("Test 1: Output for Encoding \n");
                    operation = 1;

                }
                else if(line.contains("Decoding")){
                    writer.write("Test 2: Output for Decoding \n");
                    operation = 2;

                }else if (line.contains("equality") || line.contains("Equality")){
                    writer.write("Test 3: Output for equality \n");
                    operation = 3;

                }
                //input string
                temp1 = line;


                //encode and write
                if (operation == 1 && !line.contains("Encoding"))
                {

                    //input string converted to LL then encoded into string temp2
                    temp2 = RLE.encode(stringToLL(line).getFront());

                    //write LinkedList first
                    writer.write("[" + stringToLL(line) + ":" + temp1.length() + "] \n");
                    //write encoded string second
                    writer.write("[" + temp2 + ":" + temp2.length() + "]");
                    //write compression ratio
                    writer.write("["+ (float) temp1.length() / temp2.length() +"]"+ "\n");
                }
                if(operation == 2 && !line.contains("Decoding")){

                    temp2 = RLE.decode(line);

                    //write encoded string first
                    writer.write("[" + temp1 + "]");
                    //write decoded string second
                    writer.write("[" + temp2 + "] \n" );

                }
                if (operation == 3 && !line.contains("Equality")){

                    //split based on whitespace
                    splitArr = line.split(regex);

                    //if only one string is found
                    if(splitArr.length == 1){
                        writer.write("[" + line + "]" + " [false] \n");
                    }else {
                        writer.write("[" + splitArr[0] + "]" + " [" + splitArr[1] + "] " + "["+RLE.equal(stringToLL(splitArr[0]), stringToLL(splitArr[1])) + "]\n");
                    }

                }

                line = reader.readLine();
            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static SingleLinkedList stringToLL(String theString){

        SingleLinkedList newSLL = new SingleLinkedList();

        for (int i = 0; i < theString.length(); i++){
            newSLL.add(theString.charAt(i));
        }

        return newSLL;
    }

}
