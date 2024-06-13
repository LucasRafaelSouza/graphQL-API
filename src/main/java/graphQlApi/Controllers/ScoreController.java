package graphQlApi.Controllers;


import graphQlApi.Models.CombinationsResult;
import graphQlApi.Services.ScoreServiceInterface;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ScoreController implements ScoreControllerInterface{

    private final ScoreServiceInterface ScoreService;

    public ScoreController(ScoreServiceInterface scoreService) {
        ScoreService = scoreService;
    }


    @Override
    @MutationMapping
    public CombinationsResult verify(@Argument String score){
        int combinations  = ScoreService.verify(score);
        return new CombinationsResult(combinations);
    }

}
