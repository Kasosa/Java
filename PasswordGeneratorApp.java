import java.security.SecureRandom;

public class PasswordGeneratorApp {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+={}[]|\\:;\"<>,.?/~`";
    private static final int PASSWORD_LENGTH = 12;

    private SecureRandom random = new SecureRandom();
    private PasswordGeneratorAppThread generatorThread;

    public PasswordGeneratorApp() {
        generatorThread = new PasswordGeneratorAppThread();
        generatorThread.start();
    }

    public void stopGeneratingPasswords() {
        generatorThread.stopGeneratingPasswords();
    }

    private class PasswordGeneratorAppThread extends Thread {
        private boolean generatingPasswords = true;
        private String generatedPassword;

        @Override
        public void run() {
            while (generatingPasswords) {
                try {
                    Thread.sleep(5000); // generate a new password every 5 seconds
                } catch (InterruptedException e) {
                    // ignore
                }
                generatedPassword = generatePassword();
                System.out.println(generatedPassword); // print the generated password for testing purposes
            }
        }

        public void stopGeneratingPasswords() {
            generatingPasswords = false;
        }

        protected String getGeneratedPassword () {
            return generatedPassword;
        }
    }

    public String generatePassword() {
        StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}

