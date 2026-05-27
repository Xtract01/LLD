// class JudgeAnalytics {
//     private int run = 0;
//     private int submit = 0;
//     public void countRun(){
//         run++;
//     }
//     public void countSubmit(){
//         submit++;
//     }
//     public int getRun() {
//         return run;
//     }
//     public int getSubmit() {
//         return submit;
//     }
// }


//Thread Safe Singleton (Eager Initialization)
// class JudgeAnalytics {
//     private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//     private JudgeAnalytics() {}
//     public static JudgeAnalytics getInstance() {
//         return judgeAnalytics;
//     }
// }

// Lazy loading Singleton (Not Thread Safe)
// class JudgeAnalytics {
//     private static JudgeAnalytics judgeAnalytics;
//     private JudgeAnalytics() {}
//     public static JudgeAnalytics getInstance() {
//         if (judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();
//         }
//         return judgeAnalytics;
//     }
// }


// Thread Safe Singleton (Lazy Initialization with Synchronized Method)
// class JudgeAnalytics {
//     private static JudgeAnalytics judgeAnalytics;
//     private JudgeAnalytics() {}
//     public static synchronized JudgeAnalytics getInstance() {
//         if (judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();
//         }
//         return judgeAnalytics;
//     }
// }

// Thread Safe Singleton (Lazy Initialization with Double-Checked Locking)
// class JudgeAnalytics {
//     private static volatile JudgeAnalytics judgeAnalytics;
//     private JudgeAnalytics() {}
//     public static JudgeAnalytics getInstance() {
//         if (judgeAnalytics == null) {
//             synchronized (JudgeAnalytics.class) {
//                 if (judgeAnalytics == null) {
//                     judgeAnalytics = new JudgeAnalytics();
//                 }
//             }
//         }
//         return judgeAnalytics;
//     }
// }

//Bill Pugh Singleton Implementation (Thread Safe and Lazy Initialization)
class JudgeAnalytics {
    private JudgeAnalytics() {}
    private static class Holder {
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }
    public static JudgeAnalytics getInstance() {
        return Holder.judgeAnalytics;
    }
}

public class Main {
    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics1 = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
        System.out.println(judgeAnalytics1 == judgeAnalytics2); // true
    }
}