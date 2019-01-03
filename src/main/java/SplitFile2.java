import java.io.*;

//?????????

public class SplitFile2 {
    public static void main(String[] args) throws IOException {
        //first read the file
        String inputfile = "FileToSplit/file.csv";
        BufferedReader br = new BufferedReader(new FileReader(inputfile));
        //create thje first file which will have 1000 lines
        File file = new File("FileAfterSplite/FileNumber_"+1+".csv");
        FileWriter fstream1 = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream1);
        String line="";
        //count the number of line
        int count=1;
        int file_Number=2;
        while ((line = br.readLine()) != null)
        {
            //if the line is divided by 1000 then create a new file with file count
            if(count % 1000 == 0)
            {
                File newFile = new File("FileAfterSplite/FileNumber_"+file_Number+".csv");
                fstream1 = new FileWriter(newFile);
                file_Number++;
                out = new BufferedWriter(fstream1);
            }
            if(line.indexOf(",")!=-1)
                line=line.substring(0, line.indexOf(","));
            out.write(line);
            out.newLine();
            count++;
        }

    }

}
