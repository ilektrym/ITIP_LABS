import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataManager {
    private LinkedList<Object> processors;
    private ExecutorService service;
    private HashMap<String, Integer> data;
    private StringBuilder outputData;

    public DataManager() {
        processors = new LinkedList<>();
        service = Executors.newFixedThreadPool(10);
        data = new HashMap<>();
        outputData = new StringBuilder();
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        File file = new File(source);
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] dataSet = line.split(" - ");
                data.put(dataSet[0], Integer.parseInt(dataSet[1].replaceAll("конфе((ты)|т)?", "").replaceAll(" ", "")));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void processData() {
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                 {
                    futures.add(service.submit(() -> {
                        try {
                            return (String) method.invoke(processor, data);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return "";
                        }
                    }));
                    System.out.println(method.getName());
                }
            }
        }
        for (Future<String> f : futures) {
            try {
                outputData.append(f.get());
                outputData.append("\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        service.shutdown();
    }

    public void saveData(String outputFile) {
        File file = new File(outputFile);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outputData.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}