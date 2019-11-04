package exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Parser
{

    public static void main(String[] args) throws IOException
    {
        String empFileName = "users.csv";
        List<Person> listOFEmployees = mapCSV(empFileName);
        Map<String, List<Person>> postsPerType = listOFEmployees.stream()
                .collect(groupingBy(Person::getInsurance));
        for (Map.Entry<String,  List<Person>> entry : postsPerType.entrySet()) {
            entry.getValue().sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
            writeInsuranceCSV(entry.getKey(), entry.getValue());
        }
     }

     private static void writeInsuranceCSV(String fileName, List<Person> personList)throws IOException{
         FileWriter csvWriter = new FileWriter(fileName.concat(".csv"));
         csvWriter.append("User Id");
         csvWriter.append(",");
         csvWriter.append("First Name");
         csvWriter.append(",");
         csvWriter.append("Last Name");
         csvWriter.append(",");
         csvWriter.append("Version");
         csvWriter.append(",");
         csvWriter.append("Insurance Company");

         csvWriter.append("\n");

         for (Person rowData : personList) {
             csvWriter.append(rowData.getInsurance()).append(",")
                     .append(rowData.getUserId()).append(",")
                     .append(rowData.getLastName()).append(",")
                     .append(rowData.getFirstName()).append(",")
                     .append(rowData.getVersion().toString()).append(",")
                     .append(rowData.getInsurance()).append(",");
             csvWriter.append("\n");
         }
         csvWriter.flush();
         csvWriter.close();
     }
    private static Function<String, Person> csvPersonObj = (line) -> {
        String[] record = line.split(",");// This can be delimiter which
        Person person = new Person();
        if (record[0] != null && record[0].trim().length() > 0) {
            person.setUserId(record[0]);
        }
        if (record[1] != null && record[1].trim().length() > 0) {
            person.setFirstName(record[1]);
        }
        if (record[2] != null && record[2].trim().length() > 0) {
            person.setLastName(record[2]);
        }
        if (record[3] != null && record[3].trim().length() > 0) {
            person.setVersion(Integer.valueOf(record[3]));
        }
        if (record[4] != null && record[4].trim().length() > 0) {
            person.setInsurance(record[4]);
        }
        return person;
    };


    private static List<Person> mapCSV(String personCSVFilePath) {
        List<Person> pList = new ArrayList<Person>();
        try {
            File inputF = new File(personCSVFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // Skip the header since its just coloumn name in table and in CSV file but not the data.
            pList = br.lines().skip(1).map(csvPersonObj).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return pList;
    }


}
