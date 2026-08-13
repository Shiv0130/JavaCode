/*
 * Runs in a separate thread to promote the next student
 * from the waitlist after a cancellation — simulates background processing.
 */
public class WaitlistPromoter extends Thread {

    private Event  event;
    private String cancelledStudentID;

    public WaitlistPromoter(Event event, String cancelledStudentID) {
        this.event              = event;
        this.cancelledStudentID = cancelledStudentID;
    }

    @Override
    public void run() {
        try {
            // Small delay to simulate async background work
            Thread.sleep(500);

            String promoted = event.promoteFromWaitlist();

            if (promoted != null) {
                System.out.println("\n[SYSTEM] Registration cancelled. Student "
                        + promoted + " has been promoted from the waitlist to the event.");
            }
        } catch (InterruptedException e) {
            System.out.println("[ERROR] Promotion thread interrupted.");
        }
    }
}
