package semeval2013.task7;


public class Common
{

    public enum Dataset {
        beetle,
        sciEntsBank
    }
    
    public enum TaskFormat {
        fiveWay,
        threeWay,
        twoWay,
        partialEntailment
        
    }
    
    public enum Labels5way {
        correct,
        partially_correct_incomplete,
        contradictory,
        irrelevant,
        non_domain
    }

    public enum Labels3way {
        correct,
        contradictory,
        incorrect
    }

    public enum Labels2way {
        correct,
        incorrect
    }
    
    public enum PartialEntailmentOutcomes {
        Expressed,
        Unaddressed
    }
}