package unit09.filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Displays data in a table format allowing the user to sort the table by the
 * data in any column by clicking on the column header.
 */
public class Filters extends Application {

    private List<String[]> data;
    private List<List<Label>> lables;

     @Override
    public void start(Stage stage) throws Exception {
        // The filename will be passed through as a command line parameter
        List<String> args = getParameters().getRaw();
        FileReader file = new FileReader(args.get(0));
        BufferedReader fin = new BufferedReader(file);
        int row = 0;
        int col = 0;

        // If the data is too big, add scroll bars
        ScrollPane scroller = new ScrollPane();
        scroller.setMaxSize(1000, 600);

        GridPane pane = new GridPane();
        data = new ArrayList<>();
        lables = new ArrayList<>();

        // Use the header to create the first row as buttons.
        String[] header = fin.readLine().strip().split(",");
        for (int i = 0; i < header.length; i++) {
            final int columnIndex = i;
            Button button = new Button(header[i]);
            button.setOnAction(e -> sortData(columnIndex));
            pane.add(button, col, row);
            col++;
        }
        row++;

        // Parse the CSV data using streams
        data = fin.lines()
                .map(line -> line.strip().split(","))
                .collect(Collectors.toList());

        // Create labels for each data row
        lables = data.stream()
                .map(record -> Arrays.stream(record)
                        .map(Label::new)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        // Add labels to the GridPane
        for (int i = 0; i < lables.size(); i++) {
            List<Label> labelRow = lables.get(i);
            for (int j = 0; j < labelRow.size(); j++) {
                pane.add(labelRow.get(j), j, i + 1);
            }
        }

        fin.close();

        scroller.setContent(pane);
        Scene scene = new Scene(scroller);
        stage.setScene(scene);
        stage.show();
    }

    private void sortData(int columnIndex) {
        data.sort(Comparator.comparing(row -> row[columnIndex]));
        update();
    }

    /**
     * Helper function used to update all the labels based on the
     * data. It should be called whenever the data changes.
     */
    private void update() {
        for (int i = 0; i < data.size(); i++) {
            String[] rowData = data.get(i);
            List<Label> labelRow = lables.get(i);
            for (int j = 0; j < rowData.length; j++) {
                labelRow.get(j).setText(rowData[j]);
            }
        }
    }

    public static void main (String[] args) {
        // Example of hard coding the args, useful for debugging but
        // should be removed to test using command line arguments.
        args = new String[] {"data/grades_010.csv"};
        launch (args);
    }
    
}
