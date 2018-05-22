package String;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> code = new ArrayList<>();
        if(source.length == 0 || source == null)
            return code;

        boolean isComment = false;
        StringBuilder newline = new StringBuilder();
        for(String line: source){
            line = line.trim();
            int i=0;
            char[] chars = line.toCharArray();
            if(!isComment)
                newline = new StringBuilder();
            while(i < line.length()){
                if(!isComment && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*'){
                    isComment = true;
                    i++;
                }

                else if(isComment && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/'){
                    isComment = false;
                    i++;
                }

                else if(!isComment && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/'){
                   break;
                }

                else if(!isComment){
                    newline.append(chars[i]);
                }
                i++;
            }

            if(!isComment && newline.length() > 0)
                code.add(newline.toString());
        }
        return code;
    }

    public static void main(String args[]){
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        RemoveComments rc = new RemoveComments();

        List<String> code = rc.removeComments(source);
        for(int i=0; i<code.size(); i++)
            System.out.println(code.get(i));
    }
}
