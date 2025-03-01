public class RLE {

    static String encode(Node head){

        //temp node to copy
        Node temp = head;
        //char1 gets the heads element
        //will always be one node element behind char2 until last node
        char char1 = temp.data;
        //set temp to the "head.next"
        temp = temp.next;
        //initialize stringbuilder
        StringBuilder encodedString = new StringBuilder();
        //counter for occurences of charactesr
        int count = 1;

        char char2;

        while(temp != null){
            //char2 = current element
            char2 = temp.data;

            //if past element = current element increase occurrence counter
            if (char1 == char2){

                count++;

            }else {

                if (count == 1) {
                    //System.out.println("count is 1");
                    encodedString.append(count).append(char1);
                }
                if (count > 1) {
                    //System.out.println("count greater than 1");
                    encodedString.append(count).append(char1);
                    count = 1;
                }
            }
            //make char1 the current node element before switching temp to temp.next
            char1 = char2;
            //iterate to next node
            temp = temp.next;

        }
        //adding the last element
        encodedString.append(count).append(char1);

        return encodedString.toString();

    }

    static String decode(String encodedString){

        SingleLinkedList theSLL = new SingleLinkedList();


        boolean bigNumber = false;
        StringBuilder digit = new StringBuilder("");
        int occurences;


        for (int i = 1; i < encodedString.length(); i++) {


            //flag for current being a digit
            boolean isCurrentDigit = Character.isDigit(encodedString.charAt(i));

            //flag for prev being a digit
            boolean isPrevDigit = Character.isDigit(encodedString.charAt(i - 1));


           //System.out.println("iter: " + i + " || current: " + current + " isCurrentDigit? " + isCurrentDigit +  " || prev: " + prev + " isPrevDigit? " + isPrevDigit);

            if(bigNumber){
                occurences = Integer.parseInt(digit.toString());


                for(int j = 0; j < occurences; j++){
                    theSLL.add(encodedString.charAt(i));
                }
                digit.setLength(0);
                continue;

            }

            if(isPrevDigit && !isCurrentDigit){

                occurences = Integer.parseInt(String.valueOf(encodedString.charAt(i - 1)));
                //System.out.println(occurences);

               for (int j = 0; j < occurences; j++){
                   //System.out.println("adding current " + current +" "+ j + " times");

                   theSLL.add(encodedString.charAt(i));

               }

            }
            //if two digits detected -> flag
            if(isPrevDigit && isCurrentDigit){
                digit.append(encodedString.charAt(i - 1)).append(encodedString.charAt(i));
                bigNumber = true;
            }

        }
        return theSLL.toString();

    }

    static boolean equal(SingleLinkedList theSLL1, SingleLinkedList theSLL2){

        //two pointers to iterate through LL for comparison

        Node pointer1 = theSLL1.getFront();

        Node pointer2 = theSLL2.getFront();

        if (theSLL1.getCount() != theSLL2.getCount()){
            return false;
        }
        else
        {

            while (pointer1 != null && pointer2 != null){


                if (pointer1.data == pointer2.data){

                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
                else
                {
                    return false;
                }

            }

        }

    return true;
    }
}
