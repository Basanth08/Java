module practicum2 {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires java.desktop;

    opens practicum2.question1.view to javafx.fxml;
    exports practicum2.question1.view;
    exports practicum2.question1.model;

}
