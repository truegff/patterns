package ge.lanmaster.pattern.Mediator;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

/**
 * @author alexander
 */
public class Banquet extends JDialog {

    private class ItemAdapter implements ItemListener {

        private boolean busy = false;

        public ItemAdapter() {
        }

        public void itemStateChanged(ItemEvent ie) {
            enforceInvariants();
        } // itemStateChanged(ItemEvent)

        private void enforceInvariants() {
            if (busy) {
                return;
            }
            busy = true;
            protectedEnforceInvariants();
            busy = false;
        } // enforceInvariants()

        private void protectedEnforceInvariants() {
            // set enable to true if number of people is set
            boolean enable = (peopleCount != PEOPLE_COUNT_DEFAULT);

            // Date, start, end, buffet button and table button
            // are enabled if, and only if, a valid value is in
            // the number of people field.
            dateField.setEnabled(enable);
            startField.setEnabled(enable);
            endField.setEnabled(enable);
            buffetButton.setEnabled(enable);
            tableServiceButton.setEnabled(enable);
            if (enable) {
                // Food list is enabled if and only if date or
                // time fields or radio buttons are enabled and
                // end time is at least one hour later than
                // start time and the buffet button or table
                // button is selected.
                enable = (buffetButton.isSelected() || tableServiceButton.isSelected());
                foodList.setEnabled(enable && endAtLeastOneHourAfterStart());
            } else {
                // if date or time fields or radio buttons are
                // disabled, food list must also be disabled.
                foodList.setEnabled(false);
                // radio buttons not enabled must deselect.
                buffetbutton.setSelected(false);
                tableServiceButton.setSelected(false);
            } // if enable
            okButton.setEnabled(foodList.isEnabled() && foodList.getMinSelectedIndex() > -1);
        } // protectedEnforceInvariants()

        private boolean endAtLeastOneHourAfterStart() {
            Calendar startCalendar = getStartCalendar();
            if (startCalendar == null) {
                return false;
            }
            Calendar endCalendar = getEndCalendar();
            if (endCalendar == null) {
                return false;
            }
            startCalendar.add(Calendar.MINUTE, 59);
            return getEndCalendar().after(startCalendar);
        } // endAtLeastOneHourAfterStart()
    } // class ItemAdapter

    private class BanquetMediator {

        private JButton okButton;
        private JTextComponent dateField;
        private JTextComponent startField;
        private JTextComponent peopleCountField;

        public BanquetMediator() {
            WindowAdapter windowAdapter = new WindowAdapter() {

                public void windowOpened(WindowEvent e) {
                    initialState();
                } // windowOpened(WindowEvent)
            };
            BanquetReservationDialog enclosingDialog;
            enclosingDialog = BanquetReservationDialog.this;
            enclosingDialog.addWindowListener(windowAdapter);
        } // Constructor()

        public void registerOkButton(JButton ok) {
            okButton = ok;
        }

        //registerOkButton(JButton);

        public void registerPeopleCountField(final JTextComponent field) {
            peopleCountField = field;
            DocumentAdapter docAdapter = new DocumentAdapter() {

                protected void parseDocument() {
                    int count = PEOPLE_COUNT_DEFAULT;
                    try {
                        String countText = field.getText();
                        count = Integer.parseInt(countText);
                    } catch (NumberFormatException e) {
                    }
                    if (MIN_PEOPLE <= count && count <= MAX_PEOPLE) {
                        peopleCount = count;
                    } else {
                        peopleCount = PEOPLE_COUNT_DEFAULT;
                    }
                } // parseDocument()
            };
            Document doc = field.getDocument();
            doc.addDocumentListener(docAdapter);
        } // registerPeopleCountField(JTextComponent)
    }

    private ItemAdapter itemAdapter = new ItemAdapter();
}
