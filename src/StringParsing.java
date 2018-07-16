import java.util.HashMap;

public class StringParsing {

    public String solution(String S) {
        // write your code in Java SE 8
        HashMap<String, Integer> map = new HashMap<>();
        map.put("mp3", 0);
        map.put("aac", 0);
        map.put("flac", 0);
        map.put("jpg", 1);
        map.put("bmp", 1);
        map.put("gif", 1);
        map.put("mp4", 2);
        map.put("avi", 2);
        map.put("mkv", 2);

        long[] size = new long[4];
        String[] listOfFiles = S.split("\n");
        for(int i=0; i<listOfFiles.length; i++){
            String file[] = listOfFiles[i].split("\\s");
            String fileExtension = file[0].substring(file[0].lastIndexOf(".")+1);
            long fileSize = Long.parseLong(file[1].substring(0, file[1].length()-1));
            if(map.containsKey(fileExtension)){
                size[map.get(fileExtension)] += fileSize;
            } else{
                size[3] += fileSize;
            }
        }
        return "music " + size[0] + "b \nimages " + size[1] + "b \nmovies " + size[2] + "b \nother " + size[3] + "b";
    }

    public static void main(String args[]){
        String str = "my.song.mp3 11b \ngreatSong.flac 1000b \nnot3.txt 5b \nvideo.mp4 200b \ngame.exe 100b \nmov!e.mkv 10000b";
        //System.out.println(str);

        StringParsing c = new StringParsing();
        System.out.println(c.solution(str));
    }
}
