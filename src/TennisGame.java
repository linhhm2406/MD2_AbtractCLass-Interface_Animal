public class TennisGame {

    public static final String LOVE = "Love";
    public static final String ALL = "All";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for";

    public static String getScore(int player1Score, int player2Score) {
        StringBuilder score = new StringBuilder();
        if (player1Score == player2Score) {
            score = new StringBuilder(displayWhenDraw(player1Score));
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = new StringBuilder(getPalayerAdvantageOrWin(player1Score, player2Score));
        } else {
            getPlayerScore(player1Score, player2Score, score);
        }
        return score.toString();
    }
    private static void getPlayerScore(int player1Score, int player2Score, StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score.append("-");
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score.append(LOVE);
                    break;
                case 1:
                    score.append(FIFTEEN);
                    break;
                case 2:
                    score.append(THIRTY);
                    break;
                case 3:
                    score.append(FORTY);
                    break;
            }
        }
    }

    private static String displayWhenDraw(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = LOVE + "-" + ALL;
                break;
            case 1:
                score = FIFTEEN + "-" + ALL;
                break;
            case 2:
                score = THIRTY + "-" + ALL;
                break;
            case 3:
                score = FORTY + "-" + ALL;
                break;
            default:
                score = DEUCE;
                break;
        }
        return score;
    }

    private static String getPalayerAdvantageOrWin(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = ADVANTAGE + PLAYER_1;
        else if (minusResult == -1) score = ADVANTAGE + PLAYER_2;
        else if (minusResult >= 2) score = WIN_FOR + PLAYER_1;
        else score = WIN_FOR + PLAYER_2;
        return score;
    }
}
