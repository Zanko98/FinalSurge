package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Workout {
    String data, timeOfDay,
            name,
            description,
            showDistance, plannedDistance, planedDistType, planedDuration,
            distance, distType, duration, paceType,
            reps, advDistance, advDistType, advDuration,
            markAsRace, overallPlace, ageGroupPlace,
            feel,
            effort,
            minHR, avgHR, maxHR,
            kCal,
            elGain, elGainType, elLoss, elLossType,
            powAvg, powMax, cadAvg, cadMax;
}
