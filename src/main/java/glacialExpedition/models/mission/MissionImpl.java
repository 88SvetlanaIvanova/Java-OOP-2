package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;

public  class MissionImpl implements Mission{

    @Override
    public void explore (State state, Collection<Explorer> explorers){
        // iterate over explorers
        // iterate over exhibits
        Collection<String> stateExhibits = state.getExhibits();
        for (Explorer explorer : explorers) {
            // 1 explorer
            while (explorer.canSearch() && stateExhibits.iterator().hasNext()){
                // explorer has energy
                // there are exhibits
                explorer.search();
                String currentExhibit = stateExhibits.iterator().next();
                explorer.getSuitcase().getExhibits().add(currentExhibit);
                stateExhibits.remove(currentExhibit);


            }
        }
    }
}
