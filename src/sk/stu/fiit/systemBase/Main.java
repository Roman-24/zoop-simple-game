package sk.stu.fiit.systemBase;

class Main { // packed private

    public static void main(String[] args) {

        // making new system and start system
        SystemBase systemBase = new SystemBase();
        systemBase.start();

        // start system loop for scan inputs
        SystemInput inputs = new SystemInput(systemBase);
        inputs.inputLoop();
    }

}