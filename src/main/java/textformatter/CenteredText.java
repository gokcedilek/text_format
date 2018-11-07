package textformatter;

import java.util.regex.Pattern;

public class CenteredText extends FormattedText {
    int width;
    private static final String EMPTY = "";

    public CenteredText(String line, int width){
        super();
        this.width=width;
        add(line);
    }


    private void addToText(String line){
        //adds the given part of the line as a new line
        StringBuilder s= new StringBuilder(line);
        s.deleteCharAt(s.length()-1);
        line = line.substring(0, line.length() - 1);
        int firstSpace= (width- line.length())/2;
        int lastSpace= width-line.length()-firstSpace;
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<firstSpace; i++){
            sb.append(" ");
        }
        sb.append(s);
        for(int j=0; j<lastSpace; j++){
            sb.append(" ");
        }
        super.add(sb.toString());
    }

    public boolean add(String line){
        return generatePartsToAdd(line);
    }

    private boolean generatePartsToAdd(String line){
        if (line == null)
            return false;
        if (line.equals(EMPTY))
            return false;
        String[] parts = line.split("\\s+"); //new words
        if(parts.length==1 && parts[0].length()>=width) return super.add(line);
        String textToAdd="";
        int index=0;
        int sum=0;
        while(index<parts.length){
            while(textToAdd.length()+ parts[index].length()<=width){
                textToAdd=textToAdd+ parts[index]+" ";
                sum+=parts[index].length();
                index++;
                if(index==parts.length) break;
            }
            addToText(textToAdd); //appends this instance as a new line
            if(index==parts.length) break;
            if(parts[index].length()>=width)  {super.add(parts[index]); index++;}
            sum=0;
            textToAdd="";
        }
        return true;
    }

    public String toString(){
        return super.toString();
    }


}
