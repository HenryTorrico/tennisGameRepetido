
public class TennisGame2 implements TennisGame
{
	private static final int _FORTY = 3;
	private static final int _THIRTY = 2;
	private static final int _FIFTEEN = 1;
	private static final int _LOVE = 0;
    public int P1point = _LOVE;
    public int P2point = _LOVE;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getLiteralScore(){
        String literalScore = "";
        literalScore = tie(literalScore);
        literalScore = deuce(literalScore);
        
        literalScore = normal(literalScore);
        literalScore = normal1(literalScore);
        
        literalScore = normal2(literalScore);
        literalScore = normal3(literalScore);
        
        literalScore = isAdvantageOver(literalScore);
        
        literalScore = winnerOver(literalScore);
        return literalScore;
    }

	private String winnerOver(String score) {
		if (P1point>_FORTY && P2point>=_LOVE && (P1point-P2point)>=_THIRTY)
        {
            score = "Win for player1";
        }
        if (P2point>_FORTY && P1point>=_LOVE && (P2point-P1point)>=_THIRTY)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String isAdvantageOver(String score) {
		if (P1point > P2point && P2point >= _FORTY)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= _FORTY)
        {
            score = "Advantage player2";
        }
		return score;
	}
	
	private String getLiteral(int score) {
		String result="";
		switch(score) {
		  case _LOVE:
			result = "Love";
		    break;
		  case _FIFTEEN:
			result = "Fifteen";
		    break;
		  case _THIRTY:
			result = "Thirty";
			break;
		  case _FORTY:
			result = "Forty";
			break;  
		}
		return result;
	}

	private String normal3(String score) {
		if (P2point>P1point && P2point <= _FORTY)
        {
			P1res = getLiteral(P1point);
            P2res = getLiteral(P2point);
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal2(String score) {
		if (P1point>P2point && P1point <= _FORTY)
        {
           
            P1res = getLiteral(P1point);
            P2res = getLiteral(P2point);
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal1(String score) {
		if (P2point > _LOVE && P1point==_LOVE)
        {
           
            P2res = getLiteral(P2point);
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal(String score) {
		if (P1point > _LOVE && P2point==_LOVE)
        {
          
            P1res = getLiteral(P1point);
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String deuce(String score) {
		if (P1point==P2point && P1point>=_FORTY)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (P1point == P2point && P1point <=_FORTY)
        {
            score = getLiteral(P1point);
            score += "-All";
        }
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = _LOVE; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = _LOVE; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}