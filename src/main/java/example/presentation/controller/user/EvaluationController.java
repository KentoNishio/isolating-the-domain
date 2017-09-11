package example.presentation.controller.user;

import example.domain.model.user.UserIdentifier;
import example.domain.model.user.evaluation.Evaluation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user/{userId}/evaluate")
public class EvaluationController {

    private static final String[] allowFields =
            {
                    "value",
            };

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields(allowFields);
    }

    @GetMapping()
    String show(@PathVariable(value="userId") UserIdentifier identifier,Model model) {
        model.addAttribute("identifier", identifier);
        model.addAttribute("evaluation", new Evaluation());
        return "user/evaluation/evaluation";
    }

    @PostMapping("complete")
    String complete(@PathVariable(value = "userId") UserIdentifier identifier, Model model,
                    @Validated @ModelAttribute("evaluation") Evaluation evaluation, BindingResult result) {
        model.addAttribute("identifier", identifier);
        if (result.hasErrors()) return "user/evaluation/evaluation";

        return "user/evaluation/evaluation";
    }

}
