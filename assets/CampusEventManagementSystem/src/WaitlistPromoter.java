public class WaitlistPromoter extends Thread { //Background thread which advances a waitlisted student when a registration is canceled.

    private Event event; //The event where a cancellation happened
    private String canceledStudentID; //ID of the student who canceled their registration

    //Constructor connecting promoter with a particular event and canceled student.
    public WaitlistPromoter(Event event, String cancelledStudentID) {
        this.event = event;
        this.canceledStudentID = cancelledStudentID;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500); //Delay before promoting to simulate async processing

            String promoted = event.promoteFromWaitlist(); //Try to promote next waitlisted student

            if (promoted != null) { //Alerts if a student was successfully promoted
                System.out.println("\n[SYSTEM] Registration cancelled. Student "
                        + promoted + " has been promoted from the waitlist to the event.");
            }
        } catch (InterruptedException e) {
            System.out.println("[ERROR] Promotion thread interrupted."); //Handle thread interruption
        }
    }
}
