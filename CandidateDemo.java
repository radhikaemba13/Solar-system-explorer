import java.util.Scanner;

class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;

    // Parameterized constructor
    Candidate(int candidateId, String name, int aptitude,
              int technical, int communication) {

        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    // Calculate overall score
    int getTotalScore() {
        return aptitude + technical + communication;
    }

    // Display candidate details
    void display() {
        System.out.println(candidateId + " " + name + " "
                           + getTotalScore());
    }
}

public class CandidateDemo {

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        System.out.print("Enter number of candidates to shortlist: ");
        int k = sc.nextInt();

        // Array of Candidate objects
        Candidate[] candidates = new Candidate[n];

        // Read candidate details
        for (int i = 0; i < n; i++) {

            System.out.println();
            System.out.println("Enter details of Candidate " + (i + 1));

            System.out.print("Candidate ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Aptitude: ");
            int aptitude = sc.nextInt();

            System.out.print("Technical: ");
            int technical = sc.nextInt();

            System.out.print("Communication: ");
            int communication = sc.nextInt();

            candidates[i] = new Candidate(
                id, name, aptitude, technical, communication
            );
        }

        // Sort candidates
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                int score1 = candidates[j].getTotalScore();
                int score2 = candidates[j + 1].getTotalScore();

                /*
                 * Higher score gets higher priority.
                 * If scores are equal, smaller ID gets priority.
                 */
                if (score1 < score2 ||
                    (score1 == score2 &&
                     candidates[j].candidateId >
                     candidates[j + 1].candidateId)) {

                    Candidate temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }

        // Display Top K candidates
        System.out.println();
        System.out.println("===== TOP " + k + " CANDIDATES =====");

        for (int i = 0; i < k; i++) {
            candidates[i].display();
        }

        sc.close();
    }
}