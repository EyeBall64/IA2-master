public class DataBase {

    private String filename;
    private int rowWidth;
    private int recordCount;
    private int totalColNumber;

    public DataBase(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        //recordCount = getRecordCount();
    }

    public void appendRecord(String data) {
       /*String[] Separator = new String[2];
       Separator = data.split(",");
       if (Separator[0].length() != 10 )
        */

        if (data.length() != rowWidth){
            if (data.length() > rowWidth){
                System.out.println("Tried to write " + data + " to field width of " + rowWidth);

            }
            while (data.length() < rowWidth){
                data = data + " ";
            }

        }
        if (data.length() == 10){
            FileHandler.appendLine(filename, data);
        }

        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record

    }

    public void deleteRecord(int rowNumber) {
    }

    public String getRecord(int rowNumber, int colNumber) {
        //System.out.println("GET RECORD!!!");
        return "a"; //FileHandler.readLineAt(filename,rowNumber*totalColNumber+colNumber );
    }

    public int getRecordCount() {
        int count = 0;
        int countCol = 0;
        String record = getRecord(count,countCol );
        while (record != null){
            countCol++;
            record = getRecord(count,countCol);
            if (countCol >totalColNumber){
                countCol = 0;
                count++;
            }
        }
        return count*(countCol+1);
        // return FileHandler.countLines(filename);
    }
/*
    public boolean findRecord(String SearchData) {
        String CurrentData = getRecord(0);
        int counter = 0;
        while(counter < recordCount){
            counter++;
            getRecord(counter);
        }

        // search for a record matching data
        // return true if found
        return false;
    }

 */
}
