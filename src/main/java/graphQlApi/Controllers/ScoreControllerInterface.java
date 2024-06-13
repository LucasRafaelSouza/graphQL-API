package graphQlApi.Controllers;

import graphQlApi.Models.CombinationsResult;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

public interface ScoreControllerInterface {

    @MutationMapping
    CombinationsResult verify(@Argument String score);



}
