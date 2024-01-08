module com.example.agentieturism {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires kernel;
    requires layout;
    requires org.slf4j;

    opens com.example.agentieturism to javafx.fxml;
    exports com.example.agentieturism;
}