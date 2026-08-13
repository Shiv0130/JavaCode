//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Theory questions
        //1.What are Swings?
        //Swing is a Java GUI (Graphical User Interface) toolkit used to create window-based applications.
        // It is part of Java Foundation Classes (JFC) and provides a set of lightweight components
        // (like buttons, text fields, tables)
        // for building interactive user interfaces.

        //2.Describe various features of Swings
        //Key features of Swing:
        //Lightweight Components: Swing components do not rely heavily on the underlying operating system’s GUI.
        //Pluggable Look and Feel (PLAF): The appearance of components can be changed (e.g., Metal, Nimbus, Windows).
        //Rich Set of Components: Buttons, lists, tables, trees, menus, sliders, etc.
        //MVC Architecture: Follows Model-View-Controller design for separation of data and presentation.
        //Event Handling: Supports robust event handling through listeners.
        //Double Buffering: Reduces flickering when updating GUIs.
        //Extensibility: Components can be extended to create custom widgets.

        //3. Some commonly used Swing components:
        //JButton – A push button.
        //JLabel – Displays text or images.
        //JTextField – Single-line text input field.
        //JTextArea – Multi-line text input area.
        //JCheckBox – Checkbox for boolean options.
        //JRadioButton – Option button used in groups.
        //JComboBox – Drop-down list for selecting items.
        //JList – Displays a list of items.
        //JTable – Displays data in tabular form.
        //JTree – Hierarchical data representation.


        //4. Describe basic Swing containers
        //Swing containers are used to hold and organize components:
        //JFrame – Main window with title bar, close/minimize buttons.
        //JPanel – Lightweight container for grouping components.
        //JDialog – Popup dialog window, can be modal or non-modal.
        //JApplet – Swing container for applets (runs inside a web browser).
        //JSplitPane – Divides area into two resizable sections.
        //JScrollPane – Adds scroll bars to components.


        //5. Define JApplet
        //A JApplet is a Swing container used for applets,
        // which are small Java programs that run inside a web browser or applet viewer.
        // It extends java.applet.Applet and provides Swing features for building GUI applets.


        //6. Define Tables
        //A JTable is a Swing component used to display and manage data in rows and columns (tabular format). Features include:
        //Supports editable or read-only tables.
        //Can use custom renderers and editors for cells.
        //Integrates with scroll panes for large tables.

        new CourseSelectionForm();

    }
}