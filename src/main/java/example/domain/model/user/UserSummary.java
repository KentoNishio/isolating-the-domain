package example.domain.model.user;

import example.domain.model.user.evaluation.Evaluation;

public class UserSummary {
    UserIdentifier identifier;
    Name name;
    Evaluation evaluation = new Evaluation();

    public UserIdentifier identifier() {
        return identifier;
    }

    public Name name() {
        return name;
    }

    public Evaluation evaluation() {
        return evaluation;
    }
}
