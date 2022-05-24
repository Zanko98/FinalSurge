package dto.Workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Run {
    String data, timeOfDay,
            name,
            description,
            showDistance, plannedDistance, planedDistType, planedDuration,
            distance, distType, duration,
            reps, advDistance, advDistType, advDuration, paceType,
            markAsRace, overallPlace, ageGroupPlace,
            feel,
            effort,
            minHR, avgHR, maxHR,
            kCal;

    String elGain, elGainType, elLoss, elLossType;

    String powAvg, powMax, cadAvg, cadMax;
}
