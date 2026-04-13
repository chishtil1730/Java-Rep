import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class AttendanceV2 {

    // ──────────────── constants ────────────────
    static final String[] SLOTS     = {"A1-COA","A2-MGT","B1-STS","C1-SWE","D1-DBMS","E1-MATH","F1-ML"};
    static final int      MIN_PCT   = 75;

    // ──────────────── timetable (day-code → classes held per slot) ────────────────
    static final LinkedHashMap<String, int[]> TIMETABLE = new LinkedHashMap<>();
    static {
        //                           A1 A2 B1 C1 D1 E1 F1
        TIMETABLE.put("1", new int[]{1, 1, 1, 1, 1, 0, 0}); // TUE
        TIMETABLE.put("2", new int[]{0, 0, 1, 0, 1, 1, 1}); // WED
        TIMETABLE.put("3", new int[]{1, 1, 0, 1, 1, 0, 0}); // THU
        TIMETABLE.put("4", new int[]{1, 0, 1, 0, 0, 1, 1}); // FRI
        TIMETABLE.put("5", new int[]{1, 0, 0, 1, 0, 1, 1}); // SAT
    }

    // ──────────────── hardcoded data ────────────────
    // Total classes held so far (before remaining days)
    static final int[] FINISHED  = {49, 24, 35, 37, 35, 34, 34};
    // Classes you actually attended
    static final int[] ATTENDED  = {42, 20, 30, 31, 32, 31, 31};
    // Remaining days encoded as day-codes (e.g. "23451234512345")
    static final String DAYS_LEFT = "23451234512345";

    // ─────────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        String[] remaining = DAYS_LEFT.split("");
        int n = SLOTS.length;

        // 1. Total classes after remaining days are over
        int[] totalFinished = Arrays.copyOf(FINISHED, n);
        for (String day : remaining) {
            addInPlace(totalFinished, TIMETABLE.get(day));
        }

        // 2. Classes still to be held (in the remaining days)
        int[] classesLeft = new int[n];
        for (String day : remaining) {
            addInPlace(classesLeft, TIMETABLE.get(day));
        }

        // 3. Minimum classes you must attend out of totalFinished to hit MIN_PCT
        //    formula: ceil(totalFinished * 0.75) = (totalFinished * 75 / 100) + 1
        int[] mustAttend = new int[n];
        for (int i = 0; i < n; i++) {
            mustAttend[i] = (totalFinished[i] * MIN_PCT / 100 + 1) - ATTENDED[i];
            if (mustAttend[i] < 0) mustAttend[i] = 0; // already safe
        }

        // 4. Classes you can skip (bunkable) = classesLeft − mustAttend
        int[] canBunk = new int[n];
        for (int i = 0; i < n; i++) {
            canBunk[i] = classesLeft[i] - mustAttend[i];
        }

        // 5. Projected attendance % if you attend exactly mustAttend more
        int[] projectedPct = new int[n];
        for (int i = 0; i < n; i++) {
            projectedPct[i] = (ATTENDED[i] + mustAttend[i]) * 100 / totalFinished[i];
        }

        // ─────────── print report ───────────
        printHeader("Attendance Report");

        printRow("Subject",        SLOTS,         false);
        printRow("Attended",       ATTENDED,      false);
        printRow("Finished so far",FINISHED,      false);
        printPctRow("Current %",   ATTENDED,      FINISHED);

        System.out.println();

        printRow("Classes remaining", classesLeft, false);
        printRow("Must attend",       mustAttend,  false);
        printRow("Can bunk",          canBunk,     false);
        printPctRow("Projected % (if you attend exactly must-attend)",
                addedArray(ATTENDED, mustAttend), totalFinished);

        System.out.println();
        printHeader("Summary");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s  attend %d / %d remaining   (can bunk %d)%n",
                    SLOTS[i], mustAttend[i], classesLeft[i], canBunk[i]);
        }
    }

    // ──────────────── helpers ────────────────

    static void addInPlace(int[] target, int[] delta) {
        if (target.length != delta.length) throw new IllegalArgumentException("Array length mismatch");
        for (int i = 0; i < target.length; i++) target[i] += delta[i];
    }

    static int[] addedArray(int[] a, int[] b) {
        int[] result = Arrays.copyOf(a, a.length);
        addInPlace(result, b);
        return result;
    }

    static void printHeader(String title) {
        System.out.println("─".repeat(70));
        System.out.println("  " + title);
        System.out.println("─".repeat(70));
    }

    static void printRow(String label, int[] values, boolean alignRight) {
        System.out.printf("%-46s", label);
        for (int v : values) System.out.printf("%6d", v);
        System.out.println();
    }

    static void printRow(String label, String[] values, boolean alignRight) {
        System.out.printf("%-46s", label);
        for (String v : values) System.out.printf("%6s", v);
        System.out.println();
    }

    static void printPctRow(String label, int[] attended, int[] finished) {
        System.out.printf("%-46s", label);
        for (int i = 0; i < attended.length; i++)
            System.out.printf("%5d%%", attended[i] * 100 / finished[i]);
        System.out.println();
    }
}