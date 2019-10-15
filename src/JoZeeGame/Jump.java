package JoZeeGame;

public class Jump extends Thread {

    private static boolean done = true;
    static boolean highPoint = false;
    private static int originalY = 500;
    static int jumpPosition = originalY;
    private static final int JUMP_HEIGHT = 150;

    public void run() {

        done = false;
        int delay = 20;

        while (!done) {

            jump();

            try {
                Thread.sleep(delay);
            } catch (Exception ignored) { }

        }

        highPoint = false;
    }

    private void jump() {

        if (!highPoint) {
            jumpPosition -= 10;
        }

        if (jumpPosition == originalY - JUMP_HEIGHT) {

            highPoint = true;
        }

        if (highPoint && jumpPosition <= originalY) {

            jumpPosition += 10;
            if (jumpPosition == originalY) {
                done = true;
            }
        }

    }

}
	

