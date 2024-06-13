package graphQlApi.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScoreService implements  ScoreServiceInterface{


    private static int[] possiblePoints = {3, 6, 7, 8};
    @Override
    public int verify(String score) {
        String[] scores = score.split("x");
        int firstScore = Integer.parseInt(scores[0]);
        int secondScore = Integer.parseInt(scores[1]);

        System.out.println("------------Testando SEPARACAO dos placares-------------");
        System.out.println(firstScore);
        System.out.println(secondScore);

        int firstCombination = countCombinations(firstScore,0);
        int secondCombination = countCombinations(secondScore,0);

        System.out.println("------------Testando COMBINACAO dos placares-------------");
        System.out.println(firstCombination);
        System.out.println(secondCombination);

        return firstCombination * secondCombination;
    }

    private int countCombinations(int score, int start){

        int combinations = 0;

        if (score < 0){
            return 0;
        }

        if (score == 0){
            return 1;
        }


        for (int i = start; i < possiblePoints.length; i++){
            combinations += countCombinations(score-possiblePoints[i],i);
        }




        return combinations;

    }
}
