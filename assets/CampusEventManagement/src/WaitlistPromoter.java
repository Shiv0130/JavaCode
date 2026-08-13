/* Runs in a separate background thread after a student cancels their registration
 * Automatically promotes the first student on the waitlist into the event */
public class WaitlistPromoter extends Thread {

    private Event  event;              // the event where the cancellation happened
    private String cancelledStudentID; // ID of the student who cancelled (for reference)

    public WaitlistPromoter(Event event, String cancelledStudentID) { // constructor receives the affected event
        this.event              = event;              // store the event reference
        this.cancelledStudentID = cancelledStudentID; // store who cancelled
    }

    @Override
    public void run() { // executes when the thread starts
        try {
            Thread.sleep(500); // small delay to simulate background/async processing

            String promoted = event.promoteFromWaitlist(); // attempt to move the first waitlisted student to registered

            if (promoted != null) { // only print if someone was actually promoted
                System.out.println("\n[SYSTEM] Registration cancelled. Student "
                        + promoted + " has been promoted from the waitlist to the event.");
            }
        } catch (InterruptedException e) { // handle the case where the thread is interrupted mid-sleep
            System.out.println("[ERROR] Promotion thread interrupted.");
        }
    }
}