package Javamonv1;

import java.util.HashMap;
import java.util.Map;

public class EffectivenessRepository {

    private Map<String , Map<String,Double>> effectivenessChart = new HashMap<>();

    public EffectivenessRepository ()  {

    }

    public void init(Map<String,Map<String,Double>> chart) {
        this.effectivenessChart = chart;
    }

    public double getEffectiveness(String attackType , String defenceType) {
        if (attackType == null) {
            System.err.println("Fehler!");
            return 1.0;
        }


        if (defenceType == null || defenceType.isEmpty()) {
            return 1.0;
        }
        Map<String,Double> attackMap = effectivenessChart.get(attackType);

        if (attackMap == null) {
            System.err.println("Fehler: Saldıran tip '" + attackType + "' tabloda bulunamadı.");
            return 1.0;
        }

        Double effectiveness = attackMap.get(defenceType);

        if (effectiveness == null) {
            System.err.println("Fehler");
            return 1.0;
        }

        return effectiveness;
    }
}
